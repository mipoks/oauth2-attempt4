<%@ page import="java.util.Random" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title><s:message code='page.index.title'/></title>

    <script src="https://cdn.ckeditor.com/ckeditor5/25.0.0/balloon/ckeditor.js"></script>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
</head>

<body>

<div class="container">
    <jsp:include page="/WEB-INF/templates/navbar.jsp" flush="true"/>
</div>

<main role="main" class="container">
    <div class="row">
        <div class="col-md-8 blog-main">

            <c:forEach var="page" items="${pages}">
                <div class="blog-post">
                    <c:if test="${not empty page.date}">
                        <h2 class="blog-post-title">${page.title}</h2>
                        <p class="blog-post-meta">Posted ${page.date} by <a href="#">${page.owner.name}</a></p>
                        <p>${page.getSmallText()}</p>
                        <p><a href="${pageContext.request.contextPath}/post/${page.id}"><s:message
                                code='page.index.readAll'/></a></p>
                    </c:if>
                </div>
            </c:forEach>

            <jsp:include page="/WEB-INF/templates/nextPrevBtn.jsp" flush="true"/>

        </div>

        <jsp:include page="/WEB-INF/templates/langFooter.jsp" flush="true"/>

    </div>
</main>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js"
        integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js"
        integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/holderjs@2.9.4/holder.js"></script>
<script>
    Holder.addTheme('thumb', {
        bg: '#55595c',
        fg: '#eceeef',
        text: 'Thumbnail'
    });
</script>


<svg xmlns="http://www.w3.org/2000/svg" width="200" height="250" viewBox="0 0 200 250" preserveAspectRatio="none"
     style="display: none; visibility: hidden; position: absolute; top: -100%; left: -100%;">
    <defs>
        <style type="text/css"></style>
    </defs>
    <text x="0" y="13" style="font-weight:bold;font-size:13pt;font-family:Arial, Helvetica, Open Sans, sans-serif">
        Thumbnail
    </text>
</svg>
</body>
</html>