function printTicketPrice(day, age) {
    if (age >= 0) {
        if (age <= 18) {
            switch (day) {
                case "Weekday":
                    console.log(12 + "$");
                    break;
                case "Weekend":
                    console.log(15 + "$");
                    break;
                case "Holiday":
                    console.log(5 + "$");
                    break;
                default:
                    console.log("Error!");
            }
        } else if (age <= 64) {
            switch (day) {
                case "Weekday":
                    console.log(18 + "$");
                    break;
                case "Weekend":
                    console.log(20 + "$");
                    break;
                case "Holiday":
                    console.log(12 + "$");
                    break;
                default:
                    console.log("Error!");
            }
        } else if (age <= 122) {
            switch (day) {
                case "Weekday":
                    console.log(12 + "$");
                    break;
                case "Weekend":
                    console.log(15 + "$");
                    break;
                case "Holiday":
                    console.log(10 + "$");
                    break;
                default:
                    console.log("Error!");
            }
        } else {
            console.log("Error!");
        }
    } else {
        console.log("Error!");
    }
}

printTicketPrice('Holiday', 15);