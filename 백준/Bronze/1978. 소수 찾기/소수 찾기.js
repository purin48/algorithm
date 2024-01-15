const [N, ...input] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .split(/\s/)
  .map((i) => +i);

let cnt = 0;

const isPrime = (num) => {
  let primeYN = true;
  if (num > 1) {
    for (let i = 2; i < num; i++) {
      if (num !== 2 && num % i === 0) {
        primeYN = false;
      }
    }
    primeYN ? (cnt += 1) : (cnt += 0);
  }
};

input.forEach((item) => {
  isPrime(item);
});
console.log(cnt);
