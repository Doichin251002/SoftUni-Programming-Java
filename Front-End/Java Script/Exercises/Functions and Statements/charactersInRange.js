function getCharsOfRange(firstChar, lastChar) {
    let stringOfChars = "";

    const codeOfFirstChar = Math.min(firstChar.charCodeAt(), lastChar.charCodeAt());
    const codeOfLastChar = Math.max(firstChar.charCodeAt(), lastChar.charCodeAt());

    for (let i = codeOfFirstChar + 1; i < codeOfLastChar; i++) {
        stringOfChars += String.fromCharCode(i) + " ";
    }

    return stringOfChars;
}

console.log(getCharsOfRange('a', 'd'));
console.log(getCharsOfRange('#', ':'));
console.log(getCharsOfRange('C', '#'));
console.log(getCharsOfRange('Z', 'A'));