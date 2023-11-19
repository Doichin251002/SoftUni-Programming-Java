function printSongsOfTypeList(inputData) {
    const n = inputData[0];
    const searchedTypeList = inputData[inputData.length - 1];

    class Song {
        constructor(typeList, name, time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }

        getTypeList() {
            return this.typeList;
        }

        getName() {
            return this.name;
        }
    }

    for (let i = 1; i <= n; i++) {
        const [currentTypeList, currentName, currentTime] = inputData[i].split("_");

        const song = new Song(currentTypeList, currentName, currentTime);

        if (searchedTypeList === "all" || song.getTypeList() === searchedTypeList) {
            console.log(song.getName());
        }
    }
}

printSongsOfTypeList([2,
    'like_Replay_3:15',
    'ban_Photoshop_3:48',
    'all']
);