$(function () {
    $('#delete').click(function () {
        $.ajax({
            url: '/api/accounts', headers: {
                'Accept': 'application/json', 'Content-Type': 'application/json'
            }, type: 'POST', data: JSON.stringify({
                'id': $('#id').val().remove(), 'owner': $('#owner').val().remove(),
                'balance': $('#balance').val().remove()
            }), success: [function () {
                alert('Удаление прошло успешно!');
            }], error: [function (xhr, status, error) {
                alert(xhr.responseJSON.error.message);
            }]
        });
    });
})