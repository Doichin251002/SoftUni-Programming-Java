function printEmployeeNumber(employeeNamesStringArray) {
    employeeNamesStringArray.forEach((employeeName) =>
            console.log(`Name: ${employeeName} -- Personal Number: ${employeeName.length}`));
}

printEmployeeNumber([
        'Silas Butler',
        'Adnaan Buckley',
        'Juan Peterson',
        'Brendan Villarreal'
    ]
);