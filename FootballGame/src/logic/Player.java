package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import utility.InputUtility;

public class Player extends Entity {
	private boolean holdingBall = false;
	private boolean selected = false;

	public Player(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public boolean isHoldingBall() {
		return holdingBall;
	}

	public boolean isSelected() {
		return selected;
	}

	public void update() {
		if (selected) {
			if (InputUtility.isLeftClickTriggered()) {
				this.x = InputUtility.mouseX;
				this.y = InputUtility.mouseY;
			}
		}
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.BLUE);
		gc.fillOval(x, y, 20, 20);
	}

}
