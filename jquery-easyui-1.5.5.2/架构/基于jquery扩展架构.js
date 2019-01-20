基于jquery的拓展架构，可以考虑amd，cmd，umd，node等的兼容

(function($){
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
            bindEvent(this);
            buildContent(this);
        });
	}
	//方法扩展
	$.fn.tooltip.methods = {};
	//属性扩展,
	$.fn.tooltip.parseOptions = function(){};
	//默认值
	$.fn.tooltip.defaults = {}；

})(jQuery)