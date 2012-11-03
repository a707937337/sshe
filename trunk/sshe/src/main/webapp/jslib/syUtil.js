
var sy = $.extend({}, sy);/* 定义全局对象，类似于命名空间或包的作用 */
/**
 * @author WangHuifeng
 * @requires Jquery,EasyUI 扩展validatebox 添加验证两次密码功能
 */
$.extend($.fn.validatebox.defaults.rules, {
	rePwd : {
		validator : function(value, param) {
			return value == $(param[0]).val();
		},
		message : '两次密码不一致'
	}
});

/**
 * 将form表单元素的值序列化成对象
 */
sy.serializeObject=function(form){/*将form表单元素序列化成对象*/
	var o={};
	$.each(form.serializeArray(),function(index){
		if (o[this['name']]) {
			o[this['name']] = o[this['name']] + "," + this['value'];
		} else {
			o[this['name']] = this['value'];
		}
	});
	return o;
};