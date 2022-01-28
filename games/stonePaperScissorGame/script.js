let hands = ["stone", "paper", "scissor"];
let playerOne = "";
let playerTwo = "";
let message = "";
var imageOne = document.getElementById("myImageOne");
var imageTwo = document.getElementById("myImageTwo");
var msgEl = document.getElementById("msg-el");

// Create a function that returns a random item from the array

function randomHands() {
  let a = Math.floor(Math.random() * 3);
  return a;
}

function changeImage() {
  playerOne = hands[randomHands()];
  playerTwo = hands[randomHands()];
  console.log("player 1 hand : " + playerOne);
  console.log("player 2 hand : " + playerTwo);

  if (playerOne == "stone") {
    imageOne.src = "stone.jpg";
  } else if (playerOne == "scissor") {
    imageOne.src = "scissors.jpg";
  } else {
    imageOne.src = "paper.jpg";
  }
  if (playerTwo == "stone") {
    imageTwo.src = "stone.jpg";
  } else if (playerTwo == "scissor") {
    imageTwo.src = "scissors.jpg";
  } else {
    imageTwo.src = "paper.jpg";
  }

  if (
    (playerOne === "stone" && playerTwo === "scissor") ||
    (playerOne === "scissor" && playerTwo === "paper") ||
    (playerOne === "paper" && playerTwo === "stone")
  ) {
    message = "player 1 win!!";
    console.log("player 1 win!!");
  } else if (
    (playerTwo === "stone" && playerOne === "scissor") ||
    (playerTwo === "scissor" && playerOne === "paper") ||
    (playerTwo === "paper" && playerOne === "stone")
  ) {
    message = "player 2 win!!";
    console.log("player 2 win!!");
  } else {
    message = "Draw ..!! Please try Again";
    console.log("Draw ..!!");
  }

  msgEl.textContent = "Result : " + message;
}
