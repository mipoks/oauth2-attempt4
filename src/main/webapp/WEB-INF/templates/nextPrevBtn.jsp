<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<html>
<head>
    <meta charset="UTF-8"/>
</head>
<body>
<nav class="blog-pagination">

    <a class="btn btn-outline-primary ${pagePrev < 0 ? "disabled" : ""}" href="${pageContext.request.contextPath}/news?page=${pagePrev}"><s:message
            code='btn.newer'/></a>
    <a class="btn btn-outline-primary ${pages.size() < 5 ? "disabled" : ""}" href="${pageContext.request.contextPath}/news?page=${pageNext}"><s:message
            code='btn.older'/></a>

</nav>
</body>
</html>
