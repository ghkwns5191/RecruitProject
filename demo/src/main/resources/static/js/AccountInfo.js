/**
 * 
 */

window.onload = function() {

	$.ajax({
		type: 'get',
		url: '/member/sendMemberData',
		dataType: 'json',
		success: function(member) {
			console.log('result : ' + member);
			console.log(member.username);

			document.getElementById("username").value = member.username;
			if (member.sort == "individual") {
				document.getElementById("sort").value = "개인";
			} else if (member.sort == "company") {
				document.getElementById("sort").value = "기업";
			}

			document.getElementById("name").value = member.name;
			document.getElementById("phone").value = member.phone;
			document.getElementById("email").value = member.email;
			document.getElementById("birthday").value = member.birthday;
			document.getElementById("address").value = member.address;
			document.getElementById("registerdate").value = member.registerdate;
		},
		error: function(request, status, error) {
			console.log('request : ' + request);
			console.log('status : ' + status);
			console.log('error : ' + error);
		}
	})

}