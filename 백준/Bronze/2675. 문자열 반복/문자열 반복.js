const [n, ...input] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((item) => item.split(" "));

input.forEach((item, idx) => {
  const strItem = item[1].split("");
  let strArr = [];
  for (let i = 0; i < strItem.length; i++) {
    for (let j = 0; j < item[0]; j++) {
      strArr.push(strItem[i]);
    }
  }
  console.log(strArr.join(""));
});
