

function revise() {
    var name = document.getElementById("name").value;
    var phone = document.getElementById("phone").value;
    var email = document.getElementById("email").value;
    var birthday = document.getElementById("birthday").value;
    var address1 = document.getElementById("address1").value;
    var address2 = document.getElementById("address2").value;
    var fulladdress = null;
    var password = document.getElementById("password").value;

    if(address2 == "" || address2 == "." || address2 == " ") {
        fulladdress = address1;
    } else {
        fulladdress = address1 + " " + address2;
    }

    var memberDto = {
        password: password,
        name : name,
        phone : phone,
        email: email,
        birthday: birthday,
        address: fulladdress
    }

    $.ajax({
        type: 'put',
        url: '/member/revise',
        contentType: "application/json",
        async: false,
        data: JSON.stringify(memberDto),
        success: function(data) {
        
            console.log("접속성공");
           
            if(data != '') {
                window.alert("회원정보 수정이 완료되었습니다.");
                location.href = '/mypage';
                
            } else {
                console.log("else 절 작동?")
                window.alert("비밀번호가 틀렸습니다.");
            }
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
            console.log("접속실패");
        }
    });
}