var sessionSt = sessionStorage.getItem("value");
var salvataggioData,salvataggioStudent,salvataggioVote,salvataggioModule;
var id_1;
var id_2;

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
	 salvataggioModule = document.getElementById("lista_moduli").value;
	//InserimentoVoti(document.getElementById("lista_moduli").value,id_teacher);
}
function saveIdStudentPerVote(){
	//console.log(document.getElementById("lista_moduli").value);
	//var daCar = JSON.parse(sessionSt);
	 //var id_teacher = daCar.id_teacher;
	 var uriAddress = "/Teachers/show/StudentId";
	console.log(uriAddress);	  
	var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function() {
            if (xmlHttp.readyState == 4 && xmlHttp.status >= 200) {
			console.log(daCar.first_name);
                 var obJSON = JSON.parse(xmlHttp.responseText);
                 
 					id_1=obJSON.id_student[0];
 					console.log("uriAddress="+salvataggioStudent);
 					
					}
            }
        
	
	
	xmlHttp.open("PUT", uriAddress);
	xmlHttp.setRequestHeader("institutional_email",salvataggioStudent);
    xmlHttp.send(null);
	 //getIdStudentPerVote
	//InserimentoVoti(document.getElementById("lista_moduli").value,id_teacher);
}
function saveIdAgendaPerVote(){
	
	 var uriAddress = "/Teachers/show/AgendaId/"+salvataggioData;
	console.log(uriAddress);	  
	var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function() {
            if (xmlHttp.readyState == 4 && xmlHttp.status >= 200) {
                 var obJSON = JSON.parse(xmlHttp.responseText);
                 console.log(obJSON);
 					id_2=obJSON.id_agenda[0];
 					console.log("Id_Agenda="+obJSON.id_agenda[0]);
 					
					}
            }
        
	
	
	xmlHttp.open("PUT", uriAddress);
	xmlHttp.setRequestHeader("title",salvataggioModule);
    xmlHttp.send(null);

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
	console.log(salvataggioStudent);
}
function saveidVote(){
	salvataggioVote = document.getElementById("lista_vote").value;
	console.log(salvataggioVote);
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
	var id_teacher = daCar.id_teacher;
	saveIdAgendaPerVote();
	saveIdStudentPerVote()
	
	var formData = new FormData(document.forms.newForm); 
    formData.set("id_teacher",id_teacher);
	var jsonData={
		"grade":salvataggioVote,
		"agenda_id_agenda":id_2,
		"student_id_student":id_1
	};
	console.log(jsonData);
	
	var uriAddress = "/Teachers/add/newVoto";
	console.log(uriAddress);
	  var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function() {
            if (xmlHttp.readyState == 4 && xmlHttp.status >= 200) {
			
                alert("DONE");
              
            }
        }
	
	
	xmlHttp.open("PUT", uriAddress);
    xmlHttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xmlHttp.send(jsonData);
    
    
}