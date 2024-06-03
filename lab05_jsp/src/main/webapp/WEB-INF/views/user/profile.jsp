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
    <title>Lab 5</title>
</head>
<body>
    <div class="container-fluid">
        <c:url var="pageTitle" value="User Profile" /> <%-- scope의 기본값은 page --%> 
        <%@ include file="../fragments/header.jspf" %>
        
        <main>
            <div class="mt-2 card">
                <div class="card-header">
                    <h2>내 정보</h2>
                </div>
                <div class="card-body">
                    <form>
                        <div class="mt-2">
                            <label for="userid" class="form-label">아이디</label>
                            <input id="userid" class="form-control" type="text" value="${userInfo.userid}" readonly/> 
                        </div>
                        <div class="mt-2">
                            <label for="password" class="form-label">비밀번호</label>
                            <input id="password" class="form-control" type="text" value="${userInfo.password}" readonly/> 
                        </div>
                        <div class="mt-2">
                            <label for="email" class="form-label">이메일</label>
                            <input id="email" class="form-control" type="email" readonly value="${userInfo.email}"/>
                        </div>
                        <div class="mt-2">
                            <label for="points" class="form-label">포인트</label>
                            <input id="points" class="form-control" type="text" value="${userInfo.points}" readonly/> 
                        </div>
                       
                    </form>
                </div>
             </div>
        </main>
    </div>
    
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
    crossorigin="anonymous"></script>
</body>
</html>