<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>购买列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

  </head>
  
  <body>
  	<center>
  		<c:if test="${!empty sessionScope.bookCart.map }">
	  		<h1>您购买了下列书籍</h1>
	  		<table width="80%" border="1">
	  			<tr>
	  				<td>序号</td>
	  				<td>书名</td>
	  				<td>作者</td>
	  				<td>单价</td>
	  				<td>数量</td>
	  				<td>小计</td>
	  				<td>操作</td>
	  			</tr>
	  			<!-- 注items="${sessionScope.bookCart.map }"这里使获取某一个购物项的内容 -->
	  			<c:forEach items="${sessionScope.bookCart.map }" var="cartItem" varStatus="status">
	  				<tr>
	  					<td>${status.count }</td>
	  					<td>${cartItem.value.book.name }</td>
	  					<td>${cartItem.value.book.author }</td>
	  					<td>￥${cartItem.value.book.price }元</td>
	  					<td>
	  						<input ty="text" size="5" name="num" id="num" value="${cartItem.value.num }" onblur="changeNum(this, '${cartItem.value.book.id }', '${cartItem.value.num }');"/>
	  					</td>
	  					<td>￥${cartItem.value.price }元</td>
	  					<td>
	  						<a href="javascript:toDelete('${cartItem.value.book.id }');">删除</a>
	  					</td>
	  				</tr>
	  			</c:forEach>
	  			<tr>
	  				<td colspan="2">
	  					<a href="javascript:clearCart();">清空购物车</a>
	  				</td>
	  				<td colspan="2">合计</td>
	  				<td colspan="3">￥${sessionScope.bookCart.price }元</td>
	  			</tr>
	  		</table>
	  	</c:if>
	  	<c:if test="${empty sessionScope.bookCart.map }">
	  		<h1>您没有购买任何书籍</h1>
	  	</c:if>
	</center>
  	
  	<script type="text/javascript">
  		function toDelete(bookId) {
  			var sure = window.confirm("您确定要删除吗？");
  			if (sure) {
				window.location.href = "${pageContext.request.contextPath }/deleteItemServlet?bookId=" + bookId;  				
  			}
  		}
  		
  		function clearCart() {
  			var sure = window.confirm("您确定要清空吗？");
  			if (sure) {
  				window.location.href = "${pageContext.request.contextPath }/clearCartItemServlet";
  			}
  		}
  		
  		function changeNum(inputObject, bookId, oldNum) {
  			var sure = window.confirm("您确定要修改为" + inputObject.value + "吗？");
  			if (sure) {
  				//提交
  				window.location.href = "${pageContext.request.contextPath }/changeNumServlet?bookId=" + bookId + "&num=" + inputObject.value;
  			}
  			else {
  				inputObject.value = oldNum;
  			}  			
  		}
  	</script>
  	
  </body>
</html>
