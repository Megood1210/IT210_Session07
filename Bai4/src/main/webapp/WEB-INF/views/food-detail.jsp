<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 4/13/2026
  Time: 6:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Chi tiết món ăn</title>
</head>
<body>

<h2>Chi tiết món ăn</h2>

<p style="color:green">${message}</p>

<c:if test="${not empty food}">
    <p>ID: ${food.id}</p>
    <p>Tên: ${food.name}</p>
    <p>Danh mục: ${food.category}</p>
    <p>Giá: ${food.price}</p>
    <p>Đường dẫn ảnh: ${food.imagePath}</p>
</c:if>

<c:if test="${empty food}">
    <p style="color:red">${error}</p>
</c:if>

<a href="${pageContext.request.contextPath}/food/add">Thêm mới</a>

</body>
</html>