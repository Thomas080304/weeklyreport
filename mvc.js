/** M---V---C
Model:封装后台数据及操作（数据的增查删改），属于观察者模式中的观察对象
model与Controller属于客户端和中介者的关系，model不需要和Controller及view
交互，所以model不需要有两者的引用。
View: 封装页面的渲染方法，属于观察者中的观察者
view与Controller属于客户端和中介者的关系，view不需要调用Controller的方法，
所以不需要controller的引用，需要在view中观察model的变化，所以需要model的引用
也就是视图依赖的手动收集（mvvm中是自动收集）
Controller:接受View的发送的请求，选择或者调用对应的model,属于中介者，
mdel和view相当于客户端，被中介者调用。

**/

function Event(observer){
	this._observer = observer;
	this._listeners = [];
}
Event.prototype = {
	constructor:Event,
	on:function(listener){
		this._listeners.push(listener);
	},
	fire:function(data){
		for(var i = 0,len = this._listeners.length; i< len; i++){
			this._listeners[i].call(this._observer,data);
		}
	}
};


function Model(dataArray){
	this._data = dataArray;
	this._selectedIndex = -1;
	this.addItemEvent = new Event(this);
	this.removeItemEvent = new Event(this);
	this.selectedIndexChangeEvent = new Event(this);
}
Model.prototype = {
	constructor:Model,
	getItems:function(){
		return [].concat(this._data);
	},
	addItem:function(data){
		this._data.push(data);
		this.addItemEvent.fire(data);
	},
	removeItem:function(index){
		var item = this._data.splice(index,1);
		this.removeItemEvent.fire({"data":item});
		if(index === this._selectedIndex){
			this.setSelectedIndex(-1);
		}
	},
	getSelectedIndex:function(){
		return this._selectedIndex;
	},
	setSelectedIndex:function(index){
		var previousIndex = this._selectedIndex;
		this._selectedIndex = index;
		this.selectedIndexChangeEvent.fire(previousIndex,index);
	}
};

//观察者视图依赖的收集
function View(model,elems){
	this._model = model;
	this._elems = elems;
	var that = this;
	this.selectedChangeEvent = new Event(this);
	this.addBtnEvent = new Event(this);
	this.delBtnEvent = new Event(this);
	this._model.addItemEvent(function(){
		that.rebuildList();
	});
	this._model.removeItemEvent(function(){
		that.rebuildList();
	});
	this._model.selectedIndexChangeEvent(function(){
		//
	});

}
View.prototype = {
	constructor:View,
	rebuildList:function(){
		var $list = this._elems.list,
			items,key;
		items = this._model.getItems();
		$list.empty();
		for(key in items){
			$list.append('<option key='+key+' value='+items[key]+'>'+items[key]+'</option>');
		}
		this._model.setSelectedIndex(-1);
	},
	show:function(){
		this.rebuildList();
	}
};

function Controller(model,view){
	this._model = model;
	this._view = view;
	this._view.listChangeEvnet.on(function(param){
		that.updateSelected(param.data);
	});
	this._view.addBtnEvent.on(function(){

	});
	this._view.delBtnEvent.on(function(){

	});
}
Controller.prototype = {
	constructor:Controller,
	addItem:function(){
		var item = window.prompt('Add Item:','');
		if(item){
			this._model.addItem(item);
		}
	},
	deleteItem:function(){

	},
	updateSelected:function(){

	}
};































