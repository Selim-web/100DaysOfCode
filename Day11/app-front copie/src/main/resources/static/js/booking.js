var connexionBack = "";
import("./variable.js").then(variable => {
    connexionBack = variable.connexionBack2;
});

var usersAddforMeeting = new Array();

function openModal(idModal) {
    var modal = document.getElementById(idModal);
    modal.style.display = "block";

    if (idModal === "myModalErrorInput") var span = document.getElementById("closeModalErrorInput");
    else if (idModal === "myModalConfort") var span = document.getElementById("closeModalConfort");
    else if (idModal === "myModalDevice") var span = document.getElementById("closeModalDevice");
    else var span = document.getElementById("closeModalAddPeople");

    //ferme le modal
    span.onclick = function () {
        modal.style.display = "none";
    }

    // permet le modal si click en dehors du modal
    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
}

function closeModal(idModal) {
    var modal = document.getElementById(idModal);
    modal.style.display = "none";
}

function addButtontoData(mydata) {
    var boutonVuePlan = '';
    var boutonRadio = '';
    var boutonConfort = '';
    var boutonDevice = '';
    for (let i = 0; i < mydata.length; i++) {
        boutonVuePlan = '<span style="cursor:pointer; color :#796aee" id="Map' + mydata[i].id_room + '"><i class="fas fa-share-square"></i></span>';
        boutonRadio = '<input type="radio" class="choiceSelected" id="Radio' + mydata[i].id_room + '" name="choiceSelected" style="cursor:pointer" '
            + 'onclick="choiceBooking(' + mydata[i].id_room + ') "/>  <span style="cursor: pointer; color:#333"><i class="fas fa - map - marked - alt"></i></span>';
        boutonConfort = '<span style="padding-right:10%; text-align:right"><i class="fas fa-home" style="cursor:pointer" onclick="openConfort(' + mydata[i].id_room + ')"></i></span>';
        boutonDevice = '<span style="padding-left:10%; text-align:left"><i class="fas fa-desktop" style="cursor: pointer" onclick="openDevice(' + mydata[i].id_room + ')"></i></span>';
        mydata[i].listEquipment = "<div style='display: grid;grid-template-columns:auto auto;'>" + boutonConfort + boutonDevice + "</div>";
        mydata[i].choice = boutonRadio;
        mydata[i].map = boutonVuePlan;
    }
    return mydata;
}

function changeValueRoom(idRoom) {
    document.getElementById("roomId").value = idRoom;
    document.getElementById("dateRoomChoose").value = document.getElementById("date").value;
    document.getElementById("startTimeChoose").value = document.getElementById("startTime").value;
    document.getElementById("endTimeChoose").value = document.getElementById("endTime").value;
}

function choiceBooking(idRoom) {
    let searchDate = document.getElementById("date").value;
    let searchStartTime = document.getElementById("startTime").value;
    let searchEndTime = document.getElementById("endTime").value;

    if (!searchDate || !searchEndTime || !searchStartTime) {
        openModal('myModalErrorInput');
    } else {
        let buttonRadioBox = document.getElementsByClassName("choiceSelected");
        changeValueRoom(idRoom);

        for (let i = 0; i < buttonRadioBox.length; i++) {
            if (buttonRadioBox[i].checked == true) {
                document.getElementById("buttonValidate").style.cursor = "pointer";
                document.getElementById("buttonValidate").disabled = false;
                document.getElementById("buttonValidate").style.backgroundColor = "#796aee";
            }
        }
    }
}

function ajaxRequest(params) {
    var typeRoom = '';
    //if title room exits, type == meetingRoom
    if (document.getElementById("titleMeeting") != null) typeRoom = 'meetingRoom';
    else typeRoom = 'other';

    var url = "http://" + connexionBack + ":9000/roomDigital/selectRoomDigital?type=" + typeRoom;
    console.log(url);
    $.get(url).then(function (res) {
        res = addButtontoData(res);
        params.success(res);
    })
}

function searchRoom(typeRoom) {
    let searchDate = document.getElementById("date").value;
    let searchStartTime = document.getElementById("startTime").value;
    let searchEndTime = document.getElementById("endTime").value;

    let searchTypeRoom = '';
    if (typeRoom === 'meeting') {
        document.getElementById("titleMeetingForm").value = document.getElementById("titleMeeting").value;
        console.log("searchRoom " + document.getElementById("idBooker").value);
        //add person who book the room
        usersAddforMeeting.push(document.getElementById("idBooker").value);
        document.getElementById("listEmployeeInput").value = usersAddforMeeting;
        searchTypeRoom = "meetingRoom";
    }
    else searchTypeRoom = document.getElementById("types").value;

    searchEndTime = searchEndTime + ":00";
    searchStartTime = searchStartTime + ":00";

    //check if string is empty
    if (!searchDate || !searchEndTime || !searchStartTime) {
        openModal('myModalErrorInput');
    } else {
        document.querySelector("#table tbody").innerHTML = "";
        $.ajax('http://' + connexionBack + ':9000/roomDigital/getRoomsWithSearch?endTime=' + searchEndTime + '&startTime=' + searchStartTime + '&type=' + searchTypeRoom + '&day=' + searchDate, {
            contentType: 'application/json',
            dataType: 'json',
            success: function (mydata) {
                mydata = addButtontoData(mydata);
                $("#table").bootstrapTable("load", mydata)
            }
        })
    }
}

