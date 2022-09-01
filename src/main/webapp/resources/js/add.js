const fileAdd = document.getElementById("fileAdd");
const addFiles = document.getElementById("addFiles");


let count=0;

fileAdd.addEventListener("click",function(){
    count++;
    if(count>5){
        alert("최대 5개만가능");
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
    buttonAttr.value="del";
    button.setAttributeNode(buttonAttr);

    div.appendChild(button);
    
    addFiles.append(div);
});

// addFiles.addEventListener("click",function(){
//     alert("ㅇㅅㅇ");
// })