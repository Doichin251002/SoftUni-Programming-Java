function printWholeInfoMovies(commandMoviesStringArray) {
    let moviesArray = [];

    for (const commandMovieString of commandMoviesStringArray) {
        if (commandMovieString.includes("addMovie")) {
            const movieName = commandMovieString.split("addMovie ")[1];

            moviesArray.push({"name": movieName});
        } else if (commandMovieString.includes("directedBy")) {
            const [movieName, directorName] = commandMovieString.split(" directedBy ");

            const existingMovie = moviesArray.find((e) => e.name === movieName);

            if (existingMovie) {
                existingMovie["director"] = directorName;
            }
        } else {
            const [movieName, date] = commandMovieString.split(" onDate ");

            const existingMovie = moviesArray.find((e) => e.name === movieName);

            if (existingMovie) {
                existingMovie["date"] = date;
            }
        }
    }

    moviesArray.filter((e) => e["name"] && e["director"] && e["date"])
        .forEach((e) => console.log(JSON.stringify(e)));
}

printWholeInfoMovies([
        'addMovie Fast and Furious',
        'addMovie Godfather',
        'Inception directedBy Christopher Nolan',
        'Godfather directedBy Francis Ford Coppola',
        'Godfather onDate 29.07.2018',
        'Fast and Furious onDate 30.07.2018',
        'Batman onDate 01.08.2018',
        'Fast and Furious directedBy Rob Cohen'
    ]
);

printWholeInfoMovies([
        'addMovie The Avengers',
        'addMovie Superman',
        'The Avengers directedBy Anthony Russo',
        'The Avengers onDate 30.07.2010',
        'Captain America onDate 30.07.2010',
        'Captain America directedBy Joe Russo'
    ]
);