function validateForm() {
    let nickname = document.getElementById('nickname');
    let email_regexp = /[0-9a-zа-я_A-ZА-Я]+@[0-9a-zа-я_A-ZА-Я^.]+\.[a-zа-яА-ЯA-Z]{2,4}/i;
    let email = document.getElementById('email');
    let password1 = document.getElementById('password');
    let password2 = document.getElementById('rePassword');
    let error = '';
    if (nickname.value.length < 6 || nickname.value.length > 30 ){
        error+='Nickname must be between 6 and 30 characters! \n';
    }
    if (!email_regexp.test(email.value)) {
        error+='Email is entered incorrectly! \n';
    }
    if (password1.value.length < 6 || password1.value.length > 30){
        error+='Password must be between 6 and 30 characters! \n';
    }
    if (password1.value !== password2.value) {
        error+='Passwords do not match! \n';
    }
    if (error !== '') {
        alert(error);
        return false;
    }else {
        let form = document.getElementById("form");
        form.submit();
    }
}
