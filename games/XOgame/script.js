let val = 0;
let n = 0;
let first = document.getElementById("one");
let second = document.getElementById("two");
let third = document.getElementById("three");
let fourth = document.getElementById("four");
let fifth = document.getElementById("five");
let sixth = document.getElementById("six");
let seventh = document.getElementById("seven");
let eighth = document.getElementById("eight");
let ninth = document.getElementById("nine");
let display = document.getElementById("display");
first.addEventListener("click", function () {
  convert(first);
});
second.addEventListener("click", function () {
  convert(second);
});
third.addEventListener("click", function () {
  convert(third);
});
fourth.addEventListener("click", function () {
  convert(fourth);
});
fifth.addEventListener("click", function () {
  convert(fifth);
});
sixth.addEventListener("click", function () {
  convert(sixth);
});
seventh.addEventListener("click", function () {
  convert(seventh);
});
eighth.addEventListener("click", function () {
  convert(eighth);
});
ninth.addEventListener("click", function () {
  convert(ninth);
});
function result() {
  if (
    (first.innerText == "X" &&
      second.innerText == "X" &&
      third.innerText == "X") ||
    (fourth.innerText == "X" &&
      fifth.innerText == "X" &&
      sixth.innerText == "X") ||
    (seventh.innerText == "X" &&
      eighth.innerText == "X" &&
      ninth.innerText == "X") ||
    (first.innerText == "X" &&
      fifth.innerText == "X" &&
      ninth.innerText == "X") ||
    (third.innerText == "X" &&
      fifth.innerText == "X" &&
      seventh.innerText == "X") ||
    (first.innerText == "X" &&
      fourth.innerText == "X" &&
      seventh.innerText == "X") ||
    (second.innerText == "X" &&
      fifth.innerText == "X" &&
      eighth.innerText == "X") ||
    (third.innerText == "X" && sixth.innerText == "X" && ninth.innerText == "X")
  ) {
    console.log("x win!...");
    display.innerText = "X win!...";
    restart();
  } else if (
    (first.innerText == "O" &&
      second.innerText == "O" &&
      third.innerText == "O") ||
    (fourth.innerText == "O" &&
      fifth.innerText == "O" &&
      sixth.innerText == "O") ||
    (seventh.innerText == "O" &&
      eighth.innerText == "O" &&
      ninth.innerText == "O") ||
    (first.innerText == "O" &&
      fifth.innerText == "O" &&
      ninth.innerText == "O") ||
    (third.innerText == "O" &&
      fifth.innerText == "O" &&
      seventh.innerText == "O") ||
    (first.innerText == "O" &&
      fourth.innerText == "O" &&
      seventh.innerText == "O") ||
    (second.innerText == "O" &&
      fifth.innerText == "O" &&
      eighth.innerText == "O") ||
    (third.innerText == "O" && sixth.innerText == "O" && ninth.innerText == "O")
  ) {
    console.log("O win!...");
    display.innerText = "O win!...";
    restart();
  } else if (
    first.innerText != "" &&
    second.innerText != "" &&
    third.innerText != "" &&
    fourth.innerText != "" &&
    fifth.innerText != "" &&
    sixth.innerText != "" &&
    seventh.innerText != "" &&
    eighth.innerText != "" &&
    ninth.innerText != ""
  ) {
    console.log("Draw...");
    display.innerText = "Draw...";
    restart();
  }
}
function restart() {
  first.innerText = "";
  second.innerText = "";
  third.innerText = "";
  fourth.innerText = "";
  fifth.innerText = "";
  sixth.innerText = "";
  seventh.innerText = "";
  eighth.innerText = "";
  ninth.innerText = "";
  val = 0;
}
function convert(first) {
  if (first.innerText == "") {
    if (val == 0) {
      console.log("X");
      first.innerText = "X";
      val = 1;
      result();
    } else {
      console.log("O");
      first.innerText = "O";
      val = 0;
      result();
    }
  }
}
