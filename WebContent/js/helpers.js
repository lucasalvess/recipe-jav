
function goBack(){
	window.history.back();
}

function acessaReceita($id){
	document.location.href='acessaReceita?r='+$id;
}

$(function(){

	$("select").dashboardCodeBsMultiSelect();
});