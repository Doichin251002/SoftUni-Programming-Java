function getSeparatedString(string) {
    const regex = /[A-Z][a-z]*/g;

    return string.match(regex).join(", ");
}

console.log(getSeparatedString('SplitMeIfYouCanHaHaYouCantOrYouCan'));