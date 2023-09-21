export abstract class shape{
    constructor(private _x:number, private _y:number){

    }
    public getInfo():string{
        return `x=${this._x} and y=${this._y}`
    }
    public abstract calculateArea():number;
}