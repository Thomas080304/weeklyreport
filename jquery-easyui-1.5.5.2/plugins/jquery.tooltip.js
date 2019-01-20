(function($){

	function init(target){
		$(target).addClass("tooltip-f");
	}

	function bindEvents(target){
		var opts = $.data(target, "tooltip").options;
        $(target)
	        .unbind(".tooltip")
	        .bind(opts.showEvent + ".tooltip",function(e) {
	            $(target).tooltip("show", e);
	        })
	        .bind(opts.hideEvent + ".tooltip",function(e) {
	            $(target).tooltip("hide", e);
	        })
	        .bind("mousemove.tooltip",function(e) {
	            if (opts.trackMouse) {
	                opts.trackMouseX = e.pageX;
	                opts.trackMouseY = e.pageY;
	                $(target).tooltip("reposition");
	            }
	        });
	}

	function buildContent(){

	}

	function showContent(){

	}

	function hideContent(){

	}

	function placeContent(){

	}

	function destory(){

	}

	//模块名
	$.fn.tooltip = function(options, param){
		if (typeof options == "string") {
            return $.fn.tooltip.methods[options](this, param);
        }
        options = options || {};
        return this.each(function() {
            var state = $.data(this, "tooltip");
            if (state) {
                $.extend(state.options, options);
            } else {
                $.data(this, "tooltip", {
                    options: $.extend({},
                    $.fn.tooltip.defaults, $.fn.tooltip.parseOptions(this), options)
                });
                init(this);
            }
            bindEvents(this);
            buildContent(this);
        });
	}
	//方法扩展
	$.fn.tooltip.methods = {
		options: function(jq){
			return $.data(jq[0], "tooltip").options;
		},
		tip: function(jq){
			return $.data(jq[0], "tooltip").tip;
		},
		arrow: function(jq){
			 return jq.tooltip("tip").children(".tooltip-arrow-outer,.tooltip-arrow");
		},
		show: function(jq, e){
			return jq.each(function() {
                showContent(this, e);
            });
		},
		hide: function(jq, e){
			return jq.each(function() {
                hideContent(this, e);
            });
		},
		update: function(jq, content){
			return jq.each(function() {
                buildContent(this, content);
            });
		},
		reposition: function(jq){
			return jq.each(function() {
                placeContent(this);
            });
		},
		destroy: function(jq){
			return jq.each(function() {
                destory(this);
            });
		}
	};
	//属性扩展,
	$.fn.tooltip.parseOptions = function(){};
	//默认值
	$.fn.tooltip.defaults = {
		position: 'bottom',
		content: null,
		trackMouse: false,
		deltaX: 0,
		deltaY: 0,
		showEvent： 'mouseenter',
		hideEvent: 'mouseleave',
		showDelay: 200,
		hideDelay: 100,
		onShow: function(e){},
		onHide: function(e){},
		onUpdate: function(content){},
		onPosition: function(left, top){},
		onDestroy: function(){}
	}；

})(jQuery)