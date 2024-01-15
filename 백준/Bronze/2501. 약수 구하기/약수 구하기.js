const [N, K] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .split(" ")
  .map((i) => +i);

let arr = [];
for (let i = 1; i <= N; i++) {
  if (N % i === 0) {
    arr.push(i);
  }
}

arr.sort((a, b) => a - b);
arr.length >= K ? console.log(arr[K - 1]) : console.log(0);
