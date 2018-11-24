/**
	视图----pass call---> controll ------调用---> model-----触发事件--->view	
 **/
//1.添加按钮点击
//2.删除按钮点击
//3.选中一行，获取选中行的index
//4.渲染界面
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


var Model = function(dataArr){
	this._list = dataArr;
	this._selected = -1;
	this.addItemEvent = new Event(this);
	this.delItemEvent = new Event(this);
	this.selItemEvent = new Event(this);
}
Model.prototype = {
	constructor:Model,
	getList:function(){
		return this._list;
	},
	getSelect:function(){
		return this._selected;
	},
	setSelect:function(index){
		var previous = this._selected;
		this._selected = index;
		this.selItemEvent.fire(previous,index);
	},
	addItem:function(data){
		this._list.push(data);
		this.addItemEvent.fire(data);
	},
	removeItem:function(index){
		var previous = this._list.splice(index,1);
		this.delItemEvent.fire(previous);
	}
};

var View = function(model,elems){
	this._elems = elems;
	this._model = model;
	var that = this;
	this.addBtnEvent = new Event(this);
	this._elems.addBtn.click(function(){
		that.addBtnEvent.fire();
	})
	this.delBtnEvent = new Event(this);
	this._elems.delBtn.click(function(){
		that.delBtnEvent.fire();
	})
	this.selectEvent = new Event(this);
	this._elems.list.change(function(e){
		that.selectEvent.fire({data:e.target.selectedIndex});
	})
	//监听model的变化
	this._model.addItemEvent.on(function(){
		that.buildList();
	})
	this._model.delItemEvent.on(function(){
		that.buildList();
	})
}
View.prototype = {
	constructor:View,
	buildList:function(){
		var $list = this._elems.list;
		$list.empty();
		var listData = this._model.getList();
		for(var key in listData){
			$list.append('<option value="'+listData[key]+'">'+listData[key]+'</option>');
		}
		this.selectEvent.fire({data:-1});
		//this._model.setSelect(-1);
	},
	show:function(){
		this.buildList();
	}
}

var Controller = function(model,view){
	this._view = view;
	this._model = model;
	//截获view请求
	var that = this;
	this._view.addBtnEvent.on(function(){
		that.addItem();
	})
	this._view.delBtnEvent.on(function(){
		that.delItem();
	})
	this._view.selectEvent.on(function(param){
		that.setSelect(param.data);
	})
}
Controller.prototype = {
	constructor:Controller,
	addItem(){
		var item = window.prompt('add Item','');
		if(item){
			this._model.addItem(item);
		}
	},
	delItem(){
		var index = this._model.getSelect();
		if(index > -1){
			this._model.removeItem(index);
		}
	},
	setSelect(index){
		this._model.setSelect(index);
	}
};

$(function($){
	var model = window.model= new Model(['javascript','php','java']);
	var view = new View(model,{
		'list':$('#list'),
		'addBtn':$('#addBtn'),
		'delBtn':$('#minBtn')
	});
	var controller = new Controller(model,view);
	view.show();
})










