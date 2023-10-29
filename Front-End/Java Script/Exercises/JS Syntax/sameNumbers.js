function printAreSameNumbersAndSum(number) {
    let isSame = true;

    let numberAsString = number.toString();
    let sum = Number(numberAsString[0]);

    for (let i = 0; i < numberAsString.length - 1; i++) {
        let currentNum = numberAsString[i];

        if (currentNum !== numberAsString[i + 1]) {
            isSame = false;
        }

        sum += Number(numberAsString[i + 1]);
    }

    console.log(isSame);
    console.log(sum);
}

printAreSameNumbersAndSum(1234);