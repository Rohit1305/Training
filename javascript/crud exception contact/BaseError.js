class BaseError extends Error {
    constructor(message, name, httpstatusCode, specificMessage) {
      super(message);
      this.name = name;
      this.httpstatusCode = httpstatusCode;
      this.specificMessage = specificMessage;
    }
  }
  
  module.exports = BaseError;