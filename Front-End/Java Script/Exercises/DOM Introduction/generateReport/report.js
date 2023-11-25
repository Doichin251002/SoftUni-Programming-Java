function generateReport() {
    const checkboxElements = Array.from(document.getElementsByTagName("input"));
    const rowElements = Array.from(document.querySelectorAll("tbody tr"));

    let employeeKeysIndex = {};
    for (let i = 0; i < checkboxElements.length; i++) {
        const currentCheckbox = checkboxElements[i];

        if (currentCheckbox.checked) {
            employeeKeysIndex[currentCheckbox.name] = i;
        }
    }

    let employeesInfoArray = [];
    for (const row of rowElements) {
        const cells = Array.from(row.children);
        let employeeInfoObject = {};

        for (const key in employeeKeysIndex) {
            const index = employeeKeysIndex[key];
            const value = cells[index];

            employeeInfoObject[key] = value.textContent;
        }

        employeesInfoArray.push(employeeInfoObject);
    }

    let result = document.getElementById("output");
    result.textContent = JSON.stringify(employeesInfoArray, null, "  ");
}