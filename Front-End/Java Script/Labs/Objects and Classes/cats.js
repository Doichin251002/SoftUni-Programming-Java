function printCatNameAndAge(catAgeStringArray) {
    class Cat {
        constructor(name, age) {
            this.name = name;
            this.age = age;
        }

        meow() {
            console.log(`${this.name}, age ${this.age} says Meow`)
        }
    }

    for (const currentCatAgeString of catAgeStringArray) {
        const [name, age] = currentCatAgeString.split(" ");

        const cat = new Cat(name, age);
        cat.meow();
    }
}

printCatNameAndAge(['Candy 1', 'Poppy 3', 'Nyx 2']);