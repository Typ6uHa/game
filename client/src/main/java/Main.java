import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.socket.TextMessage;

@Lazy
@SpringBootApplication
public class Main extends Application{

  //  private ConfigurableApplicationContext applicationContext;

    @FXML
    private Button button;

    @FXML
    private TextField textField;

    @Autowired
    SimpleClientWebSocketHandler handler;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent rootNode = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        primaryStage.setTitle("City");
        Scene scene = new Scene(rootNode, 845, 400);
        scene.getStylesheets().add("/styles/style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        SpringApplication app = new SpringApplication(Main.class);
        app.setWebEnvironment(false);
//        applicationContext = app.run();
//        applicationContext.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
   //     applicationContext.close();
    }

    public void onClickMethod(ActionEvent actionEvent) {
        try {
            handler
                    .getSession()
                    .sendMessage
                            (new TextMessage(textField.getText()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        textField.appendText(textField.getText() + System.lineSeparator());
        textField.clear();
    }
}
