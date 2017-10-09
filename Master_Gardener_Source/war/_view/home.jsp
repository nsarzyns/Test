<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
	<link rel="icon" type="image/png" href="images/nittany_lions_logo.jpg">

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="generator" content="Script Eden ( http://scripteden.net/ ) Template Builder v2.0.0">  
    <!--pageMeta-->
    
    <title>PSU Master Gardeners</title>
    
    <!-- Loading Bootstrap -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="css/flat-ui.css" rel="stylesheet">
    
    <link href="css/style.css" rel="stylesheet">

    

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
    
    <!--headerIncludes-->
     
    
</head>
<body>
    
    <div id="page" class="page">
        
    	<header class="item header margin-top-0 header10" id="header10">
    
    		<div class="wrapper">
    	
    			<nav role="navigation" class="navbar navbar-blue navbar-embossed navbar-lg navbar-fixed-top">
    					
    				<div class="container">
    				
    					<div class="navbar-header">
    						<a href="home" class="navbar-brand brand"><img src="images/nittany_lions_logo.jpg" id="logo"></a>
   						</div>
   							
    				<div id="navbar-collapse-02" class="collapse navbar-collapse">
  						<div id="generalSubmitContainer" >
  							<form action="${pageContext.servletContext.contextPath}/login" method="get">
  								<input name="buttonPress" type="image" value="Login" class="homeLinks" src="images/login.png" title="Log In"/>
							</form>
							
  							<form action="${pageContext.servletContext.contextPath}/signup" method="get">
  								<input name="buttonPress" type="image" value="Sign Up" class="homeLinks" src="images/signup.png" title="Sign Up"/>
							</form>
							
  							<form action="${pageContext.servletContext.contextPath}/user" method="get">
  								<input name="buttonPress" type="image" value="Account" class="homeLinks" src="images/user.png" title="My Account"/>
							</form>
  						</div>
  					</div>
    					
    					
    				</div><!-- /.container -->
    			</nav>
			
    		</div><!-- /.wrapper -->
    	
    	</header><!-- /.item -->
    	<!-- // End Nav Bar --><!-- Start Content Block -->
		<div id="intro"></div>
		<div id="container" class="container">
			<div class="col-lg-7 col-md-6 col-sm-12">
				<div id="editContent" class="editContent">
					<h1>Our Mission</h1>
				</div>
				<div id="editContent" class="editContent">
					<p class="lead">
						The Penn State Master Gardener volunteer program supports the 
						outreach mission of Penn State Extension by utilizing unbiased 
						research-based information to educate the public and our communities 
						on best practices in sustainable horticulture and environmental 
						stewardship.  
					</p>
				</div>
			</div>
			<div class="col-lg-5 col-md-6 col-sm-10">
				<div id="divSpacer"></div>
				<!-- /.spacer -->
				<div id="frameRight">
					<img class="img-responsive" src="images/black_gardener_logo.jpg">
				</div>
			</div>
			<div id="centerDiv2">
				<div id="divSpacer2"></div>
				<!-- /.spacer -->
				<p class="bold" align="center">
					York College Extension | 441 Country Club Rd | York, PA 17403
				</p>
			</div>
		</div>
		<!-- /.container -->		
    <!-- // End Content Block 1-5 v1 -->
    </div><!-- /#page -->
    
    
    <!-- Load JS here for greater good =============================-->
    <script src="js/jquery-1.8.3.min.js"></script>
    <script src="js/jquery-ui-1.10.3.custom.min.js"></script>
    <script src="js/jquery.ui.touch-punch.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap-select.js"></script>
    <script src="js/bootstrap-switch.js"></script>
    <script src="js/flatui-checkbox.js"></script>
    <script src="js/flatui-radio.js"></script>
    <script src="js/jquery.tagsinput.js"></script>
    <script src="js/jquery.placeholder.js"></script>
	<script src="js/jquery.nivo.slider.pack.js"></script>
    <script src="js/application.js"></script>
	<script src="js/over.js"></script>
	<script>
	$(function(){
		
		if( $('#nivoSlider').size() > 0 ) {
		
	    	$('#nivoSlider').nivoSlider({
	    		effect: 'random',
				pauseTime: 5000
	    	});
		
		}
		
	})
	</script>


</body></html>