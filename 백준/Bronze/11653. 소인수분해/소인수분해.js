const N = Number(require("fs").readFileSync("/dev/stdin").toString());

const arr = [];

// 소인수분해 재귀함수
const recursion = (num) => {
  if (num > 1) {
    for (let i = 2; i <= num; i++) {
      if (num % i === 0) {
        arr.push(i);
        recursion(num / i);
        break;
      }
    }
  }
};

if (N !== 1) {
  recursion(N);
  console.log(arr.join("\n"));
}
