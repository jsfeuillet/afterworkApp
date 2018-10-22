
$(document).ready(function(){
 

});

function registerUser() {
	var data = {
		name: $('#name').val(),
		username: $('#user').val(),
		mail: $('#mail').val()
	};

	$.ajax({
		type: "POST",
		url: "http://localhost:8080/register",
        data: JSON.stringify(data),
        contentType: 'application/json',
  		dataType:"json",

	}).
	done(function(data) {
	  $('#myModal').modal('show');
	  var textToShow = '';
	  if(data.info == 'OK') {
	  	textToShow = 'El usuario se ha registrado con éxito, recibirás un email para confirmar el registro';	  	
	  }
	  else if(data.info == 'NOK_MAIL') {
	  	textToShow = 'El usuario ya existe en el sistema';
	  }
	  else if(data.info == 'NOK_MAIL_BAD') {
	  	textToShow = 'Por favor, intoduzca un mail correcto';
	  }
	  else if(data.info == 'NOK_USER_BAD') {
	  	textToShow = 'Por favor, intoduzca un nombre de usuario solo con múmeros y/o letras';
	  }
	  $('#register-result').text(textToShow);
	});
}