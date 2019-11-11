<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="br.com.dasa.recipe.model.Receita"%>
<%@page import="br.com.dasa.recipe.controller.ReceitaController"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="pt-br">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=iso-8859-1" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="src/bootstrap-4.3.1-dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

	<!-- Sweet Alerts -->
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>

	<!-- Helpes -->
	<script type="text/javascript" src="js/helpers.js"></script>
	<link rel="stylesheet" type="text/css" href="css/fonts.css">

	<!-- Animate CSS -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.2/animate.min.css">
	<title>Re-cipe</title>

	<!-- Font -->
	<link href="https://fonts.googleapis.com/css?family=Lobster|Poppins&display=swap" rel="stylesheet">

	<link rel="stylesheet" type="text/css" href="tail.select\tail.select-default.min.css">

</head>
<body class="poppins">
