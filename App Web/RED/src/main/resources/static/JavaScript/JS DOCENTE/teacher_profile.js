
var sessionSt = sessionStorage.getItem("value");


function caricamento() {
	console.log(sessionSt);
	 var daCar = JSON.parse(sessionSt);
	var id_teacher = daCar.id_teacher;
	
	
	//var request = new XMLHttpRequest();
	var uriAddress = "/Teachers/search/" + id_teacher;
	console.log(uriAddress);
	//var p =request.open(PUT,uriAddress);
	  var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function() {
            if (xmlHttp.readyState == 4 && xmlHttp.status >= 200) {
		
                 //var obJSON = JSON.stringify(xmlHttp.responseText);
                  var ops = JSON.parse(xmlHttp.responseText);
                 //var ob = JSON.stringify(obJSON);
                 	console.log(ops);
				 	 document.getElementById("user_name_lastname").innerHTML=daCar.first_name+ " " + ops.last_name;
					 document.getElementById("personal_email").innerHTML=ops.personal_email;
					 document.getElementById("institutional_email").innerHTML=ops.institutional_email;
					 document.getElementById("phone_number").innerHTML=ops.phone_number;
					 document.getElementById("password").innerHTML=ops.password;
					 
				
				

            }
        }
	
	
	xmlHttp.open("PUT", uriAddress);
    xmlHttp.send(null);
	
}

function aggiorna(){
	var sessionSt = sessionStorage.getItem("value");
	var daCar = JSON.parse(sessionSt);
	var id_teacher = sessionSt.id_teacher;
	
	var formData = new FormData(document.forms.newForm); 
    formData.set("id_teacher",id_teacher);
    var jsonData = JSON.stringify(Object.fromEntries(formData));
	
	
	var request = new XMLHttpRequest();
	var uriAddress = "/Teachers/update";
	console.log(uriAddress);
	//var p =request.open(PUT,uriAddress);
	  var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function() {
            if (xmlHttp.readyState == 4 && xmlHttp.status >= 200) {
			console.log(daCar.firstName);
			
                alert("DONE");
                console.log(jsonData);
                location.reload(); 
					 
            }
        }
	
	
	xmlHttp.open("PUT", uriAddress);
    xmlHttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xmlHttp.send(jsonData);
    
}