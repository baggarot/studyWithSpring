$(function () {
    $('#create').click(function () {
        $.ajax({
            url: '/api/accounts', headers: {
                'Accept': 'application/json', 'Content-Type': 'application/json'
            }, type: 'POST', data: JSON.stringify({
                'id': $('#id').val(), 'owner': $('#owner').val(), 'balance': $('#balance').val()
            }), success: [function () {
                alert('Обновление прошло успешно!');
            }], error: [function (xhr, status, error) {
                alert(xhr.responseJSON.error.message);
            }]
        });
    });
});