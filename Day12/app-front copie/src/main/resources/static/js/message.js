var nbrMessage = 0;
var startRequestAjax = 0;

var connexionBack = "";
import("./variable.js").then(variable => {
    connexionBack = variable.connexionBack2;
});

// variable for requestAjaxMessage()
var idSender = 0;
var idReceiver = 0;
var idCompany = 0;

function displayMessagerie() {
    var cadre = document.getElementById("cadre");
    var divCollapse = document.getElementById("divCollapse");
    if (divCollapse.classList.contains("divCollapse")) {
        cadre.classList.remove("cadreCollapse");
        divCollapse.classList.remove("divCollapse");
    } else {
        cadre.classList.add("cadreCollapse");
        divCollapse.classList.add("divCollapse");
    }

}
function displayMessage(id_sender, id_receiver) {
    var request = new XMLHttpRequest();
    const url = 'http://' + connexionBack + ':9000/favoris/verifyTwoPeopleFavoris?id_sender=' + id_sender + '&id_receiver=' + id_receiver;
    request.onreadystatechange = () => {
        if (request.readyState == 4) {
            if (request.status == 200) {
                let check = JSON.parse(request.responseText);
                console.log(check + "favoris!!!!!!!!!!!!!!!!!!!!!");

                var el = document.querySelector("#divBas .divIcone .fa-star");
                var textTooltip = document.querySelector("#divBas .divIcone .tooltiptext");
                if (check) {
                    el.classList.remove("far");
                    el.classList.add("fas");
                    el.style.color = "#ffd43b";
                    textTooltip.innerHTML = "Supprimer des favoris";
                } else {
                    el.style.color = "#ffffff";
                    el.classList.add("far");
                    el.classList.remove("fas");
                    textTooltip.innerHTML = "Ajouter aux favoris";
                }
            }
        }
    }
    request.open('GET', url, true);
    request.send();

    document.getElementById("divContact").style.display = "none";
    document.getElementById("divSearchContact").style.display = "none";
    document.getElementById("messageContact").style.display = "block";
    document.getElementById("divBas").style.display = "grid";
    document.getElementById("rechercheContact").style.display = "none";
    idSender = id_sender;
    idReceiver = id_receiver;
    requestAjaxMessage();
    startRequestAjax = setInterval(function () { requestAjaxMessage(); }, 10000);
}

function requestAjaxMessage() {
    var request = new XMLHttpRequest();
    const url = 'http://' + connexionBack + ':9000/messages/getMessages?id_sender=' + idSender + '&id_receiver=' + idReceiver;
    request.open('GET', url);
    request.setRequestHeader('Content-Type', 'application/json');
    request.onload = function () {
        var data = JSON.parse(this.responseText);

        //on compte le nombre de msg, si > on actualise la div
        if (nbrMessage < data.length) {
            emptyDivMessage(idSender, idReceiver);
            for (var i = 0; i < data.length; i++) {
                let divMessage = document.createElement('div');
                let spanMessageTime = document.createElement('span');
                spanMessageTime.classList.add("spanDateMessage");
                let spanMsg = document.createElement('span');
                if (data[i].idSender == idSender) {
                    divMessage.classList.add("sendedMessage");
                } else {
                    divMessage.classList.add("receivedMessage");
                }
                let br = document.createElement('br');
                spanMessageTime.innerText = data[i].dateSend + "," + data[i].timeSend;
                spanMsg.innerText = data[i].msg;
                divMessage.appendChild(spanMessageTime);
                divMessage.appendChild(br);
                divMessage.appendChild(spanMsg);
                document.getElementById("listMessage").appendChild(divMessage);
            }
            //mettre en bas de la liste message
            document.getElementById("messageContact").scrollTop = document.getElementById("messageContact").scrollHeight;
        }
        nbrMessage = data.length;
    }
    request.send();
}

function displayContact() {
    document.getElementById("divContact").style.display = "block";
    document.getElementById("messageContact").style.display = "none";
    document.getElementById("divBas").style.display = "none";
    document.getElementById("rechercheContact").style.display = "grid";

    //on remet le nombre egal a 0
    nbrMessage = 0;
    emptyDivMessage();
    clearInterval(startRequestAjax);
}

