//dom_6.js

//Button에 click event 등록
const btn = document.getElementById("btn"); //button
const d1 = document.getElementById("d1"); //div
const add = document.getElementById("add");//add button
const add2 = document.getElementById("add2");//add2 button
const add3 = document.getElementById("add3");//add3 button
const list = document.getElementById("list");//ul
const list2 = document.getElementById("list2");//ol
const d2 = document.getElementById("d2"); //div#d2
const add4 = document.getElementById("add4");//add4 button
const add5 = document.getElementById("add5");//add5 button
const d3 = document.getElementById("d3"); //div#d3

btn.addEventListener("click",function(){

    d1.innerHTML='<img src="/resources/images/title1.jpg">';

});

add.addEventListener("click", function(){
    let li = document.createElement("li"); // <li></li>
    let t = document.createTextNode("test"); //test
    li.appendChild(t); //<li>test</li>
    list.append(li);
});

add2.addEventListener("click",function(){
    let li = document.createElement("li"); // <li></li>
    let h = document.createElement("h3"); // <h3></h3>
    let t = document.createTextNode("Hello"); //Hello
    h.appendChild(t); //<h3>Hello</h3>
    li.appendChild(h); //<li><h3>Hello</h3></li>
    list2.prepend(li);
});

add3.addEventListener("click",function(){

});

//add3을 클릭하면 div#d2 내에 input element를 append (#=id, .=class)
add3.addEventListener("click", function(){
    let input = document.createElement("input"); //<input>
    let ch = document.createAttribute("type"); //type=
    ch.value="checkbox"; //type="checkbox"
    input.setAttributeNode(ch); //<input type="checkbox">
    d2.appendChild(input);

});

//add4를 클릭하면 div#d3에 before
add4.addEventListener("click",function(){
    let h = document.createElement("h3");
    let t = document.createTextNode("before");
    h.appendChild(t);
    d3.before(h);
    
});


//add5를 클릭하면 div#d3에 after

add5.addEventListener("click", function(){
    let h = document.createElement("h3");
    let t = document.createTextNode("after");
    h.appendChild(t);
    d3.after(h);
});