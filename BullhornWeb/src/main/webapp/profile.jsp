<%@page import="java.util.ArrayList"%>
<%@page import="service.DbPostOperations"%>
<%@page import="studs.Post"%>
<%@page import="java.util.List"%>
<%@page import="service.UserInfoOperations"%>
<%@page import="studs.UserInfo"%>
<%@page import="studs.User"%>
<%@page import="service.DbUserOperations"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%
		User user =null;
		UserInfo userInfo =null;
		String email = "";
		int size = 100;
		List<Post> userposts = (List)request.getAttribute("userposts");
	if(session.getAttribute("user") != null){
	user = (User)session.getAttribute("user"); 
	userInfo =(UserInfo)UserInfoOperations.getUserInfoById(user.getBhuser_id());
		 email = user.getEmail(); 
		 
		//Find post of user
		//userposts =DbPostOperations.listPostOfUser(user.getBhuser_id());
		//pageContext.setAttribute("userposts", userposts);
		System.out.println("User post :" + request.getAttribute("userposts") );
	}else {
		response.sendRedirect("login.jsp");
		}
%>

<jsp:include page="meta.jsp" />
<title>Profile | <%=user.getFullname() %></title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/profile.css" />
<jsp:include page="header.jsp" />
<div class="contain">
	<div class="leftside">
		<div class="photo">
			
			<img alt="Profile photo"
			<% if(userInfo !=null){
				String photo =userInfo.getPhoto() ; 
			     
			         %>
				src="uploads/<%=photo %> "
				<%} %>
				>
				
		</div>

		<div class="bio">

			<p>
			<h1><% if(userInfo != null){out.println( userInfo.getJobtitle()); }else{out.println("Not Specified");} %></h1>
			</p>
			<p>
			<h4>Company Name</h4>
			</p>
			<p>
			<h5>Years of Experience</h5>
			</p>
			
			

		</div>

		<div class="settings">
			<ul class="list-group">
				<li class="list-group-item"><a href="profilesettings.jsp">Profile
						Settings</a></li>
				<li class="list-group-item"><a href="changepassword.jsp">Change
						Password</a></li>
				<li class="list-group-item">also link</li>

			</ul>

		</div>


	</div>
	<div class="rightside">

		<div class="namelocation">
			<div>
				<h2><%=user.getFullname()%></h2>
				<h5>
					<i class="fa fa-map-marker"></i> <span><% if(userInfo != null){out.println( userInfo.getCity()); }else{out.println("Not Specified");} %></span>,<span><% if(userInfo != null){out.println( userInfo.getCountry()); } else{out.println("Not Specified");}%></span>
				</h5>
			</div>

			<div>Action</div>
		</div>

		<div class="top">
			<div class="">
				<span>Motto : </span>
				<p><%=user.getMotto()%></p>
			</div>
			<div class="sendmessage">
				<button>Send Message</button>
				<button>
					Add User <i class="fa fa-user-plus"></i>
				</button>
			</div>
			<!-- <table class="table">
			<tr>
				<td>....</td>
				<td>....</td>
				<td>....</td>
				
			</tr>
			<tr>
				<td>....</td>
				<td>....</td>
				<td>....</td>
				
			</tr>
			</table>
		 -->

		</div>
		<div class="middle">
			<div class=""></div>
			<p id="plinks">
				<a class="" data-toggle="collapse" href="#timeline" role="button"
					aria-expanded="false" aria-controls="collapseExample"> Timeline
				</a> <a class="" data-toggle="collapse" href="#about" role="button"
					aria-expanded="false" aria-controls="collapseExample"> About </a>
				</a> <a class="" data-toggle="collapse" href="#createpost" role="button"
					aria-expanded="false" aria-controls="collapseExample"> Create Post </a>
			</p>
			<hr />
			<div class="collapse" id="timeline">
				<div class="timeline-container">

					<div class="update-container">
						<!-- 
						 -->
						<!-- End of timeline updates  -->
						<%if(request.getAttribute("userposts") !=null){ %>
						<c:forEach var="post" items="${userposts}"  >
								
    					<div class="news-updates">
							<div class="nametime">
								<div class="usernamephoto">
							<img alt="Profile photo"
							<% if(userInfo !=null){
			                String photo =userInfo.getPhoto() ; 
			   				%>
							src="uploads/<%=photo %> "
							<%} %>
							>
								
								
								
								<h5>
								<c:set var="id" value="${post.user.getBhuser_id()}"/>
								<% 
									
								if(pageContext.getAttribute("id") !=null){
									
								int id=(Integer)pageContext.getAttribute("id");
								System.out.println("The id value is "+ id);
								String postername =DbUserOperations.getUserById(id).getFullname(); 
								out.println(postername); 
								
								}
								
								%>
								
								</h5>
								
								</div>
								
								<h6>
									<span>5</span> <span>mins ago</span>
								</h6>
							</div>
							<div class="content">
								<p>
								<!--  -->
								 	
								 
									 
									 <p><c:out value="${post.posttext}"/></p>
									 <p><c:out value="${post.postdate}"/></p>
								
								</p>
								<div class="likecommentshare">
									<span>
										<button>
											<i class="fa fa-thumbs-up"></i>Like
										</button>
									</span> 
										
									<span>
										<button>
											<i class="fa fa-comment"></i>Comment
										</button>
									</span> 
										
									<span><button>
											<i class="fa fa-share"></i>Share
										</button>
									</span>
								</div>
							</div>
						</div><!-- End of timeline updates  -->
				</c:forEach>
    				<% }else {out.println("User has no posts");} %>

					</div>
					<!-- End of updates container  -->
					<div class="statistics">
						<div>
							<h3>Statistics</h3>
						</div>
						<h6>
							No of Articles: <span>13</span>
						</h6>
						<h6>
							Profile Views: <span>120</span>
						</h6>
					</div>
				</div>
				<!-- End of timeline container  -->
			</div>
			<!-- End of timeline platform  -->
			<div class="collapse" id="about">
				<div>
					<div id="card-top">
						<h4 class="text-left">Contact Information</h4>
						<table id="tb">
							<tbody>
								<tr>
									<td>Phone</td>
									<td><%=user.getPhone()%></td>


								</tr>
								<tr>
									<td>Address</td>
									<td><% if(userInfo != null){out.println( userInfo.getAddress()); }else{out.println("Not Specified");} %></td>
								</tr>
								<tr>
									<td>Email</td>
									<td><%=user.getEmail()%></td>
								</tr>
							</tbody>

						</table>
					</div>
					<div id="bottom">
						<h4 class="text-left">Basic Information</h4>
						<table id="tb">
							<tbody>
								<tr>
									<td>Birthday:</td>
									<td><%=user.getDob()%></td>


								</tr>
								<tr>
									<td>Gender</td>
									<td><%=user.getGender().toUpperCase()%></td>
								</tr>

							</tbody>

						</table>
					</div>
				</div>
			</div>
			<!-- End of #about platform  -->
			<div class="collapse" id="createpost">
				<div>
					<div class="card card-body" id="form-wp">
		<form action="AddPostServlet" method="POST" id="fm" class="px-4 py-3">
			<div class="form-group">
				<input type="hidden" class="form-control" id="poster" name="poster" value="<%=user.getBhuser_id() %>" />
			</div>
			<div class="form-group">
				<label for="dob">Create Post:</label> 
				<textarea class="form-control" rows="6" id="post" name="post" required ></textarea>
			</div>
			<div class="form-group " id="smt">
				<button type="submit" class="btn btn-primary">Post </button>
			</div>
	</div>
	</form>
</div>
				</div>
			</div>
			<!-- End of #Create a Post platform  -->
			
		</div>
		<!--  <div class="bottom"></div>-->
	</div>

</div>

<script>
		document.getElementById("fm").addEventListener("submit", function (e){
			e.printDefault();
		})
</script>
<jsp:include page="footer.jsp" />
