<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>An Efficient Anti Collusion Data Sharing Mechanism for Data Confidentially for Dynamic Groups | contact us  page </title>
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
                        <li ><a href="#home">Home</a></li>
                        <li><a href="groupMemberLogin.jsp">Group Member</a></li>
                        <li><a href="groupMangerLogin.jsp">Group Manger</a></li>
                        <li><a href="#price">Cloud Services Provider</a></li>
                        <li><a href="aboutUs.jsp">About Us</a></li>
                        <li class="active"><a href="contactUs.jsp">Contact Us </a></li>
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


   



        <section id="contact" class="contact sections">
            <div class="container">
                <div class="row">
                    <div class="main_contact whitebackground">
                        <div class="head_title text-center">
                            <h2>GET IN TOUCH</h2>
                           
                        </div>
                        <%
                        String sucessMsg=(String)request.getAttribute("SuccesMsg");
                                    
                         if(sucessMsg!=null && sucessMsg!=""){
                        	 
                         %>
                         
                         <p style="color: red;"><%=sucessMsg %></p>
                         
                         <%} %>
                        
                        <div class="contact_content">
                            <div class="col-md-6">
                                <div class="single_left_contact">
                                    <form action="GroupMemberContactUsController" id="formid">

                                        <div class="form-group">
                                            <input type="text" class="form-control" name="fName" placeholder="first name" required="">
                                        </div>

                                        <div class="form-group">
                                            <input type="email" class="form-control" name="userEmail" placeholder="Email" required="">
                                        </div>


                                        <div class="form-group">
                                            <textarea class="form-control" name="userMessage" rows="8" placeholder="Message"></textarea>
                                        </div>

                                        <div class="center-content">
                                            <input type="submit" value="Submit" class="btn btn-default">
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="single_right_contact">
                                    <p>An Efficient Anti Collusion Data Sharing Mechanism for Data Confidentially for Dynamic Groups </p>

                                    <div class="contact_address margin-top-40">
                                        <span>1600 Pennsylvania Ave NW, Washington,</span>
                                        <span>DC 20500, United States of America.</span> 
                                        <span class="margin-top-20">T: (202) 456-1111</span> 
                                        <span>M: (202) 456-1212</span> 
                                    </div>

                                    <div class="contact_socail_bookmark">
                                        <a href=""><i class="fa fa-facebook"></i></a>
                                        <a href=""><i class="fa fa-twitter"></i></a>
                                        <a href=""><i class="fa fa-google"></i></a>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>


       <!--  <section id="footer-menu" class="sections footer-menu">
            <div class="container">
                <div class="row">
                    <div class="footer-menu-wrapper">

                        <div class="col-md-8 col-sm-12 col-xs-12">
                            <div class="col-md-4 col-sm-6 col-xs-12">
                                <div class="menu-item">
                                    <h5>Quick Links</h5>
                                    <ul>
                                        <li>POWER BI DESKTOP</li>
                                        <li>MOBILE</li>
                                        <li>SEE ALL DOWNLOADS</li>
                                        <li>POWER BI DESKTOP</li>
                                        <li>MOBILE</li>
                                        <li>SEE ALL DOWNLOADS</li>
                                    </ul>
                                </div>
                            </div>

                            <div class="col-md-4 col-sm-6 col-xs-12">
                                <div class="menu-item">
                                    <h5>Legal</h5>
                                    <ul>
                                        <li>PRIVACY & COOKIES</li>
                                        <li>TERMS OF USE</li>
                                        <li>TRADEMARKS</li>
                                    </ul>
                                </div>
                            </div>

                            <div class="col-md-4 col-sm-6 col-xs-12">
                                <div class="menu-item">
                                    <h5>Information</h5>
                                    <ul>
                                        <li>SUPPORT</li>
                                        <li>DEVELOPERS</li>
                                        <li>BLOG</li>
                                        <li>NEWSLETTER</li>
                                        <li>PYRAMID ANALYTICS</li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-4 col-sm-6 col-xs-12">
                            <div class="menu-item">
                                <h5>Newsletter</h5>
                                <p>Insights await in your company's data. Bring them into focus with BlueLance.</p>
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Enter your email address">
                                    <input type="submit" class="form-control" value="Use It Free">
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </section> -->


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
