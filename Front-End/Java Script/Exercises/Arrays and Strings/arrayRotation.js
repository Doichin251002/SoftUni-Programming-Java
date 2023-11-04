function printRotatedArray(numArray, rotationsCount) {
    for (let i = 0; i < rotationsCount; i++) {
        let firstNum = numArray.shift();
        numArray.push(firstNum);
    }

    console.log(numArray.join(" "));
}

printRotatedArray([51, 47, 32, 61, 21], 2);