//array decleration
let expenceList = [];

//assign elements to variablre by id
const eInput = document.getElementById("eText");
const eDate = document.getElementById("edate");
const eAmt = document.getElementById("eAmt");
const submitBtn = document.getElementById("submitBtn");
const ulEl = document.getElementById("ul-el");

//assigning localStorage value
const leadsFromLocalStorage = JSON.parse(localStorage.getItem("expenceList"));

//display previous element of array in localStorage
if (leadsFromLocalStorage) {
  expenceList = leadsFromLocalStorage;
  show(expenceList);
}

//Entering elements into localStorage through button click
submitBtn.addEventListener("click", function () {
  expenceList.push({ name: eInput.value, date: eDate.value, Amt: eAmt.value });
  eInput.value = "";
  eDate.value = "";
  eAmt.value = "";
  localStorage.setItem("expenceList", JSON.stringify(expenceList));
  show(expenceList);
});

//Display the Elements of array in LocalStorage
function show(expenceList) {
  let listItems = `<table>
  <tr>
    <th>Name</th>
    <th>Date</th>
    <th>Amount</th>
  </tr>`;
  for (let i = 0; i < expenceList.length; i++) {
    listItems += `
            
    <tr>
    <td>
               
    ${expenceList[i].name}  

</td>
    <td>${expenceList[i].date}  </td>
    <td>${expenceList[i].Amt}</td>
    <td><button onclick="deleteval('${i}')">Delete</button></td>
  </tr>
    
        `;
  }
  listItems += `</table>`;
  ulEl.innerHTML = listItems;
}

//Deleting Single element in array and displaying
function deleteval(val) {
  for (let i = 0; i < expenceList.length; i++) {
    if (i == val) {
      // alert(myToDo[i] + " " + i);
      expenceList.splice(i, 1);
    }
  }
  localStorage.setItem("expenceList", JSON.stringify(expenceList));
  show(expenceList);
}
