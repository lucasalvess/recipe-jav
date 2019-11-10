
function goBack(){
	window.history.back();
}

function acessaReceita($id){
	document.location.href='receita.php?r='+$id;
}

$(function(){

	$("select").dashboardCodeBsMultiSelect();
});