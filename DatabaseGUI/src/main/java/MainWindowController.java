import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableView;
import model.Album;
import model.Artist;
import model.DataSource;


public class MainWindowController {

    @FXML
    private TableView artistTable;
    @FXML
    private ProgressBar progressBar;

    @FXML
    public void listArtist() {
        Task<ObservableList<Artist>> task = new getAllArtistsTask();
        artistTable.itemsProperty().bind(task.valueProperty());
        progressBar.progressProperty().bind(task.progressProperty());

        progressBar.setVisible(true);

        task.setOnSucceeded(e -> progressBar.setVisible(false));
        task.setOnCancelled(e -> progressBar.setVisible(false) );

        new Thread(task).start();
    }

    @FXML
    public void updateArtist() {
        Artist artist = (Artist) artistTable.getItems().get(2);

        Task<Boolean> task = new Task<Boolean>() {
            @Override
            protected Boolean call() throws Exception {
                return DataSource.getInstance().updateArtistName("AC/DC", artist.getId());
            }
        };

        task.setOnSucceeded(e -> {
            if (task.valueProperty().get()){
                artist.setName("AC/DC");
                artistTable.refresh();
            }
        });

        new Thread(task).start();
    }

    @FXML
    public void listAlbumsForArtists() {
        final Artist artist = (Artist) artistTable.getSelectionModel().getSelectedItem();
        if (artist == null) {
            System.out.println("No artist selected");
            return;
        }
        Task<ObservableList<Album>> task = new Task<ObservableList<Album>>(){
            @Override
            protected ObservableList<Album> call() throws Exception {
                return FXCollections.observableArrayList
                        (DataSource.getInstance().queryAlbumsForArtistId(artist.getId()));
            }
        };

        artistTable.itemsProperty().bind(task.valueProperty());

        new Thread(task).start();
    }
}

class getAllArtistsTask extends Task{
    @Override
    protected ObservableList<Artist> call() {
        return FXCollections.observableArrayList
                (DataSource.getInstance().queryArtists(DataSource.SortOrder.ORDER_BY_ASC));
    }
}