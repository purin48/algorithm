const fs = require('fs');
let [hh, mm] = fs.readFileSync("/dev/stdin").toString().trim().split(" ").map((item) => Number(item));

// MM - 45분, 만약 MM - 45의 값이 음수인 경우 HH에서 -1
// 만약, HH가 0이고, -1을 해야한다면 23으로 변경
if(mm - 45 < 0) {
  hh === 0 ? hh = 24 : "";
  mm = mm + 60 - 45;
  hh = hh - 1;
} else {
  mm = mm -45;
}

console.log(`${hh} ${mm}`);