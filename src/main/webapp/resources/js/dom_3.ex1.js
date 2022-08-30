const btn = document.getElementById("btn");
const btn2 = document.getElementById("btn2");
const btn3 = document.getElementById("btn3");
const btn4 = document.getElementById("btn4");
const d1 = document.getElementById("d1");
const d2 = document.getElementById("d2");
const d3 = document.getElementById("d3");
const select = document.getElementById("select");
const c1 = document.getElementsByClassName("c1");

btn.addEventListener("click",function(){
    if(select.value=="+"){
        d3.value=d1.value*1+d2.value*1;
        
    }else if(select.value=="-"){
        d3.value=d1.value*1-d2.value*1;
        
    }else if(select.value=="*"){
        d3.value=d1.value*1*d2.value*1;
        
    }else if(select.value=="/"){
        d3.value=d1.value*1/d2.value*1;
        
    }else if(select.value=="%"){
        d3.value=d1.value*1%d2.value*1;

    }
    // console.log("work");
    // console.log("d1.value");
    // console.log("d2.value");
    // d3.value=d1.value*1+d2.value*1;
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

btn4.addEventListener("click",function(){
    alert(c1);
    console.log(c1);
    console.log(c1.value);

    for(let i=0;i<c1.length;i++){
        console.log(c1[i].selected);
    }

    c1[1].selected=true;
});