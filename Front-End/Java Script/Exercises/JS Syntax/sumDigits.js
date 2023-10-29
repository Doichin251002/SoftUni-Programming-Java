function printSumOfDigits(num) {
    let sum = 0;
    let numAsString = num.toString();

    for (let i = 0; i < numAsString.length; i++) {
        let currentNum = Number(numAsString[i]);

        sum += currentNum;
    }

    console.log(sum);
}

printSumOfDigits(543);