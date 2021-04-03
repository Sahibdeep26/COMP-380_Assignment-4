/* DO NOT EDIT THIS CLASS.
 * 
 * A simple class representing an Atom.
 * An Atom is just associated with a String symbol.
 */
public class Atom
{

	private String symbol;
	
	public Atom(String sym)
	{
		symbol = sym;
	}
	
		
	public String toString()
	{
		return symbol;
	}
	
	// Two Atoms are the same if they have the same symbol.
	public boolean equals(Atom other)
	{
		if(this == other) return true;
	    if((other == null) || (other.getClass() != this.getClass())) return false;
	    
	    Atom atom = (Atom) other;
	    return atom.toString().equals(this.toString());
	}
}
