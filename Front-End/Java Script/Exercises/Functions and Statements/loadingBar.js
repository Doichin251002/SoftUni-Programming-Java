function printLoadingStatus(percent) {
    function getRepeatedSignsString(percent) {
        return "[" + "%".repeat(percent / 10) + ".".repeat(10 - percent / 10) + "]";
    }

    if (percent === 100) {
        console.log(`${percent}% Complete!\n` + getRepeatedSignsString(percent));
    } else {
        console.log(`${percent}% ` + getRepeatedSignsString(percent) + "\n" + "Still loading...");
    }
}

printLoadingStatus(30);
printLoadingStatus(50);
printLoadingStatus(100);