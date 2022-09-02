
const d1 = document.querySelector("#d1");
const d1_2_1_2 = document.querySelector("#d1_2_1_2");
const btn = document.querySelector("#btn");



console.log(d1_2_1_2.previousSibling.previousSibling);
console.log(d1_2_1_2.nextSibling.nextSibling);

console.log("-----------------------------------------------");


d1.addEventListener("click", function(){
    //li 모두 삭제

    //1.remove
    let li = d1.children[1].children[0].children;
    console.log(li);

    // for(l of li){
    //     console.log(l);
    //     l.remove();
    // }

    //2.removeChild()
    for(let i=0; i != li.length;){
        li[0].remove();
    }
});

btn.addEventListener("click", function(){
    let a = d1_2_1_2.parentNode.parentNode;
    console.log("a",a);
    a.remove();
});