function printIsPerfectNumber(num) {
    let sum = 0;

    for (let i = 0; i < num; i++) {
        if (num % i === 0) {
            sum += i;
        }
    }

    if (sum === num) {
        console.log("We have a perfect number!");
    } else {
        console.log("It's not so perfect.");
    }
}

printIsPerfectNumber(6);
printIsPerfectNumber(28);
printIsPerfectNumber(1236498);