
$(document).ready(function () {

    $("#divContainer").hide();

    $("#btn-buscar").click(function () {
        let txtMedicamento = $.trim($("#txtMedicamento").val());
        if(txtMedicamento ===''){
            toastr.warning("Debe ingresar el nombre del medicamento.");  
            return;
        }
        $("#divContainer").hide();
        $("#divMedicamentos").html("");
        $.ajax({
            type: "GET",
            url: "https://cdf-zuul-sp.herokuapp.com/farmacia-micro-client/farmacia/listar/"+txtMedicamento,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                if(data.length > 0){
                    for(var i in data){
                        var obj = data[i];
                        var htmlMedicamento = "<div class='col-xs-3'>"+
                        "<img width='150px' height='150px' class='img-responsive' src='"+obj.medicamento.url+"' alt='"+obj.medicamento.nombre+"'>"+
                        "<div class='radio'>"+
                        "<label><input id='rdnPrecio"+i+"' value='"+obj.id+"' type='radio' name='optradio'>"+obj.precio+"</label>"+
                        "</div>"+
                        "</div>";
                        $("#divMedicamentos").append(htmlMedicamento);
                        $("#divContainer").show();
                    }
                }else{
                    $("#divContainer").hide();
                    toastr.warning("No se encontraron medicamentos!!!");                    
                }
            },

            error: function (XMLHttpRequest, textStatus, errorThrown) {
                toastr.error("Request: " + XMLHttpRequest.toString() + "\n\nStatus: " + textStatus + "\n\nError: " + errorThrown);
            }
        });
    });

    $("#btn-registrar").click(function () {
        let idFarmacia = $("input[name='optradio']:checked").val();
        if(idFarmacia === undefined){
            toastr.warning("Debe seleccionar un precio.");  
            return; 
        }

        if(!confirm("\u00BFEst\u00E1 seguro de registrar el medicamento?")){
            return

        }

        var data = {
            "farmacia" : {
                "id": idFarmacia
            }
        }

        $.ajax({
            type: "POST",
            url: "https://cdf-zuul-sp.herokuapp.com/farmacia-micro-client/compra/registrar/",
            data : JSON.stringify(data),
            dataType: "json",
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (data) {
                //SI EL SERVICIO RETORNA EXITO EVALUAR
                if (data == '1') {
                    toastr.info("Se registr&oacute; correctamente.");
                } else {
                    toastr.warning("Error al registrar " + data);
                }

                $("input[name='optradio']").prop('checked', false);
            },

            error: function (XMLHttpRequest, textStatus, errorThrown) {
                toastr.error("Request: " + XMLHttpRequest.toString() + "\n\nStatus: " + textStatus + "\n\nError: " + errorThrown);
            }
        });
    });
});