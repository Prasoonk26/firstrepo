<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>Login and Registration Form with HTML5 and CSS3</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style3.css" />
		<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
		<!-- login csp page  -->
		
		<script type="text/javascript">
		
		function myFunction(id)
		{
			alert("In function");
			
			alert("values of id is "+id);
			
			$("#passwordsignup").attr("type","text");
			
			
		}
		
		
		</script>
		
		
    </head>
    <body>
    
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
                        <li><a href="index.jsp">Home</a></li>
                        <li class="active" ><a href="#">Group Member</a></li>
                         <li><a href="aboutUs.jsp">About Us</a></li>
                        <li><a href="contactUs.jsp">Contact Us </a></li>
                       
                    </ul>

                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <div class="container">
            <!-- Codrops top bar -->
           
          
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                                       <div id="wrapper">
                                     
                                       
                                <div class="animate form" id="login">
                            <form  action="GroupMemberRegisterController" autocomplete="on"> 
                                <h1> Sign up </h1> 
                                
                                  <%
                                       String errorMsg=(String)request.getAttribute("errorMsg");
                                       
                                       if(errorMsg!=null & errorMsg!=""){
                                    	                                   	                                        
                                        %>
                                        
                                         <p style="color:red;"><%=errorMsg %></p>
                                         <%
                                       }
                                         %>
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">Your username</label>
                                    <input id="usernamesignup" name="userName" required="required" type="text" placeholder="Entre Your Fisrt Name"  pattern="[a-zA-Z\s]+" required x-moz-errormessage="Enter First name" />
                                </p>
                                <p> 
                                    <label for="emailsignup" class="youmail" data-icon="e" > Your email</label>
                                    <input id="emailsignup" name="userEmail" required="required" type="email" placeholder="Entre valid Email Id "  required pattern=".*@gmail\.com" x-moz-errormessage="Enter your email (abc@gmail.com)"/> 
                                </p>
                                <p> 
                                    <label for="passwordsignup" class="youpasswd" data-icon="p">Your password </label>
                                    <input id="passwordsignup" name="userPassword" required="required" type="password" placeholder="eg. X8df!90EO" placeholder="eg. xyz123" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" title="Password must contain at least 6 characters,  including UPPER/lowercase and numbers."/>
                                     
                                </p>
                                <p> 
                                    <label for="passwordsignup_confirm" class="youpasswd" data-icon="u">Your Contact Number  </label>
                                    <input id="passwordsignup_confirm" name="userPhoneNumber" required="required" type="text" placeholder="eg. X8df!90EO" placeholder="eg. 9823456982" required pattern="[7-9]{1}[0-9]{9}"  x-moz-errormessage="* Mobile number with 7-9 and remaing 9 digit with 0-9"/>
                                </p>
                                
                                <p>
                                 <label for="passwordsignup_confirm" class="youpasswd" data-icon="u">Select Your Group  </label>
                                 <select id="passwordsignup_confirm" class="youmail" name="userGroup">
                                <option value="Group1">Group1</option>
                                 <option value="Group2">Group2</option>
                                  <option value="Group3">Group3 </option>
                                
                                </select>
                                </p>
                                <p class="signin button"> 
									<input type="submit" value="Sign up"/> 
								</p>
                                <p class="change_link">  
									Already a member ?
									<a href="groupMemberLogin.jsp" class="to_register"> Go and log in </a>
								</p>
                            </form>
                       </div>
						
                    </div>
                </div>  
            </section>
            
            <br>
            <br>
            <br>
            <br>
            
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
        
    </body>
</html>