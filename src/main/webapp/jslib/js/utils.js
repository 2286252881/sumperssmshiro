/**
 * 扩展validatebox，添加验证两次密码功能
 */
$.extend($.fn.validatebox.defaults.rules, {
	eqPwd:{
		validator : function(value, param) {
			return value == $(param[0]).val();
		},
		message : '密码不一致！'
	}
});

$.fn.tree.defaults.loadFilter = function(data, parent) {
	var opt = $(this).data().tree.options;
	var idFiled, textFiled, parentField;
	if (opt.parentField) {
		idFiled = opt.idFiled || 'id';
		textFiled = opt.textFiled || 'text';
		parentField = opt.parentField;
		var i, l, treeData = [], tmpMap = [];
		for (i = 0, l = data.length; i < l; i++) {
			tmpMap[data[i][idFiled]] = data[i];
		}
		for (i = 0, l = data.length; i < l; i++) {
			if (tmpMap[data[i][parentField]] && data[i][idFiled] != data[i][parentField]) {
				if (!tmpMap[data[i][parentField]]['children'])
					tmpMap[data[i][parentField]]['children'] = [];
				data[i]['text'] = data[i][textFiled];
				tmpMap[data[i][parentField]]['children'].push(data[i]);
			} else {
				data[i]['text'] = data[i][textFiled];
				treeData.push(data[i]);
			}
		}
		return treeData;
	}
	return data;
};


/** 
* 防止panel/window/dialog组件超出浏览器边界
* @param left
* @param top
*/
var easyuiPanelOnMove = function(left, top) {
	var l = left;
	var t = top;
	if (l < 1) {
		l = 1;
	}
	if (t < 1) {
		t = 1;
	}
	var width = parseInt($(this).parent().css('width')) + 14;
	var height = parseInt($(this).parent().css('height')) + 14;
	var right = l + width;
	var buttom = t + height;
	var browserWidth = $(window).width();
	var browserHeight = $(window).height();
	if (right > browserWidth) {
		l = browserWidth - width;
	}
	if (buttom > browserHeight) {
		t = browserHeight - height;
	}
	$(this).parent().css({/* 修正面板位置 */
		left : l,
		top : t
	});
};
$.fn.dialog.defaults.onMove = easyuiPanelOnMove;
$.fn.window.defaults.onMove = easyuiPanelOnMove;
$.fn.panel.defaults.onMove = easyuiPanelOnMove;


