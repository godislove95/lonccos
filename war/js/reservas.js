$(document).ready(function(){
	$("#reservar").submit(function(event) {
		event.preventDefault();
		var $form = $(this),
		hora = $form.find( "input[name='hora']" ).val(),
		numero = $form.find( "input[name='numero']" ).val(),
		lugar = $form.find( "input[name='lugar']" ).val(),
		zona = $form.find( "input[name='zona']" ).val(),
		fecha = $form.find( "input[name='fecha']" ).val(),
		paterno = $form.find( "input[name='paterno']" ).val(),
	    url = $form.attr( "action" );
		$("#cuerpo").html('<img id="cargando" alt="cargando" src="img/cargando.gif">');
		$.ajax({
            type: "post",
            url: url,
            data: {"hora": hora, "numero": numero, "lugar": lugar, "zona": zona, "tipo": "beta", "fecha": fecha},
            success: function(data){
            	$("#cuerpo").html(data);
            }
        });
	});
});