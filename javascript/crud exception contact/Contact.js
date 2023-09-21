const ContactInfo = require("./ContactInfo");
const BaseError = require("./BaseError");
const NotFound = require("./NotFound");
const ValidationError = require("./ValidationError");

class Contact {
    static contactID = 0
    constructor(fullname, country){
        this.ID = Contact.contactID++
        this.fullname = fullname
        this.country = country
        this.contactInfo = []
    }

    updateContact (parameter, newValue){
        try {
            switch (parameter){
                case "fullname":
                    if (typeof newValue !== 'string'){
                        throw new ValidationError();
                    }
                    this.fullname = newValue;
                    return this;
                case "country":
                    if (typeof newValue !== 'string'){
                        throw new ValidationError();
                    }
                    this.country = newValue;
                    return this;
                default:
                    throw new ValidationError();
            }
        } catch (error) {
            return error;
        }
    }

    newContactInfo(infoType, infoValue){
        let infoObj = new ContactInfo(infoType, infoValue)
        this.contactInfo.push(infoObj)
        return infoObj
    }

    findContactInfo(infoID){
        for (let i=0; i < this.contactInfo.length; i++) {
            if (this.contactInfo[i].ID == infoID){
                return i;
            }
        }
        return -1;
    }

    updateContactInfo(infoID, parameter, value){
        let index = this.findContactInfo(infoID);
        if (index === -1){
            throw new NotFound();
        }
        try {
            let info = this.contactInfo[index].updateContactInfo(parameter, value);
            return info;
        } catch (error) {
            return error;
        }
    }

    deleteContactInfo(infoID){
        let index = this.findContactInfo(infoID);
        if (index === -1){
            throw new NotFound();
        }
        try {
            let info = this.contactInfo.splice(index, 1);
            return info;
        } catch (error) {
            return error;
        }
    }

    getContactInfoByID(infoID){
        let index = this.findContactInfo(infoID);
        if (index === -1){
            throw new NotFound();
        }
        return this.contactInfo[index];
    }
}

module.exports = Contact;
