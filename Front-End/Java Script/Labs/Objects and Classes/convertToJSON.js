function printJSONString(name, lastName, hairColor) {
    console.log(JSON.stringify({name, lastName, hairColor}));
}

printJSONString('George', 'Jones', 'Brown');