function findWord(searchingWord, string) {
    searchingWord = searchingWord.toLowerCase();
    string = string.toLowerCase();

    const result = string.split(" ")
        .find(word => word === searchingWord);

    if (result) {
        return result;
    } else {
        return `${word} not found!`;
    }
}

console.log(findWord('JavaScript',
    'JavaScript is the best programming language'
));