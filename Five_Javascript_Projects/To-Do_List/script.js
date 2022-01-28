//array decleration
let myToDo = [];

//assign elements to variablre by id
const toDoInput = document.getElementById("toDoInput");
const submitBtn = document.getElementById("submitBtn");
const clearBtn = document.getElementById("clearBtn");
const ulEl = document.getElementById("ul-el");

//assigning localStorage value
const leadsFromLocalStorage = JSON.parse(localStorage.getItem("myToDo"));

//display previous element of array in localStorage
if (leadsFromLocalStorage) {
  myToDo = leadsFromLocalStorage;
  show(myToDo);
}

//Entering elements into localStorage through button click
submitBtn.addEventListener("click", function () {
  myToDo.push(toDoInput.value);
  toDoInput.value = "";
  localStorage.setItem("myToDo", JSON.stringify(myToDo));
  show(myToDo);
});

//Display the Elements of array in LocalStorage
function show(myToDo) {
  let listItems = "";
  for (let i = 0; i < myToDo.length; i++) {
    listItems += `
            <li>
               
                    ${myToDo[i]}  <button onclick="deleteval('${i}')">Delete</button>
                
            </li>
        `;
  }
  ulEl.innerHTML = listItems;
}

// Clearing array, localStorge & displaying it
clearBtn.addEventListener("click", function () {
  localStorage.clear();
  myToDo = [];
  show(myToDo);
});

//Deleting Single element in array and displaying
function deleteval(val) {
  for (let i = 0; i < myToDo.length; i++) {
    if (i == val) {
      // alert(myToDo[i] + " " + i);
      myToDo.splice(i, 1);
    }
  }
  localStorage.setItem("myToDo", JSON.stringify(myToDo));
  show(myToDo);
}
