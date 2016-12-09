import drawing.GameScreen;
import utility.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.GameLogic;
import sharedObject.RenderableHolder;
import utility.FixDataUtility;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		StackPane root = new StackPane();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);

		GameLogic gameLogic = new GameLogic();
		GameScreen gameScreen = new GameScreen(FixDataUtility.SCREEN_WIDTH, FixDataUtility.SCREEN_HEIGHT);
		root.getChildren().add(gameScreen);
		gameScreen.requestFocus();

		primaryStage.show();
		
		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				gameScreen.paintComponent();
				gameLogic.logicUpdate();
				RenderableHolder.getInstance().update();
				InputUtility.updateInputState();
			}
		};
		animation.start();
	}

}
