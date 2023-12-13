const fs = require('fs');
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let num1 = input[0];
let num2 = input[1];
let num2Arr = [...String(input[1])];

for(let i=num2Arr.length-1; i>=0; i--) {
    console.log(num1 * num2Arr[i]);
}
console.log(num1 * num2);
