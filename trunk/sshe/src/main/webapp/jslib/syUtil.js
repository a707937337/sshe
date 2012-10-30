/**
 * @author WangHuifeng
 * @requires Jquery,EasyUI
 * 扩展validatebox 添加验证两次密码功能
 */
$.extend($.fn.validatebox.defaults.rules, {   
   rePwd: {   
        validator: function(value, param){   
            return value ==$(param[0]).val();   
        },   
        message: '两次密码不一致'  
    }   
}); 