<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Dictionary Service</h1>
	<div id="divContent">Waiting for response ...</div>
	
	<form action="${pageContext.request.contextPath}" method="post">
	  <input type="submit" name="submit" value="Make another query"/>
	</form>
	  
	  ${jobID}
</body>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
sleep();
function sleep() {
	   var currentTime = new Date().getTime();

	   while (currentTime + 1000 >= new Date().getTime()) {
	   }
	   
	   $.get("${pageContext.request.contextPath}/query?jobID=" +${jobID}, function(data) 
		{
		   	$('#divContent').html(data);
		   	sleep();
	    });
	  	
	}
</script>
</html>