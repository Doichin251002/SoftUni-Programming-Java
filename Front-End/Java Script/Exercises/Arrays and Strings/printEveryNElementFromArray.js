function getEveryNElementFromArray(stringArray, step) {
    let everyStepElementArray = [];
    const arrayLength = stringArray.length;

    for (let i = 0; i < arrayLength; i += step) {
        everyStepElementArray.push(stringArray[i]);
    }

    return everyStepElementArray;
}

console.log(getEveryNElementFromArray(['1',
        '2',
        '3',
        '4',
        '5'],
    6

));