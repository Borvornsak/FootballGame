package logic;

import sharedObject.IRenderable;

public abstract class Entity implements IRenderable {
	protected double x, y;
	protected int z;
	protected boolean visible, destroyed;

	public Entity(double x, double y) {
		this.x = x;
		this.y = y;
		z = 1;
		visible = true;
		destroyed = false;
	}

	@Override
	public int getZ() {
		return z;
	}

	@Override
	public boolean isDestroyed() {
		return destroyed;
	}

	@Override
	public boolean isVisible() {
		return visible;
	}
	
	public abstract void update();

}
