function printStoreProvision(currentStockStringsArray, orderedStockStringArray) {
    orderedStockStringArray.forEach((e) => currentStockStringsArray.push(e));
    function getAllProducts(allStockStringsArray) {
        const products = {};

        for (let i = 0; i < allStockStringsArray.length; i += 2) {
            const name = currentStockStringsArray[i];
            const quantity = Number.parseInt(currentStockStringsArray[i + 1]);

            if (!products.hasOwnProperty(name)) {
                products[name] = quantity;
            } else {
                products[name] += quantity;
            }
        }

        return products;
    }

    const products = getAllProducts(currentStockStringsArray);

    for (const [productName, productQuantity] of Object.entries(products)) {
        console.log(`${productName} -> ${productQuantity}`);
    }
}

printStoreProvision([
        'Chips', '5', 'CocaCola', '9', 'Bananas', '14', 'Pasta', '4', 'Beer', '2'
    ],
    [
        'Flour', '44', 'Oil', '12', 'Pasta', '7', 'Tomatoes', '70', 'Bananas', '30'
    ]
);