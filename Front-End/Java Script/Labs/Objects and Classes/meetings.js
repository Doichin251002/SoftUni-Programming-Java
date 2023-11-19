function printSuccessfulMeetings(weekdayPersonStringArray) {
    function getSuccessfulMeetings(weekdayPersonStringArray) {
        let meetings = {};
        for (const weekdayPersonString of weekdayPersonStringArray) {
            const [weekday, person] = weekdayPersonString.split(" ");

            if (meetings.hasOwnProperty(weekday)) {
                console.log(`Conflict on ${weekday}!`);
            } else {
                meetings[weekday] = person;
                console.log(`Scheduled for ${weekday}`);
            }
        }

        return meetings;
    }

    const meetings = getSuccessfulMeetings(weekdayPersonStringArray);

    for (const currentWeekday in meetings) {
        console.log(`${currentWeekday} -> ${meetings[currentWeekday]}`);
    }
}

printSuccessfulMeetings(['Monday Peter',
    'Wednesday Bill',
    'Monday Tim',
    'Friday Tim']
);