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
    // </div>

    //부모 Element div생성
    let div = document.createElement("div"); //<div></div>
    let c = document.createAttribute("class"); //class=""
    c.value="mb-3"; //class="mb-3"
    div.setAttributeNode(c); //<div class="mb-3"></div>
    
    let label = document.createElement("label");            //<label></label>
    let labelText = document.createTextNode("File");        //"File"
    label.appendChild(labelText);                           //<label>File</label>
    let labelClass=document.createAttribute("class");       // class=
    labelClass.value="from-label";                          //class="form-label"
    label.setAttributeNode(labelClass);                     // <label class="form-label"></label>
    labelClass=document.createAttribute("for");             //for=""
    labelClass.value="files"; //for="files"
    label.setAttributeNode(labelClass); //<label for = "files" class="form-label"></>
    div.appendChild(label);
    

    let input = document.createElement("input"); //<input>
    let inputAttr = document.createAttribute("type"); //type=""
    inputAttr.value="file"; //type="file";
    input.setAttributeNode(tp); //<input type="file">

    inputAttr = document.createAttribute("name");  //name="";
    inputAttr.value="files";
    input.setAttributeNode(inputAttr);

    inputAttr = document.createAttribute("class");  //name="";
    inputAttr.value="form-control";
    input.setAttributeNode(inputAttr);
    
    inputAttr = document.createAttribute("id");  //id="";
    inputAttr.value="files";                       //id="files"
    input.setAttributeNode(inputAttr);          //<input type="file" name="files"
    div.appendChild(input);

    //자식 Element Label 생성

    addFiles.append(div);
});

