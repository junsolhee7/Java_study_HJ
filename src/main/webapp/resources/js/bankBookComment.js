const commentAdd = document.querySelector("#commentAdd");
const writer = document.querySelector("#writer");
const contents = document.querySelector("#contents");
const commentList = document.querySelector("#commentList");
const more = document.querySelector("#more");


//page 번호 담는 변수
let page=1;
//bookNum을 담을 변수
const bookNum = commentAdd.getAttribute("data-book-num");
getCommentList(page,bookNum);


commentAdd.addEventListener("click",function(){

    let wv = writer.value;
    let cv = contents.value;

    //---------------ajax------------------------------
    //1. XMLHTTPRequest 생성
    const xhttp = new XMLHttpRequest;

    //2. Method, URL 준비
    xhttp.open("POST", "./commentAdd");

    //3. Enctype
    //요청 header 정보
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    //4. 전송 (post일 경우 파라미터 추가)
    xhttp.send("bookNum="+bookNum+"&writer="+wv+"&contents="+cv);

    //5.응답 처리
    xhttp.onreadystatechange=function(){
        if(this.readyState == 4 && this.status==200){
            let result = xhttp.responseText.trim();
            console.log(result);
            result = JSON.parse(result);
            console.log(result.result);
            writer.value="";
            contents.value="";
            if(result.result==1){
                alert("댓글 작성 완료...");

                for(let i=0;i<commentList.children.length;){
                    commentList.children[0].remove();
                }
                // if(commentList.children.length!=0){
                    //     commentList.children[0].remove();
                    // }
                    page=1;
                    getCommentList(page,bookNum);
            }else{
            }
        }
    }
}); // Add click event 끝

function getCommentList(p,bn){
    //1. XMLHTTPRequest생성
    const xhttp = new XMLHttpRequest();
    
    //2. Method, URL
    xhttp.open("GET","./commentList?page="+p+"&bookNum="+bn);
    
    //3. 요청 전송
    xhttp.send();
    
    //4. 응답 처리
    xhttp.addEventListener("readystatechange",function(){
        if(xhttp.readyState==4 && xhttp.status==200){
            console.log(xhttp.responseText);
            
            //1. jsp 사용한 결과물
            // commentList.innerHTML=xhttp.responseText.trim();
            
            //2. JSON 결과물
            let result = JSON.parse(xhttp.responseText.trim());
            // let result = document.createElement("table");
            // let resultAttr=document.createAttribute("class");
            // resultAttr.value="table";// table-dark table-hover
            // result.setAttributeNode(resultAttr); //<table class="table table-dark table-hover"></table>
            let pager= result.pager; //commentPager
            let ar= result.list; //댓글리스트
            for(let i=0;i<ar.length;i++){
                
                let tr = document.createElement("tr");//<tr></tr>

                let td = document.createElement("td");//<td></td>
                let tdText=document.createTextNode(ar[i].contents);
                td.appendChild(tdText);
                tr.appendChild(td);
                
                td = document.createElement("td");//<td></td>
                tdText=document.createTextNode(ar[i].writer);
                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");//<td></td>
                // 1. js에서 날짜변경
                // let date = new Date(ar[i].regDate);
                // console.log(date);
                // let year = date.getFullYear();
                // let month = date.getMonth()+1;
                // let d =date.getDate();
                // tdText=document.createTextNode(year+"-"+month+"-"+d);
                // 2.DTO에서 날짜변경
                tdText=document.createTextNode(ar[i].regDate);


                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");
                tdText=document.createTextNode("수정");
                let tdAttr = document.createAttribute("class");
                tdAttr.value="update";
                td.setAttributeNode(tdAttr);
                td.appendChild(tdText);
                tr.appendChild(td);

                tdAttr=document.createAttribute("data-comment-num");
                tdAttr.value=ar[i].num;
                td.setAttributeNode(tdAttr);
                tr.appendChild(td);

                td = document.createElement("td");
                tdAttr = document.createAttribute("class");
                tdAttr.value="delete";
                td.setAttributeNode(tdAttr);
                tdText=document.createTextNode("삭제");
                td.appendChild(tdText);
                
                tdAttr=document.createAttribute("data-comment-num");
                tdAttr.value=ar[i].num;
                td.setAttributeNode(tdAttr);
                tr.appendChild(td);
                
                commentList.append(tr);
                
                if(page>=pager.totalPage){
                    more.classList.add("diasbled");
                }else {
                    more.classList.remove("disabled");
                }
            }
            // console.log(result);
            // console.log(commentList.children);
            
            // let t = commentList.children;
            
            // if(t.length!=0){
                //     commentList.children[0].remove();
                // }
                
                
                // try{
                    //     console.log(commentList.children());
                    //     throw new Error("에러 메시지");
                    // }catch(exception){
                        
                        // }finally{
                        
                            // }
                        // commentList.append(result);
                        // commentList.children[0].remove();
                        
                    }
    });
}// getCommentList 메서드 끝

