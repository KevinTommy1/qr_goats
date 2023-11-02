console.log(inchecktijd)
if (window.location.pathname != "/qr_goats/logincheck") {
    if (inchecktijd) {
        document.getElementById("telaat").style.display = "none"
    } else {
        document.getElementById("telaat").style.display = "block"
    }
} else {
    window.location.pathname = "/qr_goats/qrcode"
}

document.getElementById("sluiten").onclick = function() {
    document.getElementById("telaat").style.display = "none"
}