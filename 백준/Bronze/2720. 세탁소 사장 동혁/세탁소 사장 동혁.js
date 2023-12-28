const [n, ...input] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((item) => +item);

const changeM = [25, 10, 5, 1];

/*
  n번 거스름돈 계산 반복
  거스름돈 액수 분류 후 -> 0이하가 되면 분류 반복문 종료
*/
for (let i = 0; i < n; i++) {
  let dividedM = input[i];
  const moneyCnt = Array(4).fill(0);
  while (dividedM > 0) {
    if (dividedM >= changeM[0]) {
      moneyCnt[0] += Math.floor(dividedM / changeM[0]);
      dividedM = dividedM % changeM[0];
    } else if (dividedM >= changeM[1]) {
      moneyCnt[1] += Math.floor(dividedM / changeM[1]);
      dividedM = dividedM % changeM[1];
    } else if (dividedM >= changeM[2]) {
      moneyCnt[2] += Math.floor(dividedM / changeM[2]);
      dividedM = dividedM % changeM[2];
    } else if (dividedM >= changeM[3]) {
      moneyCnt[3] += Math.floor(dividedM / changeM[3]);
      dividedM = dividedM % changeM[3];
    }
  }
  console.log(moneyCnt.join(" "));
}