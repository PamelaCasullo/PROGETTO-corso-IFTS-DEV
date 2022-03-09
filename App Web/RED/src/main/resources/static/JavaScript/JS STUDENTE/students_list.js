function onPageLoaded(){
    var uriAddr = "/Students/showAll";


    var xmlHttp = new XMLHttpRequest();
   
    xmlHttp.onreadystatechange = function(){
        if(xmlHttp.readyState == 4 && xmlHttp.status == 200)
        {            
            //codice di gestione del ritorno dal servizio web
            console.log(xmlHttp.responseText);
            //document.getElementById("tblPlayer").innerText = xmlHttp.responseText;
            var jsonObj = JSON.parse(xmlHttp.responseText);
            //console.log(playerObj[0]);
            for(var idx=0; idx<jsonObj.length; idx++)
            {
                var student = jsonObj[idx];
                document.getElementById("sos").innerHTML += 
                `<tr>` +
                `<td>` + student.institutional_email +`</td>`+ 
                `<td>` + student.phone_number +`</td>`+  
                '<td><img src="' + student.photo + '"><td>' +           
                `</tr>`;
            }
           
        }
    };

    xmlHttp.open("GET", uriAddr);
    xmlHttp.send(null);


}

