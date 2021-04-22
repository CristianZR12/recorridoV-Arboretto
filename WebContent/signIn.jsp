<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Styles -->
<!-- Bootstrap V4 -->
<link rel="stylesheet" href="./css/bootstrap.min.css"></link>
<!-- Global CSS -->
<link rel="stylesheet" href="./css/global.css"></link>
<!-- FONTAWESOME -->
<script src="https://kit.fontawesome.com/78a455df4c.js" crossorigin="anonymous"></script>
</head>
<body>
	<!-- NAVBAR SIGIN -->
	<jsp:include page="WEB-INF/layout/homeHeader.jsp"></jsp:include>
	
	<!-- MAIN SIGNIN -->
	<main class="mainGlobalCenterV">
	  	<div class="cardContainer">
	  		<div class="card w-100 bg-dark">
	  			<div class="card-header" style="background-color: #A51C30;">
	  				<h3 class="card-title text-center text-white">SIGN IN</h3>
	  			</div>
	  			<div class="card-body" style="background-color: #00e676;">
	  				<form>
	  					<div class="form-group">
	  						<input type="email" class="form-control" placeholder="Email" name="email" />
	  					</div>
	  					<div class="form-group">
	  						<input type="password" class="form-control" placeholder="Password" name="pwd" />
	  					</div>
	  					<div class="form-group">
	  						<button type="submit" class="btn btn-block btn-primary"><i class="fas fa-save mr-2"></i>SAVE</button>
	  					</div>
	  				</form>
	  			</div>
	  		</div>
	  	</div>
	  </main>
	  
	<!-- FOOTER SIGNIN -->
	<jsp:include page="WEB-INF/layout/footerH.jsp"></jsp:include>
	  
	<!-- Bootstrap V4  -->
  	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
  	<script defer src="./js/bootstrap.js"></script>
</body>
</html>