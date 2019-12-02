<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="css/entrance.css">
    <script src="js/validationForEntrance.js"></script>
</head>

<body>
<div class="login-dark">
    <form method="post" autocomplete="off" id="form">
        <h2 class="sr-only">Login Form</h2>
        <div class="illustration"><i class="icon ion-ios-locked-outline"></i></div>
        <div class="form-group"><input style="color:yellow" class="form-control" type="email" name="email" id="email" placeholder="Email" required="required" max="30"></div>
        <div class="form-group"><input style="color: yellow" class="form-control" type="password" name="password" id="password" placeholder="Password" required="required"
        min="6" max="30">
        </div>
        <div class="form-group">
            <button class="btn btn-primary btn-block" type="submit" onclick="return validateForm()">Log In</button>
        </div>
        <a href="${pageContext.request.contextPath}/registration" class="forgot">You aren't registered? Register here&nbsp;<br></a></form>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>

</body>

</html>