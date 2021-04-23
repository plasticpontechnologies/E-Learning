$(document).ready(function () {

    $("#button").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {

    var search = {}
    var First_Name = $("#name").val();
    var Last_name = $("#lastname").val();
    var Email = $("#email").val();
    var Phone_Number = $("#phone_number").val();
    var Date_of_birth = $("#dateofbirth").val();
    var Password = $("#password").val();

    

    $("#button").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "http://localhost:8080/getmessage",
        data: {'userName': username},
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + JSON.stringify(data, null, 4) + "&lt;/pre&gt;";
            $('#feedback').html(json);

            console.log("SUCCESS : ", data);
            $("#button").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + e.responseText + "&lt;/pre&gt;";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#button").prop("disabled", false);

        }
    });

}