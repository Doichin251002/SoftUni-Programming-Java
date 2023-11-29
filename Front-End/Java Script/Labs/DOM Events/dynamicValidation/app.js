function validate() {
    const inputElement = document
        .getElementById("email");

    inputElement.addEventListener("change", colorInputByEmail);

    function colorInputByEmail(e) {
        const pattern = new RegExp("^[a-z]+@[a-z]+\\.[a-z]+$", "g");

        let inputEmailValue = e.currentTarget.value;

        if (!pattern.test(inputEmailValue)) {
            e.currentTarget.className = "error";
        } else {
            e.currentTarget.className = "";
        }
    }
}