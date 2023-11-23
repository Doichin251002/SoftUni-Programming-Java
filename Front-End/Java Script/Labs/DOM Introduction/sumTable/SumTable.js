function sumTable() {
    const costCellElements = Array
            .from(document.querySelectorAll("td:nth-child(even)"))
            .map((cell) => Number(cell.textContent));

    let totalCost = 0;

    for (const cost of costCellElements) {
        totalCost += cost;
    }

    document.getElementById("sum").textContent = totalCost;
}