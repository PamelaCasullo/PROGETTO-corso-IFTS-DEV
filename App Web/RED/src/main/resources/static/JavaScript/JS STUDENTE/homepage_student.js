

var sessionSt = sessionStorage.getItem("value");
function caricamento() {
//	alert(sessionSt);

	 var daCar = JSON.parse(sessionSt);
	 
	// document.getElementById("user_name_lastname").innerHTML(daCar.firstName);
	document.getElementById("user_name_lastname").innerHTML = sessionSt.firstName;
}
