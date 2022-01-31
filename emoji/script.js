const arr = [
  "1.png",
  "2.png",
  "3.png",
  "4.png",
  "5.png",
  "6.png",
  "7.png",
  "8.png",
  "9.png",
  "10.png",
  "11.png",
  "12.png",
];
let counter = 0;
let random = [];
let check = [];
let high = 0;
let highScore = localStorage.getItem("high");
const emoji = document.getElementsByClassName("box");
if (highScore) {
  high = highScore;
  document.getElementById("score").innerText = high;
}
function load(val) {
  let x = emoji[val - 1].innerHTML;
  x = x.trim();
  if (check.includes(x) == false) {
    counter++;
    document.getElementById("count").innerText = counter;
    check.push(x);
    if (counter > high) {
      high = counter;
      localStorage.setItem("high", high);
      document.getElementById("score").innerText = high;
    }
  } else {
    if (counter > high) {
      high = counter;
      localStorage.setItem("high", high);
      document.getElementById("score").innerText = high;
    }
    swal("You Loose!", "Your Current Score: " + counter + "/12", "error");
    check = [];
    counter = 0;
    document.getElementById("count").innerText = counter;
  }
  if (counter == 12) {
    swal(
      "You Won!",
      "Great Job! Your Current Score: " + counter + "/12",
      "success"
    );
    counter = 0;
    document.getElementById("count").innerText = counter;
    check = [];
  }
  while (random.length <= 12) {
    let a = Math.floor(Math.random() * 12);
    if (random.includes(a) == false) random.push(a);
    if (random.length == 12) break;
  }
  for (let i = 0; i < 12; i++) {
    emoji[i].innerHTML = `<img class="img" src="${arr[random[i]]}" />`;
  }
  random = [];
}
