function getCountOccurrences(sentence, word) {
    const wordsArray = sentence.split(" ");
    let count = 0;

    for (const currentWord of wordsArray) {
        if (currentWord === word) count++;
    }

    return count;
}

console.log(getCountOccurrences('This is a word and it also is a sentence',
    'is'
));