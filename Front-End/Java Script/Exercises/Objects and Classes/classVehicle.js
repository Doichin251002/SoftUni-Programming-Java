class Vehicle {
    constructor(type, model, parts, fuel) {
        if (typeof type === "string") this.type = type;
        if (typeof model === "string") this.model = model;
        if (typeof parts === "object") this.parts = {
            engine: parts.engine,
            power: parts.power,
            quality: parts.engine * parts.power
        };
        if (typeof fuel === "number") this.fuel = fuel;
    }

    drive(fuelLoss) {
        this.fuel -= fuelLoss;
    }
}

let parts = { engine: 6, power: 100 };
let vehicle = new Vehicle('a', 'b', parts, 200);
vehicle.drive(100);
console.log(vehicle.fuel);
console.log(vehicle.parts.quality);
