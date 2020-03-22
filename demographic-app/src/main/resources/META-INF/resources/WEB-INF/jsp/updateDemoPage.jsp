<%@ include file="header.jsp"%>

<title>Create Demographics</title>

<script type="text/javascript">
	document.addEventListener("DOMContentLoaded", function() {
		// Handler when the DOM is fully loaded

		var f = document.forms[0];

		f.likedMost.value = "${demoEntity.likedMost}";

		f.likedLeast.value = "${demoEntity.likedLeast}";

		f.roomType.value = "${demoEntity.roomType}";

	});
</script>

</head>
<body>

	<div class="container">
		<h2>Update Demographics</h2>
	</div>

	<jsp:include page="menu.jsp" />

	<div class="container">

		<div class="row">

			<div class="col-md-9" id="main-content">

				<form action="saveUpdate" method="post">



					<div class="form-group">
						<label for="age">Age/Edad</label> <select id="age" name="age"
							class="form-control">
							<option value=""></option>
							<c:forEach begin="18" end="105" varStatus="ageCounter">
								<option value="${ageCounter.index}"
									<c:if test="${ageCounter.index eq demoEntity.age}">selected="selected"</c:if>>
									${ageCounter.index}</option>
							</c:forEach>
						</select>
					</div>


					<div class="form-group">
						<label for="gender">Gender/G&eacute;nero</label> <select
							id="gender" name="gender" class="form-control">
							<option value=""></option>
							<c:forEach items="${gender}" var="listItem">
								<option value="${listItem.key}"
									<c:if test="${listItem.key eq demoEntity.gender}">selected="selected"</c:if>>
									${listItem.value}</option>
							</c:forEach>
						</select>
					</div>


					<div class="form-group">

						<label for="guestAmount">How guests in your group/Cuanta
							personas en su grupo</label> <select id="guestAmount" name="guestAmount"
							class="form-control">
							<option value=""></option>
							<c:forEach begin="1" end="40" varStatus="gAmount">
								<option value="${gAmount.index}"
									<c:if test="${gAmount.index eq demoEntity.guestAmount}">selected="selected"</c:if>>
									${gAmount.index}</option>
							</c:forEach>
						</select>
					</div>



					<div class="form-group">

						<label for="city">City you live in/Ubicacion de ciudad</label> <input
							type="text" name="city" value="${demoEntity.city}"
							class="form-control" />
					</div>

					<div class="form-group">
						<label for="country">Country you live in/Ubicacion de
							país</label> <select name="country" id="country" class="form-control">
							<option value=""></option>
							<c:forEach items="${mapCountries}" var="country">
								<option value="${country.key}"
									<c:if test="${country.key eq demoEntity.country}">selected="selected"</c:if>>
									${country.value}</option>
							</c:forEach>
						</select>
					</div>



					<div class="form-group">

						<label for="maritalStatus">Marital status/Estado civil</label> <select
							id="maritalStatus" name="maritalStatus" class="form-control">
							<option value=""></option>
							<c:forEach items="${maritalStatus}" var="listItem">
								<option value="${listItem.value}"
									<c:if test="${listItem.key eq demoEntity.maritalStatus}">selected="selected"</c:if>>
									${listItem.key}</option>
							</c:forEach>
						</select>
					</div>


					<div class="form-group">

						<label for="children">Children/ninos</label> <select id="children"
							name="children" class="form-control">
							<option value=""></option>
							<c:forEach begin="1" end="5" varStatus="childAmount">
								<option value="${childAmount.index}"
									<c:if test="${childAmount.index eq demoEntity.children}">selected="selected"</c:if>>
									${childAmount.index}</option>
							</c:forEach>
						</select>
					</div>


					<div class="form-group">

						<label for="education">Highest level of education/Grado
							maximo de educacion completado</label> <select id="education"
							name="education" class="form-control">
							<option value=""></option>
							<c:forEach items="${education}" var="listItem">
								<option value="${listItem.value}"
									<c:if test="${listItem.value eq demoEntity.education}">selected="selected"</c:if>>
									${listItem.key}</option>
							</c:forEach>
						</select>
					</div>


					<div class="form-group">

						<label for="reasonsChosen">Specific reasons why you chose
							this hotel/Razones específicas que eligió este hotel?</label> <select
							id="reasonsChosen" name="reasonsChosen" class="form-control">
							<option value=""></option>
							<c:forEach items="${reasonsChosen}" var="listItem">
								<option value="${listItem.value}"
									<c:if test="${listItem.value eq demoEntity.reasonsChosen}">selected="selected"</c:if>>
									${listItem.key}</option>
							</c:forEach>
						</select>
					</div>


					<div class="form-group">

						<label for="hearAbout">Hear About How did you hear about
							us? / ¿Cómo se enteró de nuestro hotel? </label> <select id="hearAbout"
							name="hearAbout" class="form-control">
							<option value=""></option>
							<c:forEach items="${hearAbout}" var="listItem">
								<option value="${listItem.value}"
									<c:if test="${listItem.value eq demoEntity.hearAbout}">selected="selected"</c:if>>
									${listItem.key}</option>
							</c:forEach>
						</select>
					</div>

					<div class="form-group">

						<label for="mostImportantOne">Three most important things
							for you in a hotel/ Las 3 cosas más importante para Ud en un
							hotel 1. Most important / 1. mas importante</label> <select
							id="mostImportantOne" name="mostImportantOne"
							class="form-control">
							<option value=""></option>
							<c:forEach items="${mostImportantOne}" var="listItem">
								<option value="${listItem.value}"
									<c:if test="${listItem.key eq demoEntity.mostImportantOne}">selected="selected"</c:if>>
									${listItem.key}</option>
							</c:forEach>
						</select>
					</div>


					<div class="form-group">

						<label for="mostImportantTwo">2. Most important / 2. mas
							importante</label> <select id="mostImportantTwo" name="mostImportantTwo"
							class="form-control">
							<option value=""></option>
							<c:forEach items="${mostImportantTwo}" var="listItem">
								<option value="${listItem.value}"
									<c:if test="${listItem.key eq demoEntity.mostImportantTwo}">selected="selected"</c:if>>
									${listItem.key}</option>
							</c:forEach>
						</select>
					</div>


					<div class="form-group">

						<label for="mostImportantThree">3. Most important / 3. mas
							importante</label> <select id="mostImportantThree"
							name="mostImportantThree" class="form-control">
							<option value=""></option>
							<c:forEach items="${mostImportantThree}" var="listItem">
								<option value="${listItem.value}"
									<c:if test="${listItem.key eq demoEntity.mostImportantThree}">selected="selected"</c:if>>
									${listItem.key}</option>
							</c:forEach>
						</select>
					</div>

					<div class="form-group">

						<label for="likedMost">What did you like most about your
							stay?/Que te gusto mas de su hospedaje?</label> <select id="likedMost"
							name="likedMost" class="form-control">
							<option value=""></option>
							<option value="breakfast">I liked the breakfast the most</option>
							<option value="cleaning">I liked the cleaning the most</option>
							<option value="check-in">I liked the check-in the most</option>
							<option value="check-out">I liked the check-out the most</option>
							<option value="receptionist">I liked the receptionist
								the most</option>
							<option value="housekeepers">I liked the housekeepers
								the most</option>
							<option value="general">I liked the staff in general the
								most</option>
							<option value="swimming pool">I liked the swimming pool
								the most</option>
							<option value="parking lot">I liked the parking lot the
								most</option>
							<option value="bed">I liked the bed the most</option>
							<option value="room floor">I liked the room floor the
								most</option>
							<option value="room size">I liked the room size the most</option>
							<option value="room decoration">I liked the room
								decoration the most</option>
							<option value="room in general">I liked the room room in
								general the most</option>
							<option value="facilities">I liked the facilities the
								most</option>
							<option value="quietness">I liked the quietness the most</option>
							<option value="location">I liked the location the most</option>
							<option value="business hours">I liked the the business
								hours the most</option>
							<option value="AC">I liked the AC the most</option>
							<option value="TV or Cable">I liked the TV or Cable the
								most</option>
							<option value="water">I liked the the water the most</option>
							<option value="weather">I liked the the weather the most</option>
							<option value="bar">I liked the the bar the most</option>
							<option value="prices">I liked the the prices the most</option>
							<option value="nothing good">I liked the nothing</option>
							<option value="all good">I liked everything</option>
						</select>
					</div>


					<div class="form-group">


						<label for="leastLiked">What was the least you liked about
							your stay?/Que fue lo que te gusto lo menos?</label> <select
							id="leastLiked" name="likedLeast" class="form-control">
							<option value=""></option>
							<option value="breakfast">did not like the breakfast</option>
							<option value="cleaning">did not like the cleaning</option>
							<option value="check-in">did not like the check-in</option>
							<option value="check-out">did not like the check-out</option>
							<option value="receptionist">did not like the
								receptionist</option>
							<option value="housekeepers">did not like the
								housekeepers</option>
							<option value="general">did not like the staff in
								general</option>
							<option value="swimming pool">did not like the swimming
								pool</option>
							<option value="parking lot">did not like the parking lot</option>
							<option value="bed">did not like the bed</option>
							<option value="room floor">did not like the room floor</option>
							<option value="room size">did not like the room size</option>
							<option value="room decoration">did not like the room
								decoration</option>
							<option value="room in general">did not like the room in
								general</option>
							<option value="facilities">did not like the facilities</option>
							<option value="noise">did not like the noise</option>
							<option value="location">did not like the location</option>
							<option value="business hours">did not like the business
								hours</option>
							<option value="AC">did not like the AC</option>
							<option value="TV or Cable">did not like the TV or Cable</option>
							<option value="water">did not like the water</option>
							<option value="weather">did not like the weather</option>
							<option value="bar">did not like the bar</option>
							<option value="prices">did not like the prices</option>
							<option value="nothing">I did not like anything</option>
							<option value="like everything">I liked everything</option>
						</select>
					</div>

					<div class="form-group">

						<label for="roomType">What type of room did you stay in? /
							En que tipo de cuarto se hospedó?</label> <select id="roomType"
							name="roomType" class="form-control">
							<option value=""></option>
							<option value="Standard one bed - no AC">Standard one
								bed - no AC</option>
							<option value="Standard two bed - no AC">Standard two
								bed - no AC</option>
							<option value="Deluxe one bed - with AC">Deluxe one bed
								- with AC</option>
							<option value="Deluxe two bed - with AC">Deluxe two bed
								- with AC</option>
							<option value="Suite one bed - with AC and Kitchen">Suite
								one bed - with AC and Kitchen</option>
							<option value="Suite two bed - with AC and Kitchen">Suite
								two bed - with AC and Kitchen</option>
						</select>
					</div>

					<div class="form-group">
						<label for="email">Email/Correo Electronic:</label> <input
							type="text" name="email" value="${demoEntity.email}"
							class="form-control" />
					</div>

					<div class="form-group">
						<label for="id">Id:</label> <input type="text" name="id"
							value="${demoEntity.id}" readonly class="form-control" />
					</div>

					<div class="form-group">
						<input type="submit" value="save" class="form-control" />
					</div>



				</form>

			</div>
		</div>
	</div>

	${msg}

	<jsp:include page="footer.jsp" />

</body>
</html>