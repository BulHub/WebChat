function validateForm4() {
    let name = document.getElementById('name');
    let surname = document.getElementById('surname');
    let patronymic = document.getElementById('patronymic');
    let phone = document.getElementById('phone');
    let data = document.getElementById('date of birth');
    let aboutMyself = document.getElementById('about myself');
    let phone_regexp = /^(\s*)?(\+)?([- _():=+]?\d[- _():=+]?){10,14}(\s*)?$/;
    let data_regexp = /^\d{4}[-]\d{2}[-]\d{2}$/gi;
    let error = '';
    if (name.value.length < 4 || name.value.length > 60 ){
        error+='Name must be between 6 and 60 characters! \n';
    }
    if (surname.value.length < 4 || surname.value.length > 60 ){
        error+='Surname must be between 4 and 60 characters! \n';
    }
    if (patronymic.value.length < 4 || patronymic.value.length > 60 ){
        error+='Patronymic must be between 4 and 60 characters! \n';
    }
    if (!phone_regexp.test(phone.value)) {
        error+='Phone is entered incorrectly!';
    }
    if (!data_regexp.test(data.value)) {
        error+='Data is entered incorrectly! \n';
    }
    if (aboutMyself.value.trim() === ''){
        error+='The message must not be empty! \n';
    }
    if (error !== '') {
        alert(error);
        return false;
    }else {
        let form = document.getElementById("form4");
        form.submit();
    }
}