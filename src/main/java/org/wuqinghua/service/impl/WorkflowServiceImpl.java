package org.wuqinghua.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.wuqinghua.service.WorkflowService;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class WorkflowServiceImpl implements WorkflowService {

	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private FormService formService;
	@Autowired
	private HistoryService historyService;

	@Override
	public void saveNewDeploy(CommonsMultipartFile workflowZip, String workflowName) throws IOException {
		repositoryService.createDeployment()  //创建一个部署对象
				.name(workflowName)   //添加部署名称
				.addZipInputStream(new ZipInputStream(workflowZip.getInputStream()))//添加部署资源
				.deploy();//添加部署名称
	}

	@Override
	public List<Deployment> findDeploymentList() {
		return repositoryService.createDeploymentQuery() //创建一个查询对象
						.orderByDeploymenTime()
						.asc()
						.list();
	}

	@Override
	public List<ProcessDefinition> findProcessDefinitions() {
		return repositoryService.createProcessDefinitionQuery()
							.orderByProcessDefinitionVersion()
							.asc()
							.list();
	}

	@Override
	public void viewWorkflowImg(String deploymentId, String imgName, OutputStream out) {
		//获取流程定义的输入流
		InputStream in = repositoryService.getResourceAsStream(deploymentId, imgName);
		try {
			FileCopyUtils.copy(in, out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProcDef(String deploymentId) {
		//不带及联的删除
		repositoryService.deleteDeployment(deploymentId, false);
		
	}
}
