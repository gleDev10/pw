Modelo = function () {

};

Modelo.Load = function () {
    var m = new Modelo();
    m.initialize();
    return m;
};

Modelo.prototype = {
    initialize: function () {

    },
    dataBind: function (type, data, url, success, error) {
        $.ajax({
            type: type, 
            cache: false,
            data: data, 
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            url: url, 
            success: $.createDelegate(this, success),  
            error: $.createDelegate(this, error)  
        });
    }
};

$(document).ready(function () {
    Modelo.Load();
});