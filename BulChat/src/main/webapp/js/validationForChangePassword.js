function validateForm5() {
    let email = document.getElementById('email');
    let email_regexp = /[0-9a-zа-я_A-ZА-Я]+@[0-9a-zа-я_A-ZА-Я^.]+\.[a-zа-яА-ЯA-Z]{2,4}/i;
    let oldPassword = document.getElementById('oldPassword');
    let newPassword = document.getElementById('newPassword');
    let newRePassword = document.getElementById('newRePassword');
    let error = '';

    if (!email_regexp.test(email.value)) {
        error+='Email is entered incorrectly! \n';
    }
    if (oldPassword.value.length < 6 || oldPassword.value.length > 30){
        error+='Old password must be between 6 and 30 characters! \n';
    }
    if (newPassword.value.length < 6 || newPassword.value.length > 30){
        error+='New password must be between 6 and 30 characters! \n';
    }
    if (newPassword.value !== newRePassword.value) {
        error+='Passwords do not match! \n';
    }
    if (error !== '') {
        alert(error);
        return false;
    }else {
        let form = document.getElementById("form5");
        form.submit();
    }
}