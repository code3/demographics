
<%@ include file="header.jsp"%>

<title>Display Demographics</title>
</head>
<body>

	<div class="container">
		<h2>Display Demographics</h2>
	</div>

	<jsp:include page="menu.jsp" />


	<div class="container mb-5 mt-3">


		<table class="table table-striped table-bordered mydatatable"
			style="width: 100%">

			<tr>

				<th>id</th>
				<th>age</th>
				<th>children</th>
				<th>city</th>
				<th>country</th>
				<th>education</th>
				<th>email</th>
				<th>employment</th>
				<th>gender</th>
				<th>guest amount</th>
				<th>hear about</th>
				<th>liked least</th>
				<th>liked most</th>
				<th>marital status</th>
				<th>most important one</th>
				<th>most important two</th>
				<th>most important three</th>
				<th>reasons chosen</th>
				<th>room type</th>
				<th>timestamp</th>
				<td>Update</td>
				<td>Delete</td>

			</tr>

			<c:forEach items="${demoEntity}" var="demoEntity">

				<tr>

					<td>${demoEntity.id}</td>
					<td>${demoEntity.age}</td>
					<td>${demoEntity.children}</td>
					<td>${demoEntity.city}</td>
					<td>${demoEntity.country}</td>
					<td>${demoEntity.education}</td>
					<td>${demoEntity.email}</td>
					<td>${demoEntity.employment}</td>
					<td>${demoEntity.gender}</td>
					<td>${demoEntity.guestAmount}</td>
					<td>${demoEntity.hearAbout}</td>
					<td>${demoEntity.likedLeast}</td>
					<td>${demoEntity.likedMost}</td>
					<td>${demoEntity.maritalStatus}</td>
					<td>${demoEntity.mostImportantOne}</td>
					<td>${demoEntity.mostImportantThree}</td>
					<td>${demoEntity.mostImportantTwo}</td>
					<td>${demoEntity.reasonsChosen}</td>
					<td>${demoEntity.roomType}</td>
					<td>${demoEntity.timestamp}</td>
					<td><a href="updateDemoPage?id=${demoEntity.id}">Update</a></td>
					<td><a href="deleteDemo?id=${demoEntity.id}">Delete</a></td>

				</tr>

			</c:forEach>

		</table>

	</div>

	<jsp:include page="footer.jsp" />


</body>
</html>