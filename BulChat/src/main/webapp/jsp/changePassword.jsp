<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ChangePassword</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cookie">
    <link rel="stylesheet" href="<c:url value="/css/changePassword.css"/>">
    <script src="js/validationForChangePassword.js"></script>
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
                                                            href="${pageContext.request.contextPath}/settings/aboutMyself">About
                    myself</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="#">Change Password</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link"
                                                            href="${pageContext.request.contextPath}/developers">Developers</a>
                </li>
                <li class="nav-item" role="presentation"><a class="nav-link custom-navbar"
                                                            href="${pageContext.request.contextPath}/feedback">Feedback</a>
                </li>
            </ul>
            <ul class="nav navbar-nav ml-auto">
                <li class="dropdown"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false"
                                        href="#"> <img src="<c:url value="/img/avatar.jpg"/>" class="dropdown-image">&nbsp;
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
<form class="form-horizontal" method="post" autocomplete="off" id="form5">
    <fieldset>

        <legend></legend>
        <p class="text-center" style="font-size: 32px"><a style="color: blue">${change}</a></p>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="email">Email:</label>
            <div class="col-md-4">
                <input id="email" name="email" type="text" placeholder="Write email" class="form-control input-md"
                       required="">

            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="oldPassword">Old password:</label>
            <div class="col-md-4">
                <input id="oldPassword" name="oldPassword" type="password" placeholder="Write old password"
                       class="form-control input-md" required="">

            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="newPassword">New password:</label>
            <div class="col-md-4">
                <input id="newPassword" name="newPassword" type="password" placeholder="Write a new password"
                       class="form-control input-md" required="">

            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="newRePassword">New re-password:</label>
            <div class="col-md-4">
                <input id="newRePassword" name="newRePassword" type="password" placeholder="Write a new re-password"
                       class="form-control input-md" required="">

            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="enter"></label>
            <div class="col-md-4">
                <button id="enter" name="enter" class="btn btn-primary" onclick="return validateForm5()">Enter</button>
            </div>
        </div>

    </fieldset>
</form>
<%@ include file="end.jsp" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
</body>

</html>