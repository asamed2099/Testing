<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="meta.jsp" />
    <title>BullHorn | Login</title>
     <link rel="stylesheet" href="css/main.css" />
      <link rel="stylesheet" href="css/login.css" />
  </head>
  <body>
    <div class="wrapper">
    <jsp:include page="header.jsp" />
    	<div class="jumbotron" id="jbtn">

 			<div class=""  id="error" style="text-align:center; width:30%; margin: 0px auto;" >  ${logsuccess}  </div>
    		<div class="form-container">
    			<h2>Choose user type to login</h2>
    			<p>
			  <a class="btn btn-primary" data-toggle="collapse" href="#admin" role="button" aria-expanded="false" aria-controls="collapseExample">
			    Admin
			  </a>
			   <a class="btn btn-primary" data-toggle="collapse" href="#user" role="button" aria-expanded="false" aria-controls="collapseExample">
			    User
			  </a>
			</p>
			<div class="collapse" id="admin">
				  <div class="card card-body">
				   <form class="px-4 py-3"  method="POST" action="LoginServlet">
				   <input type="hidden" name="action"  id="action" value="logout"/>
				    <div class="form-group">
				      <label for="exampleDropdownFormEmail1">Email address</label>
				      <input type="email" class="form-control" id="exampleDropdownFormEmail1" name="email" placeholder="email@example.com" required>
				    </div>
				    <div class="form-group">
				      <label for="exampleDropdownFormPassword1">Password</label>
				      <input type="password" name="password" class="form-control" id="exampleDropdownFormPassword1" placeholder="Password" required>
				    </div>
				    <div class="form-check">
				      <input type="checkbox" name="remember" class="form-check-input" id="dropdownCheck">
				      <label class="form-check-label" for="dropdownCheck">
				        Remember me
				      </label>
				    </div>
				    <button type="submit" class="btn btn-primary">Sign in</button>
  				</form>
  				<div class="dropdown-divider"></div>
  				<a class="dropdown-item" href="register.jsp">New around here? Sign up</a>
  				<a class="dropdown-item" href="#">Forgot password?</a>
				</div>
				   
				  </div>  <!-- End of collapsible admin -->
				  
				  <div class="collapse" id="user">
				  <div class="card card-body">
				   <form method="POST" action="" class="px-4 py-3">
				    <div class="form-group">
				      <label for="exampleDropdownFormEmail1">Email address</label>
				      <input type="email" class="form-control" id="exampleDropdownFormEmail1" placeholder="email@example.com">
				    </div>
				    <div class="form-group">
				      <label for="exampleDropdownFormPassword1">Password</label>
				      <input type="password" class="form-control" id="exampleDropdownFormPassword1" placeholder="Password">
				    </div>
				    <div class="form-check">
				      <input type="checkbox" class="form-check-input" id="dropdownCheck">
				      <label class="form-check-label" for="dropdownCheck">
				        Remember me
				      </label>
				    </div>
				    <button type="submit" class="btn btn-primary">Sign in</button>
  				</form>
  				<div class="dropdown-divider"></div>
  				<a class="dropdown-item" href="register">New around here? Sign up</a>
  				<a class="dropdown-item" href="#">Forgot password?</a>
				</div>
				   
				  </div>  <!-- End of collapsible = user -->
			</div> <!-- End of form container -->
				
		</div> <!-- End of form jumbotron -->
  	<section id="section">
  	.
  	</section>
   </div>
   <script>
       
   	 
   	  let error = document.getElementById("error");
   	  error.classList.add("alert");
	  error.classList.add("alert-primary");
	  setTimeout(eraseLogMessage, 10000);
   	 function eraseLogMessage(){
   		 error.innerHTML = "";
   		 error.classList.remove("alert");
   		 error.classList.remove("alert-primary");
   	 }
   </script>
   <jsp:include page="footer.jsp" />