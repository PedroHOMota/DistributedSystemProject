<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dictionary Service</title>
</head>
<body>
	<h1>Dictionary Service</h1>
	
	<form action="${pageContext.request.contextPath}/query" method="post">
	  <input type="text" name="query" placeholder="Enter query here"/>
	  <input type="submit" name="submit" value="Submit" />
	</form>
	
	<script type="text/javascript">
	   function doPost(){
	     form1.submit();
	   }
	</script>
</body>
</html>