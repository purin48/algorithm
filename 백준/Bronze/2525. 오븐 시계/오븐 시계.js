let [hh, mm, addTime] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(/\s/)
  .map((item) => +item);

/*
    HH:MM 시간에 addTime을 더한 시간을 return
    이때, 시간 범위는 0 <= HH <= 23 | 0 <= MM <= 59 
*/

if (mm + addTime > 59) {
  hh = hh + Math.floor((mm + addTime) / 60);
  mm = (mm + addTime) % 60;
  if (hh > 23) {
    hh = hh - 24;
  }
} else {
  mm = mm + addTime;
}

console.log(`${hh} ${mm}`);