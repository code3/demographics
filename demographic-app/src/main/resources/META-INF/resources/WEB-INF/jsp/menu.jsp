<%
String msg = (request.getParameter("msg") != null) ? request.getParameter("msg") : "";
String displayDemoUrl = (msg.equals("")) ? "displayDemographics" : "../displayDemographics";
%>

<nav class="navbar navbar-expand-md bg-primary navbar-dark">

	<button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#myNav">
		<span class="navbar-toggler-icon"></span>
	</button>
	
		<div class="collapse navbar-collapse" id="myNav"><!-- id must match data-target -->
		
			<ul class="navbar-nav">
				<li class="nav-item"><a href="showCreate" class="nav-link">Add Demographic</a></li>
				<li class="nav-item"><a href="<%=displayDemoUrl%>" class="nav-link">View All</a></li>
			</ul>
			
		</div>		

</nav>