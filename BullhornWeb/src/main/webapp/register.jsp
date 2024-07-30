<jsp:include page="meta.jsp" />
<jsp:include page="header.jsp" />
<title>Registration Page</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="css/login.css" />
<link rel="stylesheet" href="css/register.css">
<div class="jumbotron" id="jbtn">
	<div class="main">
		<h2 class="form-heading text-center">Create an Account</h2>
		<div id="errors"></div>
		<input type="hidden" id="err" name="errors" value="${status}">
	</div>
	<div class="card card-body" id="form-wrap">
		<form action="register" method="POST" id="fm" class="px-4 py-3">
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
				<label for="password">Password:</label> <input type="password"
					class="form-control" id="password" name="password"
					pattern="^(?=.*\d)(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9])\S{8,}$"
					title="Password must contain at least one number, 
                           one alphabet, one symbol, and be at 
                           least 8 characters long"
					required />
			</div>

			<div class="form-group">
				<label for="repassword">Re-type Password:</label> <input
					type="password" class="form-control" id="repassword"
					name="repassword"
					pattern="^(?=.*\d)(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9])\S{8,}$"
					title="Password must contain at least one number, 
                           one alphabet, one symbol, and be at 
                           least 8 characters long"
					required />
			</div>
			<div class="form-group">
				<label for="phone">Phone:</label> <input type="tel"
					class="form-control" id="phone" name="phone" maxlength="10"
					required />
			</div>


			<div class="form-group">
				<label for="gender">Gender:</label> <select id="gender"
					class="form-control" name="gender" required>
					<option value="male">Male</option>
					<option value="female">Female</option>
					
				</select>

			</div>
			<div class="form-group">
				<label for="dob">Date of Birth:</label> <input type="date"
					class="form-control" id="dob" name="dob" required />
			</div>
			<div class="form-group">
				<label for="dob">Motto:</label> 
				<textarea class="form-control" id="motto" name="motto" required >
				
				</textarea>
			</div>
			<div class="form-group " id="smt">
				<button type="submit" class="btn btn-primary">Sign Up</button>
			</div>
	</div>
	</form>
</div>
</div>
</div>
<jsp:include page="footer.jsp" />