<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <%@page import="com.anti.beans.UserBeans"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.*" %>
<%@page import="com.anti.beans.cloudBeans"%>
<%@page import="com.anti.beans.UserBeans"%>
<%@page import="java.sql.ResultSet"%>

<html class="no-js" lang=""> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>An Efficient Anti Collusion Data Sharing Mechanism for Data Confidentially for Dynamic Groups | Cloud Server provider File  Details  </title>
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
        
        <!-- Jquery jar function -->
        
       <!-- Jquery jar function -->
        
        <script type="text/javascript" src="jquery-1.3.2.min.js"></script>

        <script src="assets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
        
        
        
        
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
  
  <script type="text/javascript">
  
  function myFunction(id){
	  
	  alert(" file status is "+id);
	  
	  idName="rodio"+id;
		 alert("idName new is"+idName); 
		 
		 alert("In id is "+id);
		 
		 alert("status is "+status);
	  
		 if($("input:checkbox").is(":Checked")){
			 alert("Yes CheckBox is click ");
			 
			 var tableId=document.getElementById(idName).value;
	 		 alert("values are "+tableId);
	 		 
	 		  var statusName="chhavi"+id;
	 		 
	 		 alert("values is status"+statusName); 

	 		 
	 		 alert("Ajax Call ");
	 		 
			   $.get('CloudServerProviderFileSecondLevelEncrptionController',{tableValue:tableId},function(responseText) { 
					
					                            alert("in ajax function"); 
					   document.getElementById(statusName).innerHTML = "UploadToCloud!"; 
							
					
				
					
				
					                    });
	 		 
	 		 }
		 
		 else
			 {
			 document.getElementById(statusName).innerHTML = "UploadToCloud!";
			 }
	  
  }
  
  </script>
  
  
<!--  
     <%! String cloudName=null; %>

        <%
      
        
      cloudBeans cloudBeans=new cloudBeans();
        
      cloudBeans=(cloudBeans)session.getAttribute("CloudServerSessionInfomation");
      
      cloudName=cloudBeans.getCloud_name();
        
        
        %>


    <%
   ResultSet rs=null;
    rs=(ResultSet)session.getAttribute("cloudServerProviderFileDeatilsSession");
    
    
    
    
    %>



    </head>
    
  
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
                        
                    
                        <li><a href="welcomeToCloudServerProvider.jsp">Home</a></li>
					<li class="active"><a href="#"><%=cloudName%></a></li>
					<li ><a href="CloudServerViewMemberDetailsController">Group Member View </a></li>
					<li ><a href="CloudServerViewMemberFileDeatilsController">Group Member File Details View </a></li>
					<li><a href="aboutUs.jsp">About Us</a></li>
					<li><a href="contactUs.jsp">Contact Us </a></li>
					<li><a href="LogoutMemberController">Logout </a></li>
                       
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

                                </div>
                            </div>
                        </div>
                    </div>
                </div>			
            </div>
        </header>

        <!-- Sections -->
        <section id="features" class="features sections">
            <div class="container">
                <div class="row">
                    <div class="main_features_content2">

                     

                        <%
                      //id, user_id, user_email, user_name, file_name, file_path, file_encrption_path, file_key, file_status, user_group
                        %>
                          <table class="responstable">
 
  <tr>
   <th>Activated </th>
   <th>Number </th>
    <th>Member Name</th>
    <th>Member Email </th>
    <th>Member Group </th>
    <th>Member File Name  </th>
    <th>Member File Status </th>
  </tr>
  
  <%
while(rs.next()){
	
  %>
  
     
 
 <tr>
<td><input type="checkbox" id="rodio<%=rs.getInt(1)%>" name="Activated" value="<%=rs.getString(1)%>" onclick="myFunction(<%=rs.getInt(1)%>)"/></td>
 <td><%=rs.getInt(1) %></td> 
<td><%=rs.getString(4) %></td>
<td><%=rs.getString(3) %></td>
<td><%=rs.getString(10) %></td>
<td><%=rs.getString(5) %></td>
<td id="chhavi<%=rs.getInt(1)%>"> <%=rs.getString(9) %></td>
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
