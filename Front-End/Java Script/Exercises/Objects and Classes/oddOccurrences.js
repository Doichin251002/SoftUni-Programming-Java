function printElementsWithOddOccurs(inputString) {
    const stringsArray = inputString.toLowerCase().split(" ");

    let map = new Map();

    for (const string of stringsArray) {
        if (map.has(string)) {
            let value = map.get(string) + 1;

            map.set(string, value);
        } else {
            map.set(string, 1);
        }
    }

    let stringsWithOddOccursArray = [];

    for (const [key, value] of map) {
        if (value % 2 !== 0) {
            stringsWithOddOccursArray.push(key);
        }
    }

    console.log(stringsWithOddOccursArray.join(" "));
}

printElementsWithOddOccurs('Java C# Php PHP Java PhP 3 C# 3 1 5 C#');
printElementsWithOddOccurs('Cake IS SWEET is Soft CAKE sweet Food');