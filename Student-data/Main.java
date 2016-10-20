/*
 * Emmanuel Cobblah,CS 313
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main extends Student {
	public static void main(String[] args) {
		File inputFile = new File("Original.txt");
		Scanner in;
		ArrayList<Student> Students = new ArrayList<Student>();
		
		//read file
		try {
			in = new Scanner(inputFile);
			in.useDelimiter(",|\n");
			
			while(in.hasNext()){
				String x=in.next();
				Student s=new Student();
				s.setlastName(x);
				s.setFirstName(x=in.next());			
				s.setidNum(x=in.next());
				x=in.next();
				//add course
				while(!(x.substring(0, 4).equals("-999"))){
					//reason i used substring so i can remove the new line in -999
					Course c=new Course();
					c.setcourseNum(x);
					c.setCredit(Double.parseDouble(x=in.next()));
					c.setgradeRec(x=in.next());
					s.addcourse(c);
					x=in.next();			
				}
				x=in.next();
				s.setTotalCredits(Double.parseDouble(x));
				x=in.next();
				s.setGPA(Double.parseDouble(x));
				//add new student to arraylist with attributes
				Students.add(s);
			}
			
			in.close();
			
			//User input
			Boolean userInput=true;
			while(userInput){
				Student s=new Student();
				s.setFirstName(JOptionPane.showInputDialog("First Name:"));
				s.setlastName(JOptionPane.showInputDialog("Last Name:"));
				//ask and checks if student ID is the same
				Boolean status;
				String Id=JOptionPane.showInputDialog("6 digit Student Id:");
				while(true){
					status=s.equality(Id,Students);
					if(!status){
						s.setidNum(Id);
						break;
					}
					else{
						JOptionPane.showMessageDialog(null,"error you already on list");
						Id=JOptionPane.showInputDialog(" 6 digit Student Id:");
					}
					
				}
				//Courses
				Boolean x=true;
				double totalCredit=0;
				double grade=0.0;
				while(x){
					Course c=new Course();
					c.setcourseNum(JOptionPane.showInputDialog("CourseNum:"));
					c.setCredit((Double.parseDouble(JOptionPane.showInputDialog("what the credit:"))));
					c.setgradeRec(JOptionPane.showInputDialog("What grade did you recieve:"));
					//swith statement
					switch(c.getgradeRec())
				      {
				         case "A" :
				            grade=grade+(4.0*c.getCredit());
				            break;
				         case "A-" :
					            grade=grade+(3.7*c.getCredit());
					            break;
				         case "B+" :
					            grade=grade+(3.4*c.getCredit());
					            break;
				         case "B" :
					            grade=grade+(3.1*c.getCredit());
					            break;
				         case "B-" :
					            grade=grade+(2.8*c.getCredit());
					            break;
				         case "C+" :
					            grade=grade+(2.5*c.getCredit());
					            break;
				         case "C" :
					            grade=grade+(2.2*c.getCredit());
					            break;
				         case "C-" :
					            grade=grade+(1.9*c.getCredit());
					            break;
				         case "F+" :
					            grade=grade+(1.6*c.getCredit());
				         case "F" :
					            grade=grade+(1.3*c.getCredit());
					            break;
				         case "F-" :
					            grade=grade+(1.0*c.getCredit());
					            break;
				         default :
				            System.out.println("Invalid grade");
				      }
					totalCredit=c.getCredit()+totalCredit;
					s.addcourse(c);
					if(JOptionPane.showInputDialog("Want to add another course? yes/no:").equals("no")){
						x=false;
					}
				
				}
				s.setGPA(grade/totalCredit);
				s.setTotalCredits(totalCredit);
				Students.add(s);
				if(JOptionPane.showInputDialog("Want to add another Student? yes/no:").equals("no")){
					userInput=false;
				}
				
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		}
		//print out students in a new file Test.txt
		try {
			Student s=new Student();
			PrintWriter out = new PrintWriter("New.txt");
			for(int i=0;i<Students.size();i++){
				out.println(Students.get(i).tostring(i,Students.get(i)));
			}
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
