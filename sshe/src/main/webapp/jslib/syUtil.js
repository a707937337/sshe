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
$.extend($.messager, {
	showBySite : function(options, param) {
		var site = $.extend({
			left : "",
			top : "",
			right : 0,
			bottom : -document.body.scrollTop
			- document.documentElement.scrollTop
		}, param || {});
		var win = $("body > div .messager-body");
		if (win.length <= 0)
			$.messager.show(options);
		win = $("body > div .messager-body");
		win.window("window").css({
			left : site.left,
			top : site.top,
			right : site.right,
			zIndex : $.fn.window.defaults.zIndex++,
			bottom : site.bottom
		});
	}
});
