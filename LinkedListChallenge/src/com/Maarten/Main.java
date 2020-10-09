package com.Maarten;


import java.util.*;

public class Main {

    // Fields

    private static ArrayList<Album> listOfAlbums = new ArrayList<>();
    private static LinkedList<Song> playList = new LinkedList<Song>();
    private static Scanner scanner = new Scanner(System.in);
    private static ListIterator<Song> playListIterator = playList.listIterator();



    public static void main(String[] args) {
        // write your code here

//        Song superstition = new Song("Superstition", 3.00);
//        Song sunshineOfMyLife = new Song("You are the Sunshine of My Life",  3.40);
//        Song kidCharlemagne = new Song("Kid Charlemagne", 4.15);
//        Song fez = new Song("The Fez", 2.50);

        Album talkingBook = new Album("Talking Book");
        Album royalScam = new Album("the Royal Scam");

        talkingBook.addSong(new Song("Superstition", 3.00));
        talkingBook.addSong(new Song("You are the Sunshine of my Life", 3.40));
        talkingBook.addSong(new Song("Big Brother", 4.10));
        talkingBook.addSong(new Song("Maybe Your Baby", 5.45));


        royalScam.addSong(new Song("Kid Charlemagne", 4.15));
        royalScam.addSong(new Song("The Fez", 2.50));
        royalScam.addSong(new Song("Don't Take Me Alive", 4.05));
        royalScam.addSong(new Song("Sign In Stranger", 3.34));

        addAlbumToList(talkingBook);
        addAlbumToList(royalScam);


//        addSongToPlaylist();
//        addSongToPlaylist();
//        addSongToPlaylist();
//        addSongToPlaylist();
//
//        printPlayList();



//        if (!playList.isEmpty()) {
//            playlistPlayer();
//        } else {
//            System.out.println("Playlist is empty, no songs to play.");
//        }
        addSongToPlaylistByIterator();
        playListIterator.previous();
        playlistPlayer();
    }



    private static void playlistPlayer () {

        boolean quit = false;
        boolean goingToNextSong = true;
//        ListIterator<Song> playListIterator = playList.listIterator();

        Song currentSong = playListIterator.next();
//        currentSong.playSong();
        printMenu();

        while (!quit) {
            System.out.println("Please enter choice");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0: // menu
                    printMenu();
                    break;

                case 1: // next song
                    if (!goingToNextSong) {
                        if (playListIterator.hasNext()) {
                            playListIterator.next();
                        }
                    }
                    if (playListIterator.hasNext()) {
                        goingToNextSong = true;
                        currentSong = playListIterator.next();
                        currentSong.playSong();
                    } else {
                        System.out.println("End of playlist");
                        goingToNextSong = false;
                        currentSong = playListIterator.previous();
                        currentSong.playSong();
                    }
                    break;

                case 2: // previous song
                    if (goingToNextSong) {
                        if (playListIterator.hasPrevious()) {
                            playListIterator.previous();
                        }
                    }
                    if (playListIterator.hasPrevious()) {
                        goingToNextSong = false;
                        currentSong = playListIterator.previous();
                        currentSong.playSong();
                    } else {
                        System.out.println("Start of playlist");
                        goingToNextSong = true;
                        currentSong = playListIterator.next();
                        currentSong.playSong();

                    }
                    break;

                case 3: // repeat song

//                    if (goingToNextSong) {goingToNextSong = false;}
//                    else {goingToNextSong = true;}
//                    currentSong.playSong();
                    break;

                case 4: // add song
                    addSongToPlaylistByIterator();
                    break;

                case 5: // remove song
                    if (!playList.isEmpty()) {
                        playListIterator.remove();
                        System.out.println("Removed " + currentSong.getName());

                        if (playListIterator.hasNext()) {
                            currentSong = playListIterator.next();
                        } else if (playListIterator.hasPrevious()) {
                           currentSong =  playListIterator.previous();
                        } else {
                            System.out.println("Playlist is empty");
                            addSongToPlaylistByIterator();
                        }
                    }
                    break;

                case 6:
                    printPlayList();
                    break;

                case 7: // quit
                    quit = true;
                    break;
            }
        }

    }

    private static void printMenu() {
        System.out.println("Press:");
        System.out.println("0: menu");
        System.out.println("1: next song");
        System.out.println("2: previous song");
        System.out.println("3: repeat song");
        System.out.println("4: add song");
        System.out.println("5: remove current song");
        System.out.println("6: print playlist");
        System.out.println("7: quit");
    }








//    private static void addSongToPlaylist() {
//        System.out.println("Add songs to playlist.");
//        Album albumToPickSongFrom = pickAlbum();
//
//        if (albumToPickSongFrom != null) {
//            Song songToAdd = pickSong(albumToPickSongFrom);
//
//            if (songToAdd != null && !songIsAlreadyAdded(songToAdd)) {
//                playList.add(songToAdd);
//                System.out.println(songToAdd.getName() + " added to playlist");
//            }
//        }
//    }

    private static void addSongToPlaylistByIterator() {
        System.out.println("Add songs to playlist.");
        Album albumToPickSongFrom = pickAlbum();

        if (albumToPickSongFrom != null) {
            Song songToAdd = pickSong(albumToPickSongFrom);

            if (songToAdd != null && !songIsAlreadyAdded(songToAdd)) {
                playListIterator.add(songToAdd);
                System.out.println(songToAdd.getName() + " added to playlist");
//                songToAdd.playSong();
            }
        }
    }

    private static boolean songIsAlreadyAdded(Song songToAdd) {
        for (Song song : playList) {
            if (song.equals(songToAdd)) {
                System.out.println("Song already added.");
                return true;
            }
        }
        return false;
    }

    private static void printPlayList() {
        System.out.println("Playlist: ");
        for (Song song : playList) {
            System.out.println(song.getName() + " " + song.getDuration());
        }
    }

    private static void addAlbumToList(Album album) {
        listOfAlbums.add(album);
    }

    private static Album getAlbumFromList(int choice) {
        int arrayPosition = choice - 1;
            return listOfAlbums.get(arrayPosition);
    }

    private static void printListOfAlbums() {
        for (int i = 0; i < listOfAlbums.size() ; i++) {
            System.out.println((i + 1) + " " + listOfAlbums.get(i).getName());
        }
    }



    private static Album pickAlbum() {
        printListOfAlbums();
        System.out.println("Please enter your choice: ");
        int albumChoice = scanner.nextInt();
        scanner.nextLine();

        if (albumChoice < 1 || albumChoice > listOfAlbums.size()) {
            System.out.println("Invalid choice.");
            return null;
        } else {
            return getAlbumFromList(albumChoice);
        }
    }

    private static Song pickSong(Album album) {

            album.printSongsFromAlbum();
            System.out.println("Please enter your choice: ");
            int songChoice = scanner.nextInt();
            scanner.nextLine();

            if (songChoice < 1 || songChoice > album.getAlbumTracks().size()) {
                System.out.println("Invalid choice.");
                return null;
            } else {
                return album.getSongFromAlbum(songChoice);
            }

    }


}
