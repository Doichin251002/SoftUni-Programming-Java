function attachEventsListeners() {
    const inputDaysElement = document.getElementById("days");
    const buttonDaysElement = document.getElementById("daysBtn");

    const inputHoursElement = document.getElementById("hours");
    const buttonHoursElement = document.getElementById("hoursBtn");

    const inputMinutesElement = document.getElementById("minutes");
    const buttonMinutesElement = document.getElementById("minutesBtn");

    const inputSecondsElement = document.getElementById("seconds");
    const buttonSecondsElement = document.getElementById("secondsBtn");

    buttonDaysElement.addEventListener("click", convertDays);
    buttonHoursElement.addEventListener("click", convertHours);
    buttonMinutesElement.addEventListener("click", convertMinutes);
    buttonSecondsElement.addEventListener("click", convertSeconds);

    function convertDays() {
        inputHoursElement.value = inputDaysElement.value * 24;
        inputMinutesElement.value = inputHoursElement.value * 60;
        inputSecondsElement.value = inputMinutesElement.value * 60;
    }

    function convertHours() {
        inputDaysElement.value = inputHoursElement.value / 24;
        inputMinutesElement.value = inputHoursElement.value * 60;
        inputSecondsElement.value = inputMinutesElement.value * 60;
    }

    function convertMinutes() {
        inputSecondsElement.value = inputMinutesElement.value * 60;
        inputHoursElement.value = inputMinutesElement.value / 60;
        inputDaysElement.value = inputHoursElement.value / 24;
    }

    function convertSeconds() {
        inputMinutesElement.value = inputSecondsElement.value / 60;
        inputHoursElement.value = inputMinutesElement.value / 60;
        inputDaysElement.value = inputHoursElement.value / 24;
    }
}