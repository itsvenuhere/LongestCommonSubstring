var lcsResource = "lcs";
$("#vauesTxtArea").on("keypress",function(e) {
	var key = e.keyCode;

	// If the user has pressed enter
	if (key == 13) {
		document.getElementById("vauesTxtArea").value =document.getElementById("vauesTxtArea").value + "\n";
		return false;
	}
	else {
		return true;
	}
});


function callLcsService(resourcePath, jsonData, method) {
	$("#errorLbl").hide();
	$("#responseLbl").hide();
	
	$.ajax({
		method: method,
		url: resourcePath,
		contentType: "application/json",
		//data: JSON.stringify(jsonData),
		data: jsonData,
		success: function(data, status, xhr) {
			console.log("DATA: " + JSON.stringify(data.lcs));
			$("#responseLbl").show();

			if(null!=data.lcs && data.lcs.length>0){
				var responseStr = "";
				for(index in data.lcs){
					responseStr = responseStr + data.lcs[index].value +" , ";
				}
				responseStr = responseStr.slice(0,-2);
				$("#respTxt").text(JSON.stringify(responseStr));
			}else {
				$("#respTxt").text("No, common substring. Please try again");
			}

		},
		error: function(jqXHR, status, errorThrown) {
			console.log("ERROR: " + JSON.stringify(jqXHR.responseJSON));
			$("#responseLbl").show();
			$("#respTxt").text("Something went wrong, please check again");
		}
	});
}


function submitValues() {
	if (null!=$("#vauesTxtArea").val() && $("#vauesTxtArea").val().trim().length >0){
		var jsondata ="{\"setOfStrings\":["
		"{setOfStrings:["
		var fixedText = $("#vauesTxtArea").val().replace(/(\r\t|\t|\r)/gm, "");
		var lines = fixedText.split('\n');
		for(var i = 0;i < lines.length;i++) {
			if ($.trim(lines[i].length) > 0) {
				jsondata = jsondata + "{\"value\":\"" + $.trim(lines[i])+ "\"},"
			}

		}
		jsondata = jsondata.slice(0,-1) + "]}";
		callLcsService(lcsResource, jsondata, "POST");
	}else {
		$("#responseLbl").hide();
		$("#errorLbl").show();
		$("#errorTxt").text("Please enter atleast one string to find common longest substring");
	}
}


function validateValues() {

}



