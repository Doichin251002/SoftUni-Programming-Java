function getDifferenceOfEvenAndOddSums(numArray) {
    let sumEvenElements = 0;
    let sumOddElements = 0;

    numArray.forEach(num => num % 2 === 0 ? sumEvenElements += num : sumOddElements += num);

    return sumEvenElements - sumOddElements;
}

console.log(getDifferenceOfEvenAndOddSums([2,4,6,8,10]));