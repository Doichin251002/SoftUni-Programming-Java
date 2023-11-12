function isValidOrder(product, quantity) {
    return typeof product === "string" && product.length > 0 && quantity > 0;
}

function getTotalPriceOfOrder(product, quantity) {
    const orderProductPrice = {
        coffee: 1.5,
        water: 1,
        coke: 1.4,
        snacks: 2,
    }

    const passOrder = isValidOrder(product, quantity);

    if (passOrder) {
        return orderProductPrice[product] * quantity;
    }
}

function printTotalPrice(product, quantity) {
    console.log(getTotalPriceOfOrder(product, quantity).toFixed(2));
}

printTotalPrice("water", 5);
printTotalPrice("coffee", 2);