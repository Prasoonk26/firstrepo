<!DOCTYPE html>
    <%@page import="com.anti.beans.UserBeans"%>
    <%@page import="com.anti.beans.adminBeans"%>
<%@page import="com.anti.beans.UserBeans"%>
<%@page import="java.sql.ResultSet"%>
<head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
       <title>An Efficient Anti Collusion Data Sharing Mechanism for Data Confidentially for Dynamic Groups |    </title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style3.css" />
		<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
		<!-- login csp page  -->
    </head>
    
   
    <body>
    
       <%
        
        adminBeans adminBeans=new adminBeans();
        
        String adminName=null;
        
        session=request.getSession();
        
        adminBeans=(adminBeans)session.getAttribute("adminSessionInfomation");
        
       adminName=adminBeans.getAdmin_name();
        
        
        %>
    
    
    <%
    
   ResultSet rs=(ResultSet)session.getAttribute("adminUploadingGraphResultSession");
    %>
             <jsp:include page="headerFinal.jsp"></jsp:include>
        <nav class="navbar navbar-default">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#"><img src="assets/images/tital.png" alt="Logo" /></a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                    <ul class="nav navbar-nav navbar-right">
					<li><a href="#">Home</a></li>
					<li class="active"><a href="groupMemberLogin.jsp"><%=adminName%></a></li>
					<li><a href="GroupMangerDetailsController">Activate Member </a></li>
					<li><a href="GroupManagerViewGroupMemberController">Group Member View </a></li>
					<li><a href="GroupManagerViewFakeUserController">View Fake Member </a></li>
				   <li><a href="GroupMangerFileDeatilsController">File Details  </a></li>
				     <li><a href="GroupMangerViewRevokeRequestController">Revoke Request   </a></li>
				       <li><a href="groupMangerSelectGraphType.jsp">Performances </a></li>
					<li><a href="aboutUs.jsp">About Us</a></li>
					<li><a href="contactUs.jsp">Contact Us </a></li>
					<li><a href="LogoutMemberController">Logout </a></li>

					<!--   <li class="login"><a href="#">Sign In</a></li>  -->
                    </ul>

                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <div class="container">
            <!-- Codrops top bar -->
           
          
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                        
                       
                            <form  action="AdminSelectedForGraphContoller" autocomplete="on"> 
                                <h1>Select File Name For Uploading </h1> 
                               <select name="fileName">
                              
                              <%
                              while(rs.next()){
                              
                              %>
                              
                                
                                 
                                 <option value="<%=rs.getString(2)%>"> <%=rs.getString(2) %></option>
                               
                                 
                                 <%
                              }
                                 %>
                                 </select>
                               
                             
                                <p class="login button"> 
                                    <input type="submit" value="Send" /> 
								</p>
                              
								
								
                            </form>
                        </div>

                  	
                    </div>
                </div>  
            </section>
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
        
    </body>
</html>