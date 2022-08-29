
//1. 선택자
const d1 = document.getElementById("d1");
const d2 = document.getElementById("d2");
const d3 = document.getElementById("d3");

alert(d1.value);
alert(d1.getAttribute("value"));

d2.type="button";
d2.setAttribute("type","button");

let count = window.prompt("숫자를 입력하시오...");
let t="";
for(let i=0;i<count;i++){
    t=t+'<input type="text">';
}
d3.innerHTML=t;

let r= prompt("ROW의 갯수 입력"); //3
let c= prompt("COLUMN의 갯수 입력"); //2


let m="";
for(let i=1;i<12;i++){
    m=m+'<option>+'+i+'+</option>';
}
dm.innerHTML=qwer;

