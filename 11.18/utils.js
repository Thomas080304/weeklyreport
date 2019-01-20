function inheritPrototype(subType,superType){
    function F(){}
    F.prototype = superType.prototype;
    //改变subType的prototype为F的实例
    //F的实例通过__proto__指向subperType的prototype
    var prototype = subType.prototype = new F();
    //修正subType的constructor
    prototype.constructor = subType;
}

function EventTarget(){
    this.handlers = {};
}
EventTarget.prototype = {
    constructor:EventTarget,
    on:function(){},
    fire:function(event){
        if(!event.target){
            event.target = this;
        }
        console.log(event);
    },
    off:function(){}
};

var utils = window.utils = {};

var Model = utils.Model = function(view){
    this._view = view;
    EventTarget.call(this)
}
inheritPrototype(Model,EventTarget)
Model.prototype.add = function(msg){
    this.fire({type:'addItem',message:msg})
}

var testModel = new Model();
testModel.add('hello--->1');
testModel.add('hello--->1');


