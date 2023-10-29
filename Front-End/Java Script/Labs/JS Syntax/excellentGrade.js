const excellentGradeString = "Excellent";
function printExcellentGradeOrNot(grade) {
    if (grade >= 5.5) console.log(excellentGradeString);
    else console.log(`Not ${excellentGradeString}`);
}

printExcellentGradeOrNot(5.49);