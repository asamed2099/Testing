
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
<title>Profile| Settings</title>
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
		<h2 class="form-heading text-center">Profile Settings</h2>
		<div id="errors"></div>
		<input type="hidden" id="err" name="errors" value="${status}">
	</div>
	<div class="card card-body" id="settingsform" style="">
		<form action="EditProfileServlet" method="POST" id="fm" class="px-4 py-3" enctype = "multipart/form-data">
			<img src="images/regt.png" alt="">
			
		
			<div class="form-group">
				<label for="fullname">Full Name:</label> <input type="text"
					class="form-control" id="fullname" name="fullname" required />
			</div>

			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" id="email" name="email"
					placeholder="email@example.com" required />
			</div>
			
			<div class="form-group">
				<label for="phone">Phone:</label> <input type="tel"
					class="form-control" id="phone" name="phone" maxlength="10"
					required />
			</div>
			<div class="form-group">
				<label for="dob">Date of Birth:</label> <input type="date"
					class="form-control" id="dob" name="dob" required />
			</div>
			
			<div class="form-group">
				<label for="job">Job Title:</label> 
				<input type="text"
					class="form-control" id="job" name="job"
					 required />
			</div>

			<div class="form-group">
				<label for="job">Upload Profile Photo:</label> 
				<input type="file"
					class="form-control" id="profilephoto" name="profilephoto" />
			</div>
		<div class="form-group">
				<label for="phone">Address:</label> 
				<input type="text" class="form-control" id="address" name="address"  required/>

			</div>

			<div class="form-group">
				<label for="phone">City:</label> 
				<input type="text" class="form-control" id="city" name="city"  required />

			</div>
			<div class="form-group">
				<label for="phone">Country:</label> 
				<input type="text" class="form-control" id="country" name="country" required />

			</div>
			<div class="form-group">
				<label for="dob">Bio:</label> 
				<textarea class="form-control" id="bio" name="bio" required >
				
				</textarea>
			</div>
			<div class="form-group " id="smt">
				<button type="submit" class="btn btn-primary">Save Changes</button>
			</div>
			</form>
	</div>
	
	</div><!-- End of rightside  -->
</div>
		
		
	</div>

</div>


<jsp:include page="footer.jsp" />