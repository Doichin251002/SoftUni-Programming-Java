function getResultOfCalculation(num1, num2, operation) {
    const resultOfOperations = {
        add: num1 + num2,
        subtract: num1 - num2,
        multiply: num1 * num2,
        divide: num1 / num2
    };

    return resultOfOperations[operation];
}

console.log(getResultOfCalculation(5, 5, 'multiply'));
console.log(getResultOfCalculation(40, 8, 'divide'));
console.log(getResultOfCalculation(12, 19, 'add'));
console.log(getResultOfCalculation(50, 13, 'subtract'));