/** 
* 将form表单元素的值序列化成对象
* 
* @returns object
*/
serializeObject = function(form) {
	var o = {};
	$.each(form.serializeArray(), function(index) {
		if (o[this['name']]) {
			o[this['name']] = o[this['name']] + "," + this['value'];
		} else {
			o[this['name']] = this['value'];
		}
	});
	return o;
};
/*扩展文本验证验证*/
$.extend($.fn.validatebox.defaults.rules, {
			  idcard : {// 验证身份证 
			        validator : function(value) { 
			            return /^\d{15}(\d{2}[A-Za-z0-9])?$/i.test(value); 
			        }, 
			        message : '身份证号码格式不正确' 
			    },
			      minLength: {
			        validator: function(value, param){
			            return value.length >= param[0];
			        },
			        message: '请输入至少（2）个字符.'
			    },
			    length:{validator:function(value,param){ 
			        var len=$.trim(value).length; 
			            return len>=param[0]&&len<=param[1]; 
			        }, 
			            message:"输入内容长度必须介于{0}和{1}之间." 
			        }, 
			    phone : {// 验证电话号码 
			        validator : function(value) { 
			            return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value); 
			        }, 
			        message : '格式不正确,请使用下面格式:020-88888888' 
			    }, 
			    mobile : {// 验证手机号码 
			        validator : function(value) { 
			            return /^(13|15|18)\d{9}$/i.test(value); 
			        }, 
			        message : '手机号码格式不正确' 
			    }, 
			    intOrFloat : {// 验证整数或小数 
			        validator : function(value) { 
			            return /^\d+(\.\d+)?$/i.test(value); 
			        }, 
			        message : '请输入数字，并确保格式正确' 
			    }, 
			    currency : {// 验证货币 
			        validator : function(value) { 
			            return /^\d+(\.\d+)?$/i.test(value); 
			        }, 
			        message : '货币格式不正确' 
			    }, 
			    qq : {// 验证QQ,从10000开始 
			        validator : function(value) { 
			            return /^[1-9]\d{4,9}$/i.test(value); 
			        }, 
			        message : 'QQ号码格式不正确' 
			    }, 
			    integer : {// 验证整数 
			        validator : function(value) { 
			            return /^[+]?[1-9]+\d*$/i.test(value); 
			        }, 
			        message : '请输入整数' 
			    }, 
			    age : {// 验证年龄
			        validator : function(value) { 
			            return /^(?:[1-9][0-9]?|1[01][0-9]|120)$/i.test(value); 
			        }, 
			        message : '年龄必须是0到120之间的整数' 
			    }, 
			    
			    chinese : {// 验证中文 
			        validator : function(value) { 
			            return /^[\Α-\￥]+$/i.test(value); 
			        }, 
			        message : '请输入中文' 
			    }, 
			    english : {// 验证英语 
			        validator : function(value) { 
			            return /^[A-Za-z]+$/i.test(value); 
			        }, 
			        message : '请输入英文' 
			    }, 
			    unnormal : {// 验证是否包含空格和非法字符 
			        validator : function(value) { 
			            return /.+/i.test(value); 
			        }, 
			        message : '输入值不能为空和包含其他非法字符' 
			    }, 
			    username : {// 验证用户名 
			        validator : function(value) { 
			            return /^[a-zA-Z][a-zA-Z0-9_]{5,15}$/i.test(value); 
			        }, 
			        message : '用户名不合法（字母开头，允许6-16字节，允许字母数字下划线）' 
			    },
			    eqPwd:{
			    	validator:function(value,param){
			    		return value==$(param[0]).val();
			    	},
			    	message:'两次输入的密码不一致！'
			    },
			    faxno : {// 验证传真 
			        validator : function(value) { 
//			            return /^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/i.test(value); 
			            return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value); 
			        }, 
			        message : '传真号码不正确' 
			    }, 
			    zip : {// 验证邮政编码 
			        validator : function(value) { 
			            return /^[1-9]\d{5}$/i.test(value); 
			        }, 
			        message : '邮政编码格式不正确' 
			    }, 
			    ip : {// 验证IP地址 
			        validator : function(value) { 
			            return /d+.d+.d+.d+/i.test(value); 
			        }, 
			        message : 'IP地址格式不正确' 
			    }, 
			    name : {// 验证姓名，可以是中文或英文 
			            validator : function(value) { 
			                return /^[\Α-\￥]+$/i.test(value)|/^\w+[\w\s]+\w+$/i.test(value); 
			            }, 
			            message : '请输入姓名' 
			    },
			    date : {// 验证姓名，可以是中文或英文 
			        validator : function(value) { 
			         //格式yyyy-MM-dd或yyyy-M-d
			            return /^(?:(?!0000)[0-9]{4}([-]?)(?:(?:0?[1-9]|1[0-2])\1(?:0?[1-9]|1[0-9]|2[0-8])|(?:0?[13-9]|1[0-2])\1(?:29|30)|(?:0?[13578]|1[02])\1(?:31))|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)([-]?)0?2\2(?:29))$/i.test(value); 
			        },
			        message : '清输入合适的日期格式'
			    },
			    msn:{ 
			        validator : function(value){ 
			        return /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(value); 
			    }, 
			    message : '请输入有效的msn账号(例：abc@hotnail(msn/live).com)' 
			    },
			    same:{ 
			        validator : function(value, param){ 
			            if($("#"+param[0]).val() != "" && value != ""){ 
			                return $("#"+param[0]).val() == value; 
			            }else{ 
			                return true; 
			            } 
			        },   
			        message : '两次输入的密码不一致！'    
			    } 
});
/**
 * 
 * 取消easyui默认开启的parser
 * 
 * 在页面加载之前，先开启一个进度条
 * 
 * 然后在页面所有easyui组件渲染完毕后，关闭进度条
 * 
 *
 * 
 * @requires jQuery,EasyUI
 * 
 */
$.parser.auto = false;
$(function() {
	$.messager.progress({
		text : '页面加载中....',
		interval : 100
	});
	$.parser.parse(window.document);
	window.setTimeout(function() {
		$.messager.progress('close');
		if (self != parent) {
			window.setTimeout(function() {
				try {
					parent.$.messager.progress('close');
				} catch (e) {
				}
			}, 500);
		}
	}, 1);
	$.parser.auto = true;
});

/**
 * 使panel和datagrid在加载时提示
 * 
 *
 * 
 * @requires jQuery,EasyUI
 * 
 */
$.fn.panel.defaults.loadingMessage = '加载中....';
$.fn.datagrid.defaults.loadMsg = '加载中....';