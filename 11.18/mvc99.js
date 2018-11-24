/*

模型：模型用于封装与应用程序的业务逻辑相关的数据以及对数据处理的方法。
	  模型有对数据直接访问的权利。模型不依赖 “视图” 和 “控制器”, 也就
	  是说 模型它不关心页面如何显示及如何被操作.
	  -----观察目标

视图：视图层最主要的是监听模型层上的数据改变，并且实时的更新html页面。
	  当然也包括一些事件的注册或者ajax请求操作(发布事件),都是放在视图层来完成。
	  -----观察者


控制器：控制器接收用户的操作，最主要是订阅视图层的事件，然后调用模型
		或视图去完成用户的操作;比如：当页面上触发一个事件，控制器不输出任何东
		西及对页面做任何处理; 它只是接收请求并决定调用模型中的那个方法去处理请求, 
		然后再确定调用那个视图中的方法来显示返回的数据。
	  -----中介者
*/
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





//观察对象
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
		this.removeItemEvent.fire({'data':item});
		if(index === this._selectedIndex){
			this.setSelectedIndex(-1);
		}

	},
	getSelectedIndex:function(){
		return this._selectedIndex;
	},
	setSelectedIndex:function(index){
		var priviousIndex = this._selectedIndex;
		this._selectedIndex = index;
		this.selectedIndexChangeEvent.fire(priviousIndex,index);
	}
};

//观察者
function View(model,elems){
	this._model = model;
	this._elems = elems;
	this.listModified = new Event(this);
	this.addButtonViewClick = new Event(this);
	this.delButtonViewClick = new Event(this);
	var that = this;
	this._model.addItemEvent.on(function(){
		that.rebuildList();
	});
	this._model.removeItemEvent.on(function(){
		that.rebuildList();
	});
	//绑定html上的事件
	this._elems.list.change(function(e){
		that.listModified.fire({'data':e.target.selectedIndex});
	});
	this._elems.addButton.click(function(e){
		that.addButtonViewClick.fire();
	});
	this._elems.delButton.click(function(e){
		that.delButtonViewClick.fire();
	});

}
View.prototype = {
	constructor:View,
	rebuildList:function(){
		var $list = this._elems.list,
			items,key;
		$list.empty();
		items = this._model.getItems();
		for(key in items){
			if(items.hasOwnProperty(key)){
				$list.append(String('<option value="'+items[key]+'">'+items[key]+'</option>'));
			}
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
	var that = this;
	this._view.listModified.on(function(param){
		that.updateSelected(param.data);
	});
	this._view.addButtonViewClick.on(function(){
		that.addItem();
	});
	this._view.delButtonViewClick.on(function(){
		that.deleteItem();
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
		var index = this._model.getSelectedIndex();
		if(index !== -1){
			this._model.removeItem(index);
		}
	},
	updateSelected:function(index){
		this._model.setSelectedIndex(index);

	}
};
$(function($){
	var model = window.model= new Model(['javascript','php','java']);
	var view = new View(model,{
		'list':$('#list'),
		'addButton':$('#addBtn'),
		'delButton':$('#minBtn')
	});
	var controller = new Controller(model,view);
	view.show();
})




