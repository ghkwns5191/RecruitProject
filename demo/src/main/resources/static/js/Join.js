/**
 * 
 */

function openPop() {
	window.open("/member/usernamecheck", "usernameVal",
		"width=350px, height=30px");
};

window.onload = function() {

	document.getElementById("username").value = localStorage.getItem('username');
	console.log(localStorage.getItem('username'));
	console.log(document.getElementById("username").value);
	window.localStorage.removeItem('username');


}