<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="css/registration.css">
    <script src="js/validationForRegistration.js"></script>
</head>

<body>
<div class="login-dark">
    <form method="post" autocomplete="off" id="form">
        <h2 class="sr-only">Login Form</h2>
        <div class="illustration"><i class="icon ion-ios-locked-outline"></i><input class="form-control" type="text"
                                                                                    max="30" style="color:pink"
                                                                                    placeholder="Nickname"
                                                                                    name="nickname" id="nickname"
                                                                                    required="required"></div>
        <div class="form-group"><input class="form-control" type="text" name="email" id="email" placeholder="Email"
                                       required="required" max="30" style="color:yellow"></div>
        <div class="form-group"><input class="form-control" type="password" name="password" id="password"
                                       placeholder="Password" min="6" max="30" required="required" style="color:yellow">
        </div>
        <input class="form-control" type="password" id="rePassword" style="color:yellow" name="rePassword" placeholder="Re-password"
               required="required" min="6" max="30">
        <div class="form-group">
            <button class="btn btn-primary btn-block" type="submit" onclick="return validateForm()">Sign up <br>
            </button>
        </div>
        <a href="${pageContext.request.contextPath}/entrance" class="forgot">Are you already registered? Login
            here</a></form>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
</body>

</html>