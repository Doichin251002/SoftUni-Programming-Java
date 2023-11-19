function printEnteredCars(carNumberStringsArray) {
    let enteredCars = [];
    for (const carNumberString of carNumberStringsArray) {
        const [state, carNumber] = carNumberString.split(", ");

        const searchingCar = enteredCars.find((e) => e === carNumber);
        if (state === "IN" && searchingCar === undefined) {
            enteredCars.push(carNumber);
        } else if (state === "OUT" && searchingCar) {
            const indexOfSearingCar = enteredCars.indexOf(carNumber);

            enteredCars.splice(indexOfSearingCar, 1);
        }
    }

    if (enteredCars.length === 0) {
        console.log("Parking Lot is Empty");
    } else {
        enteredCars.sort((a, b) => a.localeCompare(b));

        enteredCars.forEach((e) => console.log(e));
    }
}

printEnteredCars(['IN, CA2844AA',
    'IN, CA1234TA',
    'OUT, CA2844AA',
    'IN, CA9999TT',
    'IN, CA2866HI',
    'OUT, CA1234TA',
    'IN, CA2844AA',
    'OUT, CA2866HI',
    'IN, CA9876HH',
    'IN, CA2822UU']
);

printEnteredCars(['IN, CA2844AA',
    'IN, CA1234TA',
    'OUT, CA2844AA',
    'OUT, CA1234TA']
);