<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Feedback</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cookie">
    <link rel="stylesheet" href="css/feedback.css">
    <script src="js/validationForFeedback.js"></script>
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
                                                            href="${pageContext.request.contextPath}/profile">Profile</a>
                </li>
                <li class="nav-item" role="presentation"><a class="nav-link"
                                                            href="${pageContext.request.contextPath}/developers">Developers</a>
                </li>
                <li class="nav-item" role="presentation"><a class="nav-link custom-navbar"
                                                            href="#">Feedback<span
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
<div class="contact-clean">
    <form method="post" id="form3" autocomplete="off">
        <h2 class="text-center">Contact us</h2>
        <p>${help}</p>
        <div class="form-group"><input class="form-control" type="text" name="name" id="name" placeholder="Name"></div>
        <div class="form-group"><input class="form-control is-invalid" type="email" name="email" id="email"
                                       placeholder="Email">
            <small class="form-text text-danger">Please enter a correct email address.</small>
        </div>
        <div class="form-group"><textarea class="form-control" rows="14" name="message" id="message"
                                          placeholder="Message"></textarea></div>
        <div class="form-group">
            <button class="btn btn-primary" type="submit" onclick="return validateForm3()">send</button>
        </div>
    </form>
</div>
<%@ include file="end.jsp" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
</body>

</html>