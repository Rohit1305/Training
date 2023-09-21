const Contact= require("./Contact.js")
const ContactDetails= require("./ContactDetails.js")

class User {
    static allUser = [];
    static ID = 1;

    constructor(fullName, isAdmin, gender, country) {
        this.ID = User.ID++;
        this.fullName = fullName;
        this.isAdmin = isAdmin;
        this.gender = gender;
        this.country = country;
        this.contacts = []
    }

    static newAdmin(fullName, gender, country) {
   
        if(typeof fullName != "string"){    
            return "Name must be a String"      
        } 
        if(gender != "M" && gender != "F"){ 
             return "Gender must be a M or F"    
        } 
        if(typeof country != "string"){     
            return "Country Name must be a String"
        }

        return new User(fullName, true, gender, country);
    }

    newUser(fullName) {
        if (!this.isAdmin) {
            return " Unauthorized user";
        }
        if(typeof fullName != "string"){
                return "Name must be a String"      
        } 
        if(gender != "M" || gender != "F"){ 
             return "Gender must be a M or F"    
        } 
        if(typeof country != "string"){    
             return "Country Name must be a String"
        }

        let userObj = new User(fullName, false, this.gender, this.country);
        User.allUser.push(userObj);
        return userObj;
    }
    getAllUsers() {
        if (!this.isAdmin) {
            return "Unauthorized";
        }
        return User.allUser;
    }

    static findUser(userId) {
        for (let index = 0; index < User.allUser.length; index++) {
            if (userId == User.allUser[index]) {
                return [index, true];
            }
        }
        return [-1, false];
    }

    updateUsers(userId, parameter, newValue) {
        if(typeof newValue != "string"){   
            return "Invalid Value assign"  
        } 
        if(typeof userId != "number"){   
            return "Invalid ID number"  
        }
        if (!this.isAdmin) {
            return " Unauthorized user";
        }
        let [indexOfuser, isUserFind] = User.findUser(userId);
        if (!isUserFind) {
            return " User Not Found";
        }

        switch (parameter) {
            case " fullName ":
                if (typeof newValue != "string") {
                    return "Invalid full Name Format";
                }
                User.allUser[indexOfuser].fullName = newValue;
                break;
            case " gender ":
                if (typeof newValue != "string") {
                    return "Invalid gender ";
                }
                User.allUser[indexOfuser].gender = newValue;
                break;
            case " country ":
                if (typeof newValue != "string") {
                    return "Invalid country";
                }
                User.allUser[indexOfuser].country = newValue;
                break;
            default:
                return "Parameter not found";
        }
    }
    deleteUser(userId) {
        if (!this.isAdmin) {
            return " Unauthorized";
        }
        let [indexOfuser, isUserFind] = User.findUser(userId);
        if (!isUserFind) {
            return " User Not Found";
        }
        User.allUser.splice(indexOfuser, 1);
    }

    createContact(contactfullName) {
        if (typeof contactfullName != "string") {
            return " Invalid contactfullName";
        }
        let contactCreated = new Contact(contactfullName)
        this.contacts.push(contactCreated)
        return contactCreated

    }


    getContacts(userId) {
        if (!this.isAdmin) {
            return " Unauthorized";
        }
        let [indexOfuser, isUserFind] = User.findUser(userId);

        if (!isUserFind) { reu } if (!isUserFind) {
            return " User Not Found";
        }
        return this.cotacts

    }

    findContact(contactId) {
        for (let index = 0; index < this.contacts.length; index++) {
            if (contactId == this.contacts[index]) {
                return [index, true];
            }
        }
        return [-1, false];
    }

    updateContact(contactId, newValue) {
        if (!this.isAdmin) {
            return " Unauthorized";
        }
        if(typeof contactId != "number"){   
            return "Invalid ID"  
        }
        if(typeof newValue != "string"){   
            return "Invalid Value"  
        } 
        
        let [indexOfContact, isContactFind] = this.findContact(contactId);
        if (!isContactFind) {
            return " Contact Not Found";
        }
        this.contacts[indexOfContact] = newValue
        return contacts[indexOfContact]


    }

    createContactDetails(contactId, typeOfContact, valueOfContact) {
        if (!this.isAdmin) {
            return " Unauthorized";
        }
        let [indexOfContact, isContactFind] = this.findContact(contactId);
        if (!isContactFind) {
            return " Contact Not Found";
        }
        let contactDetailsCreated = new ContactDetails(typeOfContact, valueOfContact)
        this.contacts[indexOfContact].contactInfos.push(contactDetailsCreated)
        return contactDetailsCreated


    }
}

let ad = User.newAdmin("Rohit Sabat","M","India")
let user1 = ad.newUser("Joe","M","USA")

user1.createContact("akash")
//console.log(ad)
console.log(a.getAllUsers)
//console.log(user1)