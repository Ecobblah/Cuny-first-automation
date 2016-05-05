import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class EditMenuHandler extends JFrame{
	
   private void createFileMenu( ) {
      JMenuItem   item;
      JMenuBar    menuBar  = new JMenuBar();
      JMenu       fileMenu = new JMenu("File");
      JMenu editMenu= new JMenu("Edit");
      FileMenuHandler fmh  = new FileMenuHandler(this);

      item = new JMenuItem("Open");    //Open...
      item.addActionListener( fmh );
      fileMenu.add( item );

      fileMenu.addSeparator();//add a horizontal separator line
      
      editMenu.addSeparator();
      
      item = new JMenuItem("Quit");       //Quit
      item.addActionListener( fmh );
      fileMenu.add( item );
      
      item=new JMenuItem("Find");
      item.addActionListener(fmh);
      editMenu.add(item);
      
      item=new JMenuItem("Replace");
      item.addActionListener(fmh);
      editMenu.add(item);

      setJMenuBar(menuBar);
      menuBar.add(fileMenu);
      menuBar.add(editMenu);
    
   } //createMenu
}
