package com.tencent.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import com.tencent.entity.BugEntity;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
/**
 * 工具类
 * @author p_xiaogzhu
 *2019年3月28日
 *
 */
public class JustinUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_HH_mm_ss");	
	public  static String getLocalTime() {		
		Long millis = System.currentTimeMillis();
		String timeNow = sdf.format(millis);
		return timeNow;
	}
	public static String getRootPath(String folderName)
	{
		String resultPath=System.getProperty("user.dir")+File.separator+folderName;
		File path = new File(resultPath);
		if(!path.exists())
		{
			path.mkdirs();
		}
		return path.getPath();
	}
	/*
	 * 工程目录下的case文件夹
	 */
	public static List<BugEntity> getRootPathCase(){
		File file = new File(System.getProperty("user.dir")+"\\case\\"+"module.xls");		
		ExcelReader reader = ExcelUtil.getReader(file, "sheet1");
		List<BugEntity> readAll = reader.readAll(BugEntity.class);
		return readAll;
	}
	public static int getRandom(int num){
		Random random =new Random();
		return random.nextInt(num);
	}
	
}
