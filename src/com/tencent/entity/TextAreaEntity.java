package com.tencent.entity;

public class TextAreaEntity {
	String describe;
	String softHardWardVersion;//软硬件版本
	String questionReappearStep;//问题重现步骤
	String expectResult;//预期结果
	String trueResult;//实际结果
	String logAndScreen;//日志或截图
	public String getDescribe() {
		return "【问题描述】";
	}
	public String getSoftHardWardVersion() {
		return "【测试软件硬件版本】";
	}
	public String getQuestionReappearStep() {
		return "【问题重现步骤】";
	}
	public String getExpectResult() {
		return "【预期结果】";
	}
	public String getTrueResult() {
		return "【实际结果】";
	}
	public String getLogAndScreen() {
		return "【日志或截图】";
	}

}
