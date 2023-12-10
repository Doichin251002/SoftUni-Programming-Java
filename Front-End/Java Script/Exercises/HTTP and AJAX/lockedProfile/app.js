function lockedProfile() {
    const baseUrl = "http://localhost:3030/jsonstore/advanced/profiles";

    const mainDiv = document.getElementById("main");

    onLoad();
    async function onLoad() {
        const response = await fetch(baseUrl);
        const allProfiles = await response.json();

        let profileIndex = 0;
        for (const currentProfile of Object.values(allProfiles)) {
            const divProfile = createDivProfile(profileIndex, currentProfile);
            mainDiv.appendChild(divProfile);

            const button = divProfile.getElementsByTagName("button")[0];
            button.addEventListener("click", displayAndHideInfo);
        }
    }

    function createDivProfile(profileIndex, profile) {
        profileIndex++;

        const divProfile = document.createElement("div");
        divProfile.className = "profile";
        divProfile.id = profile._id;

        divProfile.innerHTML = `
                <img src="./iconProfile2.png" class="userIcon" />
                <label>Lock</label>
                <input type="radio" name="user${profileIndex}Locked" value="lock" checked>
                <label>Unlock</label>
                <input type="radio" name="user${profileIndex}Locked" value="unlock"><br>
                <hr>
                <label>Username</label>
                <input type="text" name="user${profileIndex}Username" value="${profile.username}" disabled readonly />
                <div class="hiddenInfo">
                <label>Email:</label>
                <input type="email" name="user${profileIndex}Email" value="${profile.email}" disabled readonly />
                <label>Age:</label>
                <input type="email" name="user${profileIndex}Age" value="${profile.age}" disabled readonly />
                </div>

                <button>Show more</button>`;

        return divProfile;
    }

    function displayAndHideInfo(e) {
        const currentButton = e.currentTarget;
        const profileDiv = currentButton.parentNode;

        const isUnlocked = profileDiv.querySelector("input[value=unlock]").checked;
        if (!isUnlocked) {
            return;
        }

        const childrenOfHiddenDiv = Array.from(profileDiv.querySelectorAll(".hiddenInfo *"));

        for (const childElement of childrenOfHiddenDiv) {
            if (currentButton.textContent === "Show more") {

                childElement.style.display = "block";
            } else if (currentButton.textContent === "Hide it") {

                childElement.style.display = "none";
            }
        }

        if (currentButton.textContent === "Show more") {

            currentButton.textContent = "Hide it";
        } else if (currentButton.textContent === "Hide it") {

            currentButton.textContent = "Show more";
        }
    }
}