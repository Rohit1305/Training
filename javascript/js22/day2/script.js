const btmref = document.querySelector("button")
const inputref = document.querySelector("input")
const ulref = document.querySelector("ul")

btmref.addEventListener(`click`,(e)=>{
    const name = inputref.value
    console.log(name);
    if(name.length!=0){
     const li= document.createElement("li")
     li.innerText=name;
     ulref.appendChild(li);
     inputref.value="";
     li.addEventListener("click", (a) => {
        ulref.removeChild(li); //dynamic element remove 
      });
    }
})

// static elemet remove

// liAllref= document.querySelectorAll("li")
// // console.log(liAllref);

// liAllref.forEach(li => {
//     li.addEventListener(`click`,e=>{
//         console.log(e.target.remove());
//     })
    
// });

ulref.addEventListener("click", (e) => {
    if(e.target.tagName!=='UL');
    e.target.remove(); 
  });

//==================================================================x

var inputBox = document.getElementById("inputBox");
var outputDiv = document.getElementById("output");

inputBox.addEventListener("input", function() {
//   var inputText = inputBox.value;
//   outputDiv.innerText = inputText;
  outputDiv.innerText=inputBox.value
});