/*Emmanuel Cobblah
 * Project GUI class
 */
import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Project3GUI {
	static JFrame Frame;
	static TextArea unsorted_words, sorted_words,nodesorted_words;
	//static LinkedList testing;
	public Project3GUI(String title){//constructor
			//makes an empty 2 col GUI FRAME. 
					Frame=new JFrame();
					Frame.setSize(400,400);//Height, width
					Frame.setLocation(200,200);
					Frame.setTitle(title);
					createfilemenu();
					Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					Frame.setVisible(true);
					
					/*
					Frame.setLayout(new GridLayout(1,2));//three cols
					unsorted_words=new TextArea();//Area where i can places inputs for the GUI
					sorted_words= new TextArea();
					nodesorted_words=new TextArea();
					Container panel=new Container();
					panel=Frame.getContentPane();//This adds the two textarea into the GUI
					*/
					//panel.add(unsorted_words);
					//panel.add(sorted_words);
	}
	//Adds the valid inputs "words" to the left side textarea of the GUI
	public void add_unsorted(String[] words,int size){
		
	}
	//Adds the valid sorted inputs "words" to the right side textarea of the GUI
	public void add_sorted(String[] words, int size){
		 
	}
	//This basically clears everything in all textareas, only use int add_unsorted
	public void delete(){
		unsorted_words.replaceRange("", 0, 9999);
		sorted_words.replaceRange("", 0, 9999);
	}
	
	//Sorts the words in alphabetically order
	//compareTO functions returns a int, if it returns < 0, that means the left side of the string is first  alphabetically
	//if it returns >0 then the right side of the string in the parenthesis comes first.
	public void SelectionSort(String words[],int size){
		String temp;//This holds temporally strings
		for(int i=0;i<size;i++){
			for(int j=i+1;j<size;j++){
				if(words[i].compareTo(words[j])>0){//if word[j] comes in alphabetically first then switch positions.
					temp = words[i];
					words[i]=words[j];
					words[j]=temp;
				}
			}
		}
	}
	
	//Checks if the word is valid, with no special characters
	public boolean ok(String input){
			for(int j=0;j<input.length();j++){
				if(!(Character.isLetter(input.charAt(j))))
					return false;//it not a letter.
			}
			return true;
	}
	void createfilemenu(){
		JMenuItem item;
	    JMenuBar menuBar  = new JMenuBar();
	    JMenu fileMenu = new JMenu("File");
	    JMenu editMenu= new JMenu("Display");
	    
	    FileMenuHandler fmh  = new FileMenuHandler(Frame);//change to "this" later
	    
	    item = new JMenuItem("Open");    //Open...
	    item.addActionListener( fmh );
	    fileMenu.add( item );
	    
	    fileMenu.addSeparator();//add a horizontal separator line
	      
	    editMenu.addSeparator();
	    
	    item = new JMenuItem("Quit");       //Quit
	      item.addActionListener( fmh );
	      fileMenu.add( item );
	      
	      item=new JMenuItem("Nouns");
	      item.addActionListener(fmh);
	      editMenu.add(item);
	      
	      item=new JMenuItem("Verbs");
	      item.addActionListener(fmh);
	      editMenu.add(item);
	    
	    Frame.setJMenuBar(menuBar);
	      menuBar.add(fileMenu);
	      menuBar.add(editMenu);
	    
	}//createMenu
}
