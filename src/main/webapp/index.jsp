<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<html>
<head><title>Bienvenido</title></head>
<body onload="javascript:saludar();">
WEB module started
</body>
<script>
   function saludar() {
	   alert("Buenos días");
   }
</script>
</html>