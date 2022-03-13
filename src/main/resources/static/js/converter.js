$(function () {
    $('#convert').click(function () {
        let valute = $('#valute').val();
        let currency = $('#currency').val();

        $.ajax({
            type: 'POST',
            url: '/currencyConverter/converter?valute=' + valute + '&currency=' + currency,
            success: [
                function (result) {
                    $('#result').text('Сумма денежных средств по курсу равна: ' + result.value);
                }
            ]
        });
    });
});