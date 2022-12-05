<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="ISO-8859-1">
<title>Demo Ajax</title>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script text="text/javascript">
	$(document).ready(
			function() {
				$('#bttHello').click(
						function() {
							var fullname = $('#name').val();
							var gender = $("input[name='gender']:checked")
									.val();
							var hobbies = $("input[type='checkbox']:checked")
									.val();
							var selectedCity = $("#city").children("option")
									.filter(":selected").text();
							$.ajax({
								type : 'POST',
								data : {
									name : fullname,
									gender : gender,
									hobbies : hobbies,
									city : selectedCity
								},
								url : 'SaveServlet',
								success : function(result) {
									$('#result1').html(result);
								}
							});
						});
			});
</script>
</head>
<body>
	<fieldset>
		<legend>Demo 1</legend>
		<form method="POST" action="SaveServlet">
			<table>
				<tr>
					<th>Name</th>
					<td><input type="text" id="name" name="name"></td>
				</tr>
				<tr>
					<th>gender</th>
					<td><input type="radio" id="male" name="gender" value="male">male
						<input type="radio" id="female" name="gender" value="female">Female<br>
					</td>
				</tr>
				<tr>
					<th>Hobbies</th>
					<td><input type="checkbox" id="hob1" value="badminton"
						name="hobbies" class="hobbies"> Badminton <input
						type="checkbox" id="hob2" value="Cricket" name="hobbies"
						class="hobbies"> Cricket <input type="checkbox" id="hob3"
						value="Running" name="hobbies" class="hobbies">Running<br>
					</td>
				</tr>
				<tr>
					<th>city</th>
					<td><select name="city" id="city">
							<option>Select City</option>
							<option value="Ahemdabad">Ahemdabad</option>
							<option value="Patna">Patna</option>
							<option value="Jaipur">Jaipur</option>
							<option value="Vadoadara">Vadoadara</option>
					</select></td>
				</tr>
				<tr>
					<td><input type="button" value="submit" id="bttHello"><br />
					</td>
				</tr>
				<tr>
					<td colspan=2><a href="ViewServlet">View</a></td>
				</tr>
			</table>
		</form>
		<span id="result1"></span>
	</fieldset>
</body>
</html>