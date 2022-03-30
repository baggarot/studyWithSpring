$(function () {
    $('#update').click(function () {
        $.ajax({
            url: '/api/accounts', headers: {
                'Accept': 'application/json', 'Content-Type': 'application/json'
            }, type: 'POST', data: JSON.stringify({
                'id': $('#id').val().replaceAll, 'owner': $('#owner').val().replaceAll,
                'balance': $('#balance').val().replaceAll
            }), success: [function () {
                alert('Обновление прошло успешно!');
            }], error: [function (xhr, status, error) {
                alert(xhr.responseJSON.error.message);
            }]
        });
    });
})