package com.tencent.entity;

public class BugEntity {
	String title;//标题
	String describe;//问题描述
	String handlerName;//处理人
	String ccName;//抄送人
	String createName;//创建人
	String moduleName;//模块
	String priority;//优先级
	String ponderanceLevel;//严重级别
	String foundVersion;//发现版本
	String repeatRule;//重现规律
	String developmentName;//开发人员
	String testerName;//测试人员
	String bugClassName;//缺陷归属类别
	String projectVersion;//项目版本
	String softHardWardVersion;//软硬件版本
	String questionReappearStep;//问题重现步骤
	String expectResult;//预期结果
	String trueResult;//实际结果
	String logAndScreen;//日志或截图
	public String getSoftHardWardVersion() {
		return softHardWardVersion;
	}
	public String getQuestionReappearStep() {
		return questionReappearStep;
	}
	public String getExpectResult() {
		return expectResult;
	}
	public String getTrueResult() {
		return trueResult;
	}
	public String getLogAndScreen() {
		return logAndScreen;
	}
	public void setSoftHardWardVersion(String softHardWardVersion) {
		this.softHardWardVersion = softHardWardVersion;
	}
	public void setQuestionReappearStep(String questionReappearStep) {
		this.questionReappearStep = questionReappearStep;
	}
	public void setExpectResult(String expectResult) {
		this.expectResult = expectResult;
	}
	public void setTrueResult(String trueResult) {
		this.trueResult = trueResult;
	}
	public void setLogAndScreen(String logAndScreen) {
		this.logAndScreen = logAndScreen;
	}
	public String getTitle() {
		return title;
	}
	public String getDescribe() {
		return describe;
	}
	public String getHandlerName() {
		return handlerName;
	}
	public String getCcName() {
		return ccName;
	}
	public String getCreateName() {
		return createName;
	}
	public String getModuleName() {
		return moduleName;
	}
	public String getPriority() {
		return priority;
	}
	public String getPonderanceLevel() {
		return ponderanceLevel;
	}
	public String getFoundVersion() {
		return foundVersion;
	}
	public String getRepeatRule() {
		return repeatRule;
	}
	public String getDevelopmentName() {
		return developmentName;
	}
	public String getTesterName() {
		return testerName;
	}
	public String getBugClassName() {
		return bugClassName;
	}
	public String getProjectVersion() {
		return projectVersion;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}
	public void setCcName(String ccName) {
		this.ccName = ccName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public void setPonderanceLevel(String ponderanceLevel) {
		this.ponderanceLevel = ponderanceLevel;
	}
	public void setFoundVersion(String foundVersion) {
		this.foundVersion = foundVersion;
	}
	public void setRepeatRule(String repeatRule) {
		this.repeatRule = repeatRule;
	}
	public void setDevelopmentName(String developmentName) {
		this.developmentName = developmentName;
	}
	public void setTesterName(String testerName) {
		this.testerName = testerName;
	}
	public void setBugClassName(String bugClassName) {
		this.bugClassName = bugClassName;
	}
	public void setProjectVersion(String projectVersion) {
		this.projectVersion = projectVersion;
	}

}
