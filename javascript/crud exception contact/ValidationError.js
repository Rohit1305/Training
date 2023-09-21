const BaseError = require("./BaseError");

class ValidationError extends BaseError {
  constructor() {
    super("validation error", "Validation Error", 403, "Validation error occurred");
  }
}

module.exports = ValidationError;