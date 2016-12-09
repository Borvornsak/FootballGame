package logic;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class Ball extends Entity {
	private static int angle;
	private static int movespeed = 20;
	private static double maxLength = 0;
	private static double length = 0;

	public Ball(double x, double y, int angle) {
		super(x, y);
		Ball.angle = angle;
	}

	public void findLength() {
		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
			if (entity instanceof Player) {
				length = Math.sqrt(Math.pow(((Player) entity).x - x, 2) + Math.pow(((Player) entity).y - y, 2));
				if (length > maxLength) {
					maxLength = length;
				}
			}
		}
	}

	@Override
	public void update() {
		this.x += Math.cos(Math.toRadians(angle)) * movespeed;
		this.y += Math.sin(Math.toRadians(angle)) * movespeed;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.ball, x, y);
	}

}
