 <%@page import="studs.User"%>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<header>
    	<div class="header-brand"><img alt="Logo" src="images/logo.png">  </div>
    		<div class="navlinks">
		    <ul class="nav">
				  <li class="nav-item">
				    <a class="nav-link active" href="index.jsp">Home</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link" href="">News Feed</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link" href="about.jsp">About</a>
				  </li>
				  <li class="nav-item">
				  	<div class="dropdown">
						  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						   Activities
						  </button>
						  <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
						    <button class="dropdown-item" type="button">Action</button>
						    <button class="dropdown-item" type="button">Another action</button>
						    <button class="dropdown-item" type="button">Something else here</button>
						  </div>
					</div>
					
				  </li>
				    <% if(session.getAttribute("user")==null){ %>
				  <li class="nav-item"><a class="nav-link"  href="login.jsp">Login</a></li>
				  
				  <% }else{ %>
     
     				<li class="nav-item" class="nav-item">
        			<a class="nav-link " href="Logout" >Logout</a>
      				</li>
       				<li class="nav-item">
       			  <a class="nav-link "  href="profile.jsp"> <% User usr= (User) session.getAttribute("user"); out.println(usr.getFullname().toUpperCase());  %> </a>
      			</li>
      				<% } %>
				  
				  <li class="nav-item">
				   		<form class="form-inline my-2 my-lg-0">
					      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
					      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
   					   </form>
   				</li>
			</ul>
			</div>
    </header>