$(document).ready(function() {
    $('#inputText').blur(function() {
        let val = $(this).val();
        if (!val) {
            $('#errorLabel').attr('style', 'display: block');
        } else {
            $('#errorLabel').hide();
        }
    });
});