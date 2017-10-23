<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
var type = navigator.userAgent.match(/.*Mobile.*/)?"mobile":"pc";
if(type=="mobile"){
 	window.location.href='mobile/index';
}else{
	window.location.href='admin/index';
}
</script>
<%-- <%
	response.sendRedirect("admin/index");
%> --%>