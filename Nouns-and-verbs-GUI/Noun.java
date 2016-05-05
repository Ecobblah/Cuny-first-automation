
public class Noun extends word {

	public Noun(String d) {
		super(d);
	}
	public void idk(Noun d) {
		if( d instanceof Noun )
			System.out.println(" it a noun!");
	}
	//stores in word classs using super, same as the verfb class, use super to send to word class so it can add the word to the linklist
}
