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
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/main.css" />
</head>
<body>
<jsp:include page="/inc/head.jsp"></jsp:include>  
<div class="mt85">
	<div class="col-sm-2 col-md-2">
		<form action="${ctx}/loglevel"  method="post">
		  <div class="form-group">
		    <label for="log_level"><strong>Log Level</strong></label>
		    <select id="log_level"  name="loglevel" class="form-control mt12">
		      <option value="ALL" selected="selected">ALL</option>
		      <option value="TRACE">TRACE</option>
		      <option value="DEBUG">DEBUG</option>
		      <option value="INFO">INFO</option>
		      <option value="WARN">WARN</option>
		      <option value="ERROR">ERROR</option>
		      <option value="FATAL">FATAL</option>
		    </select>	   
		  </div>
		</form>
	</div>
	<div class="col-sm-10 col-md-10">
		<div class="table-responsive">
				<table class="table table-hover table-condensed">
						<thead>
							<tr>
								<th>TimeStamp</th>
								<th>Log Marker</th>
								<th>Logger</th>
								<th>Log Level</th>
								<th>Current Thread</th>
								<th>Log Message</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="log"  items="${logs}">
								<tr>
									<td>${log.timeStamp}</td>
									<td width="100px">${log.logMarker}</td>
									<td>${log.logger}</td>
									<td width="100px">${log.logLevel}</td>
									<td>${log.currentThread}</td>
									<td>${log.logMessage}</td>
								</tr>
							</c:forEach>
						</tbody>
				</table>
			</div>
		</div> 	
</div>
<script type="text/javascript" src="${ctx}/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"> 
    $(function(){
    	$("#log_level").val('${loglevel}');
    	$("#log_level").change(function(){
    		$('form').submit();
    	})
    })
</script>
</body>
</html>