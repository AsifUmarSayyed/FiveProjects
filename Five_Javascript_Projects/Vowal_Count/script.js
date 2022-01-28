//assign elements to variablre by id
const eInput = document.getElementById("eText");
let counter = 0;
const submitBtn = document.getElementById("submitBtn");

submitBtn.addEventListener("click", function () {
  let str = eInput.value;
  for (let i = 0; i < str.length; i++) {
    if (
      str.charAt(i) == "a" ||
      str.charAt(i) == "e" ||
      str.charAt(i) == "i" ||
      str.charAt(i) == "o" ||
      str.charAt(i) == "u" ||
      str.charAt(i) == "A" ||
      str.charAt(i) == "E" ||
      str.charAt(i) == "I" ||
      str.charAt(i) == "O" ||
      str.charAt(i) == "U"
    ) {
      counter++;
    }
  }
  alert("No of Vowels are : " + counter);
  eInput.value = "";
});
