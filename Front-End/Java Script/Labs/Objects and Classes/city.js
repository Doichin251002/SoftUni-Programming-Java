function printCityData(cityObject) {

    for (const entry of Object.entries(cityObject)) {
        const [key, value] = entry;
        console.log(`${key} -> ${value}`);
    }
}

printCityData({
        name: "Sofia",
        area: 492,
        population: 1238438,
        country: "Bulgaria",
        postCode: "1000"
    }
);