/*Emmanuel Cobblah
 * Project GUI class
 */
import javax.swing.*;
import java.awt.*;

public class Project2GUI {
	static JFrame Frame;
	static TextArea unsorted_words, sorted_words,nodesorted_words;
	//static LinkedList testing;
	public Project2GUI(String title){//constructor
			//makes an empty 2 col GUI FRAME. 
					Frame=new JFrame();
					Frame.setSize(400,400);//Height, width
					Frame.setLocation(200,200);
					Frame.setTitle(title);
					Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					Frame.setVisible(true);
					Frame.setLayout(new GridLayout(1,3));//three cols
					unsorted_words=new TextArea();//Area where i can places inputs for the GUI
					sorted_words= new TextArea();
					nodesorted_words=new TextArea();
					Container panel=new Container();
					Container panel2=new Container();
					panel=Frame.getContentPane();//This adds the two textarea into the GUI
					panel.add(unsorted_words);
					panel.add(sorted_words);
					panel.add(nodesorted_words);
	}
	//Adds the valid inputs "words" to the left side textarea of the GUI
	public void add_unsorted(String[] words,int size){
		delete();
		for(int i=0;i<size;i++)
			unsorted_words.append(words[i]+"\n");
	}
	//Adds the valid sorted inputs "words" to the right side textarea of the GUI
	public void add_sorted(String[] words, int size){
		 SelectionSort(words,size);
		for(int i=0;i<size;i++){
			sorted_words.append(words[i]+"\n");
		}
	}
	//This basically clears everything in all textareas, only use int add_unsorted
	public void delete(){
		unsorted_words.replaceRange("", 0, 9999);
		sorted_words.replaceRange("", 0, 9999);
		nodesorted_words.replaceRange("",0,9999);
	}
	
	public void add_node(WordList list){
		nodesorted_words.append(list.toString());//add the words to textarea
		
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
}
