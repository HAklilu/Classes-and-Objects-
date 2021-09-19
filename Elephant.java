package a1;

/**
 * NetId: bas358, ha292. Time spent: 4 hours, 25 minutes. <br>
 * What I thought about this assignment: We thought it was a good introductory
 * assignment as it got us familiar with Eclipse and the different methods in
 * Java. <br>
 * An instance maintains info about tan Elephant.
 */

public class Elephant {
	/** Name given to this Elephant, a String of length > 0. */
	private String nickName;

	/** Birth year of Elephant, int must be >= 2000 */
	private int birthYear;

	/** month this elephant was born. In 1..12, with 1 meaning January, etc. */
	private int birthMonth;

	/** Gender of Elephant 'F' means female and 'M' means male. */
	private char gen;

	/** Mother of this elephant—null if unknown */
	private Elephant mother;

	/** Mother of this elephant—null if unknown */
	private Elephant father;

	/** Number of known children of this Elephant */
	private int numChildren;

	/**
	 * Constructor: an instance with nickname n, gender g, birth year y, and birth
	 * month m. Its parents are unknown, and it has no children. <br>
	 * Precondition: n has at least 1 character, y >= 2000, m is in 1..12, and g is
	 * 'F' for female or 'M' for male.
	 */
	public Elephant(String n, char g, int y, int m) {
		assert n.length() > 0;
		assert g == 'M' || g == 'F';
		assert y >= 2000;
		assert m >= 1 && m <= 12;

		nickName = n;
		gen = g;
		birthYear = y;
		birthMonth = m;
		mother = null;
		father = null;
		numChildren = 0;
	}

	/**
	 * Constructor: an elephant with nickname n, gender g, birth year y, birth month
	 * m, mother ma, and father pa. <br>
	 * Precondition: n has at least 1 character, y >= 2000, g is 'F' for female or
	 * 'M' for male, m is in 1..12, ma is a female, and pa is a male.
	 */
	public Elephant(String n, char g, int y, int m, Elephant ma, Elephant pa) {
		this(n, g, y, m);
		assert ma != null;
		assert pa != null;
		this.addMom(ma);
		this.addDad(pa);
	}

	/**
	 * This elephant's nickname
	 */
	public String name() {
		return nickName;
	}

	/**
	 * the value of "this elephant is a female"
	 */
	public boolean isFemale() {
		return gen == 'F';
	}

	/**
	 * the date of birth of this elephant. In the form "month/year", with no blanks,
	 * e.g. "6/2007"
	 */
	public String date() {
		return Integer.toString(birthMonth) + "/" + Integer.toString(birthYear);
	}

	/**
	 * this elephant's mother (null if unknown)
	 */
	public Elephant mom() {
		return mother;
	}

	/**
	 * this elephant's father (null if unknown)
	 */
	public Elephant dad() {
		return father;
	}

	/**
	 * the number of children of this elephant
	 */
	public int children() {
		return numChildren;
	}

	/**
	 * Add e as this elephant's mother. Precondition: this elephant’s mother is
	 * unknown and e is female.
	 */
	public void addMom(Elephant e) {
		assert this.mother == null && e.isFemale();
		this.mother = e;
		e.numChildren++;
	}

	/**
	 * Add e as this elephant's father. Precondition: This elephant's father is
	 * unknown and e is male.
	 */
	public void addDad(Elephant e) {
		assert this.father == null && !e.isFemale();
		this.father = e;
		e.numChildren++;
	}

	/**
	 * Return value of "this elephant is older than e." <br>
	 * Precondition: e is not null.
	 */
	public boolean isOlder(Elephant e) {
		assert e != null;
		return this.birthYear < e.birthYear || (this.birthYear == e.birthYear && this.birthMonth < e.birthMonth);
	}

	/**
	 * Return value of "this elephant and e are siblings." (note: if e is null they
	 * can't be siblings, so false is returned).
	 */
	public boolean areSibs(Elephant e) {
		assert this != e;
		return e != null
				&& ((this.mom() != null && this.mother == e.mother) || (this.dad() != null && this.father == e.father));
	}

}
