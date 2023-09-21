const BaseError = require("./BaseError");
const ValidationError = require("./ValidationError");

class ContactInfo {
    static infoID = 0
    constructor(infoType, infoValue){
        this.ID = ContactInfo.infoID++
        this.infoType = infoType
        this.infoValue = infoValue
    }

    updateContactInfo(parameter, newValue){
        try {
            switch (parameter){
                case "infoType":
                    if (typeof newValue !== 'string'){
                        throw new ValidationError();
                    }
                    this.infoType = newValue;
                    return this;
                case "infoValue":
                    if (typeof newValue !== 'string'){
                        throw new ValidationError();
                    }
                    this.infoValue = newValue;
                    return this;
                default:
                    throw new ValidationError();
            }
        } catch (error) {
            return error;
        }
    }
}

module.exports = ContactInfo;
