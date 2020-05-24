/**
 * @author : 孙留平
 * @since : 2020年3月18日 上午1:10:05
 * @see:
 */
package com.testservice.platform.server.zentao.entity;

import java.util.Date;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.alibaba.fastjson.annotation.JSONField;
import com.testservice.platform.server.json.CustomJsonDateDeserializer;

/**
 * @author : Administrator
 * @since : 2020年3月18日 上午1:10:05
 * @see :
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZenTaoTestCase {

	private Long id;
	private Long product;
	private Long branch;
	private Long lib;
	private Long module;
	private Long path;
	private Long story;
	private Long storyVersion;
	private String title;
	private String precondition;
	private String keyword;
	private Long pri;
	private String type;
	private String stage;
	private String howRun;
	private String scriptedBy;

	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	private Date scriptedDate;
	private String scriptStatus;
	private String scriptLocation;
	private String status;
	private String subStatus;
	private String color;
	private Long frequency;
	private Long order;
	private String openedBy;

	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	private Date openedDate;

	private String reviewedBy;

	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	private Date reviewedDate;
	private String lastEditedBy;

	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	private Date lastEditedDate;
	private Long version;
	private String linkCase;
	private String fromBug;
	private Long fromCaseID;
	private Long fromCaseVersion;
	private Long deleted;
	private Long task;
	private Long bugs;
	private Long caseVersion;
	private Long results;
	private Long caseFails;
	private Long stepNumber;
	private String lastRunner;
	private String lastRunResult;
	private String assignedTo;

	@JSONField(name = "case")
	private Long caseId;
	private String storyTitle;
	private String caseStatus;

	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	private Date lastRunDate;

	@JSONField(name = "steps")
	Map<Long, ZenTaoTestCaseStep> steps;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProduct() {
		return product;
	}

	public void setProduct(Long product) {
		this.product = product;
	}

	public Long getBranch() {
		return branch;
	}

	public void setBranch(Long branch) {
		this.branch = branch;
	}

	public Long getLib() {
		return lib;
	}

	public void setLib(Long lib) {
		this.lib = lib;
	}

	public Long getModule() {
		return module;
	}

	public void setModule(Long module) {
		this.module = module;
	}

	public Long getPath() {
		return path;
	}

	public void setPath(Long path) {
		this.path = path;
	}

	public Long getStory() {
		return story;
	}

	public void setStory(Long story) {
		this.story = story;
	}

	public Long getStoryVersion() {
		return storyVersion;
	}

	public void setStoryVersion(Long storyVersion) {
		this.storyVersion = storyVersion;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrecondition() {
		return precondition;
	}

	public void setPrecondition(String precondition) {
		this.precondition = precondition;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Long getPri() {
		return pri;
	}

	public void setPri(Long pri) {
		this.pri = pri;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getHowRun() {
		return howRun;
	}

	public void setHowRun(String howRun) {
		this.howRun = howRun;
	}

	public String getScriptedBy() {
		return scriptedBy;
	}

	public void setScriptedBy(String scriptedBy) {
		this.scriptedBy = scriptedBy;
	}

	public Date getScriptedDate() {
		return scriptedDate;
	}

	public void setScriptedDate(Date scriptedDate) {
		this.scriptedDate = scriptedDate;
	}

	public String getScriptStatus() {
		return scriptStatus;
	}

	public void setScriptStatus(String scriptStatus) {
		this.scriptStatus = scriptStatus;
	}

	public String getScriptLocation() {
		return scriptLocation;
	}

	public void setScriptLocation(String scriptLocation) {
		this.scriptLocation = scriptLocation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubStatus() {
		return subStatus;
	}

	public void setSubStatus(String subStatus) {
		this.subStatus = subStatus;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Long getFrequency() {
		return frequency;
	}

	public void setFrequency(Long frequency) {
		this.frequency = frequency;
	}

	public Long getOrder() {
		return order;
	}

	public void setOrder(Long order) {
		this.order = order;
	}

	public String getOpenedBy() {
		return openedBy;
	}

	public void setOpenedBy(String openedBy) {
		this.openedBy = openedBy;
	}

	public Date getOpenedDate() {
		return openedDate;
	}

	public void setOpenedDate(Date openedDate) {
		this.openedDate = openedDate;
	}

	public String getReviewedBy() {
		return reviewedBy;
	}

	public void setReviewedBy(String reviewedBy) {
		this.reviewedBy = reviewedBy;
	}

	public Date getReviewedDate() {
		return reviewedDate;
	}

	public void setReviewedDate(Date reviewedDate) {
		this.reviewedDate = reviewedDate;
	}

	public String getLastEditedBy() {
		return lastEditedBy;
	}

	public void setLastEditedBy(String lastEditedBy) {
		this.lastEditedBy = lastEditedBy;
	}

	public Date getLastEditedDate() {
		return lastEditedDate;
	}

	public void setLastEditedDate(Date lastEditedDate) {
		this.lastEditedDate = lastEditedDate;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getLinkCase() {
		return linkCase;
	}

	public void setLinkCase(String linkCase) {
		this.linkCase = linkCase;
	}

	public String getFromBug() {
		return fromBug;
	}

	public void setFromBug(String fromBug) {
		this.fromBug = fromBug;
	}

	public Long getFromCaseID() {
		return fromCaseID;
	}

	public void setFromCaseID(Long fromCaseID) {
		this.fromCaseID = fromCaseID;
	}

	public Long getFromCaseVersion() {
		return fromCaseVersion;
	}

	public void setFromCaseVersion(Long fromCaseVersion) {
		this.fromCaseVersion = fromCaseVersion;
	}

	public Long getDeleted() {
		return deleted;
	}

	public void setDeleted(Long deleted) {
		this.deleted = deleted;
	}

	public Long getTask() {
		return task;
	}

	public void setTask(Long task) {
		this.task = task;
	}

	public Long getBugs() {
		return bugs;
	}

	public void setBugs(Long bugs) {
		this.bugs = bugs;
	}

	public Long getCaseVersion() {
		return caseVersion;
	}

	public void setCaseVersion(Long caseVersion) {
		this.caseVersion = caseVersion;
	}

	public Long getResults() {
		return results;
	}

	public void setResults(Long results) {
		this.results = results;
	}

	public Long getCaseFails() {
		return caseFails;
	}

	public void setCaseFails(Long caseFails) {
		this.caseFails = caseFails;
	}

	public Long getStepNumber() {
		return stepNumber;
	}

	public void setStepNumber(Long stepNumber) {
		this.stepNumber = stepNumber;
	}

	public String getLastRunner() {
		return lastRunner;
	}

	public void setLastRunner(String lastRunner) {
		this.lastRunner = lastRunner;
	}

	public String getLastRunResult() {
		return lastRunResult;
	}

	public void setLastRunResult(String lastRunResult) {
		this.lastRunResult = lastRunResult;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getStoryTitle() {
		return storyTitle;
	}

	public void setStoryTitle(String storyTitle) {
		this.storyTitle = storyTitle;
	}

	public String getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}

	public Date getLastRunDate() {
		return lastRunDate;
	}

	public void setLastRunDate(Date lastRunDate) {
		this.lastRunDate = lastRunDate;
	}

	@Override
	public String toString() {
		return "ZenTaoTestCase [id=" + id + ", product=" + product + ", branch="
		        + branch + ", lib=" + lib + ", module=" + module + ", path="
		        + path + ", story=" + story + ", storyVersion=" + storyVersion
		        + ", title=" + title + ", precondition=" + precondition
		        + ", keyword=" + keyword + ", pri=" + pri + ", type=" + type
		        + ", stage=" + stage + ", howRun=" + howRun + ", scriptedBy="
		        + scriptedBy + ", scriptedDate=" + scriptedDate
		        + ", scriptStatus=" + scriptStatus + ", scriptLocation="
		        + scriptLocation + ", status=" + status + ", subStatus="
		        + subStatus + ", color=" + color + ", frequency=" + frequency
		        + ", order=" + order + ", openedBy=" + openedBy
		        + ", openedDate=" + openedDate + ", reviewedBy=" + reviewedBy
		        + ", reviewedDate=" + reviewedDate + ", lastEditedBy="
		        + lastEditedBy + ", lastEditedDate=" + lastEditedDate
		        + ", version=" + version + ", linkCase=" + linkCase
		        + ", fromBug=" + fromBug + ", fromCaseID=" + fromCaseID
		        + ", fromCaseVersion=" + fromCaseVersion + ", deleted="
		        + deleted + ", task=" + task + ", bugs=" + bugs
		        + ", caseVersion=" + caseVersion + ", results=" + results
		        + ", caseFails=" + caseFails + ", stepNumber=" + stepNumber
		        + ", lastRunner=" + lastRunner + ", lastRunResult="
		        + lastRunResult + ", assignedTo=" + assignedTo + ", caseId="
		        + caseId + ", storyTitle=" + storyTitle + ", caseStatus="
		        + caseStatus + ", lastRunDate=" + lastRunDate + ", steps="
		        + steps + "]";
	}

	public Map<Long, ZenTaoTestCaseStep> getSteps() {
		return steps;
	}

	public void setSteps(Map<Long, ZenTaoTestCaseStep> steps) {
		this.steps = steps;
	}

	public Long getCaseId() {
		return caseId;
	}

	public void setCaseId(Long caseId) {
		this.caseId = caseId;
	}
}
