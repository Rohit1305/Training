"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var customer03_1 = require("./customer03");
var customer02 = new customer03_1.Customer03("rohit", "sabat");
console.log(customer02.getFirstName());
console.log(customer02.getLastName());
customer02.setFirstName("mohit");
console.log(customer02.getFirstName());
console.log(customer02.getLastName());
