
function loadPageWithGetData(restUrl, templateUrl) {
    fetch(restUrl) // Hent data
        .then(function(res){
            console.log(res);
            if (res.status ===200) //forespørgslen gik godt
            {
                res.json() // Konverter body til json
                    .then(function (json) {
                        console.log(json);
                        fetch(templateUrl).then(function (templateresp) { //Hent mustache template
                            templateresp.text().then(function (template) {
                                var html = Mustache.render(template, json); //Render siden hos klienten
                                console.log(html);
                                document.getElementById("maincontainer").innerHTML = html; //Indsæt siden
                            });
                        });
                    });
            } else { // noget gik galt!
                res.json()  //Konverter body til json
                    .then(function(json){ //tag fat i beskeden
                        alert(json.msg); //vis fejlen
                    });
            }
        });
}

function loadPageWithPostData(restUrl, templateUrl, json){
    console.log(json);
    fetch(restUrl, {
            method:'post',
            body:JSON.stringify(json),
            headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'}
        })
        .then(function(res){
            console.log(res);
            if (res.status ===200)
            {
                res.json()
                    .then(function (json) {
                        console.log(json);
                        fetch(templateUrl).then(function (templateresp) {
                            templateresp.text().then(function (template) {
                                var html = Mustache.render(template, json);
                                console.log(html);
                                document.getElementById("maincontainer").innerHTML = html;
                            });
                        });
                    });
            } else {
                res.json()
                    .then(function(json){
                        alert(json.msg);
                    });
            }
        });
}

function loadPageWithDeleteData(restUrl, templateUrl){
    fetch(restUrl, {method:'delete'})
        .then(function(res){
            console.log(res);
            if (res.status ===200)
            {
                res.json()
                    .then(function (json) {
                        console.log(json);
                        fetch(templateUrl).then(function (templateresp) {
                            templateresp.text().then(function (template) {
                                var html = Mustache.render(template, json);
                                console.log(html);
                                document.getElementById("maincontainer").innerHTML = html;
                            });
                        });
                    });
            } else {
                res.json()
                    .then(function(msg){
                        alert(msg);
                    });
            }
        });
}