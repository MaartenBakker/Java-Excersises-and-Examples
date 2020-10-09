package com.Maarten;

import java.util.ArrayList;

public class Album {

    // Fields
    private String name;
    private ArrayList<Song> albumTracks;

    // Constructor

    public Album(String name) {
        this.name = name;
        this.albumTracks = new ArrayList<Song>();
    }

    // Getter Setter


    public String getName() {
        return name;
    }

    public ArrayList<Song> getAlbumTracks() {
        return albumTracks;
    }

    // Methods

    public void addSong(Song song) {
        albumTracks.add(song);
    }

    public Song getSongFromAlbum(int trackNumber) {
        int arrayPosition = trackNumber - 1;
        return albumTracks.get(arrayPosition);
    }

    public void printSongsFromAlbum() {
        for (int i = 0; i < albumTracks.size() ; i++) {
            System.out.println((i + 1) + ": " + albumTracks.get(i).getName() + " " + albumTracks.get(i).getDuration());
        }
    }
}
