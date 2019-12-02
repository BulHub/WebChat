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

<form method="post" class="form-horizontal" autocomplete="off" id="form4">
    <fieldset>

        <!-- Form Name -->
        <legend></legend>
        <p class="text-center" style="font-size: 32px"><a style="color: blue">${help}</a></p>

        <div class="form-group">
            <label class="col-md-4 control-label" for="groups">Groups:</label>
            <div class="col-md-4">
                <select id="groups" name="groups" class="form-control" multiple="multiple">
                    <option value="Cartoon lovers">Cartoon lovers</option>
                    <option value="TV lovers">TV lovers</option>
                    <option value="Movie lovers">Movie lovers</option>
                    <option value="Anime lovers">Anime lovers</option>
                    <option value="Board game lovers">Board game lovers</option>
                    <option value="Love programming">Love programming</option>
                </select>
            </div>
        </div>

        <!--New!!!-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="newGroup">Create new group:</label>
            <div class="col-md-4">
                <input id="newGroup" name="newGroup" type="text" placeholder="Write a new group"
                       class="form-control input-md" min="3" max="30">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="name">Name:</label>
            <div class="col-md-4">
                <input id="name" name="name" type="text" placeholder="Write a name" class="form-control input-md"
                       required="required">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="surname">Surname:</label>
            <div class="col-md-4">
                <input id="surname" name="surname" type="text" placeholder="Write last name"
                       class="form-control input-md" required="required">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="patronymic">Patronymic:</label>
            <div class="col-md-4">
                <input id="patronymic" name="patronymic" type="text" placeholder="Write middle name"
                       class="form-control input-md" required="required">

            </div>
        </div>

        <!-- Phone input -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="phone">Telephone number: </label>
            <div class="col-md-4">
                <input id="phone" name="phone" type="tel" placeholder="+X-XXX-XXX-XXXX" class="form-control input-md"
                       required="required">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="date of birth">Date of Birth:</label>
            <div class="col-md-4">
                <input id="date of birth" name="date of birth" type="date" placeholder="Write the date of birth"
                       class="form-control input-md" required="required">

            </div>
        </div>

        <!-- Multiple Radios -->
        <div class="form-group">
            <label class="col-md-4 control-label">Gender:</label>
            <div class="col-md-4">
                <div class="radio">
                    <label for="gender-0">
                        <input type="radio" name="gender" id="gender-0" value="Male" checked="checked"
                               required="required">
                        Male
                    </label>
                </div>
                <div class="radio">
                    <label for="gender-1">
                        <input type="radio" name="gender" id="gender-1" value="Female">
                        Female
                    </label>
                </div>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="country">Country:</label>
            <div class="col-md-4">
                <select id="country" name="country" class="form-control" required="required">
                    <option value="1">Afghanistan</option>
                    <option value="2">Albania</option>
                    <option value="3">Algeria</option>
                    <option value="4">Andorra</option>
                    <option value="5">Angola</option>
                    <option value="6">Antigua and Barbuda</option>
                    <option value="7">Argentina</option>
                    <option value="8">Armenia</option>
                    <option value="9">Australia</option>
                    <option value="10">Austria</option>
                    <option value="11">Austrian Empire</option>
                    <option value="12">Azerbaijan</option>
                    <option value="13">Baden*</option>
                    <option value="14">Bahrain</option>
                    <option value="15">Bangladesh</option>
                    <option value="16">Barbados</option>
                    <option value="17">Bavaria*</option>
                    <option value="18">Belarus</option>
                    <option value="19">Belgium</option>
                    <option value="20">Belize</option>
                    <option value="21">Benin (Dahomey)</option>
                    <option value="22">Bolivia</option>
                    <option value="23">Bosnia and Herzegovina</option>
                    <option value="24">Botswana</option>
                    <option value="25">Brazil</option>
                    <option value="26">Brunei</option>
                    <option value="27">Brunswick and Lüneburg</option>
                    <option value="28">Bulgaria</option>
                    <option value="29">Burkina Faso (Upper Volta)</option>
                    <option value="30">Burma</option>
                    <option value="31">Burundi</option>
                    <option value="32">Cabo Verde</option>
                    <option value="33">Cambodia</option>
                    <option value="34">Cameroon</option>
                    <option value="35">Canada</option>
                    <option value="36">Central African Republic</option>
                    <option value="37">Central American Federation*</option>
                    <option value="38">Chad</option>
                    <option value="39">Chile</option>
                    <option value="40">China</option>
                    <option value="41">Colombia</option>
                    <option value="42">Comoros</option>
                    <option value="43">Costa Rica</option>
                    <option value="44">Cote d’Ivoire (Ivory Coast)</option>
                    <option value="45">Croatia</option>
                    <option value="46">Cuba</option>
                    <option value="47">Cyprus</option>
                    <option value="48">Czechia</option>
                    <option value="49">Czechoslovakia</option>
                    <option value="50">Democratic Republic of the Congo</option>
                    <option value="51">Denmark</option>
                    <option value="52">Djibouti</option>
                    <option value="53">Dominica</option>
                    <option value="54">Dominican Republic</option>
                    <option value="55">East Germany (German Democratic Republic)</option>
                    <option value="56">Ecuador</option>
                    <option value="57">Egypt</option>
                    <option value="58">El Salvador</option>
                    <option value="59">Equatorial Guinea</option>
                    <option value="60">Eritrea</option>
                    <option value="61">Estonia</option>
                    <option value="62">Eswatini</option>
                    <option value="63">Ethiopia</option>
                    <option value="64">Federal Government of Germany (1848-49)*</option>
                    <option value="65">Fiji</option>
                    <option value="66">Finland</option>
                    <option value="67">France</option>
                    <option value="68">Gabon</option>
                    <option value="69">Georgia</option>
                    <option value="70">Germany</option>
                    <option value="71">Ghana</option>
                    <option value="72">Greece</option>
                    <option value="73">Grenada</option>
                    <option value="74">Guatemala</option>
                    <option value="75">Guinea</option>
                    <option value="76">Guinea-Bissau</option>
                    <option value="77">Guyana</option>
                    <option value="78">Haiti</option>
                    <option value="79">Hanover*</option>
                    <option value="80">Hanseatic Republics*</option>
                    <option value="81">Hawaii*</option>
                    <option value="82">Hesse*</option>
                    <option value="83">Holy See</option>
                    <option value="84">Honduras</option>
                    <option value="85">Hungary</option>
                    <option value="86">Iceland</option>
                    <option value="87">India</option>
                    <option value="88">Indonesia</option>
                    <option value="89">Iran</option>
                    <option value="90">Iraq</option>
                    <option value="91">Ireland</option>
                    <option value="92">Israel</option>
                    <option value="93">Italy</option>
                    <option value="94">Jamaica</option>
                    <option value="95">Japan</option>
                    <option value="96">Jordan</option>
                    <option value="97">Kazakhstan</option>
                    <option value="98">Kenya</option>
                    <option value="99">Kingdom of Serbia/Yugoslavia*</option>
                    <option value="100">Kiribati</option>
                    <option value="101">Korea</option>
                    <option value="102">Kosovo</option>
                    <option value="103">Kuwait</option>
                    <option value="104">Kyrgyzstan</option>
                    <option value="105">Laos</option>
                    <option value="106">Latvia</option>
                    <option value="107">Lebanon</option>
                    <option value="108">Lesotho</option>
                    <option value="109">Lew Chew (Loochoo)*</option>
                    <option value="110">Liberia</option>
                    <option value="111">Libya</option>
                    <option value="112">Liechtenstein</option>
                    <option value="113">Lithuania</option>
                    <option value="114">Luxembourg</option>
                    <option value="115">Madagascar</option>
                    <option value="116">Malawi</option>
                    <option value="117">Malaysia</option>
                    <option value="118">Maldives</option>
                    <option value="119">Mali</option>
                    <option value="120">Malta</option>
                    <option value="121">Marshall Islands</option>
                    <option value="122">Mauritania</option>
                    <option value="123">Mauritius</option>
                    <option value="124">Mecklenburg-Schwerin*</option>
                    <option value="125">Mecklenburg-Strelitz*</option>
                    <option value="126">Mexico</option>
                    <option value="127">Micronesia</option>
                    <option value="128">Moldova</option>
                    <option value="129">Monaco</option>
                    <option value="130">Mongolia</option>
                    <option value="131">Montenegro</option>
                    <option value="132">Morocco</option>
                    <option value="133">Mozambique</option>
                    <option value="134">Namibia</option>
                    <option value="135">Nassau*</option>
                    <option value="136">Nauru</option>
                    <option value="137">Nepal</option>
                    <option value="138">New Zealand</option>
                    <option value="139">Nicaragua</option>
                    <option value="140">Niger</option>
                    <option value="141">Nigeria</option>
                    <option value="142">North German Confederation*</option>
                    <option value="143">North German Union*</option>
                    <option value="144">North Macedonia</option>
                    <option value="145">Norway</option>
                    <option value="146">Oldenburg*</option>
                    <option value="147">Oman</option>
                    <option value="148">Orange Free State*</option>
                    <option value="149">Pakistan</option>
                    <option value="150">Palau</option>
                    <option value="151">Panama</option>
                    <option value="152">Papal States*</option>
                    <option value="153">Papua New Guinea</option>
                    <option value="154">Paraguay</option>
                    <option value="155">Peru</option>
                    <option value="156">Philippines</option>
                    <option value="157">Piedmont-Sardinia*</option>
                    <option value="158">Poland</option>
                    <option value="159">Portugal</option>
                    <option value="160">Qatar</option>
                    <option value="161">Republic of Genoa*</option>
                    <option value="162">Republic of Korea (South Korea)</option>
                    <option value="163">Republic of the Congo</option>
                    <option value="164">Romania</option>
                    <option value="165">Russia</option>
                    <option value="166">Rwanda</option>
                    <option value="167">Saint Kitts and Nevis</option>
                    <option value="168">Saint Lucia</option>
                    <option value="169">Saint Vincent and the Grenadines</option>
                    <option value="170">Samoa</option>
                    <option value="171">San Marino</option>
                    <option value="172">Sao Tome and Principe</option>
                    <option value="173">Saudi Arabia</option>
                    <option value="174">Schaumburg-Lippe*</option>
                    <option value="175">Senegal</option>
                    <option value="176">Serbia</option>
                    <option value="177">Seychelles</option>
                    <option value="178">Sierra Leone</option>
                    <option value="179">Singapore</option>
                    <option value="180">Slovakia</option>
                    <option value="181">Slovenia</option>
                    <option value="182">Somalia</option>
                    <option value="183">South Africa</option>
                    <option value="184">South Sudan</option>
                    <option value="185">Spain</option>
                    <option value="186">Sri Lanka</option>
                    <option value="187">Sudan</option>
                    <option value="188">Suriname</option>
                    <option value="189">Sweden</option>
                    <option value="190">Switzerland</option>
                    <option value="191">Syria</option>
                    <option value="192">Tajikistan</option>
                    <option value="193">Tanzania</option>
                    <option value="194">Texas*</option>
                    <option value="195">Thailand</option>
                    <option value="196">The Bahamas</option>
                    <option value="197">The Cayman Islands</option>
                    <option value="198">The Congo Free State</option>
                    <option value="199">The Duchy of Parma*</option>
                    <option value="200">The Gambia</option>
                    <option value="201">The Grand Duchy of Tuscany*</option>
                    <option value="202">The Netherlands</option>
                    <option value="203">The Solomon Islands</option>
                    <option value="204">The United Arab Emirates</option>
                    <option value="205">The United Kingdom</option>
                    <option value="206">Timor-Leste</option>
                    <option value="207">Togo</option>
                    <option value="208">Tonga</option>
                    <option value="209">Trinidad and Tobago</option>
                    <option value="210">Tunisia</option>
                    <option value="211">Turkey</option>
                    <option value="212">Turkmenistan</option>
                    <option value="213">Tuvalu</option>
                    <option value="214">Two Sicilies*</option>
                    <option value="215">Uganda</option>
                    <option value="216">Ukraine</option>
                    <option value="217">Union of Soviet Socialist Republics*</option>
                    <option value="218">Uruguay</option>
                    <option value="219">Uzbekistan</option>
                    <option value="220">Vanuatu</option>
                    <option value="221">Venezuela</option>
                    <option value="222">Vietnam</option>
                    <option value="223">Württemberg*</option>
                    <option value="224">Yemen</option>
                    <option value="225">Zambia</option>
                    <option value="226">Zimbabwe</option>
                </select>
            </div>
        </div>

        <!-- Textarea -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="about myself">About myself:</label>
            <div class="col-md-4">
                <textarea style="width:400px; height:200px;" class="form-control" id="about myself" name="about myself"
                          required="required">I like ...</textarea>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4">
                <div class="checkbox">
                    <label for="agree-0">
                        <input type="checkbox" name="agree" id="agree-0" value="1" required="required">
                        I agree to the processing of personal data
                    </label>
                </div>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="enter"></label>
            <div class="col-md-4">
                <button type="submit" id="enter" name="enter" class="btn btn-primary" onclick="return validateForm4()">Enter
                </button>
            </div>
        </div>

    </fieldset>
</form>
<%@ include file="end.jsp" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
</body>

</html>