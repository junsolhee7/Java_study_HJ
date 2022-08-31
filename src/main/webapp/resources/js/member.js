//member.js
function loginCheck(){
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
    
}
const all = document.getElementById("all");
const cb = document.getElementsByClassName("cb");
const ca = document.getElementsByClassName("ca");


all.addEventListener("click",function(){
    for(let i=0;i<cb.length;i++){
        cb[i].checked=all.checked;
    }
})

for(let i=0; i<cb.length;i++){
    cb[i].addEventListener("click", check);
}

function check(){
    const join = document.getElementById("join");
    const frm = document.getElementById("frm");
    const req = document.getElementsByClassName("req");

    join.addEventListener("click", function(){
        let result = true;
        for(let i=0; i<req.length; i++){
            if(!req[i].checked){
                result=false;
                break;
            }
        }
        if(result){
            frm.submit();
        }else {
            alert("필수 약관에 동의해야합니다.");
        }
    })
}