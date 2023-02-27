/**
 * 
 */
 
 function inputData() {
	
	var name_company = document.getElementById('name_company').value;
	var type_company = document.getElementById('type_company').value;
	var numberofstaff_company = document.getElementById('numberofstaff_company').value;
	var phone_company = document.getElementById('phone_company').value;
	var address_company = document.getElementById('address_company').value;
	
	var companyDto = {
		name : name_company,
		type : type_company,
		address : address_company,
		phone : phone_company,
		pp20number : null,
		numberofstaff : numberofstaff_company
	}
	
	$.ajax({
		type: 'post',
		url : '/company/input',
		async: false,
		data : JSON.stringify(companyDto),
		contentType: 'application/json',
		success: function (data) {
			console.log(data);
		},
		error : function (error) {
			console.log(error);
		}
	});

}