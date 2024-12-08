package view;

import controller.UserController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class LoginPage implements EventHandler<ActionEvent> {
    private BorderPane root;
    private GridPane gridPane;

    private Label title, emailLabel, passwordLabel, errorLabel;
    private TextField emailField;
    private PasswordField passwordField;
    private Button loginButton, registerButton;

    public Scene scene;

    private UserController userController;

    private void initComponents() {
        root = new BorderPane();
        gridPane = new GridPane();

        title = new Label("Login");
        emailLabel = new Label("Email:");
        passwordLabel = new Label("Password:");
        errorLabel = new Label();

        emailField = new TextField();
        passwordField = new PasswordField();

        loginButton = new Button("Login");
        registerButton = new Button("Register");

        scene = new Scene(root, 800, 600);
        userController = new UserController();
    }

    private void setupLayout() {
        gridPane.setPadding(new Insets(20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        gridPane.add(emailLabel, 0, 0);
        gridPane.add(emailField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(loginButton, 0, 2);
        gridPane.add(registerButton, 1, 2);
        gridPane.add(errorLabel, 1, 3);

        gridPane.setAlignment(Pos.CENTER);
        root.setCenter(gridPane);
        root.setTop(title);

        BorderPane.setAlignment(title, Pos.CENTER);
    }

    private void setupEvents() {
        loginButton.setOnAction(this);
        registerButton.setOnAction(this);
    }

    public LoginPage() {
        initComponents();
        setupLayout();
        setupEvents();
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == loginButton) {
            String error = "";
            if (error != null) {
                errorLabel.setText(error);
            } else {
                // Redirect to the main application
            }
        } else if (event.getSource() == registerButton) {
            new RegisterPage();
        }
    }
}
