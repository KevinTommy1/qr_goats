
 

// Zorgt dat de onclick functies later inladen om errors te voorkomen
     window.onload = function(){  
         document.getElementById('wachtwoord').value = '';  
         document.getElementById('NieuwWachtwoord1').value = '';
         document.getElementById('NieuwWachtwoord2').value = '';    
 
         // Je wachtwoord veranderen    
         document.getElementById("wijzig-Button").onclick = function() {
             document.getElementById('wachtwoord').focus();
             addBody();
         };
         // Wachtwoord veranderen annuleren
         document.getElementById("annuleerButton").onclick = function() {
             const delayRemove = setTimeout(removeBody, 100);
             document.getElementById('wachtwoord').value = '';
             document.getElementById('NieuwWachtwoord1').value = '';
             document.getElementById('NieuwWachtwoord2').value = '';
         };
     }
 
  
 
     // Voegt de inputs toe om wachtwoord te kunnen wijzigen
     function addBody() {
         let buttons = document.querySelectorAll(".editButton")
         for (let i = 0; i < buttons.length; i++) {
             buttons[i].style.display = "block";
         }   
         let inputs = document.querySelectorAll(".inputText")
         for (let i = 0; i < inputs.length; i++) {
             inputs[i].style.display = "none";
         }
         document.getElementById("wachtwoord").style.display = "block";
         document.getElementById("NieuwWachtwoord1").style.display = "block";
         document.getElementById("NieuwWachtwoord2").style.display = "block";
         document.getElementById("wijzig-Button").style.display = "none";
 		 document.getElementById("logout-Button").style.display = "none";
         // Labels
         let profielLabel = document.querySelectorAll(".profielLabel")
         for (let i = 0; i < profielLabel.length; i++) {
             profielLabel[i].style.display = "none";
         }
         let wachtwoordWijzigLabel = document.querySelectorAll(".wachtwoordWijzigLabel")
         for (let i = 0; i < wachtwoordWijzigLabel.length; i++) {
             wachtwoordWijzigLabel[i].style.display = "block";
         }
 
     }
 
  
 
     // Verwijderd de inputs toe om wachtwoord te kunnen wijzigen
     function removeBody() {
         document.getElementById('wachtwoord').value = '';
 
  
 
         let buttons = document.querySelectorAll(".editButton")
         for (let i = 0; i < buttons.length; i++) {
             buttons[i].style.display = "none";
         }
 
         document.getElementById('wachtwoord').placeholder = "Wachtwoord";
 
         let inputs = document.querySelectorAll(".inputText")
         for (let i = 0; i < inputs.length; i++) {
             inputs[i].style.display = "block";
         }
         document.getElementById("NieuwWachtwoord1").style.display = "none";
         document.getElementById("NieuwWachtwoord2").style.display = "none";
         document.getElementById("wachtwoord").style.display = "none";
         document.getElementById("wijzig-Button").style.display = "block";
		 document.getElementById("logout-Button").style.display = "block";
 
         // Labels
         let profielLabel = document.querySelectorAll(".profielLabel")
         for (let i = 0; i < profielLabel.length; i++) {
             profielLabel[i].style.display = "block";
         }
         let wachtwoordWijzigLabel = document.querySelectorAll(".wachtwoordWijzigLabel")
         for (let i = 0; i < wachtwoordWijzigLabel.length; i++) {
             wachtwoordWijzigLabel[i].style.display = "none";
         }
     }
 
     // Leegt de inputs
     function clearNieuwWachtwoord() {
         var element = document.getElementById('NieuwWachtwoord1').element.reset();
         var element = document.getElementById('NieuwWachtwoord2').element.reset();
     }
 