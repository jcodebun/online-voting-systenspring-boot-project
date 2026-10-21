<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css">
    <title>Sign In</title>
    <style>
        .divider{
            position: relative;
            text-align: center;
            margin: 15px 0px;
        }
    </style>
</head>
<body>
<div class="container mt-4" style="position: relative; min-height: 81vh">
<div class="container mt-5 pt-5 align-items-cente">
<div class="card bg-light">
<div class="cardbody mx-auto">
    <h4 class="card-title mt-3 text-center">Add Parties</h4>


<!-- Form Start -->
<sf:form method="post" action="${pageContext.request.contextPath}/partysubmit" modelAttribute="form">
<br style="clear: both">
<%
						String uri = (String) request.getAttribute("uri");
						%>
						 <b class="text-center"><%@ include file="businessMessage.jsp"%></b>
  <!-- PartyName -->
    <s:bind path="partyName">
    <font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
  <div class="form-group input-group">
    <div class="input-group-prepend">
        <span class="input-group-text">
            <i class="fa fa-address-book"></i>
        </span>
    </div>
     
    <sf:input path="${status.expression}" type = "text"
							placeholder="Enter PartyName" class="form-control" />
			</div>			
    </s:bind>
  
  <!-- PartyName End -->

<!-- president -->
<s:bind path="president">
<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
<div class="form-group input-group">
    <div class="input-group-prepend">
        <span class="input-group-text">
            <i class="fa fa-user"></i>
        </span>
    </div>
    
    <sf:input path="${status.expression}" type="text"
							placeholder="Enter President" class="form-control" />
				 </div>		
    </s:bind>
 
  <!-- president End -->

<input type="submit" class="btn btn-block btn-success" name="operation" value="Submit">


</sf:form>
  <!-- Form End -->
</div>
</div>
</div>
<div class="mt-5">
</div>
</div>
</body>
</html>