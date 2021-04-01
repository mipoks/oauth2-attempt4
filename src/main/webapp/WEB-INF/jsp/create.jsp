<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="https://cdn.ckeditor.com/ckeditor5/25.0.0/balloon/ckeditor.js"></script>

    <title><s:message code='page.create.title'/></title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
</head>

<body>

<div class="container">
    <jsp:include page="/WEB-INF/templates/navbar.jsp" flush="true"/>
</div>

<%--ToDo add modelAttribute--%>
<main role="main" class="container">
    <div class="row">
        <div class="col-md-8 blog-main">
            <form:form method="post" id="post" action="${pageContext.request.contextPath}/create" class="blog-post"  modelAttribute="pageDto">
                <form:input name="title" class="blog-post-title" path="title"/>
                <form:input name="text" path="text" hidden="true"/>
                <div id="editor">
                    <p>
                        <c:if test="${empty pageDto.getText()}">
                            <s:message code='create.text'/>
                        </c:if>
                        <c:if test="${!empty pageDto.getText()}">
                            ${pageDto.getText()}
                        </c:if>
                    </p>
                </div>
                <form:select name="owner" path="owner">
                    <c:forEach items="${owners}" var="owner">
                        <option value="${owner.getName()}">
                                ${owner.getName()}
                        </option>
                    </c:forEach>
                </form:select>
                <input type="submit" value="<s:message code='create.btn.create'/>" class="btn btn-outline-primary">
            </form:form>
        </div>
        <jsp:include page="/WEB-INF/templates/langFooter.jsp" flush="true"/>

    </div>
</main>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/holderjs@2.9.4/holder.js"></script>
<script>
    Holder.addTheme('thumb', {
        bg: '#55595c',
        fg: '#eceeef',
        text: 'Thumbnail'
    });
</script>
<script>
    let theEditor;
    BalloonEditor
        .create(document.querySelector('#editor'))
        .then(editor => {
            theEditor = editor;
        })
        .catch(error => {
            console.error(error);
        });

    var my_func = function (event) {
        console.log("we prevented")
        event.preventDefault();
        form.text.value = theEditor.getData();
        console.log(form.text.value)
        form.submit();
    };
    var form = document.getElementById("post");
    form.addEventListener("submit", my_func, true);
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