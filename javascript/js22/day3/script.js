const getTodos =(url,callback)=>{
const request = new XMLHttpRequest();

request.addEventListener('readystatechange',e=>{
    // console.log(request,request.readyState);
    if (request.readyState==4 && request.status==200){
        // console.log(request.responseText);
        callback(undefined,JSON.parse(request.responseText));
    }
    else if (request.readyState==4){
        // console.log("could not fetch data");
        callback("could not fetch data",undefined);
    }
});

request.open('GET',url);
request.send();

};
url ="https://jsonplaceholder.typicode.com/todos"
url1= "books.json"
getTodos(url,(err,data)=>{
    if(!err){
        console.log(data);
        getTodos(url,(err,data)=>{
            if(!err){
                console.log(data);
                getTodos(url1,(err,data)=>{
                    if(!err){
                        console.log(data);
                    }else{
                        console.log(err);
                    }
                })
            }else{
                console.log(err);
            }
        })
    }else{
        console.log(err);
    }
})
//================================================================
// 100-199- informational status code 
// 200-299- success
// 300-399- redirectional 
// 400-499- client error status code
// 500-599- server error code
