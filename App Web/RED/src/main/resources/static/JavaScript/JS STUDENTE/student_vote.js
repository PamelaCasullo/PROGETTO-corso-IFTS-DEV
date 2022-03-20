
var sessionSt = sessionStorage.getItem("value");

function caricamento() {
	 var daCar = JSON.parse(sessionSt);
	 var id_student = daCar.id_student;
	console.log("voti");
	
	var request = new XMLHttpRequest();
	var uriAddress = "/Students/search/" + id_student;
	console.log(uriAddress);
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
	
}

function loadVote(){
	 var uriAddr = "/Students/show/ElencoVoti";
    var xmlHttp = new XMLHttpRequest();
	var daCar = JSON.parse(sessionSt);
	 var id_student = daCar.id_student;
    xmlHttp.onreadystatechange = function() {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            //codice di gestione del ritorno dal servizio web
            console.log(xmlHttp.responseText);
			console.log(uriAddr);
            var jsonObj = JSON.parse(xmlHttp.responseText);
             for (var idx = 0; idx < jsonObj.length;idx++) {
	  		 var grades = jsonObj[idx];
	  		 
			document.getElementById("MostraVoti").innerHTML+=
			  " <table class='table'>"+
			   "<thead><tr style='background-color: transparent;'>"+
			   "<th scope='col'><h4 class='titles-shadow titles-underline'>DATA</h4></th>"+
			   "<th scope='col'><h4 class='titles-shadow titles-underline'>MATERIA</h4></th>"+
			   "<th scope='col'><h4 class='titles-shadow titles-underline'>VOTO</h4></th></tr></thead>"+
			   "<tbody style='background-color: rgb(68, 66, 66);'>"+
			   "<tr> <th scope='row'><span class='font-text' id='student_votes_date'>"+grades.date+"</span></th>"+
			   "<td><span class='font-text' id='student_votes_module'>MODULO 07 - SVILUPPO APPLICAZIONI ANDROID</span></td>"+	
               "<td style='background-color: darkred; text-align: center;' id='student_votes_vote'><span class='font-text'>"+grades.grade+"</span></td>"+
               "</tr></tbody></table> ";
               console.log(grades);  
      
    		}
 				
        }
    };

    xmlHttp.open("GET", uriAddr);
    xmlHttp.setRequestHeader("id_student",id_student);
    xmlHttp.send(null);
}