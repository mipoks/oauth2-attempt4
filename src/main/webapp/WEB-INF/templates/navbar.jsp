<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<html>
<head>
    <meta charset="UTF-8"/>
</head>
<body>

<header class="blog-header py-3">
    <div class="row flex-nowrap justify-content-between align-items-center">
        <div class="col-4 pt-1">
            <a class="text-muted" href="#"></a>
        </div>
        <div class="col-4 text-center">
            <h3><a class="blog-header-logo text-dark" href="${pageContext.request.contextPath}/">NoPoster</a></h3>
        </div>
        <div class="col-4 d-flex justify-content-end align-items-center">
            <a class="text-muted" href="#">
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none"
                     stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                     class="mx-3">
                    <circle cx="10.5" cy="10.5" r="7.5"></circle>
                    <line x1="21" y1="21" x2="15.8" y2="15.8"></line>
                </svg>
            </a>
            <a class="btn btn-sm btn-outline-secondary" href="${pageContext.request.contextPath}/create"><s:message code='navbar.create'/></a>
        </div>
    </div>
    <div class="nav-scroller py-1 mb-2">
        <nav class="nav d-flex justify-content-between">
            <a class="p-2 text-muted" href="${pageContext.request.contextPath}/news"><s:message code='navbar.news'/></a>


            <a class="p-2 text-muted" href="#"><s:message code='navbar.design'/></a>
            <a class="p-2 text-muted" href="#"><s:message code='navbar.culture'/></a>
            <a class="p-2 text-muted" href="#"><s:message code='navbar.business'/></a>
            <a class="p-2 text-muted" href="#"><s:message code='navbar.politics'/></a>
            <a class="p-2 text-muted" href="#"><s:message code='navbar.opinion'/></a>
            <a class="p-2 text-muted" href="#"><s:message code='navbar.science'/></a>
            <a class="p-2 text-muted" href="#"><s:message code='navbar.health'/></a>
            <a class="p-2 text-muted" href="#"><s:message code='navbar.style'/></a>
            <a class="p-2 text-muted" href="#"><s:message code='navbar.travel'/></a>
        </nav>
    </div>
</header>
</body>
</html>
