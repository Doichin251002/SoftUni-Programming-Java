function printReservationPrice(groupCapacity, groupType, dayWeek) {
    let price = 0;

    if (groupCapacity > 0) {

        switch (groupType) {
            case "Students":
                switch (dayWeek) {
                    case "Friday" :
                        price = 8.45;
                        break;
                    case "Saturday" :
                        price = 9.8;
                        break;
                    case "Sunday" :
                        price = 10.46;
                        break;
                }

                price *= groupCapacity;

                if (groupCapacity >= 30) {
                    price *= 0.85;
                }
                break;

            case "Business":
                switch (dayWeek) {
                    case "Friday" :
                        price = 10.9;
                        break;
                    case "Saturday" :
                        price = 15.6;
                        break;
                    case "Sunday" :
                        price = 16;
                        break;
                }

                if (groupCapacity >= 100) {
                    price *= (groupCapacity - 10);
                } else {
                    price *= groupCapacity;
                }
                break;

            case "Regular":
                switch (dayWeek) {
                    case "Friday" :
                        price = 15;
                        break;
                    case "Saturday" :
                        price = 20;
                        break;
                    case "Sunday" :
                        price = 22.5;
                        break;
                }

                price *= groupCapacity;

                if (groupCapacity >= 10 && groupCapacity <= 20) {
                    price *= 0.95;
                }
        }

        console.log(`Total price: ${price.toFixed(2)}`);
    }
}