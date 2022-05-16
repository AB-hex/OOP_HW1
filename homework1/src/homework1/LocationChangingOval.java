package homework1;
import java.awt.*;
//OVERVIEW
public class LocationChangingOval extends LocationChangingShape{
	private Dimension size = new Dimension(0,0);
	public LocationChangingOval(Point location, Color color) {
		super(location, color);
	}

	public void setSize(Dimension dimension) {
			this.size.setSize(dimension);		
	}

	public Rectangle getBounds() {
		return new Rectangle(getLocation(),size);
	}

	public void draw(Graphics g) {
		g.setColor(getColor());
		g.fillOval(getLocation().x, getLocation().y ,
				size.width , size.height );	
	}
	
	
}