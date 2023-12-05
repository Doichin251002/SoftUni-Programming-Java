function create(words) {
   const wrapperDivElement = document.getElementById("content");

   for (const word of words) {
      const pElement = document.createElement("p");
      pElement.textContent = word;
      pElement.style.display = "none";

      const currentDivElement = document.createElement("div");
      currentDivElement.appendChild(pElement);

      currentDivElement.addEventListener("click", displayParagraph);

      wrapperDivElement.appendChild(currentDivElement);
   }

   function displayParagraph(e) {
      const childParagraphElement = e.currentTarget.children[0];
      childParagraphElement.style.display = "block";
   }
}