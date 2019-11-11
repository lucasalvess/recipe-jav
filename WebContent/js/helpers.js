
function goBack(){
	window.history.back();
}

function acessaReceita($id){
	document.location.href='receita.jsp?r='+$id;
}

$(function(){

	$("select").dashboardCodeBsMultiSelect();
});