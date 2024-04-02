const input = require("fs").readFileSync("/dev/stdin").toString();
const [n, ...arr] = input.trim().split("\n");

const fileName = arr[0].split("");
for (let i = 0; i < n; i++) {
  for (let j = 0; j < fileName.length; j++) {
    if (fileName[j] !== arr[i].split("")[j]) {
      fileName[j] = "?";
    }
  }
}
console.log(fileName.join(""));