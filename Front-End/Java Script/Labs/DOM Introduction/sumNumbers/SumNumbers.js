function calc() {
    const inputElementValue1 = Number(document
        .getElementById("num1").value);
    const inputElementValue2 = Number(document
        .getElementById("num2").value);

    const sum = inputElementValue1 + inputElementValue2;

    document.getElementById("sum").value = sum;
}
