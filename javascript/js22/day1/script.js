// const myFunc=(callbackFunc)=>{
//     console.log("Hello World")
//     let num=10
//     callbackFunc(num)
// };

// myFunc(function(value){
//     console.log(value)
// });
//=======================================================
// let players=['Virat','Sachin','Dhoni']

// const printPlayer=(player)=>{
//     console.log(player);
// }

// const ul=document.querySelector("ul")
// console.log(ul);

// let html=``;

// players.forEach((player,index)=>{
//     // console.log(player,index)
//     html+=`<li>${player}</li>`
// });

// ul.innerHTML=html
// console.log(html);

//========================================================
// var student = {
//     id: "1",
//     name: "Rohit",
//     percentage: 85,
//     hobbies:["cricket","football"],
//     login :function(){
//         console.log("logged in ");
//     },
//     logout:function(){
//         console.log('logged out');
//     },
//     printHobbies:function(){
//         console.log(this.hobbies)
//     },
//     printallDetails:function(){
//         console.log(this)
//     },
    
//   };
  
//   console.log(student);
// student.printHobbies();
// student.printallDetails();


const people = [ 
    { name: "Rohit", age: 28, percent: "85" }, 
    { name: "Akash", age: 32, percent: "80" }, 
    { name: "Siddhi", age: 45, percent: "75" } 
];  
const tableBody = document.getElementById("tableBody"); 
for (const person of people) { 
    const row = document.createElement("tr"); 
    row.innerHTML = `<td>${person.name}</td><td>${person.age}</td><td>${person.percent}</td>`; 
    tableBody.appendChild(row); 
}

const h1=document.querySelector("h1");
h1.innerText+="modified"
console.log(h1);
const h1new=document.querySelector("#header");
h1new.innerText+="updated";
const testRef=document.querySelectorAll(".test");
testRef.forEach((p)=>{    p.innerText+="more text";
})
