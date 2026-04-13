<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 4/13/2026
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<html>
<head>
    <title>Thêm món ăn</title>
</head>
<body>

<h2>Thêm món ăn</h2>
<form action="${pageContext.request.contextPath}/food/add" method="post" enctype="multipart/form-data">
    Tên món:
    <input type="text" name="name"/><br/><br/>

    Danh mục:
    <select name="category">
        <c:forEach var="c" items="${categories}">
            <option value="${c}">${c}</option>
        </c:forEach>
    </select><br/><br/>

    Giá:
    <input type="number" name="price"/><br/><br/>

    Ảnh:
    <input type="file" name="image"/><br/><br/>

    <button type="submit">Thêm</button>
</form>

</body>
</html>
