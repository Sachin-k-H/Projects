function validationform(){
	let x= document.forms["myform"]["firstName"].value;
	let y= document.forms["myform"]["lastName"].value;
	let z=document.forms["myform"]["phone"].value;
	if(x==""){
	//	alert("FirstName must be filled out");
	 document.getElementById("firstNameError").innerHTML="FirstName must be filled out";
		
		return false;
	}
	if(y==""){
	//	alert("LastName must be filled out");
		 document.getElementById("lastNameError").innerHTML="LastName must be filled out";
		return false;
	}
	if(z==""){
	//	alert("PhoneNumber must be filled out");
		 document.getElementById("phoneError").innerHTML="PhoneNumber must be filled out";
		return false;
	}
}



 function CheckEmail(){
	
			 console.log("this mailcheck");
		 console.log(document.getElementById("email").value)
	   let enteredemail= document.getElementById("email").value;
		 const xhttp = new XMLHttpRequest();
		 console.log("EnteredEmail:", enteredemail);
		 console.log("xhttp:",XMLHttpRequest);
		if(enteredemail==""){
			  document.getElementById("enteredemail").innerHTML="Fill in a  Valid Email-Id ";
		  }else{
	  	  xhttp.open("GET", "http://localhost:8080/Issues_Management/checkEmail/"+enteredemail);
		  xhttp.send();
		  console.log(xhttp);
	   xhttp.onload = function() {
		   
		   
              if (this.status == 200) {
            	  let response =this.responseText;
            	  console.log(this.responseText);
            	  
            	  document.getElementById("enteredemail").innerHTML = response;
              } else {
            	  console.log(this.responseText);
                  document.getElementById("enteredemail").innerHTML = "An error occurred while checking the email.";
              }
              
           
          };
          }
          }
          
           
 function CheckPhone(){
        		
 			 console.log(" Phone Number check");
 		 console.log(document.getElementById("phone").value)
 	   let enteredphone = document.getElementById("phone").value;
 		 const xhttp = new XMLHttpRequest();
 		 console.log("EnteredPhone:", enteredphone);
 		 console.log("xhttp:",XMLHttpRequest);
 		 if(enteredphone==""){
			  document.getElementById("enteredphone").innerHTML="Fill in a  Valid PhoneNumber ";
		  }else{
 		
 	  	  xhttp.open("GET", "http://localhost:8080/Issues_Management/checkPhone/"+enteredphone);
 		  xhttp.send();
 		  console.log(xhttp);
 	   xhttp.onload = function() {
 		   
 		   
               if (this.status == 200) {
             	  let response =this.responseText;
             	  console.log(this.responseText);
             	  
             	  document.getElementById("enteredphone").innerHTML = response;
               } else {
             	  console.log(this.responseText);
                   document.getElementById("enteredphone").innerHTML = "An error occurred while checking the phone.";
               }
}
}
}