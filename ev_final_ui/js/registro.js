
$(document).ready(function () {
	
    $.ajax({
        type: "GET",
        url: "https://cdf-zuul-sp.herokuapp.com/farmacia-micro-client/compra/listar",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            if(data.length > 0){
                for(var i in data){
                    var obj = data[i];
                    var fila = "<tr>"+
                    "<th scope='row'>"+(parseInt(i)+1)+"</th>"+
                    "<td>"+obj.farmacia.nombre+"</td>"+
                    "<td>"+obj.farmacia.medicamento.nombre+"</td>"+
                    "<td>"+obj.farmacia.precio+"</td>"+
                    "</tr>";

                    $("#tblCompras tbody").append(fila);
                }

            }else{
                toastr.warning("No se encontraron compras!!!");   
            }

        },

        error: function (XMLHttpRequest, textStatus, errorThrown) {
            toastr.error("Request: " + XMLHttpRequest.toString() + "\n\nStatus: " + textStatus + "\n\nError: " + errorThrown);
        }
    });

});