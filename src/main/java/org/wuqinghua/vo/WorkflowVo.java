package org.wuqinghua.vo;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 工作流程vo
 * 
 * @author wuqinghua
 *
 */
public class WorkflowVo {
	private String workflowName;
	private CommonsMultipartFile workflowZip;

	public WorkflowVo(String workflowName, CommonsMultipartFile workflowZip) {
		super();
		this.workflowName = workflowName;
		this.workflowZip = workflowZip;
	}

	public WorkflowVo() {
		super();
	}

	public String getWorkflowName() {
		return workflowName;
	}

	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	public CommonsMultipartFile getWorkflowZip() {
		return workflowZip;
	}

	public void setWorkflowZip(CommonsMultipartFile workflowZip) {
		this.workflowZip = workflowZip;
	}

}
