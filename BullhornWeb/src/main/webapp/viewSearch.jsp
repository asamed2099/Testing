<%@page import="studs.Post"%>
<%@page import="studs.User"%>
<%@page import="service.DbUserOperations"%>
<% 
if(session.getAttribute("user")==null){
	
	response.sendRedirect("login.jsp");
} %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
<%
	User user =(User)session.getAttribute("user");
	
	
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
    	<div class="headline"><h3>Search Results</h3></div>
   
					<% if(session.getAttribute("searchposts") !=null){ %>
				<c:forEach var="post" items="${searchposts}"  >		
    						<div class="news-updates">
							<div class="nametime">
								<div class="usernamephoto">
									<img alt="User Image" src="images/person3.jpg">
								
								<h5>
								<c:set var="id" value="${post.user.getBhuser_id()}"/>
								<% 
									
								if(pageContext.getAttribute("id") !=null){
									
								int id=(Integer)pageContext.getAttribute("id");
								
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
    				<% }else{ 
    					String search=request.getParameter("search"); 
    					out.println("No result for search  " + search  );} %>

    		

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
    <!--  -->




</div>
   <jsp:include page="footer.jsp" />