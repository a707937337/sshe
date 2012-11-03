
var sy = $.extend({}, sy);/* 定义全局对象，类似于命名空间或包的作用 */
/**
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

/**
 * @author 郭华(夏悸)
 * 
 * 生成UUID
 * 
 * @returns UUID字符串
 */
sy.random4 = function() {
	return (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
};
sy.UUID = function() {
	return (sy.random4() + sy.random4() + "-" + sy.random4() + "-" + sy.random4() + "-" + sy.random4() + "-" + sy.random4() + sy.random4() + sy.random4());
};

/**
 * 扩展 datagrid行编辑输入日期带几点的
 */
$.extend($.fn.datagrid.defaults.editors, {   
    datetimebox : {   
        init: function(container, options){   
            var input = $('<input />').appendTo(container);  
            options.editable=false;
            input.datetimebox(options);
            return input;   
        },   
        getValue: function(target){   
            return $(target).datetimebox('getValue');   
        },   
        setValue: function(target, value){   
            $(target).datetimebox('setValue',value);   
        },   
        resize: function(target, width){   
            $(target).datetimebox('resize',width);
        },
        destory:function(target){
        	$(target).datetimebox('destory');
        }
    }   
});  

/**
 * @author 孙宇
 * 
 * @requires jQuery,EasyUI
 * 
 * 扩展datagrid，添加动态增加或删除Editor的方法
 * 
 * 例子如下，第二个参数可以是数组
 * 
 * datagrid.datagrid('removeEditor', 'cpwd');
 * 
 * datagrid.datagrid('addEditor', [ { field : 'createdatetime', editor : { type : 'datetimebox', options : { editable : false } } }, { field : 'cmodifydatetime', editor : { type : 'datetimebox', options : { editable : false } } } ]);
 * 
 */
$.extend($.fn.datagrid.methods, {
	addEditor : function(jq, param) {
		if (param instanceof Array) {
			$.each(param, function(index, item) {
				var e = $(jq).datagrid('getColumnOption', item.field);
				e.editor = item.editor;
			});
		} else {
			var e = $(jq).datagrid('getColumnOption', param.field);
			e.editor = param.editor;
		}
	},
	removeEditor : function(jq, param) {
		if (param instanceof Array) {
			$.each(param, function(index, item) {
				var e = $(jq).datagrid('getColumnOption', item);
				e.editor = {};
			});
		} else {
			var e = $(jq).datagrid('getColumnOption', param);
			e.editor = {};
		}
	}
});
