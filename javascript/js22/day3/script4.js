

const getData=async()=>{
    const response = await fetch("books.json");
    if (response.status !==200){
        throw new Error("could not fetch data");
    }
    const data =await response.json();
    return data;
};

console.log(getData());

getData().then((data)=>{ 
    console.log(data); 
}).catch((err)=>{ 
    console.log(err.message); 
})