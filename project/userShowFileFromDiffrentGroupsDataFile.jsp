<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <%@page import="com.anti.beans.UserBeans"%>
<%@page import="java.sql.ResultSet"%>

    
    
<html class="no-js" lang=""> <!--<![endif]-->

<script type="text/javascript">
    
    $(document).ready(function() {
    	alert("In msg");
        window.history.pushState(null, "", window.location.href);        
        window.onpopstate = function() {
        	alert("In msg other ");
            window.history.pushState(null, "", window.location.href);
        };
    });
    </script>
   

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>An Efficient Anti Collusion Data Sharing Mechanism for Data Confidentially for Dynamic Groups | View Groups Data File  </title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">

        <!--Google fonts links-->
        <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">

        <link rel="stylesheet" href="assets/css/bootstrap.min.css">


        <!--For Plugins external css-->
        <link rel="stylesheet" href="assets/css/plugins.css" />
        <link rel="stylesheet" href="assets/css/roboto-webfont.css" />

        <!--Theme custom css -->
        <link rel="stylesheet" href="assets/css/style.css">

        <!--Theme Responsive css-->
        <link rel="stylesheet" href="assets/css/responsive.css" />

        <script src="assets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    </head>

     <!-- 
        table css
         -->
         
           <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
   
     <link rel="stylesheet" href="css_table/style.css">
      <script src="http://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src="js/ajax.js" type="text/javascript"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="http://code.jquery.com/jquery-latest.js"> </script>
    <%
    
    String userName=null;
    
    int userId;
    
    UserBeans userBeans=new UserBeans();
    
    session=request.getSession();
    
    userBeans=(UserBeans)session.getAttribute("userSessionInfomation");
    
    userId=userBeans.getId();
    
    if(userBeans==null){
    	System.out.println("session are Null");
    	
    	
    	
    	
    	 RequestDispatcher rd = request.getRequestDispatcher("groupMemberLogin.jsp");
         rd.forward(request, response);
    	
    }
    	
    else
    {
    	System.out.println("have value in session ");
    	
    	 userName=userBeans.getUser_name();
    	
    	 
    }
    
    
    %>
    
    <%
    ResultSet rs=(ResultSet)session.getAttribute("groupDataFileSession");
    %>
    
    <body>
    
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

        <!-- Sections -->
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

        <!--Home page style-->
        <header id="home" class="home">
            <div class="overlay-fluid-block">
                <div class="container text-center">
                    <div class="row">
                        <div class="home-wrapper">
                            <div class="col-md-10 col-md-offset-1">
                                <div class="home-content">

                                   <!--  <h1>Bring your Big Data to Life With Soft-Tech</h1>
                                    <p>Blue Lance transforms your company's data into rich visuals for you to collect and organize so you can focus on what matters to you. Stay in the know, spot trends as they happen, and push your business further.</p>
 -->
                                   <!--  <div class="row">
                                        <div class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12">
                                            <div class="home-contact">
                                                <div class="input-group">
                                                    <input type="text" class="form-control" placeholder="Enter your email address">
                                                    <input type="submit" class="form-control" value="Use It Free">

                                                </div>/input-group


                                            </div>
                                        </div>
                                    </div> -->


                                </div>
                            </div>
                        </div>
                    </div>
                </div>			
            </div>
        </header>

        <!-- Sections -->
             <!-- Sections -->
        <section id="features" class="features sections">
            <div class="container">
                <div class="row">
                    <div class="main_features_content2">

                     

                        <%
                      
                       //id, user_id, user_email, user_name, user_group, file_name, file_path, file_enc_path, file_enc_final_path, file_old_key, file_new_key, file_status
                        
                        %>
                          <table class="responstable">
 
  <tr>
   <th>Number </th>
    <th>Member Name</th>
    <th>Member Email </th>
    <th>Member  Group </th>
     <th>File Name </th>
      <th>Download </th>
    
  </tr>
  
  <%
while(rs.next()){
	
  %>
  
     
 
 <tr>
 
 
 
 
   
<td><%=rs.getInt(1) %></td> 
<td><%=rs.getString(4) %></td>
<td><%=rs.getString(3) %></td>
<td><%=rs.getString(5) %></td>
<td><%=rs.getString(6) %></td>
<td><a href="userDownloadFileFromDiffrentGroupController?userId=<%=rs.getInt(1)%>&userEmail=<%=rs.getString(3)%>&userFileName=<%=rs.getString(6)%>&userGroup=<%=rs.getString(5)%>">Download</a></td>


      </tr>
  
  
<%

}
%>

  
  
  
  
  
</table>
                              
                    </div>
                </div>
            </div>
        </section><!--End of Features 2 Section -->
  
       


   

        <!--Footer-->
 <jsp:include page="footer.jsp"></jsp:include>

      <div class="scrollup">
            <a href="#"><i class="fa fa-chevron-up"></i></a>
        </div>


        <script src="assets/js/vendor/jquery-1.11.2.min.js"></script>
        <script src="assets/js/vendor/bootstrap.min.js"></script>

        <script src="assets/js/plugins.js"></script>
        <script src="assets/js/modernizr.js"></script>
        <script src="assets/js/main.js"></script>
    </body>
</html>
