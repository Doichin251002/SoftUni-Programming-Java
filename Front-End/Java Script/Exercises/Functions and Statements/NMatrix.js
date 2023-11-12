function printNMatrix(size) {
    function printRow(num) {
        console.log((num.toString() + " ").repeat(size));
    }

    for (let i = 0; i < size; i++) {
        printRow(size);
    }
}

printNMatrix(3);