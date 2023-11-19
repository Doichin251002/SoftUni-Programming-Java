function printHeroesInfo(heroInfoStringsArray) {
    let heroesArray = [];

    for (const heroInfoString of heroInfoStringsArray) {
        let [name, level, items] = heroInfoString.split(" / ");
        level = Number(level);

        heroesArray.push({name, level, items});
    }

    heroesArray.sort((e1, e2) => e1["level"] - e2["level"]);

    for (const heroObject of heroesArray) {
        const {name, level, items} = heroObject;

        console.log(`Hero: ${name}\n` +
            `level => ${level}\n` +
            `items => ${items}`);
    }
}

printHeroesInfo([
        'Isacc / 25 / Apple, GravityGun',
        'Derek / 12 / BarrelVest, DestructionSword',
        'Hes / 1 / Desolator, Sentinel, Antara'
    ]
);