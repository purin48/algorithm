const [...input] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("");
const reverseInput = [...input];

reverseInput.reverse();
input.join("") === reverseInput.join("") ? console.log(1) : console.log(0);
