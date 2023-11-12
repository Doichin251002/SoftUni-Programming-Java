function printIsValidPassword(password) {
    function hasValidLength(password) {
        return password.length >= 6 && password.length <= 10;
    }

    function hasOnlyLettersAndDigits(password) {
        const regex = /^\w+$/gm;
        return regex.test(password);
    }

    function has2Digits(password) {
        const passwordArr = password.split("");
        let countDigits = 0;

        for (const passwordArrElement of passwordArr) {
            if (!isNaN(passwordArrElement)) {
                countDigits++;
            }

            if (countDigits === 2) {
                return true;
            }
        }
    }

    const validLength = hasValidLength(password);
    const validContent = hasOnlyLettersAndDigits(password);
    const validCountDigits = has2Digits(password);

    if (!validLength) {
        console.log("Password must be between 6 and 10 characters");
    }
    if (!validContent) {
        console.log("Password must consist only of letters and digits");
    }
    if (!validCountDigits) {
        console.log("Password must have at least 2 digits");
    }

    if (hasValidLength(password) && hasOnlyLettersAndDigits(password) && has2Digits(password)) {
        console.log("Password is valid");
    }
}

printIsValid('logIn');
printIsValid('MyPass123');
printIsValid('Pa$s$s');