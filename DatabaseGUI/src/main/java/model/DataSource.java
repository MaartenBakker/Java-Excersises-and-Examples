package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/anna/Java Programs/DatabaseGUI/src/main/resources/" + DB_NAME;

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK = 2;
    public static final int INDEX_SONG_TITLE = 3;
    public static final int INDEX_SONG_ALBUM = 4;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;


    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;

    public static final String VIEW_ARTIST_LIST = "artist_list";
    
    public static final String QUERY_ALBUMS_BY_ARTIST_START =
            "SELECT " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " FROM " + TABLE_ALBUMS +
                    " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST +
                    " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
                    " WHERE " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + " = \"";

    public static final String QUERY_ALBUMS_BY_ALBUMS_SORT =
            " ORDER BY " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE ";

    public static final String QUERY_ARTIST_ALBUM_AND_TRACK_BY_SONG_TITLE_START =
                    "SELECT " +
                    TABLE_SONGS + "." + COLUMN_SONG_TITLE + "," +
                    TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " +
                    TABLE_SONGS + "." + COLUMN_SONG_TRACK +
                    " FROM " + TABLE_SONGS +
                    " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS + "." + COLUMN_SONG_ALBUM + " = " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUM_ID +
                    " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " = " +
                    TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
                    " WHERE " + TABLE_SONGS + "." + COLUMN_SONG_TITLE + " =\"";

    public static final String CREATE_VIEW_ARTIST_NAME_ALBUM_NAME_SONG_TRACK_SONG_TITLE =
                    "CREATE VIEW IF NOT EXISTS " + VIEW_ARTIST_LIST + " AS " +
                    "SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " AS album" + ", " +
                    TABLE_SONGS + "." + COLUMN_SONG_TRACK + ", " +
                    TABLE_SONGS + "." + COLUMN_SONG_TITLE +
                    " FROM " + TABLE_SONGS +
                    " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS + "." + COLUMN_SONG_ALBUM + " = " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUM_ID +
                    " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " = " +
                    TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
                    " ORDER BY " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " +
                    TABLE_SONGS + "." + COLUMN_SONG_TRACK;

    public static final String QUERY_VIEW_SONG_INFO =
            "SELECT " + COLUMN_ARTIST_NAME + ", " +
            COLUMN_SONG_ALBUM + ", " +
            COLUMN_SONG_TRACK +
            " FROM " + VIEW_ARTIST_LIST +
            " WHERE " + COLUMN_SONG_TITLE + " = \"";

    public static final String QUERY_VIEW_SONG_INFO_PREP =
            "SELECT " + COLUMN_ARTIST_NAME + "," +
            COLUMN_SONG_ALBUM + ", " +
            COLUMN_SONG_TRACK + "" +
            " FROM " + VIEW_ARTIST_LIST +
            " WHERE " + COLUMN_SONG_TITLE +
            " = ?";

    public static final String INSERT_INTO_ARTISTS_PREP =
            "INSERT INTO " + TABLE_ARTISTS + "(" + COLUMN_ARTIST_NAME + ") VALUES(?)";

    public static final String   INSERT_INTO_ALBUMS_PREP =
            "INSERT INTO " + TABLE_ALBUMS + "(" + COLUMN_ALBUM_NAME + ", " + COLUMN_ALBUM_ARTIST + ") VALUES(?, ?)";

    public static final String INSERT_INTO_SONGS_PREP =
            "INSERT INTO " + TABLE_SONGS + "(" + COLUMN_SONG_TRACK + ", " + COLUMN_SONG_TITLE +
            ", " + COLUMN_SONG_ALBUM + ") VALUES(?, ?, ?)";

    public static final String QUERY_ARTIST = "SELECT " + COLUMN_ARTIST_ID + " FROM " +
            TABLE_ARTISTS + " WHERE " + COLUMN_ARTIST_NAME + " = ?";

    public static final String QUERY_ALBUM = " SELECT " + COLUMN_ALBUM_ID + " FROM " +
            TABLE_ALBUMS + " WHERE " + COLUMN_ALBUM_NAME + " = ?";

    public static final String QUERY_ALBUMS_BY_ARTIST_ID =
            " SELECT * FROM " + TABLE_ALBUMS + " WHERE " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " = ? ORDER BY " + COLUMN_ALBUM_NAME + " COLLATE NOCASE";

    public static final String UPDATE_ARTIST_NAME =
            "UPDATE " + TABLE_ARTISTS + " SET " +
            COLUMN_ALBUM_NAME + " = ? " + " WHERE " + COLUMN_ARTIST_ID + " = ?";


    public enum SortOrder {
        ORDER_BY_NONE,
        ORDER_BY_ASC,
        ORDER_BY_DESC
    }

    private Connection connection;
    private PreparedStatement querySongInfoView;
    private PreparedStatement insertIntoArtists;
    private PreparedStatement insertIntoAlbums;
    private PreparedStatement insertIntoSongs;
    private PreparedStatement queryArtist;
    private PreparedStatement queryAlbum;
    private PreparedStatement queryAlbumsByArtistId;
    private PreparedStatement updateArtistName;

    private final static DataSource instance = new DataSource();

    public static DataSource getInstance() {
        return instance;
    }

    private DataSource() {

    }

    public boolean open(){
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            querySongInfoView = connection.prepareStatement(QUERY_VIEW_SONG_INFO_PREP);
            insertIntoArtists = connection.prepareStatement(INSERT_INTO_ARTISTS_PREP, Statement.RETURN_GENERATED_KEYS);
            insertIntoAlbums = connection.prepareStatement(INSERT_INTO_ALBUMS_PREP, Statement.RETURN_GENERATED_KEYS);
            insertIntoSongs = connection.prepareStatement(INSERT_INTO_SONGS_PREP);
            queryArtist = connection.prepareStatement(QUERY_ARTIST);
            queryAlbum = connection.prepareStatement(QUERY_ALBUM);
            queryAlbumsByArtistId = connection.prepareStatement(QUERY_ALBUMS_BY_ARTIST_ID);
            updateArtistName = connection.prepareStatement(UPDATE_ARTIST_NAME);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void close(){
        try {
            if (querySongInfoView != null) {
                querySongInfoView.close();
            }
            if (insertIntoArtists != null) {
                insertIntoArtists.close();
            }
            if (insertIntoAlbums != null) {
                insertIntoAlbums.close();
            }
            if (insertIntoSongs != null) {
                insertIntoSongs.close();
            }
            if (queryArtist != null) {
                queryArtist.close();
            }
            if (queryAlbum != null) {
                queryAlbum.close();
            }
            if (queryAlbumsByArtistId != null) {
                queryAlbumsByArtistId.close();
            }
            if (updateArtistName != null) {
                updateArtistName.close();
            }


            if (connection != null) {
                connection.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean updateArtistName (String updatedName, int artistId){
        try {
            updateArtistName.setString(1, updatedName );
            updateArtistName.setInt(2, artistId);
            int affectedRecords = updateArtistName.executeUpdate();

            return (affectedRecords == 1);

        } catch (SQLException exception) {
            System.out.println("Update failed");
            exception.printStackTrace();
            return false;
        }
    }

    public List<Artist> queryArtists(SortOrder sortOrder) {

        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_ARTISTS);
        if (sortOrder != SortOrder.ORDER_BY_NONE) {
            sb.append(" ORDER BY ");
            sb.append(COLUMN_ARTIST_NAME);
            sb.append(" COLLATE NOCASE ");
            String ascOrDesc = sortOrder == SortOrder.ORDER_BY_ASC ? "ASC" : "DESC";
            sb.append(ascOrDesc);
        }


        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sb.toString())) {

                List<Artist> artists = new ArrayList<>();

                while (resultSet.next()) {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                    Artist artist = new Artist();
                    artist.setId(resultSet.getInt(INDEX_ARTIST_ID));
                    artist.setName(resultSet.getString(INDEX_ARTIST_NAME));
                    artists.add(artist);
                }

                return artists;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<Album> queryAlbumsForArtistId(int artistId) {
        try {
            queryAlbumsByArtistId.setInt(1, artistId);
            ResultSet resultSet = queryAlbumsByArtistId.executeQuery();

            List<Album> albums = new ArrayList<>();

            while (resultSet.next()){
                Album album = new Album();
                album.setName(resultSet.getString(INDEX_ALBUM_NAME));
                album.setArtistId(resultSet.getInt(INDEX_ALBUM_ARTIST));
                album.setId(artistId);
                albums.add(album);
            }

            if (!albums.isEmpty()){
                return albums;
            } else {
                return null;
            }


        } catch (SQLException exception) {
            System.out.println("Something went wrong with querying albums by artistId");
            exception.printStackTrace();
            return null;
        }
    }

    public List<Album> queryAlbumsFromArtist(String artistName, SortOrder sortOrder) {
        StringBuilder sb = new StringBuilder(QUERY_ALBUMS_BY_ARTIST_START).append(artistName).append("\"");
        sb.append(QUERY_ALBUMS_BY_ALBUMS_SORT);
        String ascOrDesc = sortOrder == SortOrder.ORDER_BY_ASC ? "ASC" : "DESC";
        sb.append(ascOrDesc);

        try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sb.toString())) {

            List<Album> albumList = new ArrayList<>();

            while (resultSet.next()) {
                Album album = new Album();
                album.setName(resultSet.getString(1));
                albumList.add(album);
            }

            return albumList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void querySongsMetadata(){
        String sql = "SELECT * FROM " + TABLE_SONGS;

        try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);) {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int numColums = resultSetMetaData.getColumnCount();
            for (int i = 1; i <= numColums; i++) {
                System.out.format("Column %d in the songs table is named %s\n",
                        i, resultSetMetaData.getColumnName(i));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getCount(String table) {
        String sql = "SELECT COUNT(*) AS count FROM " + table;
        try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            return resultSet.getInt("count");
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean createViewArtistNameAlbumNameSongTrackSongTitle() {
        try (Statement statement = connection.createStatement()) {
            statement.execute(CREATE_VIEW_ARTIST_NAME_ALBUM_NAME_SONG_TRACK_SONG_TITLE);
                return true;

        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }



    private int insertArtist(String name) throws SQLException {

            queryArtist.setString(1, name);
            ResultSet resultSet = queryArtist.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                insertIntoArtists.setString(1, name);
                int affectedRows = insertIntoArtists.executeUpdate();

                if (affectedRows != 1) {
                    throw new SQLException("Couldn't insert artist");
                }

                ResultSet generatedKeys =  insertIntoArtists.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Couldn't get _id for artist");
                }
            }
    }

    private int insertAlbum(String name, int artistId) throws SQLException {

        queryAlbum.setString(1, name);
        ResultSet resultSet = queryAlbum.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        } else {
            insertIntoAlbums.setString(1, name);
            insertIntoAlbums.setInt(2, artistId);
            int affectedRows = insertIntoAlbums.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert album");
            }

            ResultSet generatedKeys =  insertIntoAlbums.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for album");
            }
        }
    }

    public void insertSong(String title, String artist, String album, int track) {

        try {
            connection.setAutoCommit(false);

            int artistId = insertArtist(artist);
            int albumId = insertAlbum(album, artistId);

            insertIntoSongs.setInt(1, track);
            insertIntoSongs.setString(2, title);
            insertIntoSongs.setInt(3, albumId);

            int affectedRows = insertIntoSongs.executeUpdate();

            if (affectedRows == 1) {
                connection.commit();
            } else {
                throw new SQLException("The song insert failed :-(");
            }


        } catch (Exception exception) {
            System.out.println("Insert song exception");
            exception.printStackTrace();
            try {
                System.out.println("Performing Rollback");
                connection.rollback();
            } catch (SQLException exception2) {
                System.out.println("PANIC!");
                exception2.printStackTrace();
            }
        } finally {
             try {
                 connection.setAutoCommit(true);
                 System.out.println("Resetting default commit behavior");
             } catch (SQLException exception) {
                 System.out.println("Couldn't reset auto-commit");
                 exception.printStackTrace();
             }
        }
    }




}
