package Draw_Figures;

import java.awt.*; 
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
 
public class DrawPanel extends JPanel  
{ 
  private static final long serialVersionUID = 1L;
  private Figures shapes[]; 
  private int shapeCount; 
  private int shapeType; 
  private Figures currentShape; 
  private Color currentColor; 
  private boolean filledShape; 
  private JLabel statusLabel; 

  public DrawPanel( JLabel status ) 
  { 
    shapes = new Figures[ 100 ]; 
  shapeCount = 0;
  setShapeType (0); 
  setDrawingColor( Color.BLACK ); 
  setFilledShape( false ); 
  currentShape = null ; 
  setBackground( Color.WHITE );
  MouseHandler mouseHandler = new MouseHandler(); 
  addMouseListener( mouseHandler ); 
  addMouseMotionListener( mouseHandler ); 
  statusLabel = status; 
 } 
public void paintComponent( Graphics g ) 
{ 
  super .paintComponent( g ); 
   for ( int i = 0 ; i < shapeCount; i++ ) 
     shapes[ i ].draw( g ); 
    if ( currentShape != null ) 
      currentShape.draw( g ); 
     }
public void setShapeType( int shapeType ) 
 { 
  if ( shapeType < 0 || shapeType > 2 ) 
    shapeType = 0 ; 
  this .shapeType = shapeType; 
   }
public void setDrawingColor( Color c ) 
 { 
  currentColor = c; 
  } 
public void clearLastShape() 
 { 
  if ( shapeCount > 0 ) 
     { 
     shapeCount--; 
     repaint(); 
     }
  }
public void clearDrawing() 
{ 
  shapeCount = 0 ; 
  repaint(); 
  } 
public void setFilledShape( boolean isFilled ) 
 { 
  filledShape = isFilled; 
   }
public void loadDrawing() 
{ 
 ObjectInputStream input = null ; 
 try
  { 
   JFileChooser fileChooser = new JFileChooser(); 
   fileChooser.setFileSelectionMode( 
        JFileChooser.FILES_ONLY ); 
    int result = fileChooser.showOpenDialog(DrawPanel. this ); 
  // if user clicked Cancel button on dialog return; 
 if ( result == JFileChooser.APPROVE_OPTION );
 File fileName = fileChooser.getSelectedFile(); 
 if ( ( fileName == null ) || ( fileName.getName().equals( "" ) ) ) 
   { 
   JOptionPane.showMessageDialog( DrawPanel.this,"Invalid File Name" , "Invalid File Name", JOptionPane.ERROR_MESSAGE ); 
    return; 
    }
 input = new ObjectInputStream( 
      new FileInputStream( fileName ) ); 
 shapeCount = ( Integer ) input.readObject(); 
  shapes = ( Figures [] ) input.readObject(); 
  repaint(); 
  }
 catch ( EOFException eofException )
   { 
     JOptionPane.showMessageDialog( DrawPanel.this, "No more records in file." , "End of File", JOptionPane.ERROR_MESSAGE ); 
      } 
  catch ( ClassNotFoundException classNotFoundException ) 
   { 
    JOptionPane.showMessageDialog( DrawPanel.this , "Unable to create object." , "Class Not Found", JOptionPane.ERROR_MESSAGE ); 
    } 
  catch ( IOException ioException ) 
   { 
    JOptionPane.showMessageDialog( DrawPanel.this, "Error opening file." , "Error" , JOptionPane.ERROR_MESSAGE ); 
    } 
  finally 
   { 
    try 
     { 
     if ( input != null ) 
        input.close(); 
      }
    catch ( IOException ioException ) 
    { 
      JOptionPane.showMessageDialog( DrawPanel.this , "Error closing file." , "Error" , JOptionPane.ERROR_MESSAGE );
       } 
    }
 }
public void saveDrawing() 
{ 
  ObjectOutputStream output = null ;    
  try 
   { 
     JFileChooser fileChooser = new JFileChooser(); 
     fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY ); 
      int result = fileChooser.showSaveDialog(DrawPanel. this ); 
    if ( result == JFileChooser.APPROVE_OPTION); 
      File fileName = fileChooser.getSelectedFile(); 
     if ( ( fileName == null ) || ( fileName.getName().equals( "" ) ) ) 
        { 
       JOptionPane.showMessageDialog( DrawPanel.this , "Invalid File Name" , "Invalid File Name" , JOptionPane.ERROR_MESSAGE ); 
        return ; 
         } 
     output = new ObjectOutputStream( new FileOutputStream(fileName) ); 
     output.writeObject(shapeCount); 
     // write shapes to file using serialization 
     output.writeObject(shapes); 
     } 
  catch ( IOException ioException ) 
   { 
    JOptionPane.showMessageDialog( DrawPanel.this , "Error Opening File" , "Error." , JOptionPane.ERROR_MESSAGE ); 
     }
   finally 
   { 
      try 
       { 
        if ( output != null ) 
          output.close();
         }
      catch ( IOException ioException ) 
       { 
        JOptionPane.showMessageDialog( DrawPanel. this , 
             "Error closing file." , "Error" , 
             JOptionPane.ERROR_MESSAGE ); 
         }
       }
   }
private class MouseHandler extends MouseAdapter 
 implements MouseMotionListener 
  {  
  public void mousePressed( MouseEvent e ) 
   { 
    if ( currentShape != null ) 
       return; 
    switch (shapeType) 
     { 
      case 0: 
      currentShape = new Line( e.getX(), e.getY(), 
      e.getX(), e.getY(), currentColor ); 
      break ; 
       case 1: 
      currentShape = new Oval( e.getX(), e.getY(), 
      e.getX(), e.getY(), currentColor, filledShape ); 
      break ; 
      case 2: 
      currentShape = new Rectangle( e.getX(), e.getY(), 
      e.getX(), e.getY(), currentColor, filledShape ); 
      break ; 
       } 
     } 
  public void mouseReleased( MouseEvent e ) 
   { 
    if ( currentShape == null ) 
       return ; 
    currentShape.setX2( e.getX() ); 
    currentShape.setY2( e.getY() ); 
   if ( shapeCount < shapes.length ) 
     { 
     shapes[ shapeCount ] = currentShape; 
     shapeCount++; 
      }
   currentShape = null;
   repaint(); 
    }
  public void mouseDragged( MouseEvent e ) 
  { 
    if ( currentShape != null ) 
       { 
      currentShape.setX2( e.getX() ); 
      currentShape.setY2( e.getY() ); 
      repaint();
       } // end if 
    mouseMoved( e );
     }
  public void mouseMoved( MouseEvent e )
   { 
    statusLabel.setText( 
        String.format( "(%d,%d)" , e.getX(), e.getY() ) ); 
     }
   }
public static void main(String[] args) {

DrawFrame application = new DrawFrame();
application.setVisible(true);
application.setSize(900, 900);
application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}

