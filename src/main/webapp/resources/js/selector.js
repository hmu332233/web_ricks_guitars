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
