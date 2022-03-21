var sessionSt = sessionStorage.getItem("value");
function caricamento() {
	 var daCar = JSON.parse(sessionSt);
	 var id_teacher = daCar.id_teacher;
	console.log(sessionSt);
	
	var uriAddress = "/Teachers/search/" + id_teacher;
	console.log(uriAddress);	  
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
    
	RicercaModulo(daCar,id_teacher);
}
function RicercaModulo(daCar,id_teacher){
	
	var uriAddress = "/Teachers/show/ElencoModuli";
	console.log(uriAddress);	  
	var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function() {
            if (xmlHttp.readyState == 4 && xmlHttp.status >= 200) {
			console.log(daCar.first_name);
                 var obJSON = JSON.parse(xmlHttp.responseText);
                 
				 console.log(obJSON);
             for (var idx = 0; idx < obJSON.length;idx++) {
		  		var grades = obJSON[idx];
		//document.getElementById("dropdownMenuButton1").classList.toggle("show");
		document.getElementById("myList").innerHTML+=
		"<option>" 
		+ grades.title + 
		" </option>";
               
             
		}
				
            }
        }
	
	
	xmlHttp.open("PUT", uriAddress);
	xmlHttp.setRequestHeader("id_teacher",id_teacher);
    xmlHttp.send(null);
}
function saveIdModule(){
	console.log(document.getElementById("myList").value);
	var daCar = JSON.parse(sessionSt);
	 var id_teacher = daCar.id_teacher;
	RicercaVoti(document.getElementById("myList").value,id_teacher);
}
function RicercaVoti(value,id_teacher){
		var uriAddress = "/Teachers/show/ElencoVoteModuleSelected/"+value;
	console.log(uriAddress);	  
	var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function() {
            if (xmlHttp.readyState == 4 && xmlHttp.status >= 200) {
                 var obJSON = JSON.parse(xmlHttp.responseText);
                 
				 console.log(obJSON);
             for (var idx = 0; idx < obJSON.length;idx++) {
		  		var grades = obJSON[idx];
		//document.getElementById("dropdownMenuButton1").classList.toggle("show");
		document.getElementById("riempireConVoti").innerHTML+=
		"<tr><th scope='row'><span class='font-text'>"+grades.date+"</span></th>"+
        "<td><span class='font-text' >NomeDelModulo</span></td>"+      
 		"<td><span class='font-text'>"+grades.first_name + " "+ grades.last_name+"</span></td>"+
 		"<td><span class='font-text'>"+grades.grade+"</span></td></tr>";
             
		}
				
            }
        }
	
	
	xmlHttp.open("PUT", uriAddress);
	xmlHttp.setRequestHeader("id_teacher",id_teacher);
    xmlHttp.send(null);
	
	
}