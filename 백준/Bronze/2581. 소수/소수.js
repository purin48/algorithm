const [M, N] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .split("\n")
  .map((i) => +i);

const primeArr = [];

const isPrime = (num) => {
  let primeYN = true;
  if (num > 1) {
    for (let i = 2; i < num; i++) {
      if (num !== 2 && num % i === 0) {
        primeYN = false;
      }
    }
    primeYN ? primeArr.push(num) : "";
  }
};

for (let i = M; i <= N; i++) {
  isPrime(i);
}

if (primeArr.length > 0) {
  const total = primeArr.reduce((prev, cur) => prev + cur); // 누적합
  console.log(total);
  console.log(Math.min(...primeArr)); // 최솟값
} else {
  console.log(-1);
}
