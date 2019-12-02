<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <title>Chat</title>
    <style>
        body {
            background-color: #333;
            font-size: 1.5em;
            padding: 0 0.25em;
        }

        pre {
            background: #FDBCB4;
            white-space: pre-wrap;
            word-wrap: break-word;
            text-shadow: 0 0 10px #ccc;

        }

        #input {
            border-bottom: 1px solid #ccc;
            background-color: #dadada;
            padding: 0.25em;
            outline: 0;
        }

        #input::before {
            content: "> ";
        }
    </style>
    <script src="https://chr15m.github.io/bugout/bugout.min.js" type="application/javascript"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cookie">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700">
    <link rel="stylesheet" href="css/chat.css">
    <script>
        function log(message) {
            document.getElementById("log").textContent += message + "\n";
        }
    </script>
</head>
<body>
<div></div>
<nav class="navbar navbar-light navbar-expand-md custom-header">
    <div class="container-fluid"><a class="navbar-brand" href="#">Bul<span>Chat</span> </a>
        <button class="navbar-toggler" data-toggle="collapse" data-target="#navbar-collapse"><span class="sr-only">Toggle navigation</span><span
                class="navbar-toggler-icon"></span></button>
        <div
                class="collapse navbar-collapse" id="navbar-collapse">
            <ul class="nav navbar-nav links">
                <li class="nav-item" role="presentation"><a class="nav-link" href="#">Chat</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link"
                                                            href="${pageContext.request.contextPath}/profile">Profile</a>
                </li>
                <li class="nav-item" role="presentation"><a class="nav-link"
                                                            href="${pageContext.request.contextPath}/feedback">Feedback</a>
                </li>
                <li class="nav-item" role="presentation"><a class="nav-link custom-navbar"
                                                            href="${pageContext.request.contextPath}/developers">Developers<span
                        class="badge badge-pill badge-primary"></span></a></li>
            </ul>
            <ul class="nav navbar-nav ml-auto">
                <li class="dropdown"><a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false">
                    <img src="img/avatar.jpg" class="dropdown-image">&nbsp; ${nickname}</a>
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
<pre id="log"></pre>
<pre id="input" contenteditable="true"></pre>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
</body>
<script>
    log("Welcome to the chat!");
    log("Chat will become operational when at least 2 users log into it!");

    var b = Bugout("bugout-chat-tutorial");
    b.on("message", function(address, message) {
        log(address + ": " + message);
    });
    b.on("seen", function(address) { log(address + " [ This is a different user! ]"); });
    log(b.address() + " [ It is you! ]");

    document.getElementById("input").onkeydown = function(ev) {
        if (ev.keyCode === 13) {
            if (b.lastwirecount) {
                b.send(ev.target.textContent);
                ev.target.textContent = "";
            }
            ev.preventDefault();
        }
    }

</script>
</html>