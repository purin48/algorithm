const [N, M, ...arr] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .split(/\s/)
  .map((i) => +i);

let answer = 0;

for (let i = 0; i < N - 2; i++) {
  for (let j = i + 1; j < N - 1; j++) {
    for (let k = j + 1; k < N; k++) {
      let total = arr[i] + arr[j] + arr[k];
      if (answer < total && total <= M) {
        answer = total;
      }
    }
  }
}
console.log(answer);