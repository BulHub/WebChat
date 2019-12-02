function validateForm3() {
    let name = document.getElementById('name');
    let email_regexp = /[0-9a-zа-я_A-ZА-Я]+@[0-9a-zа-я_A-ZА-Я^.]+\.[a-zа-яА-ЯA-Z]{2,4}/i;
    let email = document.getElementById('email');
    let message = document.getElementById('message');
    let error = '';
    if (name.value.trim() === ''){
        error+='The name must not be empty! \n';
    }
    if (!email_regexp.test(email.value)) {
        error+='Email is entered incorrectly! \n';
    }
    if (message.value.trim() === ''){
        error+='The message must not be empty! \n';
    }
    if (error !== '') {
        alert(error);
        return false;
    }else {
        let form = document.getElementById("form3");
        form.submit();
    }
}