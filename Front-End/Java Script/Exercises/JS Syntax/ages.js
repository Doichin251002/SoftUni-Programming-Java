function getAge(yearsOld) {
    if (yearsOld < 0) {
        return "out of bounds";
    } else {
        if (yearsOld <= 2) {
            return "baby"
        } else if (yearsOld <= 13) {
            return "child";
        } else if (yearsOld <= 19) {
            return "teenager";
        } else if (yearsOld <= 65) {
            return "adult";
        } else {
            return "elder";
        }
    }
}