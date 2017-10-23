<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
		<table class="grid">
			<tr>
				<td>名称</td>
				<td>${demo.name}</td>
			</tr>
			<tr>
				<td>备注</td>
				<td colspan="3">${demo.description}</td>
			</tr>
		</table>
	</div>
</div>