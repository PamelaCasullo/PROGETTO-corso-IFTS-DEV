
var sessionSt = sessionStorage.getItem("value");

function onPageLoaded() {
	 var daCar = JSON.parse(sessionSt);
	 var id_student = daCar.id_student;
	console.log(sessionSt);
    var uriAddr = "/Students/show/ElencoPresenze";

    var xmlHttp = new XMLHttpRequest();

    xmlHttp.onreadystatechange = function() {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {

            var jsonObj = JSON.parse(xmlHttp.responseText);
			//var student;
            for (var idx = 0; idx < jsonObj.length;idx++) {
               var student = jsonObj[idx];
				
                console.log(student);
 				console.log(idx);
 				if(student.presence==true) {
                    var risultato='PRESENTE';
                    document.getElementById("daRiempire_Presenze").innerHTML += 
                    "<tr>"+
                    "<th scope='row'><span class='font-text' id='student_presence_date'>"+student.date+"</span></th>"+
                    "<td><span class='font-text' id='student_presence_module'>"+student.title+"</span></td>"+
                    "<td><span class='font-text' id='student_presence_module'>Qua ci va il docente</span></td>" +
                    "<td style='background-color: darkgreen;' id='style_td_presence'><span class='titles-shadow-black font-text' id='student_presence'>"+risultato+"</span>"+
                    "</td></tr>";
				} 
                if(student.presence==false) {
                    risultato = 'ASSENTE'
                    document.getElementById("daRiempire_Presenze").innerHTML += 
                    "<tr>"+
                    "<th scope='row'><span class='font-text' id='student_presence_date'>"+student.date+"</span></th>"+
                    "<td><span class='font-text' id='student_presence_module'>"+student.title+"</span></td>"+
                    "<td><span class='font-text' id='student_presence_module'>Qua ci va il docente</span></td>" +
                    "<td style='background-color: darkred;' id='style_td_presence'><span class='titles-shadow-black font-text' id='student_presence'>"+risultato+"</span>"+
                    "</td></tr>";
                }
          
          
			}
        }
    };

    xmlHttp.open("GET", uriAddr);
     xmlHttp.setRequestHeader("id_student",id_student);
    xmlHttp.send(null);

	studentVar();
}

function studentVar(){
	var daCar = JSON.parse(sessionSt);
	 var id_student = daCar.id_student;
	console.log(sessionSt);
	
	var request = new XMLHttpRequest();
	var uriAddress = "/Students/search/" + id_student;
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
}


