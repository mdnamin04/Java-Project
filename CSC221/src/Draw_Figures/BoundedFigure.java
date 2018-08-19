package Draw_Figures;

import java.awt.Color;

public abstract class BoundedFigure extends Figures {
private boolean unFilled;

public BoundedFigure() {
super();
setUnFilled(false);
}
public BoundedFigure(int x1, int y1, int x2, int y2, Color color,
boolean filled) {
super(x1, y1, x2, y2, color);
unFilled = filled;
}
public boolean filled() {
return unFilled;
}
public void setUnFilled(boolean filled) {
unFilled = filled;
}
public int getUpperLeftX() {
return Math.min(getX1(), getX2());
}
public int getUpperLeftY() {
return Math.min(getY1(), getY2());
}
public int getWidth() {
return Math.abs(getX2() - getX1());
}
public int getHeight() {
return Math.abs(getY2() - getY1());
}
}