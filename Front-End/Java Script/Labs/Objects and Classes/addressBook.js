function printPersonAndAddress(personAddressStringArray) {
    function getAddressBook (personAddressStringArray) {
        let addressBook = {};
        for (const currentPersonAddressString of personAddressStringArray) {
            const [person, address] = currentPersonAddressString.split(":");

            addressBook[person] = address;
        }

        return addressBook;
    }

    const addressBook = getAddressBook(personAddressStringArray);

    const persons = Object.keys(addressBook).sort((a, b) => a.localeCompare(b));

    for (const currentPerson of persons) {
        console.log(`${currentPerson} -> ${addressBook[currentPerson]}`);
    }
}

printPersonAndAddress(['Tim:Doe Crossing',
    'Bill:Nelson Place',
    'Peter:Carlyle Ave',
    'Bill:Ornery Rd']
);