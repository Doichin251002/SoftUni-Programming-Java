function attachEvents() {
    const baseUrl = "http://localhost:3030/jsonstore/blog/";
    
    const loadPostsButton = document.getElementById("btnLoadPosts");
    const viewPostsButton = document.getElementById("btnViewPost");
    const postsSelect = document.getElementById("posts");

    const postTitleH1 = document.getElementById("post-title");
    const postBodyPar = document.getElementById("post-body");
    const postCommentsUl = document.getElementById("post-comments");

    let allPosts = {};
    let allComments = {};

    loadPostsButton.addEventListener("click", async() => {
        postsSelect.innerHTML = "";

        const response = await fetch(baseUrl + "posts");
        allPosts = await response.json();

        for (const [postId, postObj] of Object.entries(allPosts)) {
            const option = document.createElement("option");

            option.value = postId;
            option.textContent = postObj.title;

            postsSelect.appendChild(option);
        }
    });

    viewPostsButton.addEventListener("click", async() => {
        postTitleH1.innerHTML = "";
        postBodyPar.innerHTML = "";
        postCommentsUl.innerHTML = "";

        const currentPostId = postsSelect.value;

        const currentPost = allPosts[currentPostId];

        if (!currentPost) {
            return;
        }

        postTitleH1.textContent = currentPost.title;
        postBodyPar.textContent = currentPost.body;

        const response = await fetch(baseUrl + "comments");
        allComments = await response.json();

        const commentsForCurrentPost = Object.values(allComments).filter(o => o.postId === currentPostId);

        for (const comment of commentsForCurrentPost) {
            const liElement = document.createElement("li");
            liElement.id = comment.id;
            liElement.textContent = comment.text;

            postCommentsUl.appendChild(liElement);
        }
    });
}

attachEvents();