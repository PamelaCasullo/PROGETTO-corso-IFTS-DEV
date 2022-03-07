function login(){

	var email = document.getElementById('email_input');
	var password = document.getElementById('password_input');

	if(email != null && password != null){
		$.ajax({
		url: "/Students/login",
      	type: "POST",
      	success: function () {
 			window.open('STUDENTE_html/homepage.html');
      },
      error: function () {
      		alert('errore');
      }
	})
}