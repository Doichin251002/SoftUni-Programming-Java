function solve() {
    let text = document
        .getElementById("text").value;

    let modifiedWordsArray = text.split(" ")
        .map((e) => e.charAt(0).toUpperCase()
                + e.slice(1).toLowerCase());

    const formatCase = document
        .getElementById("naming-convention")
        .value;
    switch (formatCase) {
        case "Pascal Case": break;
        case "Camel Case":
            const firstWord =
                modifiedWordsArray[0].charAt(0)
                    .toLowerCase()
                + modifiedWordsArray[0].slice(1);

            modifiedWordsArray.splice(0, 1, firstWord);
            break;
        default:
            modifiedWordsArray.splice(0, modifiedWordsArray.length, "Error!");
            break;
    }

    const result = document.getElementById("result");
    result.textContent = modifiedWordsArray.join("");
}