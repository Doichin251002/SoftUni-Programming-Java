function solve() {
    const generateButton = document.getElementsByTagName("button")[0];
    generateButton.addEventListener("click", generateFurniture);

    const buyButton = document.getElementsByTagName("button")[1];
    buyButton.addEventListener("click", buyFurniture);

    function generateFurniture() {
        const inputTextAreaElement = document.getElementsByTagName("textarea")[0];
        const furnitureArray = JSON.parse(inputTextAreaElement.value);

        if (!furnitureArray) {
            return;
        }

        const tBodyElement = document.getElementsByTagName("tbody")[0];

        for (const furnitureObject of furnitureArray) {
            const rowElement = tBodyElement.insertRow(-1);

            for (const [key, value] of Object.entries(furnitureObject)) {
                let cellContent;

                if (key !== "img") {
                    cellContent = document.createElement("p");
                    cellContent.textContent = value.toString();
                } else {
                    cellContent = document.createElement(key);
                    cellContent.src = value.toString();
                }

                let cellElement;
                if (key !== "img") {
                    cellElement = rowElement.insertCell(-1);
                } else {
                    cellElement = rowElement.insertCell(0);
                }
                cellElement.appendChild(cellContent);
            }

            const checkboxElement = document.createElement("input");
            checkboxElement.type = "checkbox";

            const checkboxCellElement = rowElement.insertCell(-1);
            checkboxCellElement.appendChild(checkboxElement);
        }
    }

    function buyFurniture() {
        const tBodyElement = document.getElementsByTagName("tbody")[0];
        const checkedElementsArray = Array.from(tBodyElement.querySelectorAll("input[type = checkbox]:checked"));

        let boughtFurniture = [];
        let totalPrice = 0;
        let avgFactor = 0;

        for (const checkbox of checkedElementsArray) {
            const cellParentElement = checkbox.parentElement;
            const rowParentElement = cellParentElement.parentElement;

            const nameCellElement = rowParentElement.getElementsByTagName("td")[1];
            const nameParagraphElement = nameCellElement.getElementsByTagName("p")[0];

            boughtFurniture.push(nameParagraphElement.textContent);

            const priceCellElement = rowParentElement.getElementsByTagName("td")[2];
            const priceParagraphElement = priceCellElement.getElementsByTagName("p")[0];

            totalPrice += Number(priceParagraphElement.textContent);

            const factorCellElement = rowParentElement.getElementsByTagName("td")[3];
            const factorParagraphElement = factorCellElement.getElementsByTagName("p")[0];

            avgFactor += Number(factorParagraphElement.textContent);
        }

        avgFactor /= checkedElementsArray.length;

        const outputTextAreaElement = document.getElementsByTagName("textarea")[1];
        outputTextAreaElement.value = `Bought furniture: ${boughtFurniture.join(", ")}\n`
            + `Total price: ${totalPrice.toFixed(2)}\n`
            + `Average decoration factor: ${avgFactor}`;
    }
}