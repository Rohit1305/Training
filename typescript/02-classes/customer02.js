var Customer02 = /** @class */ (function () {
    //using constructor properties to declare and initialize class variables
    function Customer02(_firstname, _lastname) {
        this._firstname = _firstname;
        this._lastname = _lastname;
    }
    Customer02.prototype.setFirstName = function (firstname) {
        this._firstname = firstname;
    };
    Customer02.prototype.setLastName = function (lastname) {
        this._lastname = lastname;
    };
    Customer02.prototype.getFirstName = function () {
        return this._firstname;
    };
    Customer02.prototype.getLastName = function () {
        return this._lastname;
    };
    return Customer02;
}());
var customer02 = new Customer02("rohit", "sabat");
console.log(customer02.getFirstName());
console.log(customer02.getLastName());
customer02.setFirstName("mohit");
console.log(customer02.getFirstName());
console.log(customer02.getLastName());
