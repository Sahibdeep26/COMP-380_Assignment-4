import java.util.ArrayList;
import java.util.List;

public class ProofTester {
	/*
	 * Name: Sahibdeep Singh 
	 * UFV ID: 300156800
	 */

	// YOU MUST IMPLEMENT THIS METHOD.
	// SEE TEXTBOOK CHAPTER/SECTION 5.2.2.1
	public static List<Atom> bottomUpDeduction(List<Rule> KB) {
		// C IS OUR LIST THAT WILL CONTAIN
		// ALL ATOMS ENTAILED BY THE KB.
		List<Atom> C = new ArrayList<Atom>();

		// loop until no more Rules can be selected
		boolean canSelect = true;

		// YOU MUST FINISH THIS WHILE LOOP.
		// ESSENTIALLY YOU ARE IMPLEMENTING LINES 9-12
		// OF FIGURE 5.3 IN THE TEXTBOOK.

		while (canSelect) {

			// YOUR CODE HERE

			canSelect = false;

			// until proven otherwise, we will be assume
			// that no useful rules will be found
			KBRules: for (Rule rules : KB) {
				// cycle through the rules in the KB
				if (!C.contains(rules.getHead())) {
					// if current rule's head
					// isn't in C yet
					for (Atom atoms : rules.getBody()) {
						// then cycle through the atoms in the current rule's
						// body
						if (!C.contains(atoms))
							// if the current body atom is not in C
							continue KBRules;
					}
					C.add(rules.getHead());
					canSelect = true;
				}
			}
		}
		return C;

		// SINCE THE ORDER DOESN'T MATTER I WON'T BE PERFORMING ANY KIND OF
		// SORTING ALGORITHMS.

		// AFTER THE BOTTOM-UP PROOF PROCEDURE THE LIST IS [d, e, b, c, a]

	}

	public static void main(String[] args) {
		// In Propositional Definite Clause Logic, a Knowledge Base (KB)
		// is just a set of Definite Clauses. A Definite Clause is an Atom or
		// a Rule.
		// To make our code simpler, we will treat all Atoms in our KB as Rules
		// with
		// empty bodies. Thus, our KB is just a list of Rules.
		List<Rule> KB = new ArrayList<Rule>();

		// Some Atoms we can talk about.
		Atom a = new Atom("a");
		Atom b = new Atom("b");
		Atom c = new Atom("c");
		Atom d = new Atom("d");
		Atom e = new Atom("e");
		Atom f = new Atom("f");
		Atom g = new Atom("g");

		// We tell the KB some things.
		// aka "axiomatizing the domain."
		// These can be Atoms (statements about things that are true),
		// or Rules.

		// When we add Atoms to our KB, we can think of them
		// as being like Rules with empty bodies.
		KB.add(new Rule(d, new Atom[] {}));
		KB.add(new Rule(e, new Atom[] {}));
		// We could have simply added Atoms like below,
		// but it simplifies our code to have all of our
		// definite clauses be Rules:
		// KB.add(d);
		// KB.add(e);

		// Adding some Rules to our KB.
		// A Rule is composed of an Atom as its head,
		// and a list of Atoms as its body.
		// e.g. the first rules say a <- b & c
		KB.add(new Rule(a, new Atom[] { b, c }));
		KB.add(new Rule(b, new Atom[] { d, e }));
		KB.add(new Rule(b, new Atom[] { g, e }));
		KB.add(new Rule(c, new Atom[] { e }));
		KB.add(new Rule(f, new Atom[] { a, g }));

		// YOU NEED TO IMPLEMENT THE bottomUpDeduction() METHOD
		// THAT WE CALL HERE.
		List<Atom> derived = bottomUpDeduction(KB);

		/*
		 * After the bottom-up procedure terminates, the derived list should
		 * contain all of the Atoms that are entailed (and thus derived) by the
		 * KB. In this case, [a, b, c, d, e]. (The order doesn't matter.)
		 */

		System.out.println(derived);
	}

}
