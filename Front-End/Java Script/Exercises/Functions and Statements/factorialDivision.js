function divideFactorialsOf(firstNum, lastNum) {
    return (getFactorial(firstNum) / getFactorial(lastNum)).toFixed(2);
}
function getFactorial(num) {
    if (num === 0) return 1;
    return num * getFactorial(num - 1);
}

console.log(divideFactorialsOf(5, 2));
console.log(divideFactorialsOf(6, 2));