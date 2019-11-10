	document.addEventListener("DOMContentLoaded", function(){
	tail.select("select", { /* Your Options */ });
});

	$(document).ready(function(){
		$('#ingredientes').multiselect({
			nonSelectedText: 'Select ingredientes',
			enableFiltering: true,
			enableCaseInsensitiveFiltering: true,
			buttonWidth:'400px'
		});

		$('#form_receita').on('submit', function(event){
			event.preventDefault();
			var form_data = $(this).serialize();
			$.ajax({
				url:"controller/salvaReceitaController.php",
				method:"POST",
				data:form_data,
				success:function(data)
				{
					$('#ingredientes option:selected').each(function(){
						$(this).prop('selected', false);
					});
					$('#ingredientes').multiselect('refresh');
					alert(data);
				}
			});
		});


	});