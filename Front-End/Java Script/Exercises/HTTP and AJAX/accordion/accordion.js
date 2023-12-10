function solution() {
    const baseUrl = "http://localhost:3030/jsonstore/advanced/articles/";

    const mainSection = document.getElementById("main");

    onLoad();

    async function onLoad() {
        const response = await fetch(baseUrl + "details");
        const allArticles = await response.json();

        for (const article of Object.values(allArticles)) {
            const articleDiv = createArticle(article);
            mainSection.appendChild(articleDiv);

            const button = articleDiv.getElementsByTagName("button")[0];
            button.addEventListener("click", displayAndHideContent);
        }
    }

    function createArticle(article) {
        const articleDiv = document.createElement("div");
        articleDiv.className = "accordion";
        articleDiv.innerHTML = `
                <div class="head">
                    <span>${article.title}</span>
                    <button class="button" id="${article._id}">More</button>
                </div>
                <div class="extra">
                    <p>${article.content}</p>
                </div>
            </div>`;

        return articleDiv;
    }

    function displayAndHideContent(e) {
        const currentButton = e.currentTarget;
        const parentArticleDiv = currentButton.parentElement.parentElement;
        const contentDiv = parentArticleDiv.getElementsByClassName("extra")[0];

        if (currentButton.textContent === "More") {
            contentDiv.style.display = "block";

            currentButton.textContent = "Less";
        } else if (currentButton.textContent === "Less") {
            contentDiv.style.display = "none";

            currentButton.textContent = "More";
        }
    }
}

solution();