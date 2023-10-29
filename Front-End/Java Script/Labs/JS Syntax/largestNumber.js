const STRING_THE_LARGEST_NUMBER_IS = "The largest number is";
function getLargestNumber(num1, num2, num3) {
    let largestNum;

    if (num1 > num2 && num1 > num3) largestNum = num1;
    else if (num2 > num1 && num2 > num3) largestNum = num2;
    else if (num3 > num1 && num3 > num2) largestNum = num3;

    return largestNum;
}

console.log(`${STRING_THE_LARGEST_NUMBER_IS} ${getLargestNumber(-3, -5, -22.5)}.`);