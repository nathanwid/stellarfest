package view;

import controller.UserController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class RegisterPage implements EventHandler<ActionEvent> {
    private BorderPane root;
    private GridPane gridPane;

    private Label title;
    private Label emailLabel;
    private TextField emailField;
    private Label usernameLabel;
    private TextField usernameField;
    private Label passwordLabel;
    private PasswordField passwordField;
    private Label errorLabel;

    private Label roleLabel;
    private ComboBox<String> roleComboBox;

    private Button register;
    private Label loginLabel;
    private Button loginBtn;

    private UserController uc;

    public Scene scene;

    private void init() {
        root = new BorderPane();
        gridPane = new GridPane();

        title = new Label("Register");
        emailLabel = new Label("Email:");
        emailField = new TextField();
        usernameLabel = new Label("Username:");
        usernameField = new TextField();
        passwordLabel = new Label("Password:");
        passwordField = new PasswordField();
        errorLabel = new Label();

        roleLabel = new Label("Select Role:");
        roleComboBox = new ComboBox<>();
        roleComboBox.getItems().addAll("Event Organizer", "Vendor", "Guest");

        register = new Button("Register");
        loginLabel = new Label("Already have an account? ");
        loginBtn = new Button("Login");

        uc = new UserController();

        scene = new Scene(root, 750, 500);
    }

    private void addComponents() {
        gridPane.add(title, 0, 0, 2, 1);
        gridPane.add(emailLabel, 0, 1);
        gridPane.add(emailField, 1, 1);
        gridPane.add(usernameLabel, 0, 2);
        gridPane.add(usernameField, 1, 2);
        gridPane.add(passwordLabel, 0, 3);
        gridPane.add(passwordField, 1, 3);
        gridPane.add(roleLabel, 0, 4);
        gridPane.add(roleComboBox, 1, 4);
        gridPane.add(errorLabel, 0, 5, 2, 1);
        gridPane.add(register, 0, 6, 2, 1);

        FlowPane loginPane = new FlowPane();
        loginPane.setAlignment(Pos.CENTER);
        loginPane.setHgap(10);
        loginPane.getChildren().addAll(loginLabel, loginBtn);

        gridPane.add(loginPane, 0, 7, 2, 1);

        root.setCenter(gridPane);
    }

    private void arrangeComponents() {
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);

        emailLabel.setMinWidth(100);
        usernameLabel.setMinWidth(100);
        passwordLabel.setMinWidth(100);
        roleLabel.setMinWidth(100);

        emailField.setMaxWidth(320);
        usernameField.setMaxWidth(320);
        passwordField.setMaxWidth(320);
        roleComboBox.setMaxWidth(320);

        GridPane.setHalignment(register, HPos.CENTER);
        GridPane.setMargin(register, new Insets(10, 0, 0, 0));

        GridPane.setHalignment(errorLabel, HPos.CENTER);
        errorLabel.setTextFill(Color.RED);
    }


    private void setStyle() {
        // Additional styling can be added here
    }

    // Event handling for Register's Validation
    private void events() {
        register.setOnAction(e -> handle(e));
        loginBtn.setOnAction(e -> handle(e));
    }

    public RegisterPage() {
        init();
        addComponents();
        arrangeComponents();
        setStyle();
        events();
        Main.redirect(scene);
    }

    @Override
    public void handle(ActionEvent e) {
        if (e.getSource() == register) {
            String error = uc.checkRegisterInput(emailField.getText(), usernameField.getText(), passwordField.getText());
            if (error != null) {
                errorLabel.setText(error);
            } else {
                uc.register(emailField.getText(), usernameField.getText(), passwordField.getText(), roleComboBox.getValue());
                new RegisterPage(); // Refresh the page after registration
            }
        } else if (e.getSource() == loginBtn) {
            Main.redirect(new LoginPage().scene);
        }
    }
}
