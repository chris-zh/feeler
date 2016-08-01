/**
 * Created by gua on 7/11/16 4:28:01
 */

// log
var log = function () {
    console.log(arguments);
};

// form
var formFromKeys = function(keys, prefix) {
    var form = {};
    for(var i = 0; i < keys.length; i++) {
        var key = keys[i];
        var tagid = prefix + key;
        var value = $('#' + tagid).val();
        if (value.length < 1) {
            // alert('字段不能为空');
            break;
        }
        form[key] = value;
    }
    return form;
};

// vip API
var vip = {
    data:{}
};

vip.ajax = function(url, method, form, success, error) {
    var request = {
        url: url,
        type: method,
        contentType: 'application/json',
        success: function (r) {
            log('vip post success', url, r);
            success(r);
        },
        error: function (err) {
            var r = {
                success: false,
                data: err
            };
            log('vip post err', url, err);
            error(r);
        }
    };
    if(method === 'post') {
        request.data = JSON.stringify(form);
    }
    $.ajax(request);
};

vip.get = function(url, response) {
    var method = 'get';
    var form = {};
    this.ajax(url, method, form, response, response);
};

vip.post = function(url, form, success, error) {
    var method = 'post';
    this.ajax(url, method, form, success, error);
};

// API normal
vip.register = function(form, success) {
    var url = '/register';
    this.post(url, form, success, success);
};

vip.login = function(form, success) {
    var url = '/login';
    this.post(url, form, success, success);
};

vip.articles = function (success) {
    var url = '/articles';
    this.post(url, '', success, success);
};

// tweet API
vip.tweetAdd = function(form, success, error) {
    var url = '/api/tweet/add';
    this.post(url, form, success, error);
};

vip.test = function(form, success) {
    var url = '/test/post';
    this.post(url, form, success, success);
};

vip.publish = function (form, success) {
    var url = '/publish';
    this.post(url, form, success, success);
};

vip.updateArticle = function (id, form, success) {
    var url = '/updateArticle/' + id;
    this.post(url, form, success, success);
};

vip.article = function (url, success) {
    this.post(url, null, success, success);
};
// vip.newArticle = function () {
//     var url = '/newArticle';
//     var response = function (r) {log(r)};
//     this.get(url, response);
// };updateArticle


