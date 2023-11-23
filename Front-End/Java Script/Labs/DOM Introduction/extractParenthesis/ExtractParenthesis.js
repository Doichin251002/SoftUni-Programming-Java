function extract(id) {
    const paragraphElementContent =
        document.getElementById(id).textContent;

    const pattern = /\(([\w ]+)\)/g;
    let match = pattern.exec(paragraphElementContent);

    let wordsInBrackets = [];
    while (match) {
        wordsInBrackets.push(match[1]);

        match = pattern.exec(paragraphElementContent);
    }

    return wordsInBrackets.join("; ");
}