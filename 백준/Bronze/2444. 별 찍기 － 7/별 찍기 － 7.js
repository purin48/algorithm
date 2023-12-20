const n = Number(require("fs").readFileSync("/dev/stdin").toString().trim());

/* 2. 1부터 N-1까지 공백과 별 찍기 */
for (let i = 1; i < n; i++) {
  let blank = " ".repeat(n - i);
  let stars = "*".repeat(i + (i - 1));
  console.log(blank + stars);
}

/* 3. N부터 1까지 공백과 별 찍기 */
for (let j = n; j > 0; j--) {
  let blank = " ".repeat(n - j);
  let stars = "*".repeat(j + (j - 1));
  console.log(blank + stars);
}
