"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.rectangle = void 0;
var rectangle = /** @class */ (function () {
    function rectangle(_height, _width) {
        this._height = _height;
        this._width = _width;
    }
    rectangle.prototype.calculateArea = function () {
        return this._height * this._width;
    };
    return rectangle;
}());
exports.rectangle = rectangle;
