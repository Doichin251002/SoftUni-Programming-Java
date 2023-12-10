function attachEvents() {
    const baseUrl = "http://localhost:3030/jsonstore/phonebook";

    const phoneBookUl = document.getElementById("phonebook");
    const [personInput, phoneInput] = document.getElementsByTagName("input");
    const [loadButton, createButton] = document.getElementsByTagName("button");

    let contacts = {};

    loadButton.addEventListener("click", async () => {
        phoneBookUl.innerHTML = "";

        const response = await fetch(baseUrl);
        contacts = await response.json();

        for (const {person, phone, _id} of Object.values(contacts)) {
            const liElement = document.createElement("li");
            liElement.id = _id;
            liElement.textContent = `${person}: ${phone}`;

            const deleteButton = document.createElement("button");
            deleteButton.textContent = "Delete";

            liElement.appendChild(deleteButton);
            phoneBookUl.appendChild(liElement);

            deleteButton.addEventListener("click", async () => {
                const currentId = _id;

                await fetch(baseUrl + "/" + currentId, {method: "DELETE"});

                liElement.remove();
            });
        }
    });

    createButton.addEventListener("click", async () => {
        const contactFormat = {
            person: personInput.value,
            phone: phoneInput.value
        };

        await fetch(baseUrl, {
            method: "POST",
            body: JSON.stringify(contactFormat)
        });

        personInput.value = "";
        phoneInput.value = "";
    });
}

attachEvents();