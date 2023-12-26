let input = require("fs").readFileSync("/dev/stdin").toString().trim();

const croAlphabetArr = ["c=", "c-", "d-", "lj", "nj", "s=", "z="];

// 크로아티아 알파벳이 input에 포함되어있다면 replace로 공백으로 변경
let cnt = 0;
for (let i = 0; i < input.length; i++) {
  croAlphabetArr.forEach((alphabet) => {
    if (input.includes("dz=")) {
      cnt += 1;
      input = input.replace("dz=", " ");
    } else if (input.includes(alphabet)) {
      cnt += 1;
      input = input.replace(alphabet, " ");
    }
  });
}

// 공백 제거 후, 기존 알파벳도 카운트
cnt += input.replaceAll(" ", "").length;
console.log(cnt);
