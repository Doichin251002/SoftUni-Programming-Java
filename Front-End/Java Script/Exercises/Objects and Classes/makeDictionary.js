function printDictionary(jsonStringsArray) {
    let dictionary = {};
    for (const jsonString of jsonStringsArray) {
        const obj = JSON.parse(jsonString);
        const term = Object.keys(obj)[0];
        const definition = Object.values(obj)[0];

        dictionary[term] = definition;
    }

    const dictionaryEntriesArray = Object.entries(dictionary)
        .sort((a, b) => a[0].localeCompare(b[0]));

    for (const [term, definition] of dictionaryEntriesArray) {
        console.log(`Term: ${term} => Definition: ${definition}`);
    }
}

printDictionary([
        '{"Coffee":"A hot drink made from the roasted and ground seeds (coffee beans) of a tropical shrub."}',
        '{"Bus":"A large motor vehicle carrying passengers by road, typically one serving the public on a fixed route and for a fare."}',
        '{"Boiler":"A fuel-burning apparatus or container for heating water."}',
        '{"Tape":"A narrow strip of material, typically used to hold or fasten something."}',
        '{"Microphone":"An instrument for converting sound waves into electrical energy variations which may then be amplified, transmitted, or recorded."}'
    ]
);