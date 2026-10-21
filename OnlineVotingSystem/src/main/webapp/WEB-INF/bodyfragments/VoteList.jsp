<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vote List</title>
</head>
<body>
	<br>
	<c:url var="delete" value="/home/Delete" />
	<c:url var="update" value="/home/update"/>
	
	<h2 align="center" class="mt-4">Vote List</h2>
	<br>
	<div class="container mt-4"
		style="position: relative;min-height: 58vh";>

		<sf:form method="post"
			action="${pageContext.request.contextPath}/voteList"
			modelAttribute="form">
             <b class="text-center"><%@ include file="businessMessage.jsp"%></b>
			<table class="table table-striped table table-dark">
			
		     	<tr>
					<!-- <td scope="col" class="bg-dark text-white font-weight-bold">Logo</td> -->
					<td scope="col" class="bg-dark text-white font-weight-bold">Name</td>
					<td scope="col" class="bg-dark text-white font-weight-bold">Vote</td>
				</tr>
					
					<c:forEach items="${collectMap}" var="vote">
					<tr class="mt-5">
<%-- 					<td scope="col"><img src="${pageContext.request.contextPath}/resources/img/${vote.key}.jpg" class="rounded-circle" alt="..." width="100px" height="100px"></td>
 --%>					<td  scope="col"><font size="13px"><b>${vote.key}</font></b></td>
					<td  scope="col"><font size="10px"><b>${vote.value}</font></b></td>
					</tr>
                    </c:forEach>
				
			</table>


		</sf:form>


	</div>
</body>
</html>