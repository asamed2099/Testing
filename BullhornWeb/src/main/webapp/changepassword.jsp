
<%@page import="service.DbUserOperations"%>
<%@page import="studs.User"%>
<% 
		User usr =null;
        String email ="";
        int size=100;
	if(session.getAttribute("user") == null){
		
		response.sendRedirect("login.jsp");
		return;
		
	}
	if(session.getAttribute("user") != null){
		usr = (User)session.getAttribute("user"); 
		 email = usr.getEmail(); 
	}
%>
<jsp:include page="meta.jsp" />
<title>Profile|Change Password</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/profile.css" />
<jsp:include page="header.jsp" />
<div class="contain">
	<div class="leftside">
		<div class="photo">
			<img alt="Profile photo" src="<%=DbUserOperations.getGravatarUrl(email, size) %>">
		</div>
			
		<div class="bio">
		
		<p><h1>Profession</h1> </p>
		<p><h4>Company Name</h4></p>
		<p><h5>Years of Experience</h5></p>
		<p></p>
		
		</div>
		
		<div class="settings">
			<ul class="list-group">
			  <li class="list-group-item">
				 <a href="profilesettings.jsp">Update Profile</a> 
			  </li>
			  <li class="list-group-item"><a href="changepassword.jsp">Change Password</a> </li>
			  <li class="list-group-item">also link</li>
			  
			</ul>
		
		</div>
		
	
	</div>
	<div class="rightside">
		<div class="main">
		<h2 class="form-heading text-center">Change Password</h2>
		<div id="errors"></div>
		<input type="hidden" id="err" name="errors" value="${status}">
	</div>
	<div class="card card-body" id="settingsform" style="">
		<form action="ChangePassword" method="POST" id="fm" class="px-4 py-3" >
			<img src="images/regt.png" alt="">
			
		
			<div class="form-group">
				<label for="oldpassword">Enter Old Password:</label> <input type="password"
					class="form-control" id="oldpassword" name="oldpassword" required />
			</div>

			<div class="form-group">
				<label for="newspassword">New Password:</label> <input type="password"
					class="form-control" id="newpassword" name="newpassword"
					pattern="^(?=.*\d)(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9])\S{8,}$"
					title="Password must contain at least one number, 
                           one alphabet, one symbol, and be at 
                           least 8 characters long"
					required  />
			</div>
			<div class="form-group">
				<label for="newspassword">Retype New Password:</label> <input type="password"
					class="form-control" id="cpassword" name="cpassword"
					pattern="^(?=.*\d)(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9])\S{8,}$"
					title="Password must contain at least one number, 
                           one alphabet, one symbol, and be at 
                           least 8 characters long"
					required  />
			</div>
			<div class="form-group " id="smt">
				<button type="submit" class="btn btn-primary">Change Password</button>
			</div>
			</form>
	</div>
	
	</div><!-- End of rightside  -->
</div>
		
		
	</div>

</div>


<jsp:include page="footer.jsp" />