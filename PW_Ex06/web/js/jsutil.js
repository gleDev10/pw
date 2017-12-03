jQuery.createDelegate = function (instance, method) {
    return function() {
        return method.apply(instance, arguments);
    };
};
