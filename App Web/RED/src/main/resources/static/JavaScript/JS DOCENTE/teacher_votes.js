var sessionSt = sessionStorage.getItem("value");
var salvataggioData,salvataggioStudent,salvataggioVote;


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
 					for(i=0; i<31;i++){
					document.getElementById("lista_vote").innerHTML+= "<option>"+i+"</option>" ;
					}
               
             
		
				
            }
        }
	
	
	xmlHttp.open("PUT", uriAddress);
    xmlHttp.send(null);
    
	RicercaModulo(id_teacher);
	RicercaStudenti(id_teacher);
}
function RicercaStudenti(id_teacher){
	var uriAddress = "/Teachers/search/studentsEmail";
	var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function() {
            if (xmlHttp.readyState == 4 && xmlHttp.status >= 200) {                 
			var obJSON = JSON.parse(xmlHttp.responseText); 
				 console.log(obJSON);
             for (var idx = 0; idx < obJSON.length;idx++) {
		  		var grades = obJSON[idx];
		//document.getElementById("dropdownMenuButton1").classList.toggle("show");
		document.getElementById("lista_student").innerHTML+=
		"<option>" 
		+ grades.institutional_email + 
		" </option>";
		
		}
				
            }
        }
	
	xmlHttp.open("PUT", uriAddress);
	xmlHttp.setRequestHeader("id_teacher",id_teacher);
    xmlHttp.send(null);
}
function RicercaModulo(id_teacher){
	
	var uriAddress = "/Teachers/show/ElencoModuli";
	console.log(uriAddress);	  
	var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function() {
            if (xmlHttp.readyState == 4 && xmlHttp.status >= 200) {                 
			var obJSON = JSON.parse(xmlHttp.responseText); 
				 console.log(obJSON);
             for (var idx = 0; idx < obJSON.length;idx++) {
		  		var grades = obJSON[idx];
		//document.getElementById("dropdownMenuButton1").classList.toggle("show");
		document.getElementById("myList").innerHTML+=
		"<option>" 
		+ grades.title + 
		" </option>";
		document.getElementById("lista_moduli").innerHTML+=
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
function saveIdModuleVote(){
	console.log(document.getElementById("lista_moduli").value);
	var daCar = JSON.parse(sessionSt);
	 var id_teacher = daCar.id_teacher;
	//InserimentoVoti(document.getElementById("lista_moduli").value,id_teacher);
}
function saveIdStudent(){
	console.log(document.getElementById("lista_moduli").value);
	var daCar = JSON.parse(sessionSt);
	 var id_teacher = daCar.id_teacher;
	//InserimentoVoti(document.getElementById("lista_moduli").value,id_teacher);
}
function saveIdVote(){
	console.log(document.getElementById("lista_moduli").value);
	var daCar = JSON.parse(sessionSt);
	 var id_teacher = daCar.id_teacher;
	//InserimentoVoti(document.getElementById("lista_moduli").value,id_teacher);
}
function saveIdModule(){
	console.log(document.getElementById("myList").value);
	var daCar = JSON.parse(sessionSt);
	 var id_teacher = daCar.id_teacher;
	RicercaVoti(document.getElementById("myList").value,id_teacher);
}
function SalvaData(){
	salvataggioData = document.getElementById("date_input").value;
	console.log(salvataggioData);
}
function saveidStudent(){
	salvataggioStudent = document.getElementById("lista_student").value;
	console.log(salvataggioData);
}
function saveidVote(){
	salvataggioVote = document.getElementById("lista_vote").value;
	console.log(salvataggioData);
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



function aggiorna(){
	var sessionSt = sessionStorage.getItem("value");
	var daCar = JSON.parse(sessionSt);
	var id_student = daCar.id_student;
	
	var formData = new FormData(document.forms.newForm); 
    formData.set("id_teacher",id_teacher);
	
	console.log(jsonData);
	
	var uriAddress = "/Teachers/add/newVoto";
	console.log(uriAddress);
	//var p =request.open(PUT,uriAddress);
	  var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function() {
            if (xmlHttp.readyState == 4 && xmlHttp.status >= 200) {
			//console.log(daCar.firstName);
			
                alert("DONE");
              
                //console.log(jsonData);
					 
            }
        }
	
	
	xmlHttp.open("PUT", uriAddress);
    xmlHttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xmlHttp.send(jsonData);
    
    
}