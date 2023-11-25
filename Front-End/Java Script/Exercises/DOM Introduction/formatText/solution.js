function solve() {
    const inputText = document
        .getElementById("input").value;
    let sentencesArray = inputText.split(".");

    sentencesArray = sentencesArray
        .filter(e => e.length > 0)
        .map(e => e += ".");

    let result = document
        .getElementById("output");

    while (sentencesArray.length > 0) {
        let p = document
            .createElement("p");

        p.textContent = sentencesArray.splice(0, 3)
            .join("");

        result.appendChild(p);
    }
}