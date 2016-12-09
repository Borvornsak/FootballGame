package logic;

import java.util.ArrayList;
import java.util.List;

import sharedObject.RenderableHolder;
import utility.FixDataUtility;

public class GameLogic {
	private List<Entity> gameObjectContainer;

	private Arrow arrow;
	private Player player;
	private PowerGauge gauge;
	
	public GameLogic(){
		this.gameObjectContainer = new ArrayList<Entity>();
		Field field = new Field();
		RenderableHolder.getInstance().add(field);
		player = new Player(FixDataUtility.SCREEN_WIDTH / 2, FixDataUtility.SCREEN_HEIGHT / 2);
		arrow = new Arrow(player.x + 20, player.y + 20);
		gauge = new PowerGauge(12.5, 50);
		addNewObject(player);
		addNewObject(arrow);
		addNewObject(gauge);
		
	}
	
	protected void addNewObject(Entity entity){
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}
	
	public void logicUpdate(){
		player.update();
		arrow.update();
		gauge.update();
	}
}
