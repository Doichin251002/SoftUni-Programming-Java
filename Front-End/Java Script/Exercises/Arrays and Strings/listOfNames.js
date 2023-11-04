function printListNames(nameArray) {
    nameArray.sort((a, b) => a.localeCompare(b));

    for (let i = 0; i < nameArray.length; i++) {
        let index = i + 1;

        console.log(`${index}.${nameArray[i]}`);
    }
}

printListNames(["John", "Bob", "Christina", "Ema"]);