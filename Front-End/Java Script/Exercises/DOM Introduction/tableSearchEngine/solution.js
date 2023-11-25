function solve() {
    document.querySelector('#searchBtn')
        .addEventListener('click', onClick);

    function onClick() {
        const searchingText = document
            .getElementById("searchField")
            .value;
        const tableRowsArray = Array.from(document
            .querySelectorAll("tbody tr"));

        for (const row of tableRowsArray) {
            row.classList.remove("select");

            if (searchingText !== "" && row.textContent
                .includes(searchingText)) {
                row.className = "select";
            }
        }
    }
}