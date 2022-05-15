package homework1;
import java.awt.*;
//OVERVIEW
public class LocationChangingOval extends LocationChangingShape{
	Dimension dimension;
	public LocationChangingOval(Point location, Color color) {
		super(location, color);
	}

	public void setSize(Dimension dimension) throws ImpossibleSizeException {
		try{
			if(dimension.height*dimension.width >= 600*400) {
			throw new ImpossibleSizeException();
			}
			else {this.dimension = (Dimension)dimension.clone();}
			
		}
		catch(ImpossibleSizeException e) {
			this.dimension = (Dimension)e.alternativeSize.clone();
		}
		
	}

	public Rectangle getBounds() {
		return new Rectangle(dimension);
	}

	public void draw(Graphics g) {
		g.setColor(getColor());
		g.fillOval(getLocation().x, getLocation().y ,
				dimension.width , dimension.height );	
	}
	
	
}