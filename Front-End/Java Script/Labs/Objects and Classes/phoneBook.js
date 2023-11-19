function printPersonAndPhoneNumber(personPhonesStringArray) {
    function getPhoneBook (personPhonesStringArray) {
        let phoneBook = {};
        for (let currentPersonPhoneString of personPhonesStringArray) {
            const [personName, phoneNumber] = currentPersonPhoneString.split(" ");

            phoneBook[personName] = phoneNumber;
        }

        return phoneBook;
    }

    const phoneBook = getPhoneBook(personPhonesStringArray);

    for (const personName in phoneBook) {
        console.log(`${personName} -> ${phoneBook[personName]}`);
    }
}

printPersonAndPhoneNumber(['Tim 0834212554',
    'Peter 0877547887',
    'Bill 0896543112',
    'Tim 0876566344']
);