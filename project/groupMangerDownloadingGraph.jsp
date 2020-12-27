<!DOCTYPE HTML>
<%@page import="java.sql.ResultSet"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		     <title>An Efficient Anti Collusion Data Sharing Mechanism for Data Confidentially for Dynamic Groups | Group Manger Dowloading  Graph   </title>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
		<script type="text/javascript" src="assest/js/jquery-1.9.1.min.js"></script>
		<style type="text/css">
${demo.css}
		</style>
		
		<%
		
		long FinalTime=0;
		
		String fileName=null;
		
	   String userEmail=null;
		
		ResultSet rs=(ResultSet)session.getAttribute("adminDownloadingGraphResultSession");
		
		//id, fileName, startTime, endTime, totalTime, userEmail
		
		while(rs.next()){
		
		FinalTime=rs.getLong(5);
		
		fileName=rs.getString(2);
		
		userEmail=rs.getString(6);
		
		}
		
		%>
	
		<script type="text/javascript">
$(function () {
    Highcharts.chart('container', {
        chart: {
            type: 'column'
        },
        title: {
            text: 'Anti Collusion  In Dowloading  Time  '
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories: [
                '<%=fileName%>  ',
             
               
             
            ],
            crosshair: true
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Time in Mili  Seconds '
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f} </b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },      plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [
        {
            name: '<%=fileName%> ',
            data: [<%=FinalTime%>]

        }]
    });
});
		</script>
	</head>
	<body>

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>

<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>

<a href="groupMangerSelectGraphType.jsp">Go Back</a>

<br>

<a href="LogoutController">Logout</a>

	</body>
</html>
