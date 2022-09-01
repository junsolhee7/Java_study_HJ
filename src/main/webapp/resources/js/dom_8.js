const count = document.getElementById("count");
const btn = document.getElementById("btn");
const result =document.getElementById("result");
const c1 =document.getElementsByClassName("c1");
const d1 =document.getElementById("d1");
const d1_1 =document.getElementById("d1_1");
const d1_1_1 =document.getElementById("d1_1_1");
const google =document.getElementById("google");

google.addEventListener("click",function(event){
    alert("Go Google");
    event.preventDefault();
});

d1.addEventListener("click",function(event){
    console.log("d1 click");
    console.log(event);
    console.log(event.currentTarget);
    console.log(event.target);
    
    if(event.target.className=='buttons'){
        alert("button");
        console.log("this:",this);
        alert(event.target.innerHTML);
    }

},false);

result.addEventListener("click",function(event){
    if(event.target.className=='c1'){
        alert(event.target.innerHTML);
    }
});

btn.addEventListener("click",function(){
    for(let i=0;i<count.value;i++){
        let b = document.createElement("button");           //<button></button>
        let c = document.createTextNode("CLICK"+i);           //CLICK
        b.appendChild(c);
        
        let attr = document.createAttribute("class");
        attr.value="c1";
        b.setAttributeNode(attr);
        
        result.appendChild(b);
    }
});
