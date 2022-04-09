
var sessionSt = sessionStorage.getItem("value");

function caricamento() {
	 var daCar = JSON.parse(sessionSt);
	 var id_teacher = daCar.id_teacher;
	console.log(sessionSt);
	
	var uriAddress = "/Teachers/search/" + id_teacher;
	console.log(uriAddress);
	//var p =request.open(PUT,uriAddress);
	  var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function() {
            if (xmlHttp.readyState == 4 && xmlHttp.status >= 200) {
			console.log(daCar.first_name);
                 var obJSON = JSON.parse(xmlHttp.responseText);
                 
				 document.getElementById("user_name_lastname").innerHTML=daCar.first_name+ " " + daCar.last_name;

		
				
            }
        }
	
	
	xmlHttp.open("PUT", uriAddress);
    xmlHttp.send(null);
	loadVote();
	loadLesson();
	
}
function loadVote(){
	 var uriAddr = "/Teachers/show/ElencoVoti";
    var xmlHttp = new XMLHttpRequest();
	var daCar = JSON.parse(sessionSt);
	 var id_teacher = daCar.id_teacher;
	// var ch="Nessun voto assegnato";
    xmlHttp.onreadystatechange = function() {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            //codice di gestione del ritorno dal servizio web
            console.log(xmlHttp.responseText);
			console.log(uriAddr);
            var jsonObj = JSON.parse(xmlHttp.responseText);
             for (var idx = 0; idx < jsonObj.length;idx++) {
	  		var grades = jsonObj[idx];
	  		/*
	  		 if(grades.grade!=0) {
						ch=grades.grade;
			} else {
				ch="Nessun voto assegnato";
			}
			*/
			
			
				 
			document.getElementById("MostraVoti").innerHTML+=  
                    "<li class='list-group-item d-flex justify-content-between align-items-center' style='background-color: #484848; border: 1px solid ;'>" +
                    "<span id='teacher_module_name' style='color: white;' class='font-text'>"+grades.title+"</span>" +
                    "<span style='margin: auto; color: white;' id='teacher_vote_date' class='font-text'>"+grades.date+"</span>" +
                    "<span class='badge bg-danger rounded-pill' id='teacher_vote'>"+grades.grade+"</span>" +
                    "</li>";					
    		}
    		
 
        }
        
    };

    xmlHttp.open("GET", uriAddr);
    xmlHttp.setRequestHeader("id_teacher",id_teacher);
    xmlHttp.send(null);
}
function loadLesson() {
    var uriAddr = "/Teachers/show/ElencoLezioni";
    var xmlHttp = new XMLHttpRequest();
	var daCar = JSON.parse(sessionSt);
	 var id_teacher = daCar.id_teacher;
    xmlHttp.onreadystatechange = function() {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            //codice di gestione del ritorno dal servizio web
            console.log(xmlHttp.responseText);
			console.log(uriAddr);
            var jsonObj = JSON.parse(xmlHttp.responseText);
             for (var idx = 0; idx < jsonObj.length;idx++) {
	  		 var lesson = jsonObj[idx];
	  		 
			document.getElementById("inserisciLezioni").innerHTML+=
			
			"<div class='list-group' style='box-shadow: 0px 3px 0px darkred;'>" +
			 "<a class='list-group-item list-group-item-action active' aria-current='true' style='background-color: darkred; border: 2px solid black;'>"+
			 "<div class='d-flex w-100 justify-content-between'>"+
			 "<!--NOME LEZIONE-->"+
             "<h5 class='mb-1 font-text' id='student_lesson_name'>"+ lesson.title +"</h5>"+
             "<!--DATA ORARIO-->"+
             "<small id='datetime_calendar'><span class='badge bg-dark'><h6 style='margin: 0;' id='student_lesson_date'>"+lesson.date+"</h6></span></small></div>";
             
    		}
 			
        }
    };

    xmlHttp.open("GET", uriAddr);
    xmlHttp.setRequestHeader("id_teacher",id_teacher);
    xmlHttp.send(null);


}