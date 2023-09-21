const BaseError = require("./BaseError");

class NotFound extends BaseError {
  constructor() {
    super("not found", "Not Found", 404, "Resource not found");
  }
}

module.exports = NotFound;