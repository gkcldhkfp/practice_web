<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
    crossorigin="anonymous">
    <title>Spring Legacy 2</title>
</head>
<body>
    <div class="container-fluid">
        <c:set var="pageTitle" value="POST LIST" />
        <%@ include file="../fragments/header.jspf" %>
    </div>

    <main class="container-fluid">
        <div class="mt-2 card">
            <div class="card-header">
                <h2>포스트 목록</h2>
            </div>
            <div class="card-body">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>작성시간</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="p" items="${posts}" >
                            <tr>
                                <td>${p.id}</td>
                                <td>${p.title}</td>
                                <td>${p.author}</td>
                                <td>${p.modifiedTime}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
    crossorigin="anonymous"></script>
</body>
</html>