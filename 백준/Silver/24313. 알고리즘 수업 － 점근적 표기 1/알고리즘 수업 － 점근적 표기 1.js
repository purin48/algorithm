const [a1, a0, c, n] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .split(/\s/)
  .map((i) => +i);

const fn = a1 * n + a0;
const gn = n;

fn <= c * gn && a1 <= c ? console.log(1) : console.log(0);