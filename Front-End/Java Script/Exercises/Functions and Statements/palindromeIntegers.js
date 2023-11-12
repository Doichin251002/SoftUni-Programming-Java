function printArePalindromeNumbers(numArray) {
    for (const numArrayElement of numArray) {
        if (numArrayElement < 0) {
            return;
        }

        console.log(isPalindromeNumber(numArrayElement));
    }
}

function isPalindromeNumber(num) {
    const numString = num.toString();
    const reversedNum = numString.split('').reverse().join('');

    return numString.toString() === reversedNum.toString();
}

printArePalindromeNumbers([123,323,421,121]);
printArePalindromeNumbers([32,2,232,1010]);