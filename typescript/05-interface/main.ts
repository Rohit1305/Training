import { shape } from "./shape";
import { rectangle } from "./rectangle";

let rect = new rectangle(10,20);

let shapes:shape[]=[];

shapes.push(rect);

shapes.forEach(shape=>{
    console.log(shape.calculateArea());
    
    console.log("======");
})