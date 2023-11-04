function printReversedArrayWithLength(length, numArray) {
    let slicedArr = numArray.slice(0, length).reverse();

    console.log(slicedArr.join(" "));
}

printReversedArrayWithLength(4, [-1, 20, 99, 5]);