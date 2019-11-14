<%@page import="Model.Compte"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css">
    <title>Document</title>
</head>

<body>
    <% 
    	Compte compte = (Compte) request.getAttribute("compte");  
    	int compte_id = (int) request.getAttribute("compte_id");
     %>
    <nav class="navbar navbar-expand navbar-dark bg-primary">
        <div class="nav navbar-nav">
            <a class="navbar-brand m-auto" href="index.html">Kowareta</a>
            <a class="nav-item nav-link active ml-5" href="index.html">Home<span class="sr-only">(current)</span></a>
        </div>
        <div class="ml-auto">
            <a class="btn btn-success btn-sm m-auto" href="#" role="button">Create Account</a>
        </div>
    </nav>

    <div class="container mt-3">
        <div class="row">
            <div class="col-2"></div>
            <div class="col-8">
                <div class="card text-white bg-info mb-3" style="max-width: 100%;">
                    <div class="card-header">Add solde to Account N° :<% out.print(compte.getNumero()); %></div>
                    <div class="card-body">
                    <form action="add-solde" method="POST">
                        <div class="card-text d-flex align-items-center mb-3">
                        	<input type="hidden" value="<% out.print(compte_id); %>" name="compte_id">
                           <p class="m-0"> Solde : <% out.print(compte.getSolde()); %> +</p> <input type="number" class="form-control" name="solde-added" id="solde-added" placeholder="add solde">  <p class="ml-2 mb-0">DHS</p>
                        </div>
                        <div class="text-right">
                           <button type="submit" class="btn btn-success btn-sm">Add</button>
                           <button type="reset" class="btn btn-warning btn-sm">reset</button>
                        </div>
					</form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>