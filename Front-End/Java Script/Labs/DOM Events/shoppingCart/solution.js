function solve() {
    let products = {};

    const buttonsProduct = Array.from(document.getElementsByClassName("add-product"));
    let textAreaElement = document.getElementsByTagName("textarea")[0];

    for (const button of buttonsProduct) {
        button.addEventListener("click", addProductToCart);
    }

    const buttonCheckout = document.getElementsByClassName("checkout")[0];
    buttonCheckout.addEventListener("click", printCheckoutMessage);

    function addProductToCart(e) {
        const divElementProduct = e.currentTarget.parentNode.parentNode;
        const productName = divElementProduct.getElementsByClassName("product-title")[0].textContent;
        const productPrice = Number(divElementProduct.getElementsByClassName("product-line-price")[0].textContent);

        if (products.hasOwnProperty(productName)) {
            const totalPriceForProduct = products[productName] + productPrice;
            products[productName] = totalPriceForProduct;
        } else {
            products[productName] = productPrice;
        }

        printProduct(productName, productPrice);
    }

    function printProduct(key, value) {
        value = value.toFixed(2);
        textAreaElement.textContent += `Added ${key} for ${value} to the cart.\n`;
    }

    function printCheckoutMessage() {
        let productNames = [];
        let totalCost = 0;

        for (const [name, price] of Object.entries(products)) {
            productNames.push(name);
            totalCost += price;
        }
        const productNamesString = productNames.join(", ");
        totalCost = totalCost.toFixed(2);

        textAreaElement.value += `You bought ${productNamesString} for ${totalCost}.`;

        disableButtons();
    }

    function disableButtons() {
        let buttonElements = Array.from(document.getElementsByTagName("button"));

        for (let button of buttonElements) {
            button.disabled = true;
        }
    }
}