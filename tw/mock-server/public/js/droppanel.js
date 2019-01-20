(function (global, factory) {
    if (typeof define === 'function' && (define.amd || define.cmd)) {
        define(factory);
    } else {
        global.Drop = factory();
    }
}(this, function (require, exports, module) {
    /**
    <div class="drop-panel-wrap">
		<h5 class="drop-panel-title">
			Separate multiple resource name with commas
		</h5>
		<div class="drop-close">
			<span class="drop-close-wrap">
				<i class="icon-close"></i>
			</span>
		</div>
		<div class="drop-panel-body">
			<div class="customer-panel">
				<input class="e-input" />
			</div>
		</div>
		<div class="drop-panel-footer">
			<a href="javascript:;" class="e-btn drop-panel-btn-first">Add Resource</a>
			<a href="javascript:;" class="e-btn drop-panel-btn-seconde">Cancel</a>
		</div>
    </div>
    $('trigger').dropPanel({
        title:'Separate multiple resource name with commas',
        content:`<div class="customer-panel">
                    <input class="e-input" />
                </div>`,
        buttons:[
            {text:'Add Resource',onClick:function(target,closeFn){}},
            {text:'Cancel',onClick:function(target,closeFn){}
        ]
    })
     */
    function DropPanel(trigger, options){
        var defaults = {
			title: '',
			content: '',
			buttons: [{}, {}],
			width: 'auto',
			eventType: 'click',
			offsets: {
				x: 0,
				y: 0
			},
			onShow: $.noop,
			onHide: $.noop
		};
        this.trigger = trigger;
        var options = $.extend({}, defaults, options || {});
        //容器 trigger的target对象
        var $container = $('<div class="drop-panel-wrap"></div>');
        //title
        var $title = $('<h5 class="drop-panel-title"></h5>').html(options.title);
        //close icon
        var $dropClose = $( 
            '<div class="drop-close">'
                +'<span class="drop-close-wrap">'
                    +'<i class="icon-close"></i>'
                +'</span>'
            +'</div>').on('click',function(){
                closeFn()
            });
        //内容
        var $body = $('<div class="drop-panel-body"></div>').html(options.content);
        //footer buttons
        var $footer = $('<div class="drop-panel-footer"></div>');
        var that = this;
        for(var i = 0, len = options.buttons.length; i < len; i++){
            (function(index){
                var $btn = $('<a href="javascript:;" class="e-btn drop-panel-btn-'+i+'"></a>');
                var opts = options.buttons[index] || {};
                $btn.text(opts.text);
                $btn.on('click',function(e){
                    e.preventDefault()
                    opts.onClick&&opts.onClick.call(that,that.trigger,$container,closeFn)
                })
                $footer.append($btn)
            })(i)
           
        }
        $container.append([$title,$dropClose,$body,$footer]);
        //初始化下拉
        this.trigger.drop($container,{
            eventType: options.eventType,
			offsets: options.offsets,
			onShow: options.onShow,
			onHide: options.onHide
        })
        var drop = this.trigger.data('drop');
        var closeFn = function(){
            drop.hide()
        }
        return drop;
    }
    
    $.fn.dropPanel = function(options){
        return $(this).each(function() {
			var dropPanel = $(this).data('dropPanel');
			if (!dropPanel) {
				$(this).data('dropPanel', new DropPanel($(this), options));
			}         
        });
    }
    return DropPanel;
}));
