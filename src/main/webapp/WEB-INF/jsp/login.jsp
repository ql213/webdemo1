<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<head>
<title>webdemo1</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="description" content=" demo" />
<meta name="keywords" content="demo"/>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/public.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/login.css" />
</head>
<body class="demo-lg">
<div class="login">
	<div class="txt-lt mb24"><h1 class="fl" href="/zjhome/login/0">Log in</h1><em class="fl icon-lock"></em></div>
    <form action="${ctx}/login" method="post">
    	 <div id="message" class="clear mb24">
       		 <c:if test="${!empty message}">
               	<div class="alert alert-danger">${message}</div>
        	</c:if>
        </div>
        <label for="id_userid" class="mb6">User ID:</label>
        <div id="id_userid">
            <input name="userId" class="form-control border"  type="text" data-required>
        </div>
        <label for="id_password" class="mb6">Password:</label>
        <div id="id_password">
            <input name="password" class="form-control border"  type="password" data-required>
        </div>

        <div class="mt32">
            <input type="submit" class="btn btn-default" value="Log In →">  
        </div>
    </form>
</div>
<script type="text/javascript" src="${ctx}/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery-validate.js"></script>
<script type="text/javascript"> 
    $(function(){
        $('form').validate({
            onKeyup : true,
            onChange : true,
            eachValidField : function() {
                $(this).closest('div').removeClass('has-error').addClass('has-success');
            },
            eachInvalidField : function() {
                $(this).closest('div').removeClass('has-success').addClass('has-error');
            },
            description : {
                message : {
                    required : '<div class="alert alert-danger">Forget user id or password ?</div>'
                }
            }
        });
    })
</script>
</body>
</html>