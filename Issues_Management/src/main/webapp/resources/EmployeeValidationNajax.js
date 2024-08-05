// For Employee Validation and ajax for email n Phone
function VerifyEmployeeName() {
	let name = document.getElementById("name");
	let error = document.getElementById("enteredname");

	if (name.value.trim() === "Open this select menu" || name.value.length < 3 || name.value.length > 30) {
		error.innerHTML = "Please enter a valid Name";
		error.style.color = 'red';

	}
	else {


		error.innerHTML = "";
	}

}
function VerifyEmployeeDesignation() {
	let name = document.getElementById("designation");
	let error = document.getElementById("entereddesignatin");

	if (name.value.trim() === "Open this select menu" || name.value.length < 3 || name.value.length > 30) {
		error.innerHTML = "Please enter a valid Designation";
		error.style.color = 'red';

	}
	else {


		error.innerHTML = "";
	}

}

function VerifyEmployeeEmail() {
	console.log("this mailcheck");
	console.log(document.getElementById("email").value)
	let enteredemail = document.getElementById("email").value;
	const xhttp = new XMLHttpRequest();
	console.log("EnteredEmail:", enteredemail);
	console.log("xhttp:", XMLHttpRequest);
	if (enteredemail == "") {
		document.getElementById("enteredemail").innerHTML = "Fill in a  Valid Email-Id ";
	} else {
		xhttp.open("GET", "http://localhost:8080/Issues_Management/verifyEmail/" + enteredemail);
		xhttp.send();
		console.log(xhttp);
		xhttp.onload = function() {


			if (this.status == 200) {
				let response = this.responseText;
				console.log(this.responseText);

				document.getElementById("enteredemail").innerHTML = response;
			} else {
				console.log(this.responseText);
				document.getElementById("enteredemail").innerHTML = "An error occurred while checking the email.";
			}


		};
	}
}


function VerifyEmployeePhone() {


	console.log(" Phone Number check");
	console.log(document.getElementById("phone").value)
	let enteredphone = document.getElementById("phone").value;
	const xhttp = new XMLHttpRequest();
	console.log("EnteredPhone:", enteredphone);
	console.log("xhttp:", XMLHttpRequest);
	if (enteredphone == "") {
		document.getElementById("enteredphone").innerHTML = "Fill in a  Valid PhoneNumber ";
	} else {

		xhttp.open("GET", "http://localhost:8080/Issues_Management/verifyPhone/" + enteredphone);
		xhttp.send();
		console.log(xhttp);
		xhttp.onload = function() {


			if (this.status == 200) {
				let response = this.responseText;
				console.log(this.responseText);

				document.getElementById("enteredphone").innerHTML = response;
			} else {
				console.log(this.responseText);
				document.getElementById("enteredphone").innerHTML = "An error occurred while checking the phone.";
			}
		};
	}
}