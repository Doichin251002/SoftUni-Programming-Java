function attachGradientEvents() {
    const divElementGradient = document
        .getElementById("gradient");
    const divElementResult = document
        .getElementById("result");

    divElementGradient.addEventListener("mousemove",
        gradientMove);
    divElementGradient.addEventListener("mouseout",
        gradientOut);

    function gradientMove(e) {
        let power = e.offsetX /
            (e.currentTarget.clientWidth - 1);

        power = Math.trunc(power * 100);
        divElementResult.textContent = power + "%";
    }

    function gradientOut(e) {
        divElementResult.textContent = "";
    }
}