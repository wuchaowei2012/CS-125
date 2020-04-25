/**
 * @author fred-wu
 *
 */
//UIUC CS125 SPRING 2016 MP. File: Person.java, CS125 Project: Challenge6-RecursionSee, Version: 2016-03-27T20:05:53-0500.183041871

public class Person {
	private final String name;
	private final int age;
	private final char gender;
	private final Person child1; // left child
	private final Person child2; // right child

	public Person(String name, int age, char gender, Person c1, Person c2) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.child1 = c1;
		this.child2 = c2;
	}

	public String toString() {
		return name + "*" + age + "*" + gender;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public char getGender() {
		return gender;
	}

	public boolean equals(Person p) {
		return (this.name.equals(p.name)) && (this.age == p.age) && (this.gender == p.gender);
	}

	public void print() {
		System.out.println(this);
		if (child1 != null)
			child1.print();
		if (child2 != null)
			child2.print();

	}

	public int count() // total person count including this object
	{
		// YOUR CODE HERE
		if (this.child1 == null && this.child2 == null) {
			return 1;
		} else {
			int leftct = 0;
			if (this.child1 != null)
				leftct = this.child1.count();

			int rightct = 0;
			if (this.child2 != null)
				rightct = this.child2.count();

			return 1 + leftct + rightct;
		}
	}

	public int countSon() {

		int sons = 0;
		if (this == null) {
			return sons;
		}
		if (this.child1 != null)
			sons++;
		if (this.child2 != null)
			sons++;

		return sons;

	}

	public int countGrandChildren() // but not greatGrandChildren
	{
		// YOUR CODE HERE
		if (this.countMaxGenerations() < 3)
			return 0;

		return this.child1.countSon() + this.child2.countSon();

	}

	public int countMaxGenerations() {
		// YOUR CODE HERE
		if (this.child1 == null && this.child2 == null) {
			return 1;
		}
		int child1 = 0;
		if (this.child1 != null)
			child1 = this.child1.countMaxGenerations();

		int child2 = 0;
		if (this.child2 != null)
			child2 = this.child2.countMaxGenerations();

		return 1 + max(child1, child2);
	}

	public static int max(int countMaxGenerations, int countMaxGenerations2) {
		if (countMaxGenerations < countMaxGenerations2)
			return countMaxGenerations2;
		else
			return countMaxGenerations;
	}

	public int countGender(char gen) {
		// YOUR CODE HERE

		if (this.child1 == null && this.child2 == null) {
			if (this.getGender() == gen) {
				return 1;
			}
			return 0;
		} else {
			int leftct = 0;
			if (this.child1 != null)
				leftct = this.child1.countGender(gen);

			int rightct = 0;
			if (this.child2 != null)
				rightct = this.child2.countGender(gen);

			int curr = 0;
			if (this.getGender() == gen) {
				curr = 1;
			}

			return curr + leftct + rightct;
		}

	}

	public Person search(String name, int maxGeneration) {
		// YOUR CODE HERE
		if(maxGeneration == 0)
			return null;
		if(maxGeneration == 1){
			if(this.getName().equals(name))
				return this;
			else
				return null;
		}
		
		if(this.getName().equals(name))
			return this;
		else{
			Person left=null,right=null;
			if (this.child1 != null)
				left = this.child1.search(name, maxGeneration - 1);
			if(this.child2 != null)
				right = this.child2.search(name, maxGeneration - 1);
			
			if (left != null)
				return left;
			if(right != null)
				return right;
			return null;
		}
	}

} // end of class
