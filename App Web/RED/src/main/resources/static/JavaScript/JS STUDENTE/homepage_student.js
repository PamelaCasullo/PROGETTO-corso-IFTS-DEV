

var sessionSt = sessionStorage.getItem("value");

function caricamento() {
	 var daCar = JSON.parse(sessionSt);
	 
	console.log(daCar[0].id_student);
	console.log(daCar);
	
	var request = new XMLHttpRequest();
	var uriAddress = "./Students/search/" + id;
	//var p =request.open(PUT,uriAddress);
	  var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function() {
            if (xmlHttp.readyState == 4 && xmlHttp.status >= 200) {
                 var obJSON = JSON.parse(xmlHttp.responseText);
                 
                  for (let index = 0; index < obJSON.length; index++) {
					
					 document.getElementById("user_name_lastname").innerHTML(obJSON[index].firstName);
					
					
				}
            }
        }
	
	
	xmlHttp.open("PUT", uriAddress);
    xmlHttp.send(null);
	
	
}
