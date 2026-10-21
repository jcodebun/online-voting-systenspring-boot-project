<%@page import="com.online.voting.dto.UserDTO"%>
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
    <title>Vote Page</title>
</head>
<body>

	 <%
		UserDTO userBean = (UserDTO) session.getAttribute("user");
	%>
	
	
<div class="container mt-4" style="position: relative; min-height: 70vh">
<div class="container mt-5 pt-5 align-items-center">
<div class="card bg-light">
 <b class="text-center"><%@ include file="businessMessage.jsp"%></b>
<div class="cardbody mx-auto">
    <h4 class="card-title mt-3 text-center">Vote Form</h4>
     <p class="text-center">Please Put Your Voter Card Number and Select Vote !!</p>  

<!-- Form Start -->
<sf:form method="post" action="${pageContext.request.contextPath}/dovote" modelAttribute="form">
						
  <!-- Voter Card Number -->
     <font color="red" style="font-size: 13px"><sf:errors path="${status.expression}" /></font>
  <div class="form-group input-group">
    <div class="input-group-prepend">
        <span class="input-group-text">
            <i class="fa fa-address-book"></i>
        </span>
    </div>
    <sf:input path="${status.expression}" type = "text" placeholder="Enter Voter Card Number" class="form-control"  value="<%=userBean.getVotercardnumber()%>"  readonly="true"/>
    
  </div>
  <!-- Voter Card Number End -->
  
   <!-- Vote -->
    <font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
<div class="form-group input-group">
    <div class="input-group-prepend">
        <span class="input-group-text">
            <i class="fa fa-hand-pointer-o"></i>
        </span>
    </div>
                       <s:bind path="partyid">
                     <sf:select class="form-control" path="${status.expression}" required="true">
						 	<sf:option value="-1" label="----Select----" />
							<sf:options itemLabel="partyName" itemValue="id" items="${partylist}"/>
					</sf:select>
					</s:bind>
						</div>
  <!-- Vote End -->

<input type="submit" class="btn btn-block btn-primary" name="operation" value="Vote">

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