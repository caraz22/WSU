"use strict";

let submitButton = document.getElementById("submitButton");
let pwd1 = document.getElementById("pwd1");
let pwd2 = document.getElementById("pwd2");


submitButton.addEventListener("click", function() 
{
   if(pwd1.Validity.patternMismatch)
      pwd1.setCustomValidity("Your Password must be at Least 8 Characters")


      else if(pwd1.value !==pwd2.value)
      {
            pwd1.setCustomValidity("Your Password does not Match")
      }
      else{
            pwd1.setCustomValidity("")
      }
});

