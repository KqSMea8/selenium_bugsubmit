package com.tencent.utils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverUtil {
	public static WebDriver getDriver(String url){		
		File classpathRoot = new File(System.getProperty("user.dir"));
		File workDir = new File(classpathRoot, "driver");
		File driverPath = new File(workDir, "chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", driverPath.getAbsolutePath());
		DesiredCapabilities sCaps = new DesiredCapabilities();
		sCaps.setJavascriptEnabled(true);
		WebDriver driver = new ChromeDriver(sCaps);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
}
