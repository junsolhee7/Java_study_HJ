const d1 = document.getElementById("d1");
const d2 = document.getElementById("d2");
const btn1 = document.getElementById("btn1");
d1.innerHTML='Hello';


//java메서드
//접근지정자 [그외지정자] 리턴타입 메서드명(){}

//function 함수명(){}
function test(){
    alert("Click Event 실행")
    let =test2(1,2);
    console.log(result);
    f1();
}//이름있는함수

function test2(num1,num2){
    let result = num1 + num2;
    return  result;

    
}//익명함수, 함수명이없는함수
let f1 = function(){
    console.log("익명함수실행");
}

//Event 적용 1
//d2.onclick = f1; ()생략
d2.onclick = function(){
    console.log("click 콜백함수 실행");
};

// Event 적용 3
btn1.addEventListener("click",function(){
    console.log("Event Listener 실행");
});
