var sessionSt = sessionStorage.getItem("value");
function caricamento() {
	 var daCar = JSON.parse(sessionSt);
	 var id_teacher = daCar.id_teacher;
	console.log(sessionSt);
	
	var request = new XMLHttpRequest();
	var uriAddress = "/Teachers/search/" + id_teacher;
	console.log(uriAddress);
	//var p =request.open(PUT,uriAddress);
	  var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function() {
            if (xmlHttp.readyState == 4 && xmlHttp.status >= 200) {
			console.log(daCar.first_name);
                 var obJSON = JSON.parse(xmlHttp.responseText);
                 
				 
 					document.getElementById("user_name_lastname").innerHTML=daCar.first_name+" "+ daCar.last_name;
					
		
				
            }
        }
	
	
	xmlHttp.open("PUT", uriAddress);
    xmlHttp.send(null);
	
}