function emptyDivMessage() {
    //vide la div à chaque requete
    document.getElementById("listMessage").innerHTML = '';
}
function sendMessage() {
    var msg = document.getElementById("message").value;
    if (msg.trim().length > 0) {
        document.getElementById("message").value = "";
        //recupere le div pour ajouter
        var size = document.getElementsByClassName("sendedMessage").length;

        var newDiv = document.createElement('div');
        newDiv.classList.add("sendedMessage");
        var newElementSpan = document.createElement("span");
        newElementSpan.innerText = msg;

        var theDate = new Date();
        var dateMessage = convertDateJSON(theDate);
        var timeMessage = convertTimeJSON(theDate);

        var spanElement = document.createElement('span');
        spanElement.classList.add("spanDateMessage");
        spanElement.innerText = dateMessage + ", " + timeMessage;
        var brElement = document.createElement('br');
        newDiv.appendChild(spanElement);
        newDiv.appendChild(brElement);
        newDiv.appendChild(newElementSpan);
        document.getElementById("listMessage").appendChild(newDiv);

        document.getElementById("messageContact").scrollTop = document.getElementById("messageContact").scrollHeight;

        //request create message
        var request = new XMLHttpRequest();
        const url = 'http://' + connexionBack + ':9000/messages/createMessage';
        request.open('POST', url);
        request.setRequestHeader('Content-Type', 'application/json');

        var message = new Object();
        message.idMessage = 0;
        message.idSender = idSender;
        message.idReceiver = idReceiver;
        message.msg = msg;
        message.dateSend = dateMessage;
        message.timeSend = timeMessage;
        var data = JSON.stringify(message);

        request.send(data);
    }
}
function activeSend() {
    document.getElementById("message").nextElementSibling.children[1].style.cursor = "pointer";
}
document.getElementById("message").addEventListener("keypress", function (event) {
    var msg = document.getElementById("message").value;
    if (msg.trim().length > 0) {
        if (event.charCode == 13) {
            sendMessage();
        }
    }
});

function displayContactAfterSearchContact() {
    document.getElementById("divContact").style.display = "none";
    document.getElementById("divSearchContact").style.display = "flex";
}

function displayContactAfterSearchContactReturn() {
    document.getElementById("divContact").style.display = "block";
    document.getElementById("divSearchContact").style.display = "none";
}



function rechercheContact(id_sender, idCompany) {
    var contact = document.getElementById("inputRechercheContact").value;

    var request = new XMLHttpRequest();
    const url = 'http://' + connexionBack + ':9000/users/getSearchContact?value=' + contact + '&id_company=' + idCompany;
    request.open('GET', url);
    request.setRequestHeader('Content-Type', 'application/json');
    request.onload = function () {
        var dataReceived = JSON.parse(this.responseText);
        console.log(dataReceived);

        // vide la div
        document.getElementById("divSearchContact").innerHTML = "";
        if (dataReceived.length > 0) {
            var html = ' <div style="z-index:2;position:absolute;width:250px;background-color: white;cursor:pointer" onclick="displayContactAfterSearchContactReturn()">'
                + ' <i class="fas fa-angle-double-left"></i></div> ';
            html = html + tableContactWithData(id_sender, dataReceived);
        } else {
            var html = "<p style='font-style:italic'>Pas de correspondance trouvée, veuillez réessayer votre recherche</p>";
        }
        displayContactAfterSearchContact();
        document.getElementById("divSearchContact").innerHTML = html;
        document.getElementById("inputRechercheContact").value = "";
    }
    request.send();
}

function convertTimeJSON(theDate) {
    if (theDate.getSeconds() < 10) var seconds = "0" + theDate.getSeconds();
    else seconds = theDate.getSeconds();

    if (theDate.getMinutes() < 10) var minutes = "0" + theDate.getMinutes();
    else minutes = theDate.getMinutes();

    if (theDate.getHours() < 10) var hours = "0" + theDate.getHours();
    else hours = theDate.getHours();

    return hours + ":" + minutes + ":" + seconds;
}

