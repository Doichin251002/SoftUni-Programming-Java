function printHashTagWords(string) {
    let wordsOfStringArray = string.split(" ");

    for (const currentWord of wordsOfStringArray) {
        if (currentWord.match("#[A-z]+\\b")) {
            console.log(currentWord.replace("#", ""));
        }
    }
}

printHashTagWords('The symbol # is known #variously in English-speaking #regions as the #number sign');