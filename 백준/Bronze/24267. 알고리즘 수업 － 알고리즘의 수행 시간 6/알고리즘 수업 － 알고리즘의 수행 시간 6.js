const N = require("fs").readFileSync("/dev/stdin").toString().trim();
console.log(`${(BigInt(N) * BigInt(N - 1) * BigInt(N - 2)) / BigInt(6)}`);
console.log(3);