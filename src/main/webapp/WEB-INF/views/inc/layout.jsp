<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>으갹갹갹</title>
<link href="/MavenPrj/resource/css/customer/style.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<!-- ---------------------------------------------헤 더------------------------------------------------------------ -->
	<!-- 헤더부분 -->
	<tiles:insertAttribute name="header" />
	<!-- ---------------------------------------------비주얼------------------------------------------------------------ -->
	<!-- 비주얼 부분 -->
	<tiles:insertAttribute name="visual" />
	<!-- -----------------------------------------------바디---------------------------------------------------------- -->
	<div id="body">
		<!-- 섹션과 메인을 div로 묶어줌 -->
		<div class="content-container clearfix">
			<!-- 어사이드 부분 -->
			<tiles:insertAttribute name="aside" />
			
			<!-- 메인 부분 -->
			<tiles:insertAttribute name="main" />
		</div>
	</div>

	<!-- -----------------------------------------------푸터---------------------------------------------------------- -->
	<!-- 푸터부분 -->
	<tiles:insertAttribute name="footer" />
</body>
</html>