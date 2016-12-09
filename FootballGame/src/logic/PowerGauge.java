package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import utility.InputUtility;

public class PowerGauge extends Entity {
	protected static boolean start;
	protected static int gauge;
	private static boolean up = true;
	private static boolean down = false;

	public PowerGauge(double x, double y) {
		super(x, y);
		gauge = 0;
		start = false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (start) {
			gauge += 2;
			if (gauge > 100) {
				gauge = 0;
				if (up) {
					up = false;
					down = true;
				} else if (down) {
					down = false;
					up = true;
				}
			}
		}
		if (InputUtility.getKeyPressed(KeyCode.Z)) {
			start = false;
			System.out.println(gauge);
		}
	}

	@Override
	public void draw(GraphicsContext gc) {
		// gc.setStroke(Color.BLACK);
		// gc.strokeRect(x, y, 25, 380);
		gc.setFill(Color.BLACK);
		if (up) {
			gc.fillRect(x, y + 380 - (gauge * 380 / 100), 25, gauge * 380 / 100);
		} else if (down) {
			gc.clearRect(x, y, 25, (gauge * 380 / 100));
		}
	}

}
