const fileAdd = document.getElementById("fileAdd");//add button
const addFiles = document.getElementById("addFiles");//add#addFiles
const fileDelete = document.querySelectorAll(".fileDelete");//forEach 가능
// const fileDelete = document.getElementsByClassName("fileDelete");//forEach 불가능

//------------Update시 file Delete---------------------------------
try{
fileDelete.forEach(function(f){
    f.addEventListener("click",function(){
        let check=window.confirm("삭제를 하면 되돌릴수 없습니다...");
        if(!check){
            return;
        }
        let fileNum = f.getAttribute("data-file-num");
        //ajax
        const xhttp = new XMLHttpRequest();
        xhttp.open("POST", "./fileDelete");
        xhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xhttp.send("fileNum="+fileNum);
        xhttp.onreadystatechange=function(){
            if(xhttp.readyState==4&&xhttp.status==200){

                let result = xhttp.responseText.trim();
                if(result==1){
                    console.log(result);
                    f.parentNode.remove();
                    count--;
                }else{
                    console.log(result);
                }
            }
        }
        
        
    });
});
}catch(e){
        console.l
}

for(fi of fileDelete){
    console.log(fi);
}

//------------Add시 file add---------------------------------------
let count=0;
let idx=0;

function setCount(c){
    if(c>=0){
        count=c;
    }
}

try{

fileAdd.addEventListener("click",function(){
    
    if(count>4){
        alert("최대 5개만 가능...");
        return;
    }
    // <div class="mb-3">
    //     <label for="files" class="form-label">File</label>
    //     <input type="file" name="files" class="form-control" id="files">
    //     <button type="button" class="del"> 삭제 </button>
    // </div>

    //부모 Element div생성
    let div = document.createElement("div"); //<div></div>
    let c = document.createAttribute("class"); //class=""
    c.value="mb-3"; //class="mb-3"
    div.setAttributeNode(c); //<div class="mb-3"></div>
    c = document.createAttribute("id");
    c.value="file"+idx;
    div.setAttributeNode(c); //<div id=""></div>

    
    //자식 Element Label 생성
    let label = document.createElement("label");            //<label></label>
    let labelText = document.createTextNode("File");        //"File"
    label.appendChild(labelText);                           //<label>File</label>
    let labelClass=document.createAttribute("class");       // class=
    labelClass.value="from-label";                          //class="form-label"
    label.setAttributeNode(labelClass);                     // <label class="form-label"></label>
    let labelFor=document.createAttribute("for");             //for=""
    labelFor.value="files"; //for="files"
    label.setAttributeNode(labelFor); //<label for = "files" class="form-label"></>
    div.appendChild(label);
    
    
    //자식 Element Label 생성
    //<input type="file" name="files" class="form-control" id="files">
    let input = document.createElement("input"); //<input>
    let inputAttr = document.createAttribute("type"); //type=""
    inputAttr.value="file"; //type="file";
    input.setAttributeNode(inputAttr); //<input type="file">
    
    inputAttr = document.createAttribute("name");  //name="";
    inputAttr.value="files";
    input.setAttributeNode(inputAttr);
    
    inputAttr = document.createAttribute("class");  //class="";
    inputAttr.value="form-control";
    input.setAttributeNode(inputAttr);
    
    inputAttr = document.createAttribute("id");  //id="";
    inputAttr.value="files";                       //id="files"
    input.setAttributeNode(inputAttr);          //<input type="file" name="files"
    div.appendChild(input);

    
    //삭제 Button Element 생성
    //     <button type="button" class="del"> 삭제 </button>
    let button = document.createElement("button");
    let buttonContents = document.createTextNode("삭제");
    button.appendChild(buttonContents);

    let buttonAttr = document.createAttribute("type");
    buttonAttr.value="button";
    button.setAttributeNode(buttonAttr);

    buttonAttr = document.createAttribute("class");
    buttonAttr.value="del btn btn-danger";
    button.setAttributeNode(buttonAttr);

    buttonAttr = document.createAttribute("title");
    buttonAttr.value = idx;
    button.setAttributeNode(buttonAttr);

    div.appendChild(button);
    
    addFiles.append(div);

    count++;
    idx++;
});3

addFiles.addEventListener("click",function(event){
    let b = event.target;
    if(b.classList[0]=='del'){
        document.getElementById("file"+b.title).remove();
        count--;
    };
});

}catch(e){

}