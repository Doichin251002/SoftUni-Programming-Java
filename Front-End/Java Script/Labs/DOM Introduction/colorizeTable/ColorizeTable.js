function colorize() {
    const rowElements= document
        .querySelectorAll("tr:nth-child(even)");

    for (const row of Array.from(rowElements)) {
        row.style.background = "teal";
    }
}