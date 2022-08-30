//member.js
const btn = document.getElementById("btn");
const frm = document.getElementById("frm");
const usr = document.getElementById("usr");
const pwd = document.getElementById("pwd");

btn.addEventListener("click",function(){
    let u = usr.value;
    let p = pwd.value;

    if(u==""){
        alert("ID는 필수 입니다.");
        return;
    }
    if(p==""){
        alert("PASSWORD는 필수 입니다.");
        return;
    }
    frm.submit();

});

// console.log(u=="");
// console.log(u.length);

// if(u.length>0 && p.length>0){
//     frm.submit();        
// }else{
//     alert("ID,PASSWORD는 필수입니다");
// }