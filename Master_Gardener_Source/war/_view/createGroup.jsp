<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="icon" type="image/png" href="images/nittany_lions_icons.jpg">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="generator" content="Script Eden ( http://scripteden.net/ ) Template Builder v2.0.0">  
    <!--pageMeta-->
	<title>Join Jamii</title>
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
    						<a href="home" class="navbar-brand brand"><img src="images/nittany_lions_icons.jpg" id="logo"></a>
   						</div>
    					
    					
    				</div><!-- /.container -->
    			</nav>
    				
    	<div class="signupcontainer">
			<form action="${pageContext.servletContext.contextPath}/createGroup" method="post">
			<table>
				<tr> <td>Group Name:</td>
				<c:if test="${! empty groupName}">
					<td><input type="text" id="username" name="groupname" placeholder="Group Name" value="${groupName}"></td>
				</c:if>
				
				<c:if test="${empty groupName}">
					<td><input type="text" id="username" name="groupname" placeholder="Group Name"></td>
				</c:if>
				</tr>
				
				<tr> <td> Description:</td>
				<c:if test="${! empty description}">
					<td><input type="text" id="password" name="description" placeholder="Description" value="${description}">
				</c:if>
				
				<c:if test="${empty description}">
					<td><input type="text" id="password" name="description" placeholder="Description"></td>
				</c:if>
				</tr>
				
				<tr> <td> Rating between 1-3 (1 = PG, 2 = PG-13, 3 = R):</td>
				<c:if test="${! empty rating}">
					<td><input type="text" id="password" name="rating" placeholder="Rating" value="${rating}">
				</c:if>
				
				<c:if test="${empty rating}">
					<td><input type="text" id="password" name="rating" placeholder="Rating"></td>
				</c:if>
				</tr>
				
				<tr>
				
				</tr>
				
				<tr><td><input type="submit" id="loginSubmit" name="buttonPress" value="Create"></td></tr>
			</table>
			<c:if test="${! empty errorMessage}">
				<tr>${errorMessage}</tr>
			</c:if>
			</form><!-- /.login -->
			</div><!-- /.signup -->
		</div><!-- /.wrapper -->
			
    	
    	</header><!-- /.item --></div><!-- /#page -->
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