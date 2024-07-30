let getFields=  {
"type":false,
"description":false,
"address":false,
"country":false,
"state":false,
"city":false

}

function validate(){

let flag=false;

for(let[key,value] of Object.entries(getFields)){
if(value===false){

flag=true;
break;
}
}
if(!flag){
document.getElementById("btn").removeAttribute("disabled");
}else{
document.getElementById("btn").setAttribute("disabled","");
}
}

function setType(){
let name=document.getElementById("type");
let error=document.getElementById("typeError");

if(name.value.trim()==="Open this select menu" || name.value.length<3 || name.value.length>30){
error.innerHTML="Please enter a valid type";
error.style.color='red';
getFields["type"]=false;
}
else{

getFields["type"]=true;
error.innerHTML="";
}
validate();
}

function setDescription(){
let name=document.getElementById("description");
let error=document.getElementById("descriptionError");

if(name.value.trim()==="" || name.value.length<10 || name.value.length>300){
error.innerHTML="Please enter Description correctly";
error.style.color='red';
getFields["description"]=false;
}
else{

getFields["description"]=true;
error.innerHTML="";
}
validate();
}

function setAddress(){
let name=document.getElementById("address");
let error=document.getElementById("addressError");

if(name.value.trim()==="" || name.value.length<5 || name.value.length>30){
error.innerHTML="Please enter Address correctly minimum 5 character";
error.style.color='red';
getFields["address"]=false;
}
else{

getFields["address"]=true;
error.innerHTML="";
}
validate();
}


function setCountry(){
let name=document.getElementById("country");
let error=document.getElementById("countryError");

if(name.value.trim()==="Choose..." || name.value.trim()===""){
error.innerHTML="Please enter Country details correctly";
error.style.color='red';
getFields["country"]=false;
}
else{

getFields["country"]=true;
error.innerHTML="";
}
validate();
}
function setState(){
let name=document.getElementById("state");
let error=document.getElementById("stateError");

if(name.value.trim()==="Choose..." || name.value.trim()===""){
error.innerHTML="Please enter State details correctly";
error.style.color='red';
getFields["state"]=false;
}
else{

getFields["state"]=true;
error.innerHTML="";
}
validate();
}

function setCity(){
let name=document.getElementById("city");
let error=document.getElementById("cityError");

if(name.value.trim()==="Choose..." || name.value.trim()===""){
error.innerHTML="Please enter City correctly";
error.style.color='red';
getFields["city"]=false;
}
else{

getFields["city"]=true;
error.innerHTML="";
}
validate();
}

