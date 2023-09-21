"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.shape = void 0;
var shape = /** @class */ (function () {
    function shape(_x, _y) {
        this._x = _x;
        this._y = _y;
    }
    shape.prototype.getInfo = function () {
        return "x=".concat(this._x, " and y=").concat(this._y);
    };
    return shape;
}());
exports.shape = shape;
