function printWordsOccurs(inputStringsArray) {
    let [searchingWordsString, ...inputWordsArray] = inputStringsArray;

    const searchingWordsArray = searchingWordsString.split(" ");

    let wordOccursObject = {};
    for (const word of searchingWordsArray) {
        const occurs = inputWordsArray.filter((e) => e === word).length;

        wordOccursObject[word] = occurs;
    }

    const entries = Object.entries(wordOccursObject)
        .sort((a, b) => b[1] - a[1]);

    for (const [word, occurs] of entries) {
        console.log(`${word} - ${occurs}`);
    }
}

printWordsOccurs([
    'is the',
    'first', 'sentence', 'Here', 'is', 'another', 'the', 'And', 'finally', 'the', 'the', 'sentence']
);