function buyFruit(fruit, weight, price) {
    weight /= 1000;

    price *= weight;

    console.log(`I need $${price.toFixed(2)} to buy ${weight.toFixed(2)} kilograms ${fruit}.`);
}

buyFruit('orange', 2500, 1.80);