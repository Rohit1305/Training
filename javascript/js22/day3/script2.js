//Promise

const getData=(url)=>{
    return new Promise ((resolve,reject)=>{
        const request = new XMLHttpRequest();

     request.addEventListener('readystatechange',e=>{
    // console.log(request,request.readyState);
    if (request.readyState==4 && request.status==200){
        // console.log(request.responseText);
        resolve(JSON.parse(request.responseText));
    }
    else if (request.readyState==4){
        // console.log("could not fetch data");
        reject("could not fetch data");
    }
});

request.open('GET',url);
request.send();
    });
};

url= "books.json"
// console.log(getData());

getData(url).then((data)=>{
    console.log(data);
    return getData(url);
}).then((data)=>{
    console.log(data);
    return getData(url);
})
.catch((err)=>{
    console.log(err);
});