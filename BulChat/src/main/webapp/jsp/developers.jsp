<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Developers</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cookie">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/developers.css">
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
                <li class="nav-item" role="presentation"><a class="nav-link" href="#">Developers</a></li>
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
<section class="home-team">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col col-md-8">
                <div class="sectionTitle text-center">
                    <h2>Our Professionals </h2>
                    <p>People without whom you would not see this site. Thanks to them.</p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 col-lg-3">
                <div class="card card-style2 team-card">
                    <div class="card_img"><img class="img-fluid img-full loaded" src="img/team1.jpg" alt="Team one"
                                               data-original="img/team1.jpg" data-was-processed="true">
                        <div class="hover-overlay effect-scale"><a href="#" class="overlay_icon"><i
                                class="fa fa-facebook"></i></a><a href="#" class="overlay_icon"><i
                                class="fa fa-twitter"></i></a><a href="#" class="overlay_icon"><i
                                class="fa fa-linkedin"></i></a></div>
                    </div>
                    <div class="card-block">
                        <h4 class="card-title">Bulat Bilalov</h4><span>Team leader</span></div>
                </div>
            </div>
            <div class="col-md-6 col-lg-3">
                <div class="card card-style2 team-card">
                    <div class="card_img"><img class="img-fluid img-full loaded" src="img/team2.jpg" alt="Team one"
                                               data-original="img/team1.jpg" data-was-processed="true">
                        <div class="hover-overlay effect-scale"><a href="#" class="overlay_icon"><i
                                class="fa fa-facebook"></i></a><a href="#" class="overlay_icon"><i
                                class="fa fa-twitter"></i></a><a href="#" class="overlay_icon"><i
                                class="fa fa-linkedin"></i></a></div>
                    </div>
                    <div class="card-block">
                        <h4 class="card-title">Sky</h4><span>Financial support</span></div>
                </div>
            </div>
            <div class="col-md-6 col-lg-3">
                <div class="card card-style2 team-card">
                    <div class="card_img"><img class="img-fluid img-full loaded" src="img/team3.jpg" alt="Team one"
                                               data-original="img/team1.jpg" data-was-processed="true">
                        <div class="hover-overlay effect-scale"><a href="#" class="overlay_icon"><i
                                class="fa fa-facebook"></i></a><a href="#" class="overlay_icon"><i
                                class="fa fa-twitter"></i></a><a href="#" class="overlay_icon"><i
                                class="fa fa-linkedin"></i></a></div>
                    </div>
                    <div class="card-block">
                        <h4 class="card-title">Buddy pie<br></h4><span>Protective support</span></div>
                </div>
            </div>
            <div class="col-md-6 col-lg-3">
                <div class="card card-style2 team-card">
                    <div class="card_img"><img class="img-fluid img-full loaded" src="img/team4.jpg" alt="Team one"
                                               data-original="img/team1.jpg" data-was-processed="true">
                        <div class="hover-overlay effect-scale"><a href="#" class="overlay_icon"><i
                                class="fa fa-facebook"></i></a><a href="#" class="overlay_icon"><i
                                class="fa fa-twitter"></i></a><a href="#" class="overlay_icon"><i
                                class="fa fa-linkedin"></i></a></div>
                    </div>
                    <div class="card-block">
                        <h4 class="card-title">Mr. Carrot</h4><span>Food Support</span></div>
                </div>
            </div>
        </div>
    </div>
</section>
<%@ include file="end.jsp" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
</body>

</html>