"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Customer03 = void 0;
var Customer03 = /** @class */ (function () {
    //using constructor properties to declare and initialize class variables
    function Customer03(_firstname, _lastname) {
        this._firstname = _firstname;
        this._lastname = _lastname;
    }
    Customer03.prototype.setFirstName = function (firstname) {
        this._firstname = firstname;
    };
    Customer03.prototype.setLastName = function (lastname) {
        this._lastname = lastname;
    };
    Customer03.prototype.getFirstName = function () {
        return this._firstname;
    };
    Customer03.prototype.getLastName = function () {
        return this._lastname;
    };
    return Customer03;
}());
exports.Customer03 = Customer03;
// let customer02 = new Customer02("rohit","sabat");
// console.log(customer02.getFirstName());
// console.log(customer02.getLastName());
// customer02.setFirstName("mohit")
// console.log(customer02.getFirstName());
// console.log(customer02.getLastName());
