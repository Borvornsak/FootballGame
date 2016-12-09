package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;
import utility.FixDataUtility;
import utility.InputUtility;

public class Arrow extends Entity {
	private static int angle;
	private static boolean selected;

	public Arrow(double x, double y) {
		super(x, y);
		angle = 0;
		selected = false;
	}
	
	public static boolean isSelected() {
		return selected;
	}

	@Override
	public void update() {
		for(IRenderable entity : RenderableHolder.getInstance().getEntities()){
			if(entity instanceof Player){
				if(((Player) entity).isSelected()){
					this.x = ((Player) entity).x + 20;
					this.y = ((Player) entity).y + 20;
				}
			}
		}
		if (!selected) {
			angle += 3;
			if (angle >= 360)
				angle -= 360;
		}
		if (InputUtility.getKeyPressed(KeyCode.SPACE)) {
			selected = true;
			PowerGauge.start = true;
		}
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.translate(x, y);
		gc.rotate(angle);
		gc.clearRect(30, -10, 20, 20);
		//System.out.println(angle);
		// gc.drawImage(RenderableHolder.arrow, x, y);
		gc.setFill(Color.BLUE);
		gc.fillRect(30, -10, 20, 20);
		gc.rotate(-angle);
		gc.translate(-x, -y);
	}

}
