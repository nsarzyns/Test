<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" href="images/nittany_lions_logo.jpg">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="generator"
	content="Script Eden ( http://scripteden.net/ ) Template Builder v2.0.0">
<c:forEach items="${groups}" var="group">
	<title>${group.name} - Master Gardeners</title>
</c:forEach>

<!--pageMeta-->

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

				<nav role="navigation"
					class="navbar navbar-blue navbar-embossed navbar-lg navbar-fixed-top">

					<div class="container">

						<div class="navbar-header">
							<button data-target="#navbar-collapse-02" data-toggle="collapse"
								class="navbar-toggle" type="button">
								<span class="sr-only">Toggle navigation</span>
							</button>
							<a href="home" class="navbar-brand brand"><img
								src="images/nittany_lions_logo.jpg" id="logo"></a>
						</div>
						<!--/.navbar-header -->
						<!-- HERE IS YOUR SEARCH JSP THING -->
						<form class="search-collapse"
							action="${pageContext.servletContext.contextPath}/user"
							method="post">
							<input type="text" id="searchText" name="keyword"
								placeholder="Search..." required> <input type="image"
								src="images/search_black.jpg" value="Search" id="searchButton">
						</form>
						<br>

						<div id="navbar-collapse-02" class="collapse navbar-collapse">
							<ul class="nav navbar-nav navbar-right">
								<li class="propClone">
									<form action="${pageContext.servletContext.contextPath}/user"
										method="get">
										<input name="buttonPress" type="image" value="Account"
											class="homeLinks" src="images/user.png" title="My Account" />
									</form>
								</li>
								<li class="propClone">
									<form
										action="${pageContext.servletContext.contextPath}/editUser"
										method="get">
										<input name="submit" type="image" value="submit"
											class="homeLinks" src="images/gear.png"
											title="Account Settings" />
									</form>
								</li>
								<li class="propClone">
									<form action="${pageContext.servletContext.contextPath}/login" method = "post">
										<input name="loginSubmit" type="image" value="Logout" class="homeLinks" src="images/logout.png"  alt="submit" title="Log Out">
									</form>
								</li>
							</ul>
						</div>
						<!--/.navbar-collapse -->
					</div>
					<!-- /.container -->
				</nav>

				<!--pageContent-->

				<div class="pageContent">
					<div id="coverPhotoContainer">
						<!-- COVER PHOTO JSP: "${group.img}"-->
						<img src="images/garden_greenhouse.jpg" id="coverPhoto">
					</div>
					<div class="pageInfo">
						<c:forEach items="${groups}" var="group">
							<p id="pageName">${group.name}</p>
							<div id="overlay" onclick="off()">
								<div id="description">
									<h1>Group Description:</h1>
									${group.description}
								</div>
							</div>
						</c:forEach>
							<a>${group.memberCount} Members</a> | 
							<a onclick="on()">Description</a> | 
							<form action="${pageContext.servletContext.contextPath}/group" method="post">
							<a><input type="Submit" value="Join Group" name="memberSubmit" class="joinGroup"></a>
							</form>
					</div>

					<div class="sidebar">
						<button onclick="toggleSideBar()" id="toggle" style="right: 0px;color: white">Group Options</button>
						<div id="sideBar" style="right: -300px;">
							<form id="GroupGet" method="post">
							<ul class="list-unstyled">
								<li class="sidebarItem"><a href="http://localhost:8081/Master-Gardener/createGroup" style="color: white">Create New Group</a></li>
									<c:forEach items="${groups}" var="group">
										<tr>
										<td class="groupListItem"><input class="sidebarItem" type="Submit" value="${group.name}" id="Submit" name="Submit"></td>
										</tr>
									</c:forEach>
							</ul>
							</form>
							<!--<input type="Submit" value=${group.name } id="Submit" name="Submit">-->
						</div>
					</div>
					
			
					
					<div class="postForm">
						<img src="images/black_user.jpg" class="postPhotos">
						<form id="post"
							action="${pageContext.servletContext.contextPath}/group"
							method="post">
							<textarea rows="4" cols="50" id="newPost" name="newPost"
								placeholder="What do you want this group to know?"
								value="${postText}" form="post" required name="newPost"></textarea>
							<input type="Submit" value="Post" id="postSubmit"
								name="postSubmit">
						</form>
					</div>
					<table>
						<c:forEach items="${posts}" var="pair">
							<div class="aPost">
								<div>${pair.left.name}:</div>
								<div class="postText">${pair.right.text}</div>
							</div>
						</c:forEach>
					</table>
				</div>
				<!--/pageContent-->
			</div>
			<!-- /.wrapper -->

		</header>
		<!-- /.item -->
	</div>
	<!-- /#page -->
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
	
	function toggleSideBar() {
    	var x = document.getElementById('sideBar');
    	var y = document.getElementById('toggle');
    	if (x.style.right === '-300px') {
        	x.style.right = '0%';
        	y.style.right = '300px';
    	} else {
        	x.style.right = '-300px';
        	y.style.right = '0px';
    	}
	}
	
	function on() {
    	document.getElementById("overlay").style.display = "block";
	}

	function off() {
    	document.getElementById("overlay").style.display = "none";
	}
	
	$(function(){
		
		if( $('#nivoSlider').size() > 0 ) {
		
	    	$('#nivoSlider').nivoSlider({
	    		effect: 'random',
				pauseTime: 5000
	    	});
		
		}
		
	})
	</script>


</body>
</html>