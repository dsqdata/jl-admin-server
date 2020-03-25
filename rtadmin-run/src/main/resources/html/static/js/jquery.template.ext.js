/**
 * template-web 扩展插件 依赖 template-web.js
 */

template.defaults.imports.formatDemo = function(value1, value2) {
	return value1 + ":" + value2;
}
template.defaults.imports.formatPriceNo = function(price) {
	var value = parseFloat(price) / 100;
	var xsd = value.toString().split(".");

	if(xsd.length == 1) {
		value = value.toString();
		return value;
	}

	if(xsd.length > 1) {
		if(xsd[1].length < 2) {
			value = value.toString() + "0";
		}
		return value;
	}
	return value;
};