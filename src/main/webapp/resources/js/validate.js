function isEnglish(text)
{
	var regex = /^[a-zA-Z]+$/;
	return regex.test(text);
}

function isNatural(text)
{
	var regex = /^([1-9]\d*)?$/;
	return regex.test(text);
}

function isDecimal(text)
{
	var regex = /^\d*(\.\d+)?$/;
	return regex.test(text);
}