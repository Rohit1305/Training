class Contact {

    static Id = 0
    constructor(fullName) {
        this.Id = Contact.Id++
        this.fullName = fullName
        this.contactInfos = []
    }
}
module.exports = Contact