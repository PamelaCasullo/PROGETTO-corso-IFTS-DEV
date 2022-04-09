
var sessionSt = sessionStorage.getItem("value");
function onPageLoaded(){
	var daCar = JSON.parse(sessionSt);
	 var id_teacher = daCar.id_teacher;
	console.log(sessionSt);
	
	document.getElementById("user_name_lastname").innerHTML=daCar.first_name+ " " + daCar.last_name;

	
    RicercaModulo(id_teacher);
	loadOther();
}
function loadOther() {
	 
	
}
function saveIdModule(){
	console.log(document.getElementById("myList").value);
	var save_module=document.getElementById("myList").value;
	var daCar = JSON.parse(sessionSt);
	 var id_teacher = daCar.id_teacher;
	 RicercaStudenti(id_teacher,save_module);
	
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
function RicercaStudenti(id_teacher,save_module){
	var daCar = JSON.parse(sessionSt);
	 var id_teacher = daCar.id_teacher;
	 console.log(daCar.id_teacher);
	 
	var uriAddress = "/Teachers/search/studentsEmail/"+save_module;
	console.log(uriAddress);
	var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function() {
            if (xmlHttp.readyState == 4 && xmlHttp.status >= 200) {                 
			var obJSON = JSON.parse(xmlHttp.responseText); 
             for (var idx = 0; idx < obJSON.length;idx++) {
		  		var grades = obJSON[idx];
		  		console.log(grades);
		     document.getElementById("daRiempire").innerHTML += 
                    "<div class='col-lg-3 mb-4'>" + 
                    "<div class='card' style='background-color: darkred; box-shadow: 0px 3px 10px black; border-radius: 5px;'>" +
                    "<div class='card-body'>" +   
                    "<img src='https://www.timeoutdubai.com/cloud/timeoutdubai/2021/09/11/hfpqyV7B-IMG-Dubai-UAE.jpg' class='rounded-circle' height='55px' width='55px' style='border: 2px solid black'>" +
                    "<span class='card-title titles-shadow-black font-text' style='background-color: darkred; margin-left: 5px' id='student_name'>"+grades.first_name + " " + grades.last_name+"</span>" +
                    "<ul class = 'list-group list-group-flush'style = 'margin-top: 10px;' > " +
                    "<li class = 'list-group-item' style = 'background-color: darkred; border-radius: 5px; box-shadow: 0px 3px 2px black;'> <span class = 'badge bg-dark'>E - MAIL</span> " +
                    "<a href='mailto:' " + grades.institutional_email + " style = 'margin-left: 5px;' class = 'mailto-text' id = 'students_list_instistutional_mail'> "+grades.institutional_email+" </a></li >" +
                    "<li class = 'list-group-item' style = 'background-color: darkred; border-radius: 5px; box-shadow: 0px 3px 2px black; margin-top: 5px;'>" +
                    "<span class = 'badge bg-dark'> NR. </span><span style='margin-left: 5px; color: white;' id='students_list_number'>"+grades.phone_number+"</span > </li></ul>";

            
		
		}
				
            }
        }
	
	xmlHttp.open("PUT", uriAddress);
	xmlHttp.setRequestHeader("id_teacher",id_teacher);
    xmlHttp.send(null);
}