function revealWords(wordsString, string) {
    let wordsArray = wordsString.split(", ");

    for (const currentWord of wordsArray) {
        string = string.replace("*".repeat(currentWord.length), currentWord);
    }

    console.log(string);
}

revealWords('great, learning',
    'softuni is ***** place for ******** new programming languages'
);