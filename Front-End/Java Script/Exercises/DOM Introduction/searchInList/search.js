function search() {
    const searchingText = document
        .getElementById("searchText").value;

    const townsArray = Array.from
    (document.getElementById("towns")
        .children);

    let matches = 0;
    for (const town of townsArray) {
        town.style.fontWeight
            = "initial";
        town.style.textDecoration
            = "initial";

        if (town.textContent
            .includes(searchingText)) {
            town.style.fontWeight = "bold";
            town.style.textDecoration = "underline";

            matches++;
        }
    }

    const result = document
        .getElementById("result");

    result.textContent = `${matches} matches found`;
}
