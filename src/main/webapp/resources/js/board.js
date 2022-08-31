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
    let result = true;
    for(let i=0; i<cb.length; i++){
        console.log(cb[i].checked);
        if(!cb[i].checked){
            result=false;
            break;
        }
    }
    all.checked=result;
}
ca.addEventListener("click",function(){
	
})