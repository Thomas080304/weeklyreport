function instantiate(Type, locals) {
    var Constructor = function() {},
        instance, returnedValue;
    // 设置临时构造函数的prototype为传入函数的构造
    Constructor.prototype = (isArray(Type) ? Type[Type.length - 1] : Type).prototype;
    instance = new Constructor();
    returnedValue = invoke(Type, instance, locals);

    return isObject(returnedValue) || isFunction(returnedValue) ? returnedValue : instance;
}
function invoke(fn, self, locals){
    var args = [],
        $inject = annotate(fn),
        length, i,
        key;

    for(i = 0, length = $inject.length; i < length; i++) {
      key = $inject[i];
      if (typeof key !== 'string') {
        throw $injectorMinErr('itkn',
                'Incorrect injection token! Expected service name as string, got {0}', key);
      }
      args.push(
        locals && locals.hasOwnProperty(key)
        ? locals[key]
        : getService(key)
      );
    }
    if (!fn.$inject) {
      // this means that we must be an array.
      fn = fn[length];
    }

    // http://jsperf.com/angularjs-invoke-apply-vs-switch
    // #5388
    return fn.apply(self, args);
}

function provider(name, provider_) {
    assertNotHasOwnProperty(name, 'service');
    if (isFunction(provider_) || isArray(provider_)) {
      provider_ = providerInjector.instantiate(provider_);
    }
    if (!provider_.$get) {
      throw $injectorMinErr('pget', "Provider '{0}' must define $get factory method.", name);
    }
    // { $get:function(){} }
    // { $get:['$injector',function($injector){ return $injector.instantiate(constructor); } }
    // { $get: function(){ return val } }
    return providerCache[name + providerSuffix] = provider_;
}

function factory(name, factoryFn) {
    // 工厂函数 
    return provider(name, { $get: factoryFn }); 
}

function service(name, constructor) {
    // 构造函数
    // provider(name,{ $get:['$injector',function($injector){ return $injector.instantiate(constructor); } })
    return factory(name, ['$injector', function($injector) {
      return $injector.instantiate(constructor);
    }]);
}
function valueFn(value) {return function() {return value;};}
function value(name, val) { 
    // factory(name, function(val){ return function(){ return val } })
    return factory(name, valueFn(val)); 
}

