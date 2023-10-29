function printNumberForCooking(numberAsString, op1, op2, op3, op4, op5) {
    let number = Number(numberAsString);

    const listOfOperations = Array.of(op1, op2, op3, op4, op5);

    for (let i = 0; i < 5; i++) {
        switch (listOfOperations[i]) {
            case "chop": number /= 2; break;
            case "dice": number = Math.sqrt(number); break;
            case "spice": number++; break;
            case "bake": number *= 3; break;
            case "fillet": number = (number * 0.8).toFixed(1);
        }

        console.log(number);
    }
}

printNumberForCooking('9', 'dice', 'spice', 'chop', 'bake', 'fillet');