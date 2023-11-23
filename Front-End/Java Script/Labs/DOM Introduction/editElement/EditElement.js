function editElement(ref, match, replacer) {
    const content = ref.textContent;

    const editedContent = content.replace
    (new RegExp(match, "g"), replacer);

    ref.textContent = editedContent;
}