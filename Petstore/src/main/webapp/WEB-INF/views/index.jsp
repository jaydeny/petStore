<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><spring:message code="title" /></title>
    <style>
        .errors{
            color: red;
        }
    </style>
</head>
<body>

<spring:message code="global.greeting" arguments="${user},~~~" argumentSeparator="," />

<div>
    <spring:message code="page.cl" />
    <br>
    <a href="/cl/zh">中文</a>
    <a href="/cl/en">English.</a>
    <a href="/cl/jp">日本</a>
    <br><br>
</div>

<div style="border: 1px solid red;margin: auto;height: 100px;text-align: center">
    <spring:message code="context.cl" />
</div>

<form:form action="/cl/user" method="post" modelAttribute="user" >
    <div class="errors">
        <form:input  path="id"/>
        <form:errors path="id" />
    </div>
    <div class="errors">
        <form:input  path="username"/>
        <form:errors path="username" />
    </div>

    <input type="submit" value="提交">
</form:form>

</body>
</html>
