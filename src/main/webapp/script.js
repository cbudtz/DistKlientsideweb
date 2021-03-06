
function loadStartside() {
    // det følgende svarer til loadPageWithGetData("rest/time","startside.mustache"); men er inlinet her for overskueligheds skyld
    fetch("rest/servertid").then(function(servertidBlob){ // Hent servertiden
        console.log("Her kommer svar på rest/servertid");
        console.log(servertidBlob);
        servertidBlob.json().then(function(servertidJson) { // Konverter body til json
            console.log(servertidJson);
            //Hent mustache template
            fetch("startside.mustache").then(function (startsideBlob) {
                startsideBlob.text().then(function (startside) {
                    var html = Mustache.render(startside, servertidJson); //Render siden hos klienten
                    console.log("Her er rest-svaret flettet ind i skabelonen startside.mustache");
                    console.log(html);
                    document.getElementById("maincontainer").innerHTML = html; //Indsæt siden
                });
            });
        });
    });
}

function doLogin(){
    var username = document.getElementById("brugernavn").value;
    var password = document.getElementById("password").value;
    var loginData = {"brugernavn":username,"password":password};
    loadPageWithPostData("rest/login","loginsuccess.mustache", loginData)
}


// Henter noter som et JSON array og viser det
function loadNotes(){
    loadPageWithGetData("rest/noter","noter.mustache");

}

function postNote(){
    var note = document.getElementById("note").value;
    loadPageWithPostData("rest/noter","noter.mustache", {tekst:note})
}


function deleteNote(id){
    loadPageWithDeleteData("rest/noter/" + id, "noter.mustache");
}

function hentAdresser(){
    var query = document.getElementById("adresse").value; //Hent input feltets værdi
    fetch("https://dawa.aws.dk/autocomplete?q=" + query + "&type=adresse&fuzzy=") //hent data fra dawa
        .then(function(res){ //behandl resultatet
            res.json() //konverter til json
                .then(function(json){
                    fetch("adresser.mustache").then(function(templateresp){ //hent template
                        templateresp.text().then(function(template){ //konverter template-svar til tekst
                            var html = Mustache.render(template, json); //render template og data
                            console.log(html)
                            document.getElementById("adressecontainer").innerHTML = html; //indsæt resultat i DOM-containeren
                        })
                    })
                })
        })
}