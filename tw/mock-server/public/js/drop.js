(function (global, factory) {
    if (typeof define === 'function' && (define.amd || define.cmd)) {
        define(factory);
    } else {
        global.Drop = factory();
    }
}(this, function (require, exports, module) {
    /**
     * 12个对齐的方向 trigger-target
     * t-l(1-4) t-c(5-7) t-r(2-3)
     * b-l(4-1) b-c(7-5) b-r(3-2)
     * l-t(1-2) l-c(8-6) l-b(4-3)
     * r-t(2-1) r-c(6-8) r-b(3-4)
     */
    function Drop(trigger, target, options){
        var defaults = {
            align:'b-l',
            onShow:$.noop,
            onHide:$.noop
        };
        this.options = $.extend({},defaults,options);
        this.align = this.options.align;
        this.display = false;
        this.trigger = trigger;
        this.target = target;
        var that = this;
        //点击空白处弹框消失
        $(document).mousedown(function(e) {
            console.log('1---->',e.target);
            var target = e&&e.target;
            if(!target || that.display != true){return}
            //冒泡的trigger不等于当前的trigger
            if( target != that.trigger[0]&&
                target != that.target[0]&&
                that.trigger[0].contains(target) === false&&
                that.target[0].contains(target) === false ){
                that.hide();
            }
        });
        this.trigger.on('click',function(e){
            console.log('2--->',that)
            if(that.display === false){
                that.show();
            }else{
                that.hide();
            }
        });
        $(window).on('resize',function(){
            that.position();
        })
        //$('body').append(this.target);
    }
    Drop.prototype.show = function(){
        var target = this.target;
		if (target && $.contains(document.body, target[0]) == false) {
			$('body').append(target);
		}
        this.display = true;
        this.target.css('position','absoulute').show()
        this.position();
        if(typeof this.options.onShow === 'function'){
            this.options.onShow.call(this,this.trigger,this.target)
        }
    }
    Drop.prototype.hide = function(){
        this.target.hide();
        this.display = false;
        if(typeof this.options.onHide === 'function'){
            this.options.onHide.call(this,this.trigger,this.target)
        }
    }
    Drop.prototype.destory = function(){
        $(document).off();
        this.trigger.off();
        $(window).off();
        this.target.remove();
    }
    Drop.prototype.position = function(){
        //1.先计算是否溢出
        //2.如果溢出交换方向
        //3.交换方向后计算target的left，top
        var align = this.align;
        var prefix = (align+'').split('-')[0];
        //判断是否溢出
        var dir = getDir(this.trigger,this.target);
        //在给定的方向上溢出，交换方向强行计算
        if(!dir[prefix]){
            align = swapDir(align);
        }
        var pos = getPos(this.trigger,this.target,align);
        this.target.css({
            position:'absolute',
            left:Math.round(pos.left),
            top:Math.round(pos.top)
        })
        function getPos(trigger,target,dir){
            var tarPos = formatPos(target);
            var triPos = formatPos(trigger);
            var winPos = formatPos(window);
            var dirs = (dir+'').split('-');
            var prefix = dirs[0];
            //l c r t c b
            var last = dirs[1];
            var left,top;
            switch(prefix){
                case 't'://top l c t
                    top = triPos.top - tarPos.height;
                    if(last === 'l'){
                        left = triPos.left;
                    }else if(last === 'c'){
                        left = triPos-(tarPos.width-triPos.width)/2;
                    }else{
                        left = triPos.left-(tarPos.width-triPos.width)
                    }
                    break;
                case 'b'://bottom l c t
                    top = triPos.top+triPos.height;
                    if(last === 'l'){
                        left = triPos.left;
                    }else if(last === 'c'){
                        left = triPos.left-(tarPos.width-triPos.width)/2;
                    }else{
                        left = triPos.left-(tarPos.width-triPos.width)
                    }
                    break;
                case 'l'://left t c b
                    left = triPos.left-tarPos.width;
                    if(last === 't'){
                        top = triPos.top;
                    }else if(last === 'c'){
                        top = triPos.top - (tarPos.width-triPos.width)/2;
                    }else{
                        top = triPos.top-(tarPos.height-triPos.height);
                    }
                    break;
                case 'r'://right t c b
                    left = triPos.left+triPos.width;
                    if(last === 't'){
                        top = triPos.top;
                    }else if(last === 'c'){
                        top = triPos.top-(tarPos.height-triPos.height)/2;
                    }else{
                        top = triPos.top-(tarPos.height-triPos.height);
                    }
                    break;
            }
            return {
                left:left,
                top:top
            }
        }
        function swapDir(dir){
            var alignMap = [
                ['t-l','b-l'],
                ['t-c','b-c'],
                ['t-r','b-r'],
                ['l-t','r-t'],
                ['l-c','r-c'],
                ['l-b','r-b'],
            ];
            var finder = false,
                current = null;
            for(var i = 0,len = alignMap.length; i < len; i++){
                current = alignMap[i];
                for(var j = 0, leng = current.length; j < leng; j++){
                    if(current[j] === dir){
                        var temp = current.slice(); 
                        temp.splice(j,1);
                        finder = temp;
                        break;
                    }
                }
            }
            return finder[0];
        }
        function getDir(trigger,target){
            var tarPos = formatPos(target);
            var triPos = formatPos(trigger);
            var winPos = formatPos(window);
            var result = {
                t:false,
                r:true,
                b:true,
                l:false
            };
            var totalWidth = triPos.left+triPos.width+tarPos.width;
            var totalHeight = triPos.top+triPos.height+tarPos.height;
            //right
            if(totalWidth > winPos.width){
                result.r = false;
                result.l = true;
            }
            //bottom
            if(totalHeight > winPos.height+winPos.sTop){
                result.b = false;
                result.t = true;
            }
            //left
            if(tarPos.width > triPos.left){
                result.l = false;
            }
            //top
            if(tarPos.height > triPos.top-winPos.sTop){
                result.t = false;
            }
            return result;
        }
        function formatPos(elem){
            var $elem = $(elem);
            var offset = $elem.offset();
            return {
                width:$elem.outerWidth(),
                height:$elem.outerHeight(),
                left:offset&&offset.left || 0,
                top:offset&&offset.top || 0,
                sLeft:$elem.scrollLeft(),
                sTop:$elem.scrollTop()
            }
        }
    }
    //扩展到jquery的实例上
	$.fn.drop = function(target, options) {
		return $(this).each(function() {
			var drop = $(this).data('drop');
			if (!drop) {
				$(this).data('drop', new Drop($(this), target, options));
			}         
        });
	};
    return Drop;
}));
