<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<html>
<head>
    <meta charset="UTF-8"/>
</head>
<body>
<aside class="col-md-4 blog-sidebar">
    <div class="p-3">
        <h4 class="font-italic"><s:message code='footer.read'/></h4>
        <ol class="list-unstyled">
            <li><a href="${pageContext.request.contextPath}/change?locale=ru_RU">Русский</a></li>
            <li><a href="${pageContext.request.contextPath}/change?locale=en_EN">English</a></li>
            <li><a href="#">Deutsche</a></li>
        </ol>
    </div>
</aside>
</body>
</html>
