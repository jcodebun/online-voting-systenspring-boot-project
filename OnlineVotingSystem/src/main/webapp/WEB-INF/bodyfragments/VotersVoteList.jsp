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
<title>Insert title here</title>
</head>
<body>
	<br>
	<c:url var="delete" value="/Delete" />
	<c:url var="update" value="/update" />

	<h2 align="center">Voters Vote List</h2>
	<br>
	<div class="container mt-4"
		style="position: relative; min-height: 72vh">

		<sf:form method="post"
			action="${pageContext.request.contextPath}/VotersVoteList"
			modelAttribute="form">


			<%-- <table width="100%">
				<tr>
					<td align="center"><s:bind path="partyName">
							<sf:input path="${status.expression}" type="text" name="name"
								placeholder="Search By Name" value="" />
						</s:bind> &emsp;&emsp; <input type="submit" name="operation" value="Search">&nbsp;&nbsp;&nbsp;<input
						type="submit" name="operation" value="Reset"></td>
				</tr>
			</table> --%>
			<br>
			<b class="text-center"><%@ include file="businessMessage.jsp"%></b>
			<table class="table table-striped table table-dark">
				<tr>

					<th scope="col">Voter Card Number</th>
					<th scope="col">Party</th>
					<th scope="col">Voters</th>
				</tr>

				<c:forEach items="${list}" var="votersvotelist">
					<tr>
						<td>${votersvotelist.votercardnumber}</td>
						<td>${votersvotelist.vote}</td>
						<%-- <td>${votersvotelist.userid}</td> --%>


						 <td><%--<a class="btn btn-info"
							href="${update}?id=${votersvotelist.id}"><i class='fas fa-edit'
								style='font-size: 15px;'></i></a>&nbsp;&nbsp;&nbsp; --%>
								 
								<a
							class="btn btn-danger" href="${delete}?id=${votersvotelist.id}"><i
								class='	far fa-trash-alt' style='font-size: 15px;'></i></a></td>

					</tr>
				</c:forEach>
				</tbody>
			</table>


		</sf:form>


	</div>
</body>
</html>