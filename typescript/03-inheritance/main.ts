import { shape } from "./shape";
import { rectangle } from "./rectangle";

let rect = new rectangle(10,20,30,40);

let shapes:shape[]=[];

shapes.push(rect);

shapes.forEach(shape=>{
    console.log(shape.getInfo());
    console.log("======");
})