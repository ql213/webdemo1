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
	<div class="col-sm-6 col-md-6">
		<div id="piecontainer" >
		</div>
	</div>
	<div class="col-sm-6 col-md-6">
		<div id="linecontainer" >
		</div>
	</div> 	
</div>

<script type="text/javascript" src="${ctx}/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/highchart/js/highcharts.js" ></script>
<script type="text/javascript"> 
    $(function(){
    	var piedata = [];
        var respiedata = JSON.parse('${piedata}');
         $.each(respiedata, function(i,d){
        	 piedata.push([d.logLevel,d.num]);
         });
         
     	var linedata = [];
        var reslinedata = JSON.parse('${linedata}');
         $.each(reslinedata, function(i,d){
        	 linedata.push(d);
         });
         
         $('#linecontainer').highcharts({
             chart: {
                 type: 'spline'
             },
             title: {
                 text: 'Logs Over Time'
             },
             xAxis: {
                 type: 'datetime',
                 title: {
                     text: null
                 }
             },
             yAxis: {
                 title: {
                     text: null
                 },
                 min: 0
             },
             tooltip: {
            	 formatter: function () {
                     return '<b>' + this.series.name + '</b><br/>' +
                             Highcharts.dateFormat('%Y-%m-%d', this.x) + '<br/>' + '<span style="color:#08c">' +
                            this.y + '</span>';
                 }
             },
             plotOptions: {
                 spline: {
                     marker: {
                         enabled: true
                     }
                 }
             },
             series: [ ]
         });
         
         var linechart = $('#linecontainer').highcharts();
         
         $.each(linedata, function(i,d){
        	 linechart.addSeries({  
                 name: d.logLevel,  
                 data: (function() {
                     var data = [];
                     var len = d.timestampNumList.length;  
      
                     for (var idx = 0; idx < len; idx++) { 
                         data.push([
                        	Date.UTC(d.timestampNumList[idx].year, d.timestampNumList[idx].month -1, d.timestampNumList[idx].day),
                            d.timestampNumList[idx].num 
                         ]); 
                     } 
                     return data; 
                 })() 
		     }); 
         });
         
		$('#piecontainer').highcharts({
		        chart: {
		            plotBackgroundColor: null,
		            plotBorderWidth: null,
		            plotShadow: false
		        },
		       /* colors:[
		                '#7CB5EC',//第一个颜色
		                '#ff6c6b',//第二个颜色
		               ],*/
		        title: {
		            text: 'Log Types'
		        },
		   
		        plotOptions: {
		            pie: {
		                allowPointSelect: true,
		                cursor: 'pointer',
		                dataLabels: {
		                    enabled: true,
		                    color: '#000000',
		                    connectorColor: '#000000',
		                    format: '<b>{point.name}</b>: {point.y}',
		                },
		                showInLegend: true
		            }
		        },
		        series: [{
		            type: 'pie',
		            name: 'Number',
		            data: piedata
		        }]
		 });
    })
    </script>
</body>
</html>