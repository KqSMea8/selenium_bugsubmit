package com.tencent.main;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cn.hutool.json.JSONUtil;

import com.tencent.entity.BugEntity;
import com.tencent.utils.DriverUtil;
import com.tencent.utils.Helper;
import com.tencent.utils.JustinUtil;

public class SubmitBug {
	WebDriver driver;
	Helper helper;
	Map<String, String> map = new HashMap<String, String>();
	public void init(BugEntity bugEntity) throws InterruptedException {
		try {
			
			String url = "http://tapd.oa.com/miaOS_SDK/bugtrace/bugreports/my_view";
			driver = DriverUtil.getDriver(url);
			helper = new Helper(driver);
			helper.click(helper.getWebeElement(By.id("btn_smartlogin")));
			helper.click(helper.getWebeElement(By.xpath(".//*[@id='btn_add_bug']/span")));
			helper.switchToWindow("创建缺陷");
			helper.click(helper.getWebeElement(By.className("current-value")));
			helper.click(helper.getWebeElement(By.linkText("迭代测试缺陷模版")));
			helper.ctrlA();
			helper.delete();
			helper.enter(helper.getWebeElement(By.id("BugTitle")), bugEntity.getTitle() + JustinUtil.getLocalTime(), true);
			driver.switchTo().frame(helper.getWebeElement(By.className("editor-iframe")));
			WebElement body = driver.findElement(By.xpath("html/body"));
			helper.RichTextEdit(body, bugEntity);
			helper.defaultContext();
			System.out.println(JSONUtil.toJsonPrettyStr(bugEntity));
			System.out.println("处理人姓名");
			helper.enter(helper.getWebeElement(By.id("BugCurrentOwnerValue")), bugEntity.getHandlerName(), true);

			System.out.println("测试姓名");
			helper.enter(helper.getWebeElement(By.id("BugTeValue")), bugEntity.getTesterName(), true);

			System.out.println("开发姓名");
			helper.enter(helper.getWebeElement(By.id("BugDeValue")), bugEntity.getDevelopmentName(), true);

			System.out.println("模块下拉框");
			Select select = new Select(helper.getWebeElement(By.id("BugModule")));
			select.selectByValue(bugEntity.getModuleName());

			System.out.println("严重级别拉框");
			Select severitySelect = new Select(helper.getWebeElement(By.id("BugSeverity")));
			severitySelect.selectByVisibleText(bugEntity.getPonderanceLevel());

			System.out.println("优先级下拉框");
			Select priorityselect = new Select(helper.getWebeElement(By.id("BugPriority")));
			priorityselect.selectByVisibleText(bugEntity.getPriority());

			System.out.println("发现版本下拉框");
			Select foundVersion = new Select(helper.getWebeElement(By.id("BugVersionReport")));
			foundVersion.selectByVisibleText(bugEntity.getFoundVersion());

			System.out.println("重现规律下拉框");
			Select repeatRule = new Select(helper.getWebeElement(By.id("BugFrequency")));
			repeatRule.selectByVisibleText(bugEntity.getRepeatRule());
			System.out.println("准备滑动");
			helper.click(helper.getWebeElement(By.className("control-label")));
			helper.scroll();

			System.out.println("缺陷下拉框");
			Select bug = new Select(helper.getWebeElement(By.id("BugCustomField10")));
			bug.selectByValue(bugEntity.getBugClassName());
			//附件上传
			helper.updateFile(helper.getWebeElement(By.id("file_input")), "F:\\log\\9398d427_2019_02_28_10_43_52.txt");
			
			System.out.println("提交");
			WebElement submit = helper.getWebeElement(By.id("save_view"));
			submit.submit();
			Thread.sleep(7000);
			helper.quit();
			System.out.println("退出");
			map.put(bugEntity.getTitle(), "successed");
		} catch (Exception e) {
			map.put(bugEntity.getTitle(), "failed");
		}
	}
}
