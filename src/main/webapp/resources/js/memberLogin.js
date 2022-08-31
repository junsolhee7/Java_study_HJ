const id = document.getElementById("id");//아이디
const pwd = document.getElementById("pwd");//비밀번호
const pwd2 = document.getElementById("pwd2");//비밀번호2
const nam = document.getElementById("nam");//이름
const email = document.getElementById("email");//이메일
const phone = document.getElementById("phone");//전화번호
const frm = document.getElementById("frm");//폼
const pwc = document.getElementById("pwc");//폼

id.focus();

//1
id.addEventListener("change", function(){
    i=id.value;
    if(i.length<2){
        alert("ID는 2글자 이상이어야 합니다...");
        id.focus;
    }
})

//2
pwd.addEventListener("change", function(){
    p=pwd.value;
    if(p.length<6){
        alert("Password는 6글자 이상이어야 합니다...");
        pwd.focus;
    }
})

//3
pwd2.addEventListener("change", function(){
    if(pwd.value==pwd2.value){

    }else{
        pwd.focus;
        alert("Password가 다릅니다.");
    }
})

//4
frm.addEventListener("click",function(){
    n=nam.value;
    e=email.value;
    p=phone.value;
    if(n.length>=1 && e.length>=1 && p.length>=1){
        alert("회원가입이 완료되었습니다.");
        frm.submit;
    }else{
        alert("name,email,phone 입력해주세요.");
    }
})

//test
test = document.getElementById("test"); //test

test.addEventListener("change",function(){
    let qwe=""
    console.log(test.value);

})

