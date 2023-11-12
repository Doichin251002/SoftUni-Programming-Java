function addAndSubtractNumbers(firstNum, secondNum, lastNum) {
    const sum = (first, second) => first + second;
    const subtract = (sum, last) => sum - last;

    return subtract(sum(firstNum, secondNum), lastNum);
}

console.log(addAndSubtractNumbers(10, 30, 20));