"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var rectangle_1 = require("./rectangle");
var rect = new rectangle_1.rectangle(10, 20);
var shapes = [];
shapes.push(rect);
shapes.forEach(function (shape) {
    console.log(shape.calculateArea());
    console.log("======");
});
