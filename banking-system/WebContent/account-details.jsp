<%@page import="Model.Client"%>
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
            Client client = (Client) request.getAttribute("client"); 
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
                    <div class="card text-white bg-info mb-3" style="max-width: 50rem;">
                        <div class="card-header">Les informations du compte</div>
                        <div class="card-body">
                            <h4 class="card-title"><% out.print(client.getNom()+" "+client.getPrenom()); %> </h4>
                            <p class="card-text">
                                Nom : <% out.print(client.getNom()); %>
                            </p>
                             <p class="card-text">
                                Prenom : <% out.print(client.getPrenom()); %>
                            </p>
                             <p class="card-text">
                                CIN : <% out.print(client.getCIN()); %>
                            </p>
                             <p class="card-text">
                                Numero du compte : <% out.print(client.getCompte().getNumero()); %>
                            </p>
                             <p class="card-text">
                                Solde : <% out.print(client.getCompte().getSolde()); %>
                            </p>
                            <div class="text-right">
                                <a name="" id="" class="btn btn-success btn-sm" href="add-solde?compte_id=<% out.print(client.getCompte().getId()); %>" role="button">add Solde</a>
                                <a name="" id="" class="btn btn-danger btn-sm" href="delete-account?id=<%out.print(client.getId());%>" role="button">Delete</a>
                            </div>
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