function convertDateJSON(theDate) {
    if (theDate.getFullYear() < 10) var years = "0" + theDate.getFullYear();
    else years = theDate.getFullYear();

    if (theDate.getMonth() < 10) var month = "0" + (theDate.getMonth() + 1);
    else month = (theDate.getMonth() + 1);

    if (theDate.getDate() < 10) var day = "0" + theDate.getDate();
    else day = theDate.getDate();

    return years + "-" + month + "-" + day;
}

function addFavoris() {
    console.log("laala");
    console.log(idReceiver + " idReceiver");
    console.log(idSender + " idSender");
    var star = document.querySelector(".divIcone .tooltip .fa-star");
    var request = new XMLHttpRequest();
    var url = '';
    //add favoris
    if (star.classList.contains("far")) {
        star.classList.remove("far");
        star.classList.add("fas");
        star.style.color = "#ffd43b";


        url = 'http://' + connexionBack + ':9000/favoris/favorisInsert';
    } else {
        //delete favoris
        star.classList.add("far");
        star.classList.remove("fas");
        star.style.color = "#ffffff";

        url = 'http://' + connexionBack + ':9000/favoris/dropFavoris';
    }

    request.open('POST', url);
    request.setRequestHeader('Content-Type', 'application/json');
    request.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            // Response
            var response = this.responseText;
            console.log(response);
        }
    };
    var data = {
        idPerson1: idSender,
        idPerson2: idReceiver
    };
    request.send(JSON.stringify(data));
}

function displayFavoris(id, idCompany, text) {
    console.log(text + "clique bouton" + idCompany);
    var div = document.getElementById("cacheForFavoris");
    div.innerHTML = '';//vide la div
    var request = new XMLHttpRequest();
    var url = '';
    if (text === "favoris") {
        url = 'http://' + connexionBack + ':9000/favoris/selectFavoris?id_sender=' + id;
    } else if (text === "employee") {
        url = 'http://' + connexionBack + ':9000/messages/getContacts?id_sender=' + id + "&id_company=" + idCompany;
    }
    console.log(url);
    request.onreadystatechange = () => {
        if (request.readyState == 4) {
            if (request.status == 200) {
                let conversations = JSON.parse(request.responseText);
                console.log(conversations);
                div.innerHTML = tableContactWithData(id, conversations);
            }
        }
    }
    request.open('GET', url, true);
    request.send();
}

function tableContactWithData(id_sender, dataReceived) {
    let img = "";
    let span = "";
    var html = '';
    html = html + "<table id='tableContact' style='width:100%;margin-top:15px;'><tbody>";
    for (var i = 0; i < dataReceived.length; i++) {
        console.log(dataReceived[i]);
        if (dataReceived[i].id != id_sender) {
            if (dataReceived[i].id <= 300 && dataReceived[i].id >= 0) img = '<img src="/images/homme1.png" />';
            else if (dataReceived[i].id > 300 && dataReceived[i].id <= 600) img = '<img src="/images/homme2.png" />';
            else if (dataReceived[i].id > 600 && dataReceived[i].id <= 900) img = '<img src="/images/femme1.png" />';
            else img = '<img src="/images/femme2.png" />';

            if (dataReceived[i].status == 'occupy') span = "<span class='spanStatus' style='color:red;'><i class='fas fa-circle' style='font-size:0.75rem'></i></span>";
            else span = '<span class="spanStatus" style="color:green;"><i class="fas fa-circle"style="font-size:0.75rem"></i></span>';

            html += "<tr onclick=displayMessage(" + id_sender + "," + dataReceived[i].id + ")>" +
                "<td class='divSpanStatus'>" + img + span + "</td>" +
                "<td><span style='color:#212529'>" + dataReceived[i].firstname + " " +
                "<span style='color:#212529'>" + dataReceived[i].lastname + "</span> </td>" +
                "<td><i class='fas fa-angle-right'></i></td></tr>";
        }
    }
    html += "</tbody></table>";
    return html;
}
