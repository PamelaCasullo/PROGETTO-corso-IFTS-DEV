function onPageLoaded() {
    var uriAddr = "/Students/show/ElencoLezioni";


    var xmlHttp = new XMLHttpRequest();

    xmlHttp.onreadystatechange = function() {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            //codice di gestione del ritorno dal servizio web
            console.log(xmlHttp.responseText);
			console.log(uriAddr);
            var jsonObj = JSON.parse(xmlHttp.responseText);
			//var student;
           		
    			var student = jsonObj[0];
                console.log(student);
 				
        }
    };

    xmlHttp.open("GET", uriAddr);
    xmlHttp.send(jsonObj[0].student.id_student);


}