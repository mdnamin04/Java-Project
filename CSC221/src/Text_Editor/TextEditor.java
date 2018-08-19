package Text_Editor;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class TextEditor
 {

 public TextEditor() 
 {

	 JFrame f= new JFrame("Text Editor Frame");
	 String fontName[]={"Serif","SanSerif","MonoSpaced","Arial","Calibri"}; //Array of font name

	 //Array of font size
	 String fontSize[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};

	 //Text box
	 final JTextField field = new JTextField("",30);
	 field.setBounds(30,100,400,30);

	 //Check box : Bold
	 final JCheckBox checkBox1 = new JCheckBox("Bold ");  
	 checkBox1.setBounds(120,50,100,50);  

	 //Check box : Italic
	 final JCheckBox checkBox2 = new JCheckBox("Italic");  
	 checkBox2.setBounds(50,50,100,50);

	 //Combo box for font name
	 @SuppressWarnings({ "unchecked", "rawtypes" })

	 final JComboBox cb=new JComboBox(fontName);
	 cb.setBounds(200,50,100,30);

	 //Combo box for font size
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	 final JComboBox cbsize=new JComboBox(fontSize);
	 cbsize.setBounds(310,50, 50,30);
	 cbsize.setSelectedIndex(11);
	 Font font = new Font("Serif", Font.PLAIN,12); //Default font for text field format (font name, font style, font size)

	 field.setFont(font);
	 f.add(field);
	 f.add(checkBox1);  
	 f.add(checkBox2);
	 f.add(cb);
	 f.add(cbsize);
	 f.setSize(500,300);  
	 f.setLayout(null);  
	 f.setVisible(true);  

/*

* Action listener for CheckBox1 i.e. Bold text

*/

	 checkBox1.addItemListener(
			 new ItemListener(){

				 public void itemStateChanged(ItemEvent e){

					 if(checkBox1.isSelected()) //If bold selected
						 { 
						 int style;
						 style = Font.BOLD;
						 if(checkBox2.isSelected()) //If Italic selected
							 style += Font.ITALIC;
						 Font font = new Font((String) cb.getItemAt(cb.getSelectedIndex()), //Fetching font name
								 style,
								 Integer.parseInt((String) cbsize.getItemAt(cbsize.getSelectedIndex())) + 1);//Font size
						 field.setFont(font);
						 }

					 if(!checkBox1.isSelected()) //If not bold selected
						 {
						 int style;
						 style = Font.PLAIN; //Making font style plain
						 if(checkBox2.isSelected()) //If Italic selected
							 style += Font.ITALIC;
						 Font font = new Font((String) cb.getItemAt(cb.getSelectedIndex()), //Fetching font name
								 style,
								 Integer.parseInt((String) cbsize.getItemAt(cbsize.getSelectedIndex())) + 1);//Font size
						 field.setFont(font);
						 }
				 }
			 }
			 );

/*

* Action listener for CheckBox2 i.e. Italic text

*/

	 checkBox2.addItemListener(
			 new ItemListener(){
				 public void itemStateChanged(ItemEvent e){
					 if(checkBox2.isSelected()) //If Italic selected
					 {
						 int style;
						 style = Font.ITALIC;
						 if(checkBox1.isSelected()) //If bold selected
							 style += Font.BOLD;
						 Font font = new Font((String) cb.getItemAt(cb.getSelectedIndex()), //Fetching font name
								 style,
								 Integer.parseInt((String) cbsize.getItemAt(cbsize.getSelectedIndex())) + 1); //Font size
						 field.setFont(font);
					 }
					 if(!checkBox2.isSelected()) //If not Italic selected
					 {
						 int style;
						 style = Font.PLAIN; //Making font style plain
						 if(checkBox1.isSelected())
							 style += Font.BOLD;
						 Font font = new Font((String) cb.getItemAt(cb.getSelectedIndex()), //Fetching font name
								 style,
								 Integer.parseInt((String) cbsize.getItemAt(cbsize.getSelectedIndex())) + 1); //Font size
						 field.setFont(font);
					 }
				 }
			 }
			 );
/*

* Action listener for Font name change

*/

	 cb.addItemListener(
			 new ItemListener(){
				 public void itemStateChanged(ItemEvent e)
				 {
					 int style = 0;
					 if(checkBox2.isSelected())
						 style = Font.ITALIC;
					 if(checkBox1.isSelected())
						 style += Font.BOLD;
					 Font font = new Font((String) cb.getItemAt(cb.getSelectedIndex()), //Fetching font name
							 style,
							 Integer.parseInt((String) cbsize.getItemAt(cbsize.getSelectedIndex())) + 1);//Font size
					 field.setFont(font);
				 }
			 }
			 );
/*

* Action listener for Font size change

*/

	 cbsize.addItemListener(
			 new ItemListener(){
				 public void itemStateChanged(ItemEvent e)
				 {
					 int style = 0;
					 if(checkBox2.isSelected())
						 style = Font.ITALIC;
					 if(checkBox1.isSelected())
						 style += Font.BOLD;
					 Font font = new Font((String) cb.getItemAt(cb.getSelectedIndex()), //Fetching font name
							 style,
							 Integer.parseInt((String) cbsize.getItemAt(cbsize.getSelectedIndex())) + 1);//Font size
					 field.setFont(font);
				 }
			 }
			 );
 }

 public static void main (String[] args) {
	 new TextEditor();
 }
}
