package com.tencent.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tencent.entity.BugEntity;
import com.tencent.entity.TextAreaEntity;

public class Helper {
	WebDriver driver;
	Robot robot;

	public Helper(WebDriver driver) {
		super();
		this.driver = driver;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	// 点击
	public void click(WebElement web) {
		sleep(1000);
		web.click();
		sleep(500);
	}

	// 输入文本信息
	public void enter(WebElement element, String str, boolean click) {
		if (click) {
			click(element);
		}
		sleep(1400);
		element.sendKeys(str);
		System.out.println("输入的值：" + str);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		sleep(600);
	}

	// 获取元素
	public WebElement getWebeElement(By by) {
		return driver.findElement(by);
	}

	// 模拟CtrlV功能
	public void ctrlV() throws InterruptedException {
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	// 模拟CtrlA功能
	public void ctrlA() throws InterruptedException {
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	// 模拟键盘的BackSpace删除键
	public void delete() throws InterruptedException {
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
	}

	// 销毁浏览器实例
	public void quit() {
		driver.quit();
	}

	// 默认界面
	public void defaultContext() {
		System.out.println("切换默认界面");
		driver.switchTo().defaultContent();
	}

	// 元素文本清除
	public void clear(WebElement element) {
		element.clear();
	}

	// 滚动，模拟键盘的End键
	public void scroll() {
		robot.keyPress(KeyEvent.VK_END);
		robot.keyRelease(KeyEvent.VK_END);
		System.out.println("向下滑动");
		sleep(500);
	}

	// 切换标签
	public void switchToWindow(String title) {
		Set<String> allHands = driver.getWindowHandles();
		for (String windowId : allHands) {
			if (driver.switchTo().window(windowId).getTitle().contains(title)) {
				driver.switchTo().window(windowId);
				break;
			}
		}
	}

	// 富文本框的加粗功能图标，
	public void bold() {
		defaultContext();
		WebElement bTag = getWebeElement(By.xpath("//*[@id=\"editor-BugDescription\"]/div[6]/span[1]"));
		bTag.click();
		driver.switchTo().frame(getWebeElement(By.className("editor-iframe")));
	}

	// 休眠
	public void sleep(int sleepMs) {
		try {
			Thread.sleep(sleepMs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void updateFile(WebElement element,String path){
		element.sendKeys(path);
	}
	public void RichTextEdit(WebElement body, BugEntity bugEntity) {
		TextAreaEntity textAreaEntity = new TextAreaEntity();
		clear(body);
		// 软硬件版本
		bold();
		enter(body, textAreaEntity.getSoftHardWardVersion(), false);
		bold();
		enter(body, bugEntity.getSoftHardWardVersion(), false);
		// 问题描述
		bold();
		enter(body, textAreaEntity.getDescribe(), false);
		bold();
		enter(body, bugEntity.getDescribe(), false);
		// 问题重现步骤
		bold();
		enter(body, textAreaEntity.getQuestionReappearStep(), false);
		bold();
		enter(body, bugEntity.getQuestionReappearStep(), false);
		// 预期结果
		bold();
		enter(body, textAreaEntity.getExpectResult(), false);
		bold();
		enter(body, bugEntity.getExpectResult(), false);
		// 实际结果
		bold();
		enter(body, textAreaEntity.getTrueResult(), false);
		bold();
		enter(body, bugEntity.getTrueResult(), false);
		// 日志或截图
		bold();
		enter(body, textAreaEntity.getLogAndScreen(), false);
		bold();
		enter(body, bugEntity.getLogAndScreen(), false);
	}
}
