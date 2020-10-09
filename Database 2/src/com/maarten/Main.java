package com.maarten;

import com.maarten.model.*;
import com.maarten.model.DataSource;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DataSource dataSource = new DataSource();

        if(!dataSource.open()){ // opens dataSource && returns true if successful
            System.out.println("Can't open dataSource");
            return;
        }

//        List<Artist> artists = dataSource.queryArtists(DataSource.SortOrder.ORDER_BY_ASC);
//
//        if(artists != null){
//            artists.forEach(artist -> System.out.println(artist.getName()));
//        }

//        List<Album> albums =
//                dataSource.queryAlbumsFromArtist("Carole King", DataSource.SortOrder.ORDER_BY_ASC);
//        if(albums != null) {
//            albums.forEach(album -> System.out.println(album.getName()));
//        }
//        System.out.println(albums.size());
//
//        System.out.println("==========");
//
//        printArtistAlbumTrackFromSongTitle(dataSource, "Go Your Own Way", DataSource.SortOrder.ORDER_BY_ASC);
//        printArtistAlbumTrackFromSongTitle(dataSource, "Pipo", DataSource.SortOrder.ORDER_BY_ASC);
//        printArtistAlbumTrackFromSongTitle(dataSource, "She's On Fire", DataSource.SortOrder.ORDER_BY_ASC);
//
//        dataSource.querySongsMetadata();
//
//        System.out.println(dataSource.getCount(DataSource.TABLE_SONGS));


        dataSource.createViewArtistNameAlbumNameSongTrackSongTitle();

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please input song title:");
//        String inputString = scanner.nextLine();
//
//        printArtistAlbumTrackFromSongTitleViaView(dataSource, inputString);


        dataSource.insertSong("This Amazing Hat", "Maarten Bakker", "Rejected Scripts", 1);


        dataSource.close();

    }

    static public void printArtistAlbumTrackFromSongTitle(DataSource dataSource, String songTitle,
                                                          DataSource.SortOrder sortOrder) {
        List<SongArtist> songArtists = dataSource.queryArtistFromSong(songTitle, sortOrder);
        if(songArtists != null) {
            songArtists.forEach(songArtist -> {
                System.out.println("Title: " + songArtist.getSongTitle());
                System.out.println("Album: " + songArtist.getAlbumName());
                System.out.println("Artist: " + songArtist.getArtistName());
                System.out.println("Track: " + songArtist.getTrack());
                System.out.println("---------");
            });
        } else {
            System.out.println("No artist found for the track " + songTitle);
            System.out.println("---------");
        }
    }

    static public void printArtistAlbumTrackFromSongTitleViaView(DataSource dataSource, String songTitle) {
        List<SongArtist> songArtists = dataSource.querySongsInfo(songTitle);
        if(songArtists != null) {
            songArtists.forEach(songArtist -> {
                System.out.println("Title: " + songArtist.getSongTitle());
                System.out.println("Album: " + songArtist.getAlbumName());
                System.out.println("Artist: " + songArtist.getArtistName());
                System.out.println("Track: " + songArtist.getTrack());
                System.out.println("---------");
            });
        } else {
            System.out.println("No artist found for the track " + songTitle);
            System.out.println("---------");
        }
    }






}
