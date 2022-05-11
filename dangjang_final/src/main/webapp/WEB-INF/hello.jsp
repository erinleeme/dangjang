<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring Boot Application with JSP</title></head>
<body> Hello, Spring Boot App
    <a href="#none" id="test">click</a>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $('#test').click(function(){
        $.ajax({
           type: 'post',
            url: '/dangjang/shop/test/ttt',
            success: function(){
               alert('성공!');
            }
        });
    })
</script>
</body>
</html>

