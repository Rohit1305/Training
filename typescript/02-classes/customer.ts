class Customer{
    private firstname:string;
    private lastname:string;

    constructor(firstname:string,lastname:string){
        this.firstname=firstname;
        this.lastname=lastname;
    }  
    public setFirstName(firstname:string){
        this.firstname=firstname;
    } 
    public setLastName(lastname:string){
        this.lastname=lastname;
    } 
    public getFirstName():string{
        return this.firstname;
    }
    public getLastName():string{
        return this.lastname;
    }
}
let customer = new Customer("rohit","sabat");

console.log(customer.getFirstName());
console.log(customer.getLastName());
