const remove1 = document.getElementById("remove1");                             //button#remove1
const remove2 = document.getElementById("remove2");                             //button#remove2

const d1 = document.getElementById("d1");                                       //div#d1
const d2 = document.getElementById("d2");                                       //div#d2
const d2_2 = document.getElementById("d2_2");                                   //div#d2_2
const d2_3 = document.getElementById("d2_3");                                   //div#d2_3
const d2_4 = document.getElementById("d2_4");                                   //div#d2_4

remove1.addEventListener("click", function(){
    //삭제
    d1.remove();
});

remove2.addEventListener("click",function(){
    const ch = document.getElementsByClassName("ch");                           //h1#ch
    const ar = [];
    for(let i=0; i<ch.length;i++){
        ar.push(ch[i].id)
    }

    for(i of ar){
        let d = document.getElementById(i);
        d2.removeChild(d);
    }
    

    // for(let i=1;i<5;i++){
    //     const d2_1 = document.getElementById("d2_"+i);                           //div#d2_1
    //     d2.removeChild(d2_1);
    // }   //for문


});