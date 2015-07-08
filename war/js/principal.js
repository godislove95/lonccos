$(document).ready(function(){
	var i = 0;
	function slider(){
		switch (i % 3) {
		case 1:
			$("#slider").html('<img class="cambio" src="img/slider1.png">');
			break;
		case 2:
			$("#slider").html('<img class="cambio" src="img/slider2.png">');
			break;
		default:
			$("#slider").html('<img class="cambio" src="img/slider3.png">');
			break;
		}
		i++;
	}
	setInterval(function(){slider()}, 4000);
	
	// Attach a submit handler to the form
	$( "#searchForm" ).submit(function( event ) {
	 
	  // Stop form from submitting normally
	  event.preventDefault();
	 
	  // Get some values from elements on the page:
	  var $form = $( this ),
	    term = $form.find( "input[name='s']" ).val(),
	    url = $form.attr( "action" );
	 
	  // Send the data using post
	  var posting = $.post( url, { s: term } );
	 
	  // Put the results in a div
	  posting.done(function( data ) {
	    var content = $( data ).find( "#content" );
	    $( "#result" ).empty().append( content );
	  });
	});
	
});