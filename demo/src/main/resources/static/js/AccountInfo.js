/**
 *
 */

window.onload = function () {
  $.ajax({
    type: "get",
    url: "/member/sendMemberData",
    dataType: "json",
    success: function (member) {
      console.log("result : " + member);
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
      var address = member.address;
      var lengthlimit = 50;
      var index = address.indexOf("");
      if (address.length <= lengthlimit) {
        document.getElementById("address1").innerHTML = address;
        document.getElementById("address2").innerHTML = ".";
      } else if (address.length > lengthlimit) {
        while (index <= 50) {
          index = address.indexOf(" ", index + 1);
        }
        var add1 = address.substring(0, index);
        var add2 = address.substring(index + 1, address.length);
        document.getElementById("address1").innerHTML = add1;
        document.getElementById("address2").innerHTML = add2;
      }
      document.getElementById("registerdate").innerHTML = member.registerdate;
    },
    error: function (request, status, error) {
      console.log("request : " + request);
      console.log("status : " + status);
      console.log("error : " + error);
    },
  });
};

function toRevise() {
  location.href = "/mypage/account/revise";
}

function back() {
  history.go(-1);
}
