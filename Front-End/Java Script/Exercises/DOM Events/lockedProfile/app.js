function lockedProfile() {
    const buttonElements = Array.from(document.getElementsByTagName("button"));

    for (const button of buttonElements) {
        button.addEventListener("click", displayInfo);
    }

    function displayInfo(e) {
        const buttonElement = e.currentTarget;
        const profileParentDiv = buttonElement.parentElement;
        const unlockedInputElement = profileParentDiv.querySelectorAll("input[type = radio]")[1];

        if (!unlockedInputElement.checked) {
            return;
        }

        const infoDiv = profileParentDiv.querySelector("div[id $= HiddenFields]");

        if (buttonElement.textContent === "Show more") {
            infoDiv.style.display = "block";
            buttonElement.textContent = "Hide it";
        } else if (buttonElement.textContent === "Hide it") {
            infoDiv.style.display = "none";
            buttonElement.textContent = "Show more";
        }
    }
}