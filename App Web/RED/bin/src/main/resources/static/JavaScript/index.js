function login(){

	var email = document.getElementById('email_input').value;
	var pwd = document.getElementById('password_input').value;
	
	var datajson = JSON.stringify({
    			emailq: email,
    			passwordq: pwd
  			});
  			
  	console.log(datajson);
	if(radioBTN()=="STUDENTE"){
	if(email != null && pwd != null){
		$.ajax({
		url: "/Students/login",
      	type: "POST",
      	contentType: 'application/json; charset=utf-8',
      	data:  datajson,
      	success: function (response) {
			if(JSON.stringify(response)=="") {
				alert("ERRORE INSERIMENTO DATI");
			} else {
				var p = JSON.stringify(response);
				sessionStorage.setItem("value",p);
				window.open('STUDENTE_html/student_homepage.html',"_self");
			}
      	},
		error: function (request, status, error) {
       		 alert(request.responseText);
    		}
		})
	}
	} else if(radioBTN()=="DOCENTE"){
		if(email != null && pwd != null){
		$.ajax({
		url: "/Teachers/login",
      	type: "POST",
      	contentType: 'application/json; charset=utf-8',
      	data:  datajson,
      	success: function (response) {
			
 			if(JSON.stringify(response)=="") {
				alert("ERRORE INSERIMENTO DATI");
			} else {
				var p = JSON.stringify(response);
				sessionStorage.setItem("value",p);
				window.open('DOCENTE_html/teacher_homepage.html',"_self");
			}
			
      	},
		error: function (request, status, error) {
       		 alert(request.responseText);
    		}
		})
	}
	}
}
function radioBTN(){
    var getSelectedValue = document.querySelector('input[name="radio"]:checked').value;   
    if(getSelectedValue != null) { 
	    if(document.getElementById('student_radio_button').checked) {   
           var selectedValue = document.getElementById('student_radio_button').value;  
          // alert("Selected Radio Button is: " + selectedValue);    
           return "STUDENTE";
    } else {  
           if(document.getElementById('teacher_radio_button').checked) {   
          	var selectedValue = document.getElementById('teacher_radio_button').value;  
          // 	alert("Selected Radio Button is: " + selectedValue);    
           	return "DOCENTE";
           }
 }
 }
}




