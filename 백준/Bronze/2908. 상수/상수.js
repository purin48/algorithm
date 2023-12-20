let [first, second] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ");

first = first.split("").reverse().join("");
second = second.split("").reverse().join("");

first > second ? console.log(first) : console.log(second);