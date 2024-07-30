<%@page import="studs.User"%>
<%@page import="service.DbUserOperations"%>

<%
		User user =null;
		String email = "";
		int size = 100;
	if(session.getAttribute("user") != null){
	user = (User)session.getAttribute("user"); 
		 email = user.getEmail(); 
	}else {
		response.sendRedirect("login.jsp");
		}
%>
<jsp:include page="meta.jsp" />
<title>Profile| Abdul Samad</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/profile.css" />
<jsp:include page="header.jsp" />
<div class="contain">
	<div class="leftside">
		<div class="photo">
			<img alt="Profile photo"
				src="<%=DbUserOperations.getGravatarUrl(email, size)%>">
		</div>

		<div class="bio">

			<p>
			<h1>Profession</h1>
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
				<li class="list-group-item"><a href="profilesettings.jsp">Change
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
					<i class="fa fa-map-marker"></i> Riyadh, Country
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
			<p>
				<a class="" data-toggle="collapse" href="#timeline" role="button"
					aria-expanded="false" aria-controls="collapseExample"> Timeline
				</a> <a class="" data-toggle="collapse" href="#about" role="button"
					aria-expanded="false" aria-controls="collapseExample"> About </a>
			</p>
			<hr />
			<div class="collapse" id="timeline">
				<div class="timeline-container">

					<div class="update-container">
						<div class="timeline-updates">
							<div class="nametime">
								<h5>Admin Support</h5>
								<h6>
									<span>5</span> <span>mins ago</span>
								</h6>
							</div>
							<div class="content">
								<p>There are many variations of passages of Lorem Ipsum
									available, but the majority have suffered alteration in some
									form, by injected humour, or randomised words which don't look
									even slightly believable. If you are going to use a passage of
									Lorem Ipsum, you need to be sure there isn't anything
									embarrassing hidden in the middle of text. All the Lorem Ipsum
									generators on the Internet tend to repeat predefined chunks as
									necessary, making this the first true generator on the
									Internet. It uses a dictionary of over 200 Latin words,
									combined with a handful of model sentence structures, to
									generate Lorem Ipsum which looks reasonable. The generated
									Lorem Ipsum is therefore always free from repetition, injected
									humour, or non-characteristic words etc</p>
								<div class="likecommentshare">
									<span><button>
											<i class="fa fa-thumbs-up"></i>Like
										</button></span> <span><button>
											<i class="fa fa-comment"></i>Comment
										</button></span> <span><button>
											<i class="fa fa-share"></i>Share
										</button></span>
								</div>
							</div>
						</div>
						<!-- End of timeline updates  -->



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
									<td>453 Base 4 Street , Riyadh, KSA</td>
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
		</div>
		<!--  <div class="bottom"></div>-->
	</div>

</div>


<jsp:include page="footer.jsp" />