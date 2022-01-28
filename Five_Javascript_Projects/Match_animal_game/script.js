const arr = ["1.jpg", "2.jpg", "3.jpg"];
let img1 = 0;
let img2 = 0;
let counter = 0;
let win = 0,
  attempt = 2,
  over = 0;
const winFromLocalStorage = localStorage.getItem("win");
const overFromLocalStorage = localStorage.getItem("over");
if (winFromLocalStorage || overFromLocalStorage) {
  over = overFromLocalStorage;
  win = winFromLocalStorage;
  document.getElementById("attempt").innerText = " " + attempt;
  show();
}
function st(name, x) {
  name.classList.toggle("hover");
  let a = Math.floor(Math.random() * 3);
  if (img1 != 0) img2 = a;
  else img1 = a;
  attempt--;
  document.getElementById("attempt").innerText = " " + attempt;
  switch (x) {
    case 1:
      document.getElementById("backone").innerHTML = `<img src="${arr[a]}" />`;
      break;
    case 2:
      document.getElementById("backtwo").innerHTML = `<img src="${arr[a]}" />`;
      break;
    case 3:
      document.getElementById("backthree").innerHTML = `<img src="${arr[a]}"/>`;
      break;
    case 4:
      document.getElementById("backfour").innerHTML = `<img src="${arr[a]}" />`;
      break;
    case 5:
      document.getElementById("backfive").innerHTML = `<img src="${arr[a]}" />`;
      break;
    case 6:
      document.getElementById("backsix").innerHTML = `<img src="${arr[a]}" />`;
      break;
  }
  counter++;
  if (counter == 2 && img1 == img2) {
    document.getElementById("display").innerText = `You won`;
    win++;
    localStorage.setItem("win", win);
    show();
  } else if (counter == 2 && img1 != img2) {
    document.getElementById("display").innerText = `You loose`;
    over++;
    localStorage.setItem("over", over);
    show();
  } else if (counter > 2) {
    location.reload();
    show();
  }
}
function show() {
  document.getElementById("displaywon").innerText = `No of Wins :${win}`;
  document.getElementById("displayover").innerText = `No of loose: ${over}`;
  let a = parseInt(over) + parseInt(win);
  let winP = Math.floor((parseInt(win) / a) * 100);
  if (a == 0) winP = 0;
  document.getElementById(
    "displaytotal"
  ).innerText = `Total No Of Trys: ${a} & you'r win percentage: ${winP} % `;
  document.getElementById("attempt").innerText = " " + attempt;
}
function re() {
  over = 0;
  win = 0;
  localStorage.setItem("win", win);
  localStorage.setItem("over", over);
  show();
}
