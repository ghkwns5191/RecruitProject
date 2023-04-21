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

			document.getElementById("username").innerHTML = member.username;
			if (member.sort == "individual") {
				document.getElementById("sort").innerHTML = "개인";
			} else if (member.sort == "company") {
				document.getElementById("sort").innerHTML = "기업";
			}

			document.getElementById("name").innerHTML = member.name;
			document.getElementById("phone").innerHTML = member.phone;
			document.getElementById("email").innerHTML = member.email;
			document.getElementById("birthday").innerHTML = member.birthday;
			document.getElementById("address").innerHTML = member.address;
			document.getElementById("registerdate").innerHTML = member.registerdate;
		},
		error: function(request, status, error) {
			console.log('request : ' + request);
			console.log('status : ' + status);
			console.log('error : ' + error);
		}
	})

}