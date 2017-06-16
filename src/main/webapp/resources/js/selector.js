$( "#instrumentType_select" ).change(function() {

	$('.visible-print-block').removeClass('visible-print-block');
	
	var option_val = $( '#instrumentType_select' ).val();
	switch (option_val) {
	case "Unspecified" :
	case "Guitar" :
	break;
	case "Mandolin" :
		$('#numStrings').addClass('visible-print-block');
	break;
	case "Banjo" :
		$('#topWood').addClass('visible-print-block');
	break;
	default :
		alert("준비중입니다");
	break;
	}
});

$("#btn-submit").click(function() { 
	
	var instrumentType = $('#instrumentType_select').val();
	
	var serialNumber = $('#serialNumber_input').val();
	var price = $('#price_input').val();
	var model = $('#model_input').val();
	var numStrings = $('#numStrings_input').val();
	
	var builder = $('#builder_select').val();
	var type = $('#type_select').val();
	var topWood = $('#topWood_select').val();
	var backWood = $('#backWood_select').val();
	
	
	if( !isDecimal(price) ){
		alert("가격은 숫자(소수 가능)만 입력이 가능합니다");
		return false;
	}
	
	if( !isNatural(numStrings) ){
		alert("numStrings는 숫자만 입력이 가능합니다");
		return false;
	}
	
		
	switch (instrumentType) {
	case "Guitar" :
		if( serialNumber && price && model && numStrings )
			return true;
	break;
	case "Mandolin" :
		if( serialNumber && price && model )
			return true;
	break;
	case "Banjo" :
		if( serialNumber && price && model && numStrings )
			return true;
	break;
	default :
		alert("준비중입니다");
		return false;
	break;
	}
	
	
	alert("모두 입력해주세요");
	
	
	return false; 
});
