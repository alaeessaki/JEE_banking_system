<%@page import="Model.Client"%>
<%@page import="java.util.ArrayList"%>
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
    	ArrayList<Client> clients = new ArrayList<Client>();
    	clients = (ArrayList<Client>) request.getAttribute("clients");
    	%>
        <nav class="navbar navbar-expand navbar-dark bg-primary">
            <div class="nav navbar-nav">
                  <a class="navbar-brand m-auto" href="index.html">Kowareta</a>
                <a class="nav-item nav-link active ml-5" href="index.html">Home<span class="sr-only">(current)</span></a>
            </div>
            <div class="ml-auto">
               <a class="btn btn-success btn-sm m-auto" href="create-client.html" role="button">Create Account</a>
            </div>
        </nav>
    
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-striped m-auto">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Nom :</th>
                                <th scope="col">Prenom :</th>
                                <th scope="col">CIN :</th>
                                <th scope="col">Action :</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<% for(int i = 0; i<clients.size(); i++){ %>
                            <tr>
                                <td scope="row" class="align-middle" > <% out.print(clients.get(i).getId()); %></td>
                                <td class="align-middle"> <% out.print(clients.get(i).getNom()); %></td>
                                <td class="align-middle"> <% out.print(clients.get(i).getPrenom()); %></td>
                                <td class="align-middle"> <% out.print(clients.get(i).getCIN()); %></td>
                                <td class="align-middle">
                                    <a name="" id="" class="btn btn-primary btn-sm" href="#" role="button">update</a> 
                                    <a name="" id="" class="btn btn-success btn-sm" href="account?client_id=<% out.print(clients.get(i).getId()); %>" role="button">Account details</a> 
                                    <a name="" id="" class="btn btn-danger btn-sm" href="delete-account?id=<% out.print(clients.get(i).getId()); %>" role="button">Delete</a>
                                </td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
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