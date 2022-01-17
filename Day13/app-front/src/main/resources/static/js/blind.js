var height = document.getElementById("height").innerHTML;
//console.log(height);
document.getElementById("store").style.height = height+'px';

function addHeight() {
    var element = document.getElementById("store");
    //console.log(element)
    var elementStyle = element.offsetHeight;
    //console.log(elementStyle)
    var newHeight = elementStyle;
    if (newHeight < 185) {
        newHeight = newHeight + 5;
        element.style.setProperty('height', newHeight + 'px');
        document.getElementById("newHeight").value = newHeight;
    }
    else
        alert("Le store est fermé au maximum");
}

function removeHeight() {
    var element = document.getElementById("store");
    //console.log(element)
    var elementStyle = element.offsetHeight;
    //console.log(elementStyle)
    var newHeight = elementStyle;
    if (newHeight > 25) {
        newHeight = newHeight - 5;
        element.style.setProperty('height', newHeight + 'px');
       // console.log(newHeight);
        //console.log(document.getElementById("newHeight").innerHTML = newHeight);
    }
    else
        alert("Le store est ouvert au maximum");


}