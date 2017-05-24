package io.anuke.novix.scene;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;

import io.anuke.novix.Core;

public class ImagePreview extends Group{
	protected Stack stack;
	public final PixmapImage image;
	
	public ImagePreview(Pixmap pixmap){
		stack = new Stack();
		
		image = new PixmapImage(pixmap);
		
		int scale = pixmap.getWidth();
		float ratio = 1f/((float)pixmap.getWidth() / pixmap.getHeight());
		AlphaImage alpha = new AlphaImage(scale, (int)(scale*ratio));
		GridImage grid = new GridImage(io.anuke.novix.drawgrid.canvas.width(), io.anuke.novix.drawgrid.canvas.height());
		BorderImage border = new BorderImage();
		border.setColor(Color.CORAL);
		
		stack.add(alpha);
		stack.add(image);
		if(io.anuke.novix.i.prefs.getBoolean("grid")) stack.add(grid);
		stack.add(border);
		
		addActor(stack);
	}
	
	public void draw(Batch batch, float alpha){
		super.draw(batch, alpha);
		stack.setBounds(0, 0, getWidth(), getHeight());
	}
	
	public PixmapImage getImage(){
		return image;
	}
}
