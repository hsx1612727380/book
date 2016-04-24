<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>所有书籍</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
  </head>
  
  <body>
  	<center>
  		<h1>书籍列表</h1>
  		<table width="80%" border="1">
			<tr>
				<td>序号</td>
				<td>编号</td>
				<td>书名</td>
				<td>作者</td>
				<td>单价</td>
				<td>描述</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${books }" var="book" varStatus="status">
				<tr style="background-color: ${status.count % 2 == 0 ? '#FFE1FF' : '#DBE1FF' }">
					<td>${status.count }</td>
					<td>${book.key }</td>
					<td>${book.value.name }</td>
					<td>${book.value.author }</td>
					<td>￥${book.value.price }元</td>
					<td>${book.value.description }</td>
					<td>
						<a href="${pageContext.request.contextPath }/buyBookServlet?bookId=${book.key}">购买</a>
					</td>
				</tr>
			</c:forEach>
  		</table>
  	</center>
  </body>
</html>
