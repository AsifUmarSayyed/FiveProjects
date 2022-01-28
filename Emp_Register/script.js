//array decleration
let noteList = [];

//assign elements to variablre by id
const eNumber = document.getElementById("eNumber");
const eName = document.getElementById("eName");
const eContact = document.getElementById("eContact");
const eAddress = document.getElementById("eAddress");
const ePhoto = document.getElementById("ePhoto");
const submitBtn = document.getElementById("submitBtn");
const ulEl = document.getElementById("ul-el");

//assigning localStorage value
const leadsFromLocalStorage = JSON.parse(localStorage.getItem("noteList"));

//display previous element of array in localStorage
if (leadsFromLocalStorage) {
  noteList = leadsFromLocalStorage;
  show(noteList);
}

//Entering elements into localStorage through button click
submitBtn.addEventListener("click", function () {
  // ePhoto.value = ePhoto.value.replace(
  //   /C:\fakepath/gi,
  //   " C:/home/am-pc-10/Desktop/Training Road map/Emp_Register/imgs/"
  // );
  alert(ePhoto.files[0].name);

  noteList.push({
    Emp_Id: eNumber.value,
    Emp_Name: eName.value,
    Emp_Contact_No: eContact.value,
    Emp_Address: eAddress.value,
    Emp_Photo: ePhoto.files[0].name,
  });
  eNumber.value = "";
  eName.value = "";
  eContact.value = "";
  eAddress.value = "";
  ePhoto.value = "";
  localStorage.setItem("noteList", JSON.stringify(noteList));
  show(noteList);
});

//Display the Elements of array in LocalStorage
function show(noteList) {
  let listItems = "";
  for (let i = 0; i < noteList.length; i++) {
    listItems += `
            
    <div class="note">
    <img src="${noteList[i].Emp_Photo}" height="100px" width="100px"/> 
     <span class="close" onclick="deleteval('${i}')">&times;</span> <br/>
      
    <span class="noteHead">EmpID: ${noteList[i].Emp_Id}</span>  <br> 
     
    ${noteList[i].Emp_Name} <br>
    
    <button  onclick="calmodel('${[i]}')">Show</button>
    
 
</div>
    
        `;
  }

  ulEl.innerHTML = listItems;
}

//Deleting Single element in array and displaying
function deleteval(val) {
  for (let i = 0; i < noteList.length; i++) {
    if (i == val) {
      // alert(myToDo[i] + " " + i);
      noteList.splice(i, 1);
    }
  }
  localStorage.setItem("noteList", JSON.stringify(noteList));
  show(noteList);
}

// Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
var info = document.getElementById("info");
// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal
function calmodel(val) {
  let listItems = "";
  let i = val;
  listItems += `
            <center>
            
      <h3>Employee ${noteList[i].Emp_Id} Details </h3>
      <img src="${noteList[i].Emp_Photo}" height="100px" width="100px"/> <br>
      <label>Emp Number:</label>
      <input type="number" id="eNumber1" placeholder="Enter Emp id"  value="${noteList[i].Emp_Id}"/>
      <label>Emp Name:</label>
      <input type="text" id="eName1" placeholder="Enter Employee Name" value="${noteList[i].Emp_Name}"/><br />
      <label>Contact No:</label>
      <input type="number" id="eContact1" placeholder="Enter Contact no" value="${noteList[i].Emp_Contact_No}"/>
      <label>Full Address:</label>
      <input
        type="text"
        id="eAddress1"
        placeholder="Enter Full Address "
        value="${noteList[i].Emp_Address}"
      /><br />
      <label>Photo:</label>
      <input
        type="file"
        id="ePhoto1"
        placeholder="Enter Photo "
        accept="image/*"
        url="${noteList[i].Emp_Photo}"
      />
      <br />
      
    <button  onclick="update('${i}')">Edit</button>
    
 
</div>
</center>
    
        `;

  info.innerHTML = listItems;

  modal.style.display = "block";
}
function update(i) {
  noteList[i].Emp_Id = document.getElementById("eNumber1").value;
  noteList[i].Emp_Name = document.getElementById("eName1").value;
  noteList[i].Emp_Contact_No = document.getElementById("eContact1").value;
  noteList[i].Emp_Address = document.getElementById("eAddress1").value;

  localStorage.setItem("noteList", JSON.stringify(noteList));

  alert("updated");
}
// When the user clicks on <span> (x), close the modal
span.onclick = function () {
  modal.style.display = "none";
};

// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
};
