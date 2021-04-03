/* DO NOT EDIT THIS CLASS
 * 
 * A simple class representing a Rule.
 * A rule is composed of an Atom as its head,
 * and a conjunction of Atoms as its body.
 * e.g. h <- b1 & b2
 */
public class Rule
{

	Atom head;
	Atom[] body;
	
	public Rule(Atom h, Atom[] b)
	{
		head = h;
		body = b;
	}
	
	public Atom getHead()
	{
		return head;
	}
	
	public Atom[] getBody()
	{
		return body;
	}
}
