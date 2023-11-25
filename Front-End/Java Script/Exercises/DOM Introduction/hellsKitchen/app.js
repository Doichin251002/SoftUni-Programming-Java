function solve() {
    document.querySelector('#btnSend')
        .addEventListener('click', onClick);

    function onClick() {
        let restaurantStringsArray = document
            .querySelector("#inputs textarea").value;

        restaurantStringsArray = restaurantStringsArray.split("\"").filter(e => e.match(/[\w\-\d, ]+\b/g));

        let restaurantsWorkers = {};
        for (const restaurantString of restaurantStringsArray) {
            const [restaurantName, ...workersString] = restaurantString.split(" - ");

            let workersSalary;
            if (restaurantsWorkers.hasOwnProperty(restaurantName)) {
                workersSalary = restaurantsWorkers[restaurantName];
            } else {
                workersSalary = [];
            }
            for (const workerSalaryString of workersString[0].split(", ")) {
                let [workerName, salary] = workerSalaryString.split(" ");
                salary = Number(salary);

                const worker = {workerName, salary};
                if (!workersSalary.includes(worker)) {
                    workersSalary.push(worker);
                }
            }

            restaurantsWorkers[restaurantName] = workersSalary;
        }

        for (let [restaurant, workers] of Object.entries(restaurantsWorkers)) {
            workers = workers.map((o) => Object.values(o)).sort((a, b) => b[1] - a[1]);
            workers = workers.map((e) => Object.assign({}, e));
            restaurantsWorkers[restaurant] = workers;
        }

        let restaurantAvgSalary = {};
        for (const [restaurant, workers] of Object.entries(restaurantsWorkers)) {
            let totalSalary = 0;

            for (const worker of workers) {
                totalSalary += Object.values(worker)[1];
            }

            restaurantAvgSalary[restaurant] = totalSalary / Object.values(workers).length;
        }

        restaurantAvgSalary = Object.fromEntries(Object.entries(restaurantAvgSalary).sort((a, b) => b[1] - a[1]));

        const bestRestaurant = Object.keys(restaurantAvgSalary)[0];
        const bestAvgSalary = Object.values(restaurantAvgSalary)[0];
        const workers = restaurantsWorkers[bestRestaurant];
        const bestWorkerSalary = Object.values(workers)[0][1];
        console.log(workers)

        let pElementRestaurant = document.querySelector("#bestRestaurant p");
        pElementRestaurant.textContent = `Name: ${bestRestaurant} Average Salary: ${bestAvgSalary.toFixed(2)} Best Salary: ${bestWorkerSalary.toFixed(2)}`;

        let pElementWorkers = document.querySelector("#workers p");
        for (const worker of workers) {
            const name = Object.values(worker)[0];
            const salary = Object.values(worker)[1];
            pElementWorkers.textContent += `Name: ${name} With Salary: ${salary} `;
        }
    }
}