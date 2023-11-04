function getSumOfFirstAndLastElements(numArray) {
    const firstElement = numArray.shift();
    const lastElement = numArray.pop();

    return firstElement + lastElement;
}

console.log(getSumOfFirstAndLastElements([20, 30, 40]));