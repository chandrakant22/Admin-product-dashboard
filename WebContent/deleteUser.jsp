<%@page import="model.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int uid=Integer.parseInt(request.getParameter("i"));

int a=new UserDao().delete(uid);
if(a>0)
{
	response.sendRedirect("dashboard.jsp");
}
else
{
	out.print("Eerror :");
}
%>
</body>
</html>