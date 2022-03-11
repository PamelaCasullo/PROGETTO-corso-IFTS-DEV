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
  var sessionSt = sessionStorage.getItem("value");

function caricamento() {
	 var daCar = JSON.parse(sessionSt);
	 var id_student = daCar[0].id_student;
	console.log(daCar[0].id_student);
	console.log(daCar);
	
	var request = new XMLHttpRequest();
	var uriAddress = "/Students/search/" + id_student;
	console.log(uriAddress);
	//var p =request.open(PUT,uriAddress);
	  var xmlHttp = new XMLHttpRequest();
        xmlHttp.onreadystatechange = function() {
            if (xmlHttp.readyState == 4 && xmlHttp.status >= 200) {
			console.log(daCar[0].firstName);
                 var obJSON = JSON.parse(xmlHttp.responseText);
                 console.log(obJSON);
					  document.getElementById("user_name_lastname").innerHTML=daCar[0].firstName+ " " + daCar[0].last_name;
					 document.getElementById("date_of_birth").innerHTML=daCar[0].date_of_birth;
					 document.getElementById("personal_email").innerHTML=daCar[0].personal_email;
					 document.getElementById("institutional_email").innerHTML=daCar[0].institutional_email;
					 document.getElementById("phone_number").innerHTML=daCar[0].phone_number;				
            }
        }
	
	
	xmlHttp.open("PUT", uriAddress);
    xmlHttp.send(null);
}
