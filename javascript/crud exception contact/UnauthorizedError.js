const BaseError = require("./BaseError");

class UnauthorizedError extends BaseError {
  constructor() {
    super("Unauthorized access", "Unauthorized", 401, "Unauthorized access");
  }
}

module.exports = UnauthorizedError;