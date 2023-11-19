function printObject(jsonString) {
    let object = JSON.parse(jsonString);

    for (const entry of Object.entries(object)) {
        const [key, value] = entry;
        console.log(`${key}: ${value}`);
    }
}

printObject('{"name": "George", "age": 40, "town": "Sofia"}');