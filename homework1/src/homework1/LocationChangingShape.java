package homework1;

import java.awt.*;
import java.util.Random;

/**
 * A LocationChaningShape is a Shape that can change its location using its step()
 * method. A LocationChaningShape has a velocity property that determines the speed
 * of location changing.
 * Thus, a typical LocationChaningShape consists of the following set of
 * properties: {location, color, shape, size, velocity}
 */


public abstract class LocationChangingShape extends Shape implements Animatable {	
	private int velocityX,velocityY;
	// TODO: Write Abstraction Function
	
	// TODO: Write Representation Invariant

	
	/**
	 * @effects Initializes this with a a given location and color. Each
	 *          of the horizontal and vertical velocities of the new
	 *          object is set to a random integral value i such that
	 *          -5 <= i <= 5 and i != 0
	 */
	public LocationChangingShape(Point location, Color color) {
		super(location,color);
		int upperBound = 6, lowerBound = -6; 
		Random rand = new Random();
		do {
		velocityX = rand.nextInt(upperBound-lowerBound)+lowerBound;
    	velocityY = rand.nextInt(upperBound-lowerBound)+lowerBound;
		}while( velocityX==0 || velocityY==0 );
    
    }


    /**
     * @return the horizontal velocity of this.
     */
    public int getVelocityX() {
    	return velocityX;

    	
    }


    /**
     * @return the vertical velocity of this.
     */
    public int getVelocityY() {
    	return velocityY;
    }


    /**
     * @modifies this
     * @effects Sets the horizontal velocity of this to velocityX and the
     * 			vertical velocity of this to velocityY.
     */
    public void setVelocity(int velocityX, int velocityY) {
    	this.velocityX=velocityX;
    	this.velocityY=velocityY;
    }


    /**
     * @modifies this
     * @effects Let p = location
     * 				v = (vx, vy) = velocity
     * 				r = the bounding rectangle of this
     *         	If (part of r is outside bound) or (r is within bound but
     *          adding v to p would bring part of r outside bound) {
     * 				If adding v to p would move r horizontally farther away
     * 				from the center of bound,
     * 					vx = -vx
     * 				If adding v to p would move r vertically farther away
     * 				from the center of bound,
     * 					vy = -vy
     *          }
     * 			p = p + v
     */
    public void step(Rectangle bound) {
    	boolean[] inBound= inLimit(bound);
    	if(!inBound[0]) {
    		velocityX = -velocityX;
    	}
    	if(!inBound[1]) {
    		velocityY = -velocityY;
    	}
    	Point newLocation = this.getLocation();
    	newLocation.move(newLocation.x+velocityX, newLocation.y+velocityY);
    	setLocation(newLocation);
    }
    
    protected boolean[] inLimit(Rectangle bound) {
    	boolean[] result = {true,true};
       	Rectangle r = getBounds();
       	int leftBorder = 0,rightBorder = bound.width,
       			upperBorder = 0, lowerBorder = bound.height;
    	if( r.contains(leftBorder,r.y) 
    			|| r.contains(rightBorder,r.y)
    			|| r.contains(leftBorder-velocityX,r.y)
    			|| r.contains(rightBorder-velocityX,r.y)) {
    		result[0] = false;	
    	} 
    	if( r.contains(r.x,upperBorder) 
    			|| r.contains(r.x,lowerBorder)
    			|| r.contains(r.x,upperBorder-velocityY)
    			|| r.contains(r.x,lowerBorder-velocityY)) {
    		result[1] = false;	}
    	return result;
    }
 
 
}
