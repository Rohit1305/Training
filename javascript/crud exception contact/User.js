const Contact = require("./Contact");
const ContactInfo = require("./ContactInfo");
const BaseError = require("./BaseError");
const NotFound = require("./NotFound");
const UnauthorizedError = require("./UnauthorizedError");
const ValidationError = require("./ValidationError");

class User {
    static allUsers = [];
    static userID = 0;

    constructor(fullname, isAdmin, gender, country) {
        this.ID = User.userID++;
        this.fullname = fullname;
        this.gender = gender;
        this.isAdmin = isAdmin;
        this.country = country;
        this.contacts = [];
    }

    static newAdmin(fullname, gender, country) {
        try {
            if (typeof (fullname) !== 'string') {
                throw new ValidationError();
            }
            if (gender !== 'M' && gender !== 'F' && gender.toUpperCase() !== 'MALE' && gender.toUpperCase() !== 'FEMALE') {
                throw new ValidationError();
            }
            if (typeof (country) !== 'string') {
                throw new ValidationError();
            }
            return new User(fullname, true, gender, country);
        } catch (error) {
            return error;
        }
    }

    newUser(fullname, gender, country) {
        try {
            if (typeof (fullname) !== 'string') {
                throw new ValidationError();
            }
            if (gender !== 'M' && gender !== 'F' && gender.toUpperCase() !== 'MALE' && gender.toUpperCase() !== 'FEMALE') {
                throw new ValidationError();
            }
            if (typeof (country) !== 'string') {
                throw new ValidationError();
            }
            if (!this.isAdmin) {
                throw new UnauthorizedError();
            }

            let user = new User(fullname, false, gender, country);
            User.allUsers.push(user);
            return user;
        } catch (error) {
            return error;
        }
    }

    getAllUsers() {
        try {
            if (!this.isAdmin) {
                throw new UnauthorizedError();
            }
            return User.allUsers;
        } catch (error) {
            return error;
        }
    }

    findUser(ID) {
        try {
            for (let i = 0; i < User.allUsers.length; i++) {
                if (User.allUsers[i].ID === ID) {
                    return i;
                }
            }
            return -1;
        } catch (error) {
            return error;
        }
    }

    updateUser(ID, parameter, newValue) {
        try {
            if (!this.isAdmin) {
                throw new UnauthorizedError();
            }
            let index = this.findUser(ID);
            if (index === -1) {
                throw new NotFound();
            }

            switch (parameter) {
                case "fullname":
                    if (typeof newValue !== 'string') {
                        throw new ValidationError();
                    }
                    User.allUsers[index].fullname = newValue;
                    return User.allUsers[index];
                case "gender":
                    if (newValue !== 'M' && newValue !== 'F' && newValue.toUpperCase() !== 'MALE' && newValue.toUpperCase() !== 'FEMALE') {
                        throw new ValidationError();
                    }
                    User.allUsers[index].gender = newValue;
                    return User.allUsers[index];
                case "country":
                    if (typeof newValue !== 'string') {
                        throw new ValidationError();
                    }
                    User.allUsers[index].country = newValue;
                    return User.allUsers[index];
                default:
                    throw new ValidationError();
            }
        } catch (error) {
            return error;
        }
    }

    deleteUser(ID) {
        try {
            if (!this.isAdmin) {
                throw new UnauthorizedError();
            }
            let index = this.findUser(ID);
            if (index === -1) {
                throw new NotFound();
            }

            User.allUsers.splice(index, 1);
            return "User Details Deleted Successfully";
        } catch (error) {
            return error;
        }
    }

    newContact(fullname, country) {
        try {
            if (typeof (fullname) !== 'string') {
                throw new ValidationError();
            }
            if (typeof (country) !== 'string') {
                throw new ValidationError();
            }
            if (this.isAdmin) {
                throw new UnauthorizedError();
            }

            let userContact = new Contact(fullname, country);
            this.contacts.push(userContact);
            return userContact;
        } catch (error) {
            return error;
        }
    }

    readContacts() {
        try {
            if (this.isAdmin) {
                throw new UnauthorizedError();
            }
            return this.contacts;
        } catch (error) {
            return error;
        }
    }

    findContact(ID) {
        try {
            for (let i = 0; i < this.contacts.length; i++) {
                if (this.contacts[i].ID === ID) {
                    return i;
                }
            }
            return -1;
        } catch (error) {
            return error;
        }
    }

    updateContact(ID, parameter, newValue) {
        try {
            if (this.isAdmin) {
                throw new UnauthorizedError();
            }

            let index = this.findContact(ID);

            if (index === -1) {
                throw new NotFound();
            }

            let modifiedContact = this.contacts[index].updateContact(parameter, newValue);
            return modifiedContact;
        } catch (error) {
            return error;
        }
    }

