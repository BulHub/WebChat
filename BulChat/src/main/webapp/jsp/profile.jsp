<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cookie">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/aboutMyself.css">
</head>
<body>
<nav class="navbar navbar-light navbar-expand-md custom-header">
    <div class="container-fluid"><a class="navbar-brand" href="#">Bul<span>Chat</span> </a>
        <button class="navbar-toggler" data-toggle="collapse" data-target="#navbar-collapse"><span class="sr-only">Toggle navigation</span><span
                class="navbar-toggler-icon"></span></button>
        <div
                class="collapse navbar-collapse" id="navbar-collapse">
            <ul class="nav navbar-nav links">
                <li class="nav-item" role="presentation"><a class="nav-link"
                                                            href="${pageContext.request.contextPath}/chat">Chat</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link"
                                                            href="#">Profile</a>
                </li>
                <li class="nav-item" role="presentation"><a class="nav-link"
                                                            href="${pageContext.request.contextPath}/developers">Developers</a>
                </li>
                <li class="nav-item" role="presentation"><a class="nav-link custom-navbar"
                                                            href="${pageContext.request.contextPath}/feedback">Feedback<span
                        class="badge badge-pill badge-primary"></span></a></li>
            </ul>
            <ul class="nav navbar-nav ml-auto">
                <li class="dropdown"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false"
                                        href="#"> <img src="img/avatar.jpg" class="dropdown-image">&nbsp;
                    ${nickname}</a>
                    <div class="dropdown-menu dropdown-menu-right" role="menu"><a class="dropdown-item"
                                                                                  role="presentation"
                                                                                  href="${pageContext.request.contextPath}/settings/aboutMyself">Settings </a><a
                            class="dropdown-item"
                            role="presentation"
                            href="${pageContext.request.contextPath}/entrance">Logout </a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>
<p class="text-center" style="font-size: 32px"><a style="color: blue">${look}</a></p>
<div style="align-content: center">
    <table class="table" style="max-width: 80%; left: 10%; " >
        <thead class="thead-inverse">
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Data</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">1</th>
            <td>Name</td>
            <td>${name}</td>
        </tr>
        <tr>
            <th scope="row">2</th>
            <td>Surname</td>
            <td>${surname}</td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>Patronymic</td>
            <td>${patronymic}</td>
        </tr>
        <tr>
            <th scope="row">4</th>
            <td>Phone</td>
            <td>${phone}</td>
        </tr>
        <tr>
            <th scope="row">5</th>
            <td>DateOfBirth</td>
            <td>${dateOfBirth}</td>
        </tr>
        <tr>
            <th scope="row">6</th>
            <td>Gender</td>
            <td>${gender}</td>
        </tr>
        <tr>
            <th scope="row">7</th>
            <td>Country</td>
            <td>${country}</td>
        </tr>
        </tbody>
    </table>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>

</body>
</html>
