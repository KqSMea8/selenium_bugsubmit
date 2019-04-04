package com.tencent.main;

import java.util.List;

import com.tencent.entity.BugEntity;
import com.tencent.utils.JustinUtil;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		SubmitBug submitBug = new SubmitBug();
		//List中有一行为标题，所以下标从1开始
		List<BugEntity> entities = JustinUtil.getRootPathCase();
		for (int i = 1; i < entities.size(); i++) {
			submitBug.init(entities.get(i));	
			break;
		}
		System.out.println("-----------------------写入结果-----------------------");
		for (String str : submitBug.map.keySet()) {			
			System.out.println("标题："+str+"结果："+submitBug.map.get(str));
		}
	}
}
