document.getElementById("UserName").addEventListener("blur", function () {
    checkUserName()
}, false)

document.getElementById("Pw").addEventListener("blur", function () {
    checkPw()
}, false)

document.getElementById("RepeatPw").addEventListener("blur", function () {
    checkRePw()
}, false)

document.getElementById("Email").addEventListener("blur", function () {
    checkEmail()
}, false)

var un = false
var pw = false
var repw = false
var email = false

function checkUserName() {
    var str = document.getElementById("UserName").value
    if (str == "") {
        document.getElementById("Error").innerText = "Please input the username!"
        un = false
    } else {
        document.getElementById("Error").innerText = ""
        un = true
    }
    check()
}

function checkPw() {
    var str = document.getElementById("Pw").value


    if (str == "") {
        if (document.getElementById("Error").innerText == "")
            document.getElementById("Error").innerText = "Please input the password!"
        pw = false
    } else {
        document.getElementById("Error").innerText = ""
        pw = true
    }
    check()
}

function checkRePw() {
    var str1 = document.getElementById("RepeatPw").value
    var str2 = document.getElementById("Pw").value

    if (str2 == "") {
        if (document.getElementById("Error").innerText == "")
            document.getElementById("Error").innerText = "Please input the password!"
        pw = false
    } else if (str1 != str2) {
        if (document.getElementById("Error").innerText == "")
            document.getElementById("Error").innerText = "Entered passwords differ!"
        repw = false
    } else {
        document.getElementById("Error").innerText = ""
        repw = true
    }
    check()
}

function checkEmail() {
    var str = document.getElementById("Email").value
    var i = str.indexOf("@")
    if (i == -1) {
        if (document.getElementById("Error").innerText == "")
            document.getElementById("Error").innerText = "Please input the current Email!"
        email = false
    } else if (str == "") {
        if (document.getElementById("Error").innerText == "")
            document.getElementById("Error").innerText = "Please input the Email!"
        email = false
    } else {
        document.getElementById("Error").innerText = ""
        email = true
    }
    check()
}

function check() {
    if (un && pw && repw && email) {
        document.getElementById("SubNew").style.visibility = "visible"
    } else {
        document.getElementById("SubNew").style.visibility = "hidden"
    }
}