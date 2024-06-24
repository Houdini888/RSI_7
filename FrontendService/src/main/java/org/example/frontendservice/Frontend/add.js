$(document).ready(function() {
    $('#saveButton').click(function(event) {
        event.preventDefault();

        var messId = $('#messageId').val();
        var messText = $('#messageText').val();

        const messData = {
            message: messText,
        };

        $.ajax({
            url: `http://localhost:8080/messages/${messId}/operation`,
            type: 'POST',
            contentType: 'text/plain',
            data: messText,
            success: function(data) {
                // generateTableRow(data);
                // $('#messageId').val('');
                // $('#messageText').val('');
            },
            error: function(xhr, status, error) {
                if (xhr.status === 400) {
                    alert(`Error adding message with ID ${messId}`);
                } else {
                    console.error('Error:', error);
                }
            }
        });
    });


});
