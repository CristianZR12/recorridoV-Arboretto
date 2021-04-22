$(() => {
	
	const addUser = () => {
		
		const formulario = $('#signUpU');
		
		formulario.submit((e) => {
			e.preventDefault();
			$.ajax({
				url: "./SLGuardarUsuario",
				type: "POST",
				success: (response) => {
					localStorage.setItem("mensaje", response);
				}
			});
		});


	}
	
	addUser();
});