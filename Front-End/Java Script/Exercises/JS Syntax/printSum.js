function printSumNumbersFromTo(fromNum, toNum) {
    let numberLineString = "";
    let sum = 0;

    for (let i = fromNum; i <= toNum; i++) {
        numberLineString += i + " ";
        sum += i;
    }

    console.log(numberLineString.trim());
    console.log(`Sum: ${sum}`);
}

printSumNumbersFromTo(5, 10);