//-------------------------더보기----------------------------------
more.addEventListener("click",function(){
    page++;
    // const bookNum = commentAdd.getAttribute("data-book-num");
    console.log(page);
    console.log(bookNum);
    getCommentList(page,bookNum);
});


commentList.addEventListener("click", function(event){
    
    //------------------------Update---------------------------
    if(event.target.className=="update"){
        //1. 버튼창이용
        // let contents = event.target.previousSibling.previousSibling.previousSibling;
        // console.log(contents);
        // let v = contents.innerHTML;
        // contents.innerHTML="<textarea>"+v+"</textarea>";
        //2. 모달이용
        let contents = event.target.previousSibling.previousSibling.previousSibling.innerHTML;
        let writer = event.target.previousSibling.previousSibling.innerHTML;
        let num = event.target.getAttribute("data-comment-num");
        console.log(contents);
        document.querySelector("#updateContents").value = contents;
        document.querySelector("#updateWriter").value = writer;
        document.querySelector("#num").value=num;

        document.querySelector("#up").click();

        

    }
    
    //-----------------------Delete----------------------------
    if(event.target.className=="delete"){
        let check = window.confirm("삭제하시겠습니까?");
        if(check==true){
            let num = event.target.getAttribute("data-comment-num");
            console.log("num: ",num);
            
            //1. XMLHTTPRequest
            const xhttp = new XMLHttpRequest;
            
            //2. 요청 정보(URL, Method)
            xhttp.open("POST","commentDelete");
            
            //3. Header (enctype);
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

            //4. 요청 (파라미터와 함께)
            xhttp.send("num="+num);
            
            //5. 응답 처리
            xhttp.onreadystatechange=function(){
                if(xhttp.readyState==4&&xhttp.status==200){
                    let result=xhttp.responseText.trim();
                    if(result==1){
                        alert("삭제 성공");
                        page=1;
                        
                        for(let i=0;i<commentList.children.length;){
                            commentList.children[0].remove();
                        }

                        getCommentList(page,bookNum);
                        
                    }else("삭제 실패");
                }
            }
        }
    }
});

//----------------------------Modal Update button click----------------------------

const update = document.querySelector("#update");
update.addEventListener("click",function(){
    //modal 에서 num,contents 전송

    let num = document.getElementById("num").value;
    let contents = document.querySelector("#updateContents").value;

    //1.--------------Ajax------------------
    const xhttp = new XMLHttpRequest();
    xhttp.open("POST","commentUpdate");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("num="+num+"&contents="+contents);
    xhttp.onreadystatechange=function(){
        if(xhttp.readyState == 4 && xhttp.status == 200){
            console.log(xhttp.responseText.trim());
            let result=xhttp.responseText.trim();
            if(result>0){
                alert("댓글 수정 완료...");
                for(let i=0;i<commentList.children.length;){
                    commentList.children[0].remove();
                }
                    page=1;
                    getCommentList(page,bookNum);


            }else{
                alert("댓글 수정 실패...");
            }
        }
    }

});