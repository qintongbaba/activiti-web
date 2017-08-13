package org.wuqinghua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/workflow")
public class WorkflowController {

	@RequestMapping(path = "/deploymentManager", method = RequestMethod.GET)
	public String showDeploymentManager() {
		return "workflow/workflow";
	}

	/**
	 * 发布流程
	 * 
	 * @return
	 */
	@RequestMapping(path = "/deployment", method = RequestMethod.POST)
	public String deployment(@RequestParam CommonsMultipartFile workflowZip) {
		System.out.println("workflowZip:" + workflowZip.getOriginalFilename());
		return "workflow/workflow";
	}
}
