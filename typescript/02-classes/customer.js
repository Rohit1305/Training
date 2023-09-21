var Customer = /** @class */ (function () {
    function Customer(firstname, lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
    Customer.prototype.setFirstName = function (firstname) {
        this.firstname = firstname;
    };
    Customer.prototype.setLastName = function (lastname) {
        this.lastname = lastname;
    };
    Customer.prototype.getFirstName = function () {
        return this.firstname;
    };
    Customer.prototype.getLastName = function () {
        return this.lastname;
    };
    return Customer;
}());
var customer = new Customer("rohit", "sabat");
console.log(customer.getFirstName());
console.log(customer.getLastName());
