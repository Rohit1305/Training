
export class Customer03{

    //using constructor properties to declare and initialize class variables
        constructor(private _firstname:string,private _lastname:string){
        }  
        public setFirstName(firstname:string){
            this._firstname=firstname;
        } 
        public setLastName(lastname:string){
            this._lastname=lastname;
        } 
        public getFirstName():string{
            return this._firstname;
        }
        public getLastName():string{
            return this._lastname;
        }
    }
    
    // let customer02 = new Customer02("rohit","sabat");
    
    // console.log(customer02.getFirstName());
    // console.log(customer02.getLastName());
    
    // customer02.setFirstName("mohit")
    // console.log(customer02.getFirstName());
    // console.log(customer02.getLastName());
    