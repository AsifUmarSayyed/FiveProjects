//array decleration
let noteList = [];

//assign elements to variablre by id
const eInput = document.getElementById("eText");
const eDate = document.getElementById("edate");
const eAmt = document.getElementById("eAmt");
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
  noteList.push(eInput.value);
  eInput.value = "";

  localStorage.setItem("noteList", JSON.stringify(noteList));
  show(noteList);
});

//Display the Elements of array in LocalStorage
function show(noteList) {
  let listItems = "";
  for (let i = 0; i < noteList.length; i++) {
    listItems += `
            
    <div class="note">
     <span class="close" onclick="deleteval('${i}')">&times;</span>   
    <span class="noteHead">Note ${i + 1}</span>  <br> 
     
    ${noteList[i].slice(0, 50)}.....  <br>
    <button  onclick="calmodel('${noteList[i]}')">Show</button>
    
 
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
  info.innerText = val;
  modal.style.display = "block";
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
