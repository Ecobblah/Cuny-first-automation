import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class FileMenuHandler implements ActionListener {
	 word w;
	 TextArea unsorted;
	 TextArea sorted;
	 //word w;
	 
	 UnsortedWordList un_sorted;
	 SortedWordList sorted_class;
   JFrame jframe;
   public FileMenuHandler (JFrame jf) {
	   //Make sure to add another parameter for linked list, and stor
	   //it as a varible.
      jframe = jf;
   }
   public void actionPerformed(ActionEvent event) {
      String menuName = event.getActionCommand();
      if (menuName.equals("Open")){
         openFile(); 
      	inputcommand();
      }
      else if (menuName.equals("Quit"))
    	  System.exit(0);
      else if (menuName.equals("Verbs"))
    	  openVerbs();
      else if (menuName.equals("Nouns"))
    	  openNouns();
   } //actionPerformed
   
   void openFile(){
	   int status;
	   JFileChooser chooser = new JFileChooser( );
	   status = chooser.showOpenDialog(null);
	   readSource(chooser.getSelectedFile());
   }
   private void readSource(File chosenFile){
		  String chosenFileName = chosenFile.getName();
		  TextFileInput inFile = new TextFileInput(chosenFileName);
		  un_sorted= new UnsortedWordList();
		  sorted_class=new SortedWordList();
		  
		  //Gui for 2 textarea
		   unsorted = new TextArea();
		   sorted = new TextArea();
		  jframe.setLayout(new GridLayout(1,2));
		  Container panel=new Container();
		  panel=jframe.getContentPane();
		  panel.add(unsorted);
		  panel.add(sorted);
		  //Store word into linkedlist.
		  String read=inFile.readLine();
			while(read!=null){
				int length =read.length();
				//if you find a V then send to the verb class.
				char NorV=read.charAt(length-2);
				if(NorV=='V'){
					w= new Verb(read+"\n");
					un_sorted.append(w);
					//un_sorted.append(w+"\n");
				}
				else{
					w=new Noun(read+"\n");
					un_sorted.append(w);
				}				

				read=inFile.readLine();
			}
			
			unsorted.append(un_sorted.toString());
			un_sorted.sort();
			sorted.append(sorted_class.toString());
		  jframe.setVisible(true);
	  }
   public void openVerbs(){
	   word input=sorted_class.nextWord();
	   delete();
	   un_sorted.resetList();
	   while(input!=null){
	  if(input instanceof Verb){
		sorted.append(input.toString());
		unsorted.append(input.toString());
	  }
	  input=sorted_class.nextWord();
	  
	   }
   }
   public void openNouns(){
	   word input=sorted_class.nextWord();
	   delete();
	   un_sorted.resetList();
	   while(input!=null){
	  if(input instanceof Noun){
		sorted.append(input.toString());
		unsorted.append(input.toString());
	  }
	  input=sorted_class.nextWord();
	  
	   }
   }
   public void inputcommand(){
	   word ConvertToStr;
	   CharSequence v = "(V)";
	   CharSequence N = "(N)";
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
				System.out.println("Stoping!");
				break;
			}
			
			else if(user_input[1].equals(""))
				JOptionPane.showMessageDialog(null,"ERROR after " +user_input[0]+ " is blank!");
			
			else if(user_input[0].equals("ADD")|| user_input[0].equals("add")){
				for(int i=1;i<user_input.length;i++){
					if(user_input[i].contains(v))
						w= new Verb(user_input[i]+"\n");
					else if(user_input[i].contains(N))
						w=new Noun(user_input[i]+"\n");
					un_sorted.insert(w);
					unsorted.append(user_input[i]+"\n");
				}
				sorted.replaceRange("", 0, 9999);//delete sorted side and replace
				sorted.append(un_sorted.toString());
			}
			//if delete find the word and delete it, and make the size smaller
			//delete_linknode finds the node and deleted it
			else if(user_input[0].equals("DELETE")|| user_input[0].equals("delete")){
				for(int i=1;i<user_input.length;i++){
					if(user_input[i].contains(v))
						w= new Verb(user_input[i]+"\n");
					else if(user_input[i].contains(N))
						w=new Noun(user_input[i]+"\n");
					un_sorted.delete_Linknode(w);
				}
				sorted.replaceRange("", 0, 9999);//delete sorted side and replace
				sorted.append(un_sorted.toString());
				unsorted.replaceRange("", 0, 9999);
				unsorted.append(un_sorted.toString());
			}
			
			else
				JOptionPane.showMessageDialog(null,"ERROR "+user_input[0]+" isn't any of the valid commands!");
		}//end of while loop	
	}//inputcommand
   
   public void delete(){
		unsorted.replaceRange("", 0, 9999);
		sorted.replaceRange("", 0, 9999);
	}

}