/**
 * 
 */

function tomemberinfo() {
    location.href="/mypage/accountinfo";
}

function toresume(id) {
    location.href="/mypage/user/resume/detail/" + id;
}

function tonewresume() {
    location.href="/mypage/user/resume/new";
}

function recruitapply(id) {
    location.href="/mypage/company/recruit/detail/" + id;
}

function applylist() {
    location.href="/mypage/user/applyinfo";
}

function back() {
    history.go(-1);
}