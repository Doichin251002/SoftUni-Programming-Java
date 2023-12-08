function attachEvents() {
    const baseUrl = "http://localhost:3030/jsonstore/collections/books";

    const loadBooksButton = document.getElementById("loadBooks");
    const bodyTableElement = document.getElementsByTagName("tbody")[0];
    const createBookButton = document.querySelector("#form button");
    const inputTitleElement = document.querySelector("#form input[name=title]");
    const inputAuthorElement = document.querySelector("#form input[name=author]");
    const inputIdElement = document.querySelector("#form input[name=id]");

    const updateBookButton = document.createElement("button");
    updateBookButton.textContent = "Update";

    loadBooksButton.addEventListener("click", () => {
        fetch(baseUrl)
            .then(res => res.json())
            .then(result => {
                bodyTableElement.innerHTML = "";

                const books = Object.keys(result).reduce((acc, _id) => {
                    acc.push({_id, ...result[_id]});
                    return acc;
                }, []);

                books.map(b => createBookRow(b))
                    .forEach(e => bodyTableElement.appendChild(e));
            });
    });

    createBookButton.addEventListener("click", (e) => {
        e.preventDefault();

        const title = inputTitleElement.value;
        const author = inputAuthorElement.value;

        fetch(baseUrl, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({title, author})
        })
            .then(res => res.json())
            .then(() => {
                const bookElement = createBookRow({title, author});
                bodyTableElement.appendChild(bookElement);

                inputTitleElement.value = "";
                inputAuthorElement.value = "";
            })
            .catch(err => console.log(err));
    });

    updateBookButton.addEventListener("click", (e) => {
        e.preventDefault();

        const title = inputTitleElement.value;
        const author = inputAuthorElement.value;
        const id = inputIdElement.value;

        if (!id) {
            return;
        }

        fetch(`${baseUrl}/${id}`, {
            method: "PUT",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify({title, author, _id: id})
        })
            .then(res => res.json())
            .then(data => {
                const currentBookRow = bodyTableElement.querySelector("tr[data-update=true]");

                const titleCell = currentBookRow.firstChild;
                const authorCell = titleCell.nextSibling;

                titleCell.textContent = title;
                authorCell.textContent = author;

                const editButton = currentBookRow.querySelector("button");
                editButton.textContent = "Edit";
                updateBookButton.replaceWith(createBookButton);
                currentBookRow.removeAttribute("data-update");
                
                inputTitleElement.value = "";
                inputAuthorElement.value = "";
                inputIdElement.value = "";
            })
    })

    function createBookRow(book) {
        const bookRow = document.createElement("tr");

        const titleCell = document.createElement("td");
        titleCell.textContent = book.title;

        const authorCell = document.createElement("td");
        authorCell.textContent = book.author;

        const editButton = document.createElement("button");
        editButton.textContent = "Edit";
        editButton.addEventListener("click", (e) => {
            e.preventDefault();

            if (editButton.textContent === "Cancel") {
                inputTitleElement.value = "";
                inputAuthorElement.value = "";
                inputIdElement.value = "";

                editButton.textContent = "Edit";

                updateBookButton.replaceWith(createBookButton);
                bookRow.removeAttribute("data-update");

                return;
            }

            inputTitleElement.value = book.title;
            inputAuthorElement.value = book.author;
            inputIdElement.value = book._id;

            editButton.textContent = "Cancel";

            createBookButton.replaceWith(updateBookButton);
            bookRow.setAttribute("data-update", true);
        });

        const deleteButton = document.createElement("button");
        deleteButton.textContent = "Delete";

        const buttonsCell = document.createElement("td");
        buttonsCell.appendChild(editButton);
        buttonsCell.appendChild(deleteButton);

        bookRow.appendChild(titleCell);
        bookRow.appendChild(authorCell);
        bookRow.appendChild(buttonsCell);

        return bookRow;
    }
}

attachEvents();