function printPoweredNumber(num, pow) {
    let result = 1;
    for (let i = 0; i < pow; i++) {
        result *= num;
    }

   return result;
}

console.log(printPoweredNumber(2,8));
console.log(printPoweredNumber(3,4));