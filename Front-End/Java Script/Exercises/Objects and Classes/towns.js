function printTown(townStringsArray) {
    for (const townString of townStringsArray) {
        let [name, latitude, longitude] = townString.split(" | ");

        latitude = Number.parseFloat(latitude).toFixed(2);
        longitude = Number.parseFloat(longitude).toFixed(2);

        const town = {"town": name, latitude, longitude};

        console.log(town);
    }
}

printTown(['Sofia | 42.696552 | 23.32601',
    'Beijing | 39.913818 | 116.363625']
)