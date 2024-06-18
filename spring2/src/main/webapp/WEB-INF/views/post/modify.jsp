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
    <title>DETAILS</title>
</head>
<body>
    <div class="container-fluid">
        <c:set var="pageTitle" value="POST MODIFY" />
        <%@ include file="../fragments/header.jspf" %>
    
    
     <main>
            <div class="mt-2 card">
                <div class="card-header">
                    <h2>포스트 수정하기</h2>
                </div>
                <div class="card-body">
                    <form id="modifyForm">
                       <div class="mt-2">
                            <label for="id" class="form-label">번호</label>
                            <input id="id" name ="id" class="form-control" type="text" value="${post.id}" readonly/> 
                        </div>
                        <div class="mt-2">
                            <label for="title" class="form-label">제목</label>
                            <input id="title" name ="title" class="form-control" type="text" value="${post.title}"/> 
                        </div>
                        <div class="mt-2">
                            <label for="content" class="form-label">내용</label>
                            <textarea id="content" name ="content" class="form-control" rows="5">${post.content}</textarea>
                        </div>
                        <div class="mt-2">
                            <label for="author" class="form-label">작성자</label>
                            <input id="author" class="form-control" type="text" value="${post.author}" readonly/> 
                        </div>
                    </form>
                </div>
                <div class="card-footer">
                    <c:url var="postDetailPage" value="/post/details">
                        <c:param name="id" value="${post.id}" />
                    </c:url>
                    <button class ="btn btn-outline-danger" id="btnDelete" >삭제</button>
                    <button class ="btn btn-outline-success" id="btnUpdate" >업데이트</button>
                </div> 
            </div>
            
         </main>
        </div>
    
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
    crossorigin="anonymous"></script>
    
     <!-- Axio JS 라이브러리 -->
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    
    <c:url var="post_modify_js" value="/js/post_modify.js"/>
    <script src="${post_modify_js}"></script>
</body>
</html>