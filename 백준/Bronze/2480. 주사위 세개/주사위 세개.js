let [...arr] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map((item) => +item);

arr.sort((a, b) => a - b);
let result = 0;

if (arr[0] === arr[1] && arr[1] === arr[2]) {
  result = 10000 + arr[0] * 1000;
} else if (arr[0] === arr[1] && arr[1] !== arr[2]) {
  result = 1000 + arr[0] * 100;
} else if (arr[1] === arr[2] && arr[2] !== arr[0]) {
  result = 1000 + arr[1] * 100;
} else if (arr[2] === arr[0] && arr[0] !== arr[1]) {
  result = 1000 + arr[2] * 100;
} else {
  result = arr[2] * 100;
}
console.log(result);