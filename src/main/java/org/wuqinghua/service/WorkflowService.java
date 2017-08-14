package org.wuqinghua.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface WorkflowService {

	void saveNewDeploy(CommonsMultipartFile workflowZip, String workflowName) throws IOException;

	List<Deployment> findDeploymentList();

	List<ProcessDefinition> findProcessDefinitions();

	void viewWorkflowImg(String deploymentId, String imgName, OutputStream out);

	void deleteProcDef(String deploymentId);

}
