function isPositiveResult(num1, num2, num3) {
    const numArr = [num1, num2, num3];

    const negativeNumbersCount = numArr.filter((num) => num < 0).length;

    return negativeNumbersCount === 0 || negativeNumbersCount === 2;
}

function printSignResult(num1, num2, num3) {
    const signCheck = isPositiveResult(num1, num2, num3);

    signCheck ? console.log("Positive") : console.log("Negative");
}

printSignResult(5, 12, -15);
printSignResult(-6, -12, 14);
printSignResult(-1, -2, -3);
printSignResult(-5, 1, 1);