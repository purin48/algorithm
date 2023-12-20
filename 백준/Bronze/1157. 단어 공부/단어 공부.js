const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("");

// 알파벳 26자 길이만큼의 0으로 채워진 배열 생성
const alphabet = Array("Z".charCodeAt() - "A".charCodeAt() + 1).fill(0);

// 입력값 대문자로 변경
const arr = input.map((item) => {
  return item.toUpperCase();
});

// 알파벳 유니코드로 변경 후, 해당하는 idx에 + 1 카운트
arr.forEach((item) => {
  const idx = item.charCodeAt() - "A".charCodeAt();
  alphabet[idx] += 1;
});

// 알파벳 배열 중 최댓값 찾고 중복 검사 & 알파벳 최댓값 idx 뽑기
const maxVal = Math.max(...alphabet);
let maxValCnt = 0;
let maxValIdx;

alphabet.forEach((item, alphabetIdx) => {
  if (item === maxVal) {
    maxValCnt += 1;
    maxValIdx = alphabetIdx;
  }
});

// 최댓값 중복이면 "?" 출력, 아니면 유니코드에 해당하는 알파벳 출력
maxValCnt > 1
  ? console.log("?")
  : console.log(String.fromCharCode(maxValIdx + "A".charCodeAt()));
