function printSumOfEvenAndOddDigits(num) {
    const numString = num.toString();
    const numStringLength = numString.length;

    let evenSum = 0;
    let oddSum = 0;
    let lastDigit;

    for (let i = 0; i < numStringLength; i++) {
        lastDigit = Number(numString[i]);

        lastDigit % 2 === 0 ? evenSum += lastDigit : oddSum += lastDigit;
    }

    console.log(`Odd sum = ${oddSum}, Even sum = ${evenSum}`);
}

printSumOfEvenAndOddDigits(1000435);
printSumOfEvenAndOddDigits(3495892137259234);