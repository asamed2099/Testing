<% 
if(session.getAttribute("user")==null){
	
	response.sendRedirect("login.jsp");
} %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
<%
	// User user =(User)session.getAttribute("user");
	//List <Post> posts = request.getAttribute("allposts");
	//System.out.println(request.getAttribute("allposts"));
%>
<jsp:include page="meta.jsp" />
    <title>BullHorn | New Feed</title>
     <link rel="stylesheet" href="css/main.css" />
      <link rel="stylesheet" href="css/login.css" />
      <link rel="stylesheet" href="css/newsfeed.css" />
  </head>
  <body>
    <div class="wrapper">
    <jsp:include page="header.jsp" />
    
    <div class="newsfeed">
    
    <div class="infoside" id="infoside">
    
    	<h3>News Categories</h3>
    	<ul>
    		<li>World Updates</li>
    		<li>Politics</li>
    		<li>Sports</li>
    		<li>Business</li>
    		<li>Technology</li>
    		<li>Trends</li>
    		<li>Videos</li>
    	</ul>
    
    </div>
    
    <div class="newscontainer" id="newscontainer">
    
    	<div class="news-updates">
							<div class="nametime">
								<div class="usernamephoto">
									<img alt="User Image" src="images/person3.jpg">
								<h5>Admin Support</h5>
								
								</div>
								
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
			<c:forEach var="post" items="${allposts}"  >		
    					<div class="news-updates">
							<div class="nametime">
								<div class="usernamephoto">
									<img alt="User Image" src="images/person3.jpg">
								<h5></h5>
								
								</div>
								
								<h6>
									<span>5</span> <span>mins ago</span>
								</h6>
							</div>
							<div class="content">
								<p>
								<!-- 
								
								${post.posttext}
								${post.user.getEmail}
								 -->
									 <c:out value=""/>
									 <p> <c:out value=""/></p>
									 <c:out value=""/>
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
    	

    		

    </div><!-- End of newscontainer  -->
    <div class="inforight" id="inforight">
    	<div class="" id="">
    		<h3>Trends and Updates</h3>
    	</div>
    	<div class="" id="">
    	</div>
    	<div class="" id="">
    	</div>
    </div>
    <!--  
    	<div class="container">
<table class="table table-bordered">
<thead>
<tr><th>User</th><th>Post</th><th>Date</th></tr>
</thead>
<tbody>
<c:forEach var="post" items="${posts}">
<tr><td><a href="ProfileServlet?action=viewprofile&user
id=<c:out value="${post.bhuser.bhuserid}"/>">
<c:out value="${post.bhuser.useremail}"/></a></td>
<td><c:out value="${post.posttext}"/></td>
<td><fmt:formatDate value="${post.postdate}"
pattern="yy-MMM-dd"/></td>
</tr>

</c:forEach>
</tbody>
</table>
</div>
  
  
    </div>

-->




</div>
   <jsp:include page="footer.jsp" />