    deleteContact(ID) {
        try {
            if (this.isAdmin) {
                throw new UnauthorizedError();
            }
            let index = this.findContact(ID);
            if (index === -1) {
                throw new NotFound();
            }

            this.contacts.splice(index, 1);
            return "Contact Deleted Successfully";
        } catch (error) {
            return error;
        }
    }

    newContactInfo(ID, infoType, infoValue) {
        try {
            if (this.isAdmin) {
                throw new UnauthorizedError();
            }

            let index = this.findContact(ID);
            if (index === -1) {
                throw new NotFound();
            }

            let infoObj = this.contacts[index].newContactInfo(infoType, infoValue);
            return infoObj;
        } catch (error) {
            return error;
        }
    }

    getAllInfo(ID) {
        try {
            if (this.isAdmin) {
                throw new UnauthorizedError();
            }

            let index = this.findContact(ID);
            if (index === -1) {
                throw new NotFound();
            }
            return this.contacts[index].contactInfo;
        } catch (error) {
            return error;
        }
    }

    updateContactInfo(ID, infoID, infoType, infoValue) {
        try {
            if (this.isAdmin) {
                throw new UnauthorizedError();
            }

            let index = this.findContact(ID);
            if (index === -1) {
                throw new NotFound();
            }

            let updatedContactInfo = this.contacts[index].updateContactInfo(infoID, infoType, infoValue);
            return updatedContactInfo;
        } catch (error) {
            return error;
        }
    }

    deleteContactInfo(ID, infoID) {
        try {
            if (this.isAdmin) {
                throw new UnauthorizedError();
            }

            let index = this.findContact(ID);
            if (index === -1) {
                throw new NotFound();
            }

            let deletedContactInfo = this.contacts[index].deleteContactInfo(infoID);
            return deletedContactInfo;
        } catch (error) {
            return error;
        }
    }

    getUserByID(userID) {
        try {
            if (!this.isAdmin) {
                throw new UnauthorizedError();
            }
            let index = this.findUser(userID);
            if (index === -1) {
                throw new NotFound();
            }
            return User.allUsers[index];
        } catch (error) {
            return error;
        }
    }

    getContactByID(contactID) {
        try {
            if (this.isAdmin) {
                throw new UnauthorizedError();
            }

            let index = this.findContact(contactID);

            if (index === -1) {
                throw new NotFound();
            }
            return this.contacts[index];
        } catch (error) {
            return error;
        }
    }

    getContactInfoByID(contactID, infoID) {
        try {
            if (this.isAdmin) {
                throw new UnauthorizedError();
            }

            let index = this.findContact(contactID);
            if (index === -1) {
                throw new NotFound();
            }
            let info = this.contacts[index].getContactInfoByID(infoID);
            return info;
        } catch (error) {
            return error;
        }
    }
}

// module.exports = User;

// Create an admin user
const adminUser = User.newAdmin("Admin User", "M", "USA");
console.log(adminUser);

// Admin creates a regular user
const regularUser = adminUser.newUser("Regular User", "F", "Canada");
console.log(regularUser);

// Add a contact for the regular user
const contact1 = regularUser.newContact("John Smith", "USA");
console.log(contact1);

// Update the contact's information
const updatedContact1 = regularUser.updateContact(contact1.ID, "fullname", "Updated Contact 1");
console.log(updatedContact1);

// Add contact info
const contactInfo1 = contact1.newContactInfo("Email", "contact1@example.com");
console.log(contactInfo1);

// Get all contact info
const allContactInfo = regularUser.getAllInfo(contact1.ID);
console.log(allContactInfo);

// Update contact info
const updatedContactInfo = regularUser.updateContactInfo(contact1.ID, contactInfo1.ID, "infoType", "Phone");
console.log(updatedContactInfo);

// Delete contact info
const deletedContactInfo = regularUser.deleteContactInfo(contact1.ID, contactInfo1.ID);
console.log(deletedContactInfo);

// Get a specific contact info by ID
const specificContactInfo = regularUser.getContactInfoByID(contact1.ID, contactInfo1.ID);
console.log(specificContactInfo);

// Delete a contact
const deletedContact = regularUser.deleteContact(contact1.ID);
console.log(deletedContact);

// Get all contacts for the regular user
const allContacts = regularUser.readContacts();
console.log(allContacts);

// Get a specific contact by ID
const specificContact = regularUser.getContactByID(contact1.ID);
console.log(specificContact);

// Get a user by ID (admin only)
const userByID = adminUser.getUserByID(regularUser.ID);
console.log(userByID);

// Update a user's information (admin only)
const updatedUser = adminUser.updateUser(regularUser.ID, "country", "India");
console.log(updatedUser);

// Delete a user (admin only)
const deletedUser = adminUser.deleteUser(regularUser.ID);
console.log(deletedUser);