function login(){

	var email = document.getElementById('email_input').value;
	var pwd = document.getElementById('password_input').value;
	
	var datajson = JSON.stringify({
    			emailq: email,
    			passwordq: pwd
  			});
  			
  	console.log(datajson);
	
	if(email != null && pwd != null){
		$.ajax({
		url: "/Students/login",
      	type: "POST",
      	contentType: 'application/json; charset=utf-8',
      	data:  datajson,
      	success: function (response) {
			alert(JSON.stringify(response));
			//alert("AAAAAAAA");
 			//window.open('STUDENTE_html/homepage.html');
      	},
		error: function (request, status, error) {
       		 alert(request.responseText);
    		}
		})
	}
}

