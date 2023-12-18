function solution(s) {
    const input = s.split(" ").map(item => +item);
    input.sort((a,b) => a - b);
    
    return `${input[0]} ${input[input.length - 1]}`;
}