<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../commons/commons.jspf"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部署管理</title>
</head>
<body>
	<table width="100%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="30"><table width="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td height="24" bgcolor="#353c44"><table width="100%"
								border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td><table width="100%" border="0" cellspacing="0"
											cellpadding="0">
											<tr>
												<td width="6%" height="19" valign="bottom"><div
														align="center">
														<img
															src="${pageContext.request.contextPath }/images/tb.gif"
															width="14" height="14" />
													</div></td>
												<td width="94%" valign="bottom"><span class="STYLE1">部署信息管理列表</span></td>
											</tr>
										</table></td>
									<td><div align="right">
											<span class="STYLE1"> </span>
										</div></td>
								</tr>
							</table></td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td><table width="100%" border="0" cellpadding="0"
					cellspacing="1" bgcolor="#a8c7ce" onmouseover="changeto()"
					onmouseout="changeback()">
					<tr>
						<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div
								align="center">
								<span class="STYLE10">ID</span>
							</div></td>
						<td width="60%" height="20" bgcolor="d3eaef" class="STYLE6"><div
								align="center">
								<span class="STYLE10">流程名称</span>
							</div></td>
						<td width="20%" height="20" bgcolor="d3eaef" class="STYLE6"><div
								align="center">
								<span class="STYLE10">发布时间</span>
							</div></td>
						<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div
								align="center">
								<span class="STYLE10">操作</span>
							</div></td>
					</tr>
					<c:forEach items="${depList}" var="dep">
						<tr>
							<td height="20" bgcolor="#FFFFFF" class="STYLE6"><div
									align="center">${dep.id }</div></td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE19"><div
									align="center">${dep.name }</div></td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE19"><div
									align="center">${dep.deploymentTime}</div></td>
							<td height="20" bgcolor="#FFFFFF"><div align="center"
									class="STYLE21">
									<a
										href="${pageContext.request.contextPath}/workflow/deleteProcDef/${dep.id}" />删除</a>
								</div></td>
						</tr>
					</c:forEach>
				</table></td>
		</tr>
	</table>
	<hr>
	<br />
	<table width="100%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="30"><table width="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td height="24" bgcolor="#353c44"><table width="100%"
								border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td><table width="100%" border="0" cellspacing="0"
											cellpadding="0">
											<tr>
												<td width="6%" height="19" valign="bottom"><div
														align="center">
														<img
															src="${pageContext.request.contextPath }/images/tb.gif"
															width="14" height="14" />
													</div></td>
												<td width="94%" valign="bottom"><span class="STYLE1">流程定义信息列表</span></td>
											</tr>
										</table></td>
									<td><div align="right">
											<span class="STYLE1"> </span>
										</div></td>
								</tr>
							</table></td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td><table width="100%" border="0" cellpadding="0"
					cellspacing="1" bgcolor="#a8c7ce" onmouseover="changeto()"
					onmouseout="changeback()">
					<tr>
						<td width="12%" height="20" bgcolor="d3eaef" class="STYLE6"><div
								align="center">
								<span class="STYLE10">ID</span>
							</div></td>
						<td width="18%" height="20" bgcolor="d3eaef" class="STYLE6"><div
								align="center">
								<span class="STYLE10">名称</span>
							</div></td>
						<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div
								align="center">
								<span class="STYLE10">流程定义的KEY</span>
							</div></td>
						<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div
								align="center">
								<span class="STYLE10">流程定义的版本</span>
							</div></td>
						<td width="15%" height="20" bgcolor="d3eaef" class="STYLE6"><div
								align="center">
								<span class="STYLE10">流程定义的规则文件名称</span>
							</div></td>
						<td width="15%" height="20" bgcolor="d3eaef" class="STYLE6"><div
								align="center">
								<span class="STYLE10">流程定义的规则图片名称</span>
							</div></td>
						<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div
								align="center">
								<span class="STYLE10">部署ID</span>
							</div></td>
						<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div
								align="center">
								<span class="STYLE10">操作</span>
							</div></td>
					</tr>

					<c:forEach items="${pdList }" var="pd">
						<tr>
							<td height="20" bgcolor="#FFFFFF" class="STYLE6"><div
									align="center">${pd.id}</div></td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE19"><div
									align="center">${pd.name}</div></td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE19"><div
									align="center">${pd.key}</div></td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE6"><div
									align="center">${pd.version}</div></td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE6"><div
									align="center">${pd.resourceName}</div></td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE6"><div
									align="center">${pd.diagramResourceName}</div></td>
							<td height="20" bgcolor="#FFFFFF" class="STYLE6"><div
									align="center">${pd.deploymentId}</div></td>
							<td height="20" bgcolor="#FFFFFF"><div align="center"
									class="STYLE21">
									<a target="_blank"
										href="${pageContext.request.contextPath}/workflow/viewWorkflowImg/${pd.diagramResourceName}/${pd.deploymentId}">查看流程图</a>
								</div></td>
						</tr>
					</c:forEach>
				</table></td>
		</tr>
	</table>
	<hr>
	<br />
	<!-- 发布流程 -->

	<table width="100%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="30"><table width="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td height="24" bgcolor="#353c44"><table width="100%"
								border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td><table width="100%" border="0" cellspacing="0"
											cellpadding="0">
											<tr>
												<td width="6%" height="19" valign="bottom"><div
														align="center">
														<img
															src="${pageContext.request.contextPath }/images/tb.gif"
															width="14" height="14" />
													</div></td>
												<td width="94%" valign="bottom"><span class="STYLE1">部署流程定义</span></td>
											</tr>
										</table></td>
									<td><div align="right">
											<span class="STYLE1"> </span>
										</div></td>
								</tr>
							</table></td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td>
				<div align="left" class="STYLE21">
					<form
						action="${pageContext.request.contextPath }/workflow/deployment"
						enctype="multipart/form-data" method="POST">
						流程名称:<input type="text" name="workflowName" style="width: 200px;" /><br />
						流程文件:<input type="file" name="workflowZip" style="width: 200px;" /><br />
						<input type="submit" value="上传流程" class="button_ok" />
					</form>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>