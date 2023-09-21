import { Customer03 } from "./customer03";

let customer02 = new Customer03("rohit","sabat");

console.log(customer02.getFirstName());
console.log(customer02.getLastName());

customer02.setFirstName("mohit")
console.log(customer02.getFirstName());
console.log(customer02.getLastName());