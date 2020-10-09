import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.DataSource;


public class Main extends Application {

    public static void main(String[] args) throws ClassNotFoundException {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainWindow.fxml"));
        Parent root = loader.load();
        MainWindowController mainWindowController = loader.getController();
        mainWindowController.listArtist();

        primaryStage.setTitle("Music Database");
        primaryStage.setScene(new Scene (root, 800, 600));
        primaryStage.show();
    }


    @Override
    public void init() throws Exception {
        super.init();
        if (!DataSource.getInstance().open()){
            System.out.println("Fatal Error: Couldn't connect to database");
            Platform.exit();
        };
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        DataSource.getInstance().close();
    }
}
