<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<title>手机</title>
<meta charset="UTF-8">  
<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link  rel="stylesheet" href="${ctx}/jslib/easyui1.4.2/themes/gray/easyui.css" type="text/css">
<link rel="stylesheet"  href="${ctx}/jslib/easyui1.4.2/themes/mobile.css" type="text/css" >
<link rel="stylesheet"  href="${ctx}/jslib/easyui1.4.2/themes/icon.css" type="text/css" >

<script src="${ctx}/jslib/easyui1.4.2/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${ctx}/jslib/easyui1.4.2/jquery.easyui.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${ctx}/jslib/easyui1.4.2/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>
<script src="${ctx}/jslib/easyui1.4.2/jquery.easyui.mobile.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/jslib/extJs.js" charset="utf-8"></script>


</head>
<body>
	<div class="easyui-navpanel" style="position:relative;padding:20px">
        <header>
            <div class="m-toolbar">
                <div class="m-title">Basic Form</div>
                <div class="m-right">
                    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#ff').form('reset')" style="width:60px">Reset</a>
                </div>
            </div>
        </header>
        <form id="ff">
            <div>
                <label>Full name</label>
                <input class="easyui-textbox" prompt="Full name" style="width:100%">
            </div>
            <div>
                <label>Birthday</label>
                <input class="easyui-datebox" prompt="Birthday" data-options="editable:false,panelWidth:220,panelHeight:240,iconWidth:30" style="width:100%">
            </div>
            <div>
                <label>Password</label>
                <input class="easyui-textbox" type="password" prompt="Password" style="width:100%">
            </div>
            <div>
                <label>Number</label>
                <input class="easyui-numberbox" prompt="Number" style="width:100%">
            </div>
            <div>
                <label>Volumn</label>
                <input class="easyui-slider" value="10" style="width:100%">
            </div>
        </form>
    </div>
    <style scoped>
        form label{
            display: block;
            margin: 10px 0 5px 0;
        }
    </style>
</body>
</html>