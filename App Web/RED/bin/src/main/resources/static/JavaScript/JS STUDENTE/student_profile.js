
// bind the on-change event
$(document).ready(function() {
    $("#upload-file-input").on("change", uploadFile);
  });
  
  /**
   * Upload the file sending it via Ajax at the Spring Boot server.
   */
  function uploadFile() {
    $.ajax({
      url: "/uploadFile",
      type: "POST",
      data: new FormData($("#upload-file-form")[0]),
      enctype: 'multipart/form-data',
      processData: false,
      contentType: false,
      cache: false,
      success: function () {
        // Handle upload success
        // ...
      },
      error: function () {
        // Handle upload error
        // ...
      }
    });
  } // function uploadFile


function caricamento() {
	  var sessionSt = sessionStorage.getItem("value");
	 var daCar = JSON.parse(sessionSt);
 var id_student = daCar.id_student;
	console.log(daCar.id_student);
	console.log(daCar);
	
	var request = new XMLHttpRequest();
	var uriAddress = "/Students/search/" + id_student;
	console.log(uriAddress);
	//var p =request.open(PUT,uriAddress);
	  var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function() {
            if (xmlHttp.readyState == 4 && xmlHttp.status >= 200) {
                 var obJSON = JSON.parse(xmlHttp.responseText);
					 document.getElementById("user_name_lastname").innerHTML=daCar.first_name+" "+ daCar.last_name;
					 document.getElementById("date_of_birth").innerHTML=daCar.date_of_birth;
					 document.getElementById("personal_email").innerHTML=daCar.personal_email;
					 document.getElementById("institutional_email").innerHTML=daCar.institutional_email;
					 document.getElementById("phone_number").innerHTML=daCar.phone_number;				
            }
        }
	
	
	xmlHttp.open("PUT", uriAddress);
    xmlHttp.send(null);
}




function aggiorna(){
	var sessionSt = sessionStorage.getItem("value");
	var daCar = JSON.parse(sessionSt);
	var id_student = daCar.id_student;
	
	var formData = new FormData(document.forms.newForm); //uguale a var form = document.getElementById("newForm");
    formData.set("id_student",id_student);
    var jsonData = JSON.stringify(Object.fromEntries(formData));
	
	
	var request = new XMLHttpRequest();
	var uriAddress = "/Students/update";
	console.log(uriAddress);
	//var p =request.open(PUT,uriAddress);
	  var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function() {
            if (xmlHttp.readyState == 4 && xmlHttp.status >= 200) {
			console.log(daCar.firstName);
			
                alert("DONE");
              
                console.log(jsonData);
					 
            }
        }
	
	
	xmlHttp.open("PUT", uriAddress);
    xmlHttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xmlHttp.send(jsonData);
    
}

