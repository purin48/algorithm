const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString();

const N = parseInt(input);

let answer = 0;

for (let i = 0; i < N; i++) {
  let sum = 0;

  const stringValue = i.toString();

  // i 자리수만큼 반복 후, 각 자리수 값을 sum값에 더해주기
  for (let j = 0; j < stringValue.length; j++) {
    sum += parseInt(stringValue[j]);
  }

  // i에 해당하는 생성자 값 sum에 넣기
  sum += i;

  if (sum === N) {
    answer = i;
    break;
  }
}

console.log(answer);