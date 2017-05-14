<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	#table{
		border : 1px solid black;
	}
	
	td{
		border : 1px solid black;
		text-align:center;
	}
	
	tr{
		border : 1px solid black;
	}
	
	h1{
		font-size: 20px;
	}
	
	h2{
		font-size: 14px;
	}
</style>
<main>
	<h1><b>강좌 디테일 페이지 </b></h1>
	 
	 <table id="table">
		<c:forEach var="lec" items="${model.lectures}">		
		<tr>
			<td>강좌 명</td>
			<td>대상</td>
			<td>선생님 </td>
			<td>교재 제목</td>
		</tr>
		<tr>
			<td>${lec.title}</td>
			<td>${lec.forWho}</td>
			<td>${lec.memberName}</td>
			<td>${lec.bookTitle}</td>
		</tr>
		</c:forEach>
	</table>
	
	<table id="table">
	<h1><b>강좌 목차<b></h1>
	<c:forEach var="lec" items="${model.lectures}">	
		<tr>
			<td>강의 제목</td>
			<td>강의 시간</td>
		</tr>
			<c:forEach var="chaps" items="${lec.chapters}">
				<tr><h2>${chaps.title }</h2></tr>
					<c:forEach var="units" items="${chaps.units}">
						<tr>
							<td> ${units.title} </td>
							<td> ${units.duration} </td>
						</tr>
					</c:forEach>
			</c:forEach>		
	</c:forEach>
		
	</table>
</main>