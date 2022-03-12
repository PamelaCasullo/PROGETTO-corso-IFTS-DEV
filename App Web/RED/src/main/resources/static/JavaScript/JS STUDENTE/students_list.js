function onPageLoaded() {
    var uriAddr = "/Students/showAll";


    var xmlHttp = new XMLHttpRequest();

    xmlHttp.onreadystatechange = function() {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            //codice di gestione del ritorno dal servizio web
           // console.log(xmlHttp.responseText);

            var jsonObj = JSON.parse(xmlHttp.responseText);
			//var student;
            for (var idx = 0; idx < jsonObj.length;idx++) {
               var student = jsonObj[idx];
				
                console.log(student);
 				console.log(idx);
                document.getElementById("daRiempire").innerHTML += 
                    "<div class='col-lg-3 mb-4'>" + 
                    "<div class='card' style='background-color: darkred; box-shadow: 0px 3px 10px black; border-radius: 5px;'>" +
                    "<div class='card-body'>" +   
                    "<img src='https://www.timeoutdubai.com/cloud/timeoutdubai/2021/09/11/hfpqyV7B-IMG-Dubai-UAE.jpg' class='rounded-circle' height='55px' width='55px' style='border: 2px solid black'>" +
                    "<span class='card-title titles-shadow-black font-text' style='background-color: darkred; margin-left: 15px' id='student_name'>"+student.first_name + " " + student.last_name+"</span>" +
                    "<ul class = 'list-group list-group-flush'style = 'margin-top: 10px;' > " +
                    "<li class = 'list-group-item' style = 'background-color: darkred; border-radius: 5px; box-shadow: 0px 3px 2px black;'> <span class = 'badge bg-dark'>E - MAIL</span> " +
                    "<a style = 'margin-left: 5px;' class = 'mailto-text' id = 'students_list_instistutional_mail'> "+student.institutional_email+" </a></li >" +
                    "<li class = 'list-group-item' style = 'background-color: darkred; border-radius: 5px; box-shadow: 0px 3px 2px black; margin-top: 5px;'>" +
                    "<span class = 'badge bg-dark'> NR. </span><span style='margin-left: 5px; color: white;' id='students_list_number'>"+student.phone_number+"</span > </li></ul >";

            }

        }
    };

    xmlHttp.open("GET", uriAddr);
    xmlHttp.send(null);


}