//Fetch Api

fetch("books.json").then((response)=>{ 
    return response.json(); 
}).then((data)=>{ 
    console.log(data); 
}).catch((err)=>{ 
    console.log("could not fetch data"); 
})