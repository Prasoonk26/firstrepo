<!DOCTYPE html>
    <%@page import="com.anti.beans.UserBeans"%>
<head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
       <title>An Efficient Anti Collusion Data Sharing Mechanism for Data Confidentially for Dynamic Groups |  Group  Member File Upload   </title>
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
    UserBeans userBeans=new UserBeans();
    
    String userName=null;
    
    userBeans=(UserBeans)session.getAttribute("userSessionInfomation");
    
    userName=userBeans.getUser_name();
    
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
                        <li ><a href="welcomeToMember.jsp">Home</a></li>
                        <li class="active"><a href="groupMemberLogin.jsp"><%=userName %></a></li>
                          <li><a href="groupMemberChangePassword.jsp">Change Password </a></li>
                         <li><a href="groupMemberRevokeGroup.jsp">Member Revoke </a></li>
                         <li><a href="GroupMangerDeleteFromCloudController">Remove From Cloud  </a></li>
                        <li><a href="groupMemberFileUpload.jsp">File Upload</a></li>
                         <li><a href="groupMemberFileDownload.jsp">File Download</a></li>
                         <li><a href="GroupMemberViewMemberController">Member Details </a></li>
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
                        

                        
                        <%
                        String sucessMsg=(String)request.getAttribute("sucessMsg");
                        
                        if(sucessMsg!=null && sucessMsg!=""){
                        	
                                               
                        %>
                        <p style="color: red;"><%=sucessMsg %></p>
                        
                        <%
                        }
                        
                        %>
                        
                         <%
                        String errorMsg=(String)request.getAttribute("errorMsg");
                        
                        if(errorMsg!=null && errorMsg!=""){
                        	
                                               
                        %>
                        <p style="color: red;"><%=errorMsg %></p>
                        
                        <%
                        }
                        
                        %>
                        
                       
                        <%
                        String errorMsg1=(String)request.getAttribute("errorMsg1");
                        
                        if(errorMsg1!=null && errorMsg1!=""){
                        	
                                               
                        %>
                        <p style="color: red;"><%=errorMsg1 %></p>
                        
                        <%
                        }
                        
                        %>
                        
                           <form  action="GroupMemberUploadDataController" method="post" enctype="multipart/form-data" > 
                                <h1>Upload the Data </h1> 
                               
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> Upload the Data Here: </label>
                                    <input id="password" name="userFileData" required="required" type="file"/> 
                                </p>
                              
                                <p class="login button"> 
                                    <input type="submit" value="Upload" /> 
								</p>
                               
								<br>
								<br>
								<br>
								
								
								
								
                            </form>
                        </div>

                  	
                    </div>
                </div>  
            </section>
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
        
    </body>
</html>