function addColleague(id) {
    let searchDate = document.getElementById("date").value;
    let searchStartTime = document.getElementById("startTime").value;
    let searchEndTime = document.getElementById("endTime").value;

    searchEndTime = searchEndTime + ":00";
    searchStartTime = searchStartTime + ":00";

    //check if string is empty
    if (!searchDate || !searchEndTime || !searchStartTime) {
        openModal('myModalErrorInput');
    } else {
        var bodyModal = document.querySelector("#myModalAddPeople .modal-body");
        let html = '';

        var request = new XMLHttpRequest();
        const url = 'http://' + connexionBack + ':9000/employee/employeeInCompany?id=' + id;
        request.open('GET', url);
        request.setRequestHeader('Content-Type', 'application/json');
        request.onload = function () {
            var data = JSON.parse(this.responseText);

            if (data.length > 0) {
                html = '<table id="tableModalPeople"><tbody>';
                for (let i = 0; i < data.length; i++) {
                    let td1 = '<td>' + data[i].first_name + '</td>';
                    let td2 = '<td>' + data[i].last_name + '</td>';
                    let td3 = '';

                    let styleColor = "";
                    if (data[i].status === "free") {
                        styleColor = "style='color:#16db93' ";
                    }
                    else {
                        styleColor = "style='color:#ed9775' ";
                    }

                    if (data[i].sg == true) {
                        td3 = '<td style="text-align:right"><i class="fas fa-user-tag"></i>'
                            + '<i style="margin-left:5px;cursor:pointer" class="fas fa-plus-circle" onclick="addPeopleFront(' + data[i].id + ',\'' + data[i].first_name + '\',\'' + data[i].last_name + '\')"></i></td>';
                    } else {
                        td3 = '<td style="text-align:right"><i class="fas fa-user"></i>'
                            + '<i style="margin-left:11px;cursor:pointer" class="fas fa-plus-circle" onclick="addPeopleFront(' + data[i].id + ',\'' + data[i].first_name + '\',\'' + data[i].last_name + '\')"></i></td>';
                    }

                    let tr = '<tr ' + styleColor + '>' + td1 + td2 + td3 + '</tr>';
                    html = html + tr;
                }
                html = html + '</tbody></table>';
            }
            bodyModal.innerHTML = html;
        }
        request.send();
        openModal('myModalAddPeople');
    }
}

function addPeopleFront(id, first_name, last_name, email) {
    let verif = true;

    for (let i = 0; i < usersAddforMeeting.length; i++) {
        if (id === usersAddforMeeting[i]) {
            verif = false;
        }
    }

    if (verif) {
        var div = document.getElementById("listPeopleforMeeting");
        let html = '';
        html = '<div class="' + id + first_name + '" style="display:grid; grid-template-columns: 50% 50%; height:25px"><span class="spanFirstName">' + first_name + ' ' + last_name + '</span><span>'
            + '<i onclick="removeColleague(' + id + ',\'' + first_name + '\')" class="fas fa-user-minus"></i></span></div>';

        div.innerHTML = div.innerHTML + html;
        //add id to the list of employee;
        usersAddforMeeting.push(id);
        document.getElementById("listEmployeeInput").value = usersAddforMeeting;
    }
}

function removeColleague(id, firstName) {
    var users = document.getElementsByClassName(id + firstName);
    for (let i = 0; i < users.length; i++) {
        users[i].style.display = "none";
    }

    //delete element of the array
    var index = usersAddforMeeting.indexOf(id);
    if (index > -1) {
        usersAddforMeeting.splice(index, 1);
    }
    document.getElementById("listEmployeeInput").value = usersAddforMeeting;
}

function openConfort(room_id) {
    var request = new XMLHttpRequest();
    var bodyModal = document.querySelector("#myModalConfort .modal-body");
    let html = '';
    const url = 'http://' + connexionBack + ':9000/roomDigital/roomById?room_id=' + room_id;
    request.open('GET', url);
    request.setRequestHeader('Content-Type', 'application/json');
    request.onload = function () {
        var data = JSON.parse(this.responseText);
        console.log(data);
        html = '<table id="tableModalConfort" style="width: 100%">';
        html = html + '<thead style="text-align: center"> <tr> <th></th></th><th>Etat</th> <th>Température de consigne</th> <th>Mode</th> </tr> </thead>';
        let td_etat_heating = '';
        if (data.heatingDwp.etat == true) td_etat_heating = '<td>Allumé</td>';
        else td_etat_heating = '<td>Eteint</td>';
        html = html + ' <tbody style="text-align: center">' +
            ' <tr>' +
            '<td>Chauffage</td>' +
            td_etat_heating +
            '    <td>' + data.heatingDwp.temperature + '°C</td>' +
            '   <td>' + data.heatingDwp.mode + '</td>' +
            '    </tr>' +
            '    </tbody>'
        html = html + '<thead style="text-align: center"> <tr> <th></th><th>Etat</th> <th>Intensité Electrique</th> <th>Mode</th> </tr> </thead>';
        let td_etat_light = '';
        if (data.lightDwp.etat == true) td_etat_light = '<td>Allumée</td>';
        else td_etat_light = '<td>Eteint</td>';
        html = html + ' <tbody style="text-align: center">' +
            ' <tr>' +
            '<td>Lumière</td>' +
            td_etat_light +
            '    <td>' + data.lightDwp.intensity + '%</td>' +
            '   <td>' + data.lightDwp.mode + '</td>' +
            '    </tr>' +
            '    </tbody>'
        html = html + '</table>';
        bodyModal.innerHTML = html;
    }
    request.send();
    openModal('myModalConfort');
}

function openDevice(room_id) {
    var request = new XMLHttpRequest();
    const url = 'http://localhost:9000/chauffage/chauffage?room_id=' + room_id;
    request.open('GET', url);
    request.setRequestHeader('Content-Type', 'application/json');
    request.onload = function () {
        var data = JSON.parse(this.responseText);
        console.log(data)
    }
    request.send();
    openModal('myModalDevice');
}

