async function attachEvents() {
    const baseURL = "http://localhost:3030/jsonstore/collections/students";

    const studentsTableBody = document.querySelector("#results tbody");
    const [firstNameInput, lastNameInput, facultyNumberInput, gradeInput] =
        document.getElementsByTagName("input");

    const submitButton = document.getElementById("submit");
    submitButton.addEventListener("click", createStudent);

    const response = await fetch(baseURL);
    const allStudents = await response.json();

    for (const student of Object.values(allStudents)) {
        rowCreator(student);
    }

    async function createStudent() {
        const isValidStudent = firstNameInput.value && lastNameInput.value && facultyNumberInput.value && gradeInput.value;

        if (isValidStudent) {
            const firstName = firstNameInput.value;
            const lastName = lastNameInput.value;
            const facultyNumber = facultyNumberInput.value;
            const grade = gradeInput.value;

            const student = {
                firstName, lastName, facultyNumber, grade
            };

            await fetch(baseURL, {
                method: "POST",
                body: JSON.stringify(student)
            });

            rowCreator(student);

            firstNameInput.value = "";
            lastNameInput.value = "";
            facultyNumberInput.value = "";
            gradeInput.value = "";
        }
    }

    function rowCreator(student) {
        const firstNameCell = document.createElement("td");
        firstNameCell.textContent = student.firstName;

        const lastNameCell = document.createElement("td");
        lastNameCell.textContent = student.lastName;

        const facultyNumberCell = document.createElement("td");
        facultyNumberCell.textContent = student.facultyNumber;

        const gradeCell = document.createElement("td");
        gradeCell.textContent = student.grade;

        const studentRow = document.createElement("tr");
        studentRow.appendChild(firstNameCell);
        studentRow.appendChild(lastNameCell);
        studentRow.appendChild(facultyNumberCell);
        studentRow.appendChild(gradeCell);

        studentsTableBody.appendChild(studentRow);
    }
}

attachEvents();