import { shape } from "./shape";

export class rectangle extends shape {
    constructor(theX: number, theY: number, private _height: number, private _width: number) {
        super(theX, theY); 
    }

    public getInfo():string{
        return super.getInfo()+`height:${this._height} and width:${this._width}`;
    }
}