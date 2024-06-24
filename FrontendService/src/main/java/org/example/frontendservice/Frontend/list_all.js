function removeTable() {
    const tbody = $('#carTableBody');
    if (tbody.length) {
        tbody.empty();
    }
}



function fetchAndGenerateTable() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/messages/all",
        dataType: "json",
        success: function(data) {
            // console.error(data);
            generateTableRows(data);
        },
        error: function(xhr, status, error) {
            console.error('Error fetching data:', error);
        }
    });
}

function generateTableRows(messages) {
    const tbody = $('#messageTableBody');
    if (!tbody.length) {
        console.error('Table body element not found.');
        return;
    }
    tbody.empty();

    messages.forEach(function(message) {
        let row = '<tr>';
        row += '<td>' + message.id + '</td>';
        row += '<td>' + message.text + '</td>';
        row += '<td>' + message.encryptedText + '</td>';

        row += '</tr>';
        tbody.append(row);
    });
}

function toggleListButton() {
    const listButton = $('#listButton');

        fetchAndGenerateTable();

}