package Draw_Figures;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends BoundedFigure {

public Rectangle() {
super();
setUnFilled(false);
}

public Rectangle(int x1, int y1, int x2, int y2, Color color,
boolean notToFill) {
super(x1, y1, x2, y2, color, notToFill);
}
public void draw(Graphics g) {
g.setColor(getColor());

if (filled()) {
g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
} else {
g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
}
} 
} 