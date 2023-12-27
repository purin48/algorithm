const [n, ...arr] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(/\s/)
  .map((item) => +item);

for (let i = 0; i < n; i++) {
  const multi = i * 3;
  const H = arr[multi];
  const W = arr[multi + 1];
  let N = arr[multi + 2];

  // H * W 호텔의 호 -> 층 순서로 이중 for문으로 돌리기(호가 우선)
  for (let w = 1; w <= W; w++) {
    for (let h = 1; h <= H; h++) {
      if (N > 0) {
        N -= 1;
        if (N === 0) console.log(`${h}${w < 10 ? `0${w}` : `${w}`}`);
      } else {
        break;
      }
    }
  }
}
