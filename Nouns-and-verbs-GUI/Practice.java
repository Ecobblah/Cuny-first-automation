import javax.swing.JOptionPane;

public class Practice {
	
	public static void main(String[] args) {
		SortedWordList list = new SortedWordList();
		word v=new Verb("Always");
		v=new Verb("b");
		list.append(v);
		v=new Verb("c");
		list.append(v);
		v=new Verb("d");
		list.append(v);
		v=new Verb("a");
		list.append(v);
		
		list.sort();
		int x=2;
		System.out.println(list);
	}
	
}
