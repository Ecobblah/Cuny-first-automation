/*
 * Emmanuel Cobblah
 * Project 2 Program
 */
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class Project2 {
	public static void main(String[] arg){
		WordList link_words=new WordList();
		String[]words =new String[100];
		String[]sorted_words =new String[100];
		TextFileInput File= new TextFileInput("wordsfile.txt");	
		Project2GUI MYGUI= new Project2GUI("Project2GUI");//This is is object being created from my ProjectGUI class.
		String input=File.readLine();
		//going to make size my capacity for my array;
		int size=0;
		
		//checks each line to see if it valid or not, place them in an array and gets the size(13) at start
		System.out.println("Invalid words");
		for(int i=0; input!=null;i++){
			if(MYGUI.ok(input)){
				words[i]=input;
				link_words.append(input+"\n");//add valid input to link list
				input=File.readLine();
				++size;
			}
			else{
				System.out.println(input);//this is for the invalid words
				i--;//if the word is not okay keep "i" where it is so we wont leave an array blank in between words
				input=File.readLine();
			}
		}
		
		//Only time Sorted words equals unsorted words
		for(int i=0;i<size;i++){
			sorted_words[i]=words[i];
		}
		//this is only run once, adds these values to GUI.
		//Add valid words
		MYGUI.add_unsorted(words,size);
		//Add the sorted words
		MYGUI.add_sorted(sorted_words,size);
		//sort Linklist, then add them
		link_words.sort();
		MYGUI.add_node(link_words);
		
		
		/* This part repeats until the user enters stop with a space after it.
		 * Ask the user to enter add or delete at the begging with a space after it.
		 * If add-"add cat,dog,...etc", this can add as many times you want.
		 * If delete-" delete dog", it can only delete one at a time.  
		*/
		while(true){
			StringTokenizer myTokens = new StringTokenizer(JOptionPane.showInputDialog(null,"Enter a command"),",");
			int counter=myTokens.countTokens();//counts tokens
			String [] user_input = new String[(counter+1)];//had to make counter +1 bigger
			user_input[0]=myTokens.nextToken(" ");	
			for(int i=1;i<(counter+1);i++)
				user_input[i]=myTokens.nextToken(",");
				//because i been getting the first words with space in front from StringTokenizer i have to delete the space.
			user_input[1]=user_input[1].substring(1);
			
			//If add place the input into the arrays then, increase the size.
			//insert is for inserting the new word to Linklist
			if(user_input[0].equals("STOP")|| user_input[0].equals("stop")){
				System.out.println("Ending program!");
				break;
			}
			
			else if(user_input[1].equals(""))
				JOptionPane.showMessageDialog(null,"ERROR after " +user_input[0]+ " is blank!");
			
			else if(user_input[0].equals("ADD")|| user_input[0].equals("add")){
				for(int i=1;i<user_input.length;i++){
					words[size]=user_input[i];
					sorted_words[size]=user_input[i];
					MYGUI.add_unsorted(words,++size);
					MYGUI.add_sorted(sorted_words,size);
					link_words.insert(user_input[i]+"\n");
					MYGUI.add_node(link_words);
				}
			}
			//if delete find the word and delete it, and make the size smaller
			//delete_linknode finds the node and deleted it
			else if(user_input[0].equals("DELETE")|| user_input[0].equals("delete")){
				for(int i=1;i<user_input.length;i++){
					if(find (words,size,user_input[i])!=(-5)){
						find_and_del(words,size,user_input[i]);
						find_and_del(sorted_words,size,user_input[i]);
						MYGUI.add_unsorted(words,--size);
						MYGUI.add_sorted(sorted_words,size);
						link_words.delete_Linknode(user_input[i]+"\n");
						MYGUI.add_node(link_words);
					}
					else
						JOptionPane.showMessageDialog(null,user_input[i]+" not on the list");
				}
			}
			
			else
				JOptionPane.showMessageDialog(null,"ERROR "+user_input[0]+" isn't any of the valid commands!");
		}//end of while loop	
	}//main
	
	
	
	
	
	
	 static void find_and_del(String []a,int size,String w){
		 if(find (a,size,w)!=-1){
			for(int i=find (a,size,w);i<a.length-1;i++){
				//if it finds the word, use that index to start from that position and move the rest of the words to the left.
						a[i]=a[i+1];
			}	
		 } 
	 }
	 static int find (String []a,int size,String w){
		 for(int i=0;i<size;i++){
			 if(a[i].equals(w)){
				 return i;
			 }
		 }
		 return (-5);
	 }
	

}
