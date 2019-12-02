<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AboutMyself</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cookie">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/aboutMyself.css">
    <script src="js/validationForAboutMyself.js"></script>
</head>

<body>
<nav class="navbar navbar-light navbar-expand-md custom-header">
    <div class="container-fluid"><a class="navbar-brand" href="#">Bul<span>Chat</span> </a>
        <button class="navbar-toggler" data-toggle="collapse" data-target="#navbar-collapse"><span class="sr-only">Toggle navigation</span><span
                class="navbar-toggler-icon"></span></button>
        <div
                class="collapse navbar-collapse" id="navbar-collapse">
            <ul class="nav navbar-nav links">
                <li class="nav-item" role="presentation"><a class="nav-link" href="#">About myself</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link"
                                                            href="${pageContext.request.contextPath}/settings/changePassword">Change
                    Password</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link"
                                                            href="${pageContext.request.contextPath}/developers">Developers</a>
                </li>
                <li class="nav-item" role="presentation"><a class="nav-link custom-navbar"
                                                            href="${pageContext.request.contextPath}/feedback">Feedback</a>
                </li>
            </ul>
            <ul class="nav navbar-nav ml-auto">
                <li class="dropdown"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false"
                                        href="#"> <img src="${pageContext.request.contextPath}/img/avatar.jpg"
                                                       class="dropdown-image" alt="">&nbsp;
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
            <ul class="nav navbar-nav"></ul>
        </div>
    </div>
</nav>

<p></p>
<p></p>
<p class="text-center " style="font-size: 32px">Thank you</p>
<p class="text-center" style="font-size: 32px"><a style="color: blue">for filling</a></p>
<p class="text-center" style="font-size: 32px">and <a class="text-danger">out</a> information </p>
<p class="text-center" style="font-size: 32px"><a class="text-warning"> about </a> about yourself)</p>


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
</body>

</html>
