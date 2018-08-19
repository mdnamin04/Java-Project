package Draw_Figures;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends BoundedFigure {
	
public Oval() {
super();
setUnFilled(false);
}

public Oval(int x1, int y1, int x2, int y2, Color color, boolean notToFill) {
super(x1, y1, x2, y2, color, notToFill);
}
public void draw(Graphics g) {
g.setColor(getColor());

if (filled()) {
g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
} else {
g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
}
} 
} 