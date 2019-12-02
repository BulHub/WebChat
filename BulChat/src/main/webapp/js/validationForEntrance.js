function validateForm() {
    let password1 = document.getElementById('password');
    let email = document.getElementById('email');
    let error = '';
    let email_regexp = /[0-9a-zа-я_A-ZА-Я]+@[0-9a-zа-я_A-ZА-Я^.]+\.[a-zа-яА-ЯA-Z]{2,4}/i;
    if (!email_regexp.test(email.value)) {
        error+='Email is entered incorrectly! \n';
    }
    if (password1.value.length < 6 || password1.value.length > 30){
        error+='Password must be between 6 and 30 characters! \n';
    }
    if (error !== '') {
        alert(error);
        return false;
    }else {
        let form = document.getElementById("form");
        form.submit();
    }
}