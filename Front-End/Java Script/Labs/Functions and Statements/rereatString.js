function repeatString(string, countForRepeating) {
    let result = string;
    for (let i = 1; i < countForRepeating; i++) {
        result += string;
    }

    return result;
}

console.log(repeatString("abc", 3));
console.log(repeatString("String", 2));