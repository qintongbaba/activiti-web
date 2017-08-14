package org.wuqinghua.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.wuqinghua.service.WorkflowService;
import org.wuqinghua.vo.WorkflowVo;

@Controller
@RequestMapping("/workflow")
@RequiresAuthentication
public class WorkflowController {

	@Autowired
	private WorkflowService workflowService;

	@RequestMapping(path = "/deploymentManager", method = RequestMethod.GET)
	public String deploymentManager(Model model) {
		// 查询部署对象(act_re_deployment)
		List<Deployment> depList = workflowService.findDeploymentList();

		// 查询流程定义(act_re_procdef)
		List<ProcessDefinition> pdList = workflowService.findProcessDefinitions();

		model.addAttribute("depList", depList);
		model.addAttribute("pdList", pdList);
		return "workflow/workflow";
	}

	/**
	 * 发布流程
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(path = "/deployment", method = RequestMethod.POST)
	public String deployment(WorkflowVo workflowVo) throws IOException {

		// 1.获取流程文件zip
		CommonsMultipartFile workflowZip = workflowVo.getWorkflowZip();
		// 2.获取文件名称
		String workflowName = workflowVo.getWorkflowName();

		// 部署
		workflowService.saveNewDeploy(workflowZip, workflowName);

		return "redirect:/workflow/deploymentManager";
	}

	// 查看流程图
	@RequestMapping("/viewWorkflowImg/{imgName}/{deploymentId}")
	public void viewWorkflowImg(@PathVariable String deploymentId, @PathVariable String imgName, OutputStream out) {
		workflowService.viewWorkflowImg(deploymentId, imgName, out);
	}
	
	//删除流程定义
	@RequestMapping("/deleteProcDef/{deploymentId}")
	public String deleteProcDef(@PathVariable String deploymentId) {
		workflowService.deleteProcDef(deploymentId);
		return "redirect:/workflow/deploymentManager";
	}
	
}
