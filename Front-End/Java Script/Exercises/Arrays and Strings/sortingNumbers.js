function sortNumbers(numArray) {
    numArray.sort((a, b) => a - b);

    let sortedArray = [];
    while (numArray.length) {
        let smallestNum = numArray.shift();
        let biggestNum = numArray.pop();
        sortedArray.push(smallestNum, biggestNum);
    }

    return sortedArray;
}

console.log(sortNumbers([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]));