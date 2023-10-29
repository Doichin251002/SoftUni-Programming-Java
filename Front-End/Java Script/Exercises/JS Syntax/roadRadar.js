function printRoadRadar(currentSpeed, area) {
    let speedLimit = 0;

    switch (area) {
        case "motorway":
            speedLimit = 130;
            break;
        case "interstate":
            speedLimit = 90;
            break;
        case "city":
            speedLimit = 50;
            break;
        case "residential":
            speedLimit = 20;
            break;
    }

    if (currentSpeed <= speedLimit) {
        console.log(`Driving ${currentSpeed} km/h in a ${speedLimit} zone`);
    } else {
        const differenceSpeed = currentSpeed - speedLimit;
        let status = "";

        if (differenceSpeed <= 20) {
            status = "speeding";
        } else if (differenceSpeed <= 40) {
            status = "excessive speeding";
        } else {
            status = "reckless driving";
        }

        console.log(`The speed is ${differenceSpeed} km/h faster than the allowed speed of ${speedLimit} - ${status}`);
    }
}

printRoadRadar(200, 'motorway');