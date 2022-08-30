const btn = document.getElementById("btn");
const btn2 = document.getElementById("btn2");
const btn3 = document.getElementById("btn3");
const d1 = document.getElementById("d1");
const d2 = document.getElementById("d2");
const d3 = document.getElementById("d3");

btn.addEventListener("click",function(){
    console.log("work");
    console.log("d1.value");
    console.log("d2.value");
    d3.value=d1.value*1+d2.value*1;
});

function test(num1,num2){
    let result = num1*num2;
    return result;
};

btn2.addEventListener("click",function(){
    alert("BTN2");
});

btn3.addEventListener("click",function(){
    btn2.click();
});