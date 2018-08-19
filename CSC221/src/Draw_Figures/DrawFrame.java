package Draw_Figures;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class DrawFrame extends JFrame {
// Declare Instant variables
private JPanel componentPanel;
private JPanel statusBar;
private JButton undoButton;
private JButton saveButton;
private JButton loadButton;
private JButton clearButton;
private JComboBox<String> shapeComboBox;
private JComboBox<String> colorComboBox;
private JCheckBox filledCheckBox;
private DrawPanel mousePanel;
private JLabel statusLabel;

// Colors 13 predefined for the JComboBox
private String colorNames[] = { "Black", "Blue", "Cyan", "Dark Gray","Gray", "Green", "Light Gray", "Magenta", "Orange", 
		"Pink", "Red", "White", "Yellow" };
private Color colors[] = { Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY,
Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW };

// Shapes for the JComboBox
private String[] shapeChoice = { "Line", "Oval", "Rectangle" };
private int shapeNum[] = { 0, 1, 2 };

public DrawFrame() {

super("Java Drawing Assignment");

componentPanel = new JPanel();
statusBar = new JPanel();
statusLabel = new JLabel("Mouse Outside Panel");
undoButton = new JButton("Undo");
saveButton = new JButton("Save");
loadButton = new JButton("Load");
clearButton = new JButton("Clear");
colorComboBox = new JComboBox<String>(colorNames);
shapeComboBox = new JComboBox<String>(shapeChoice);
filledCheckBox = new JCheckBox("Filled");// Create CheckBox

add(componentPanel, BorderLayout.NORTH);
add(statusBar, BorderLayout.SOUTH);
statusBar.add(statusLabel);

mousePanel = new DrawPanel(statusLabel);
add(mousePanel, BorderLayout.CENTER);

componentPanel.add(undoButton);
undoButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
mousePanel.clearLastShape();
}
});
componentPanel.add(clearButton);
clearButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
mousePanel.clearDrawing();
}
});
componentPanel.add(colorComboBox, BorderLayout.NORTH);
colorComboBox.addItemListener(new ItemListener() {
public void itemStateChanged(ItemEvent e) {
if (e.getStateChange() == ItemEvent.SELECTED);
mousePanel.setDrawingColor(colors[colorComboBox.getSelectedIndex()]);
}
});
componentPanel.add(shapeComboBox);
shapeComboBox.addItemListener(new ItemListener() {
public void itemStateChanged(ItemEvent e) {
if (e.getStateChange() == ItemEvent.SELECTED);
mousePanel.setShapeType(shapeNum[shapeComboBox
.getSelectedIndex()]);
}
});
componentPanel.add(filledCheckBox);
filledCheckBox.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
mousePanel.setFilledShape(filledCheckBox.isSelected());
}
});
componentPanel.add(saveButton);
saveButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
mousePanel.saveDrawing();
}
});
componentPanel.add(loadButton);
loadButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
mousePanel.loadDrawing();
}
});
}
}
