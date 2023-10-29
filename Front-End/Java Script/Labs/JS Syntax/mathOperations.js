function printResult(num1, num2, operation) {
    if (typeof num1 === typeof num2) {
        let result;

        switch (operation) {
            case "+": result = num1 + num2; break;
            case "-": result = num1 - num2; break;
            case "*": result = num1 * num2; break;
            case "/": result = num1 / num2; break;
            case "%": result = num1 % num2; break;
            case "**": result = num1 ** num2;
        }

        console.log(result);
    }
}

printResult(10, "1", "*");