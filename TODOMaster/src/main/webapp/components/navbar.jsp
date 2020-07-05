<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

	<div class="container">
		<a class="navbar-brand" href="#">
			<img alt="brand" src="img/idea.png" width="45" height="45">
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="index.jsp">Home
				</a></li>
			</ul>
			
			
			<c:if test="${user==null }">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="signup.jsp">Sign-Up</a></li>
			</ul>
			</c:if>
			
			
			<c:if test="${user!=null}">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item  text-white mt-2">${user.getUserName()}</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="Logout">Logout</a></li>
			</ul>
			</c:if>
		</div>
	</div>

</nav>