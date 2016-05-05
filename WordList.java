
public abstract class  WordList {
	private  static WordNode first= new WordNode(null);
	private   WordNode last=first;
	private WordNode e=first;
	private word current_word;
	private   int length=0;
	//add node to the end
	public  void append(word s){
		WordNode n=new WordNode (s);
		last.next=n;
		last=n;
		length++;
	}
	//add word in the beg
	public  void prepend(word d) { 
		 WordNode n = new WordNode(d); 
		 n.next = first.next; 
		 first.next = n; 
		 length++; 
		 if (first == last) last = n; 
		} 

	public String toString() {
		WordNode p = first.next;
		String returnString = "";
		while (p != null) {
			returnString += p.data+"";
			p = p.next;
		}
		return returnString;
	}
	/*sorts the links, this basically follows the same concept as the slection_sort function
	 * made 2 vari that contains what first is pointing to,inside the second for loop
	 * i would make x point to another pointer and check the data of x and y, if it in order
	 * if it not in order take the y data and save it to temp, place the x data to y and temp to x data
	 * after that ill make y going to the next pointer and set it equal to x so you wouldnt have to check the previous  data.
	 */
	
	public  void sort(){
		WordNode x,y;
		x=first.next;
		y=first.next;
		for(int i=0;i<length;i++){
			for(int j=i+1;j<length;j++){
				x=x.next;
				String Object_string=y.data.toString();
				if(Object_string.compareTo((x.data).toString())>0){
					word temp = y.data;
					y.data=x.data;
					x.data=temp;
				}
			}
			y=y.next;
			x=y;
		}
	}
	
	public void insert(word w){
		WordNode x,check;
		x=first.next;
		check=x;
		//Had to changed inside the linkedlist word to string so i can use compare methode. same goes for x.data cuz linkedlist has only word type
		String Object_string=w.toString();
		if(Object_string.compareTo((x.data).toString())<0){//this func skips the first node for some reason, so this is basically checking it.
			prepend(w);
		}
		else
			while(x.data!=null){
				check=x.next;
				if(Object_string.compareTo((check.data).toString())<0){
					WordNode n=new WordNode (w);
					n.next=x.next;//take what x is point to make it the same as the node next
					x.next=n;//then the x.next will now point to n which is pointing what x.next was prev pointing to.
					break;
				}
				x=x.next;
			}
		
	}
	public  void delete_Linknode(word w){
		WordNode x,check,y;
		x=first;
			while(x.next!=null){
				check=x;
				check=check.next;
				y=check.next;//checks even further for check vari.
				if(check.data.equals(w)){//if it finds the word, make the next node pointer point to the next 2 pointers, which will delete
					if(y==null){//if the word is the last node
						check.data=null;//if y is at the end make check.data empty to delete last word.
					}
					else
						x.next=check.next;	//the pointer x.next was previ pointing too.
				}
				x=x.next;
			}
	}
	public void resetList(){
		e=first;
	}
	
	public word nextWord(){
		e=e.next;
		if(e==null)
			return null;
		current_word=e.data;
		return current_word;
	}
	
	   
}

