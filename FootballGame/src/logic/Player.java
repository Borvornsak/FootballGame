package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;
import utility.InputUtility;

public class Player extends Entity {
	private boolean holdingBall = false;
	private boolean selected = false;

	public Player(double x, double y) {
		super(x, y);
	}

	public boolean isHoldingBall() {
		return holdingBall;
	}

	public boolean isSelected() {
		return selected;
	}

	@Override
	public void update() {
		if(InputUtility.getKeyPressed(KeyCode.S)){
			selected = true;
		}
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
		//gc.drawImage(RenderableHolder.player, x, y);
		gc.setFill(Color.BLACK);
		gc.fillOval(x, y, 40, 40);
	}

}
