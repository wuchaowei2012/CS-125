//UIUC CS125 SPRING 2016 MP. File: Person.java, CS125 Project: Challenge6-RecursionSee, Version: 2016-03-27T20:05:53-0500.183041871
/**
 * @author ywang443
 *
 */
public class Person
{
private final String name;
private final int age;
private final char gender;
private final Person child1; //left child
private final Person child2; //right child

public Person(String name, int age, char gender, Person c1, Person c2)
{
    this.name=name;
    this.age=age;
    this.gender=gender;
    this.child1 = c1;
    this.child2 = c2;
}

public String toString()
{
    return name+"*"+age+"*"+gender;
}

public String getName() 
{
	return name;
}

public int getAge() 
{
	return age;
}

public char getGender() 
{
	return gender;
}

public boolean equals(Person p)
{
	return (this.name.equals(p.name)) &&
			(this.age==p.age) &&
			(this.gender==p.gender);
}


public void print() 
{
   System.out.println(this);
   if(child1 != null)
       child1.print();
   if(child2 != null)
       child2.print();
   
}

public int count() // total person count including this object
{
	//YOUR CODE HERE
	int count = 1;
	if (child1 != null) count += child1.count();
	if (child2 != null) count += child2.count();
	return count;
}
public int countGrandChildren() // but not greatGrandChildren
{
	//YOUR CODE HERE
	return countGrandChildren(2);
}

public int countGrandChildren(int i){
	int count = 0;
	if (i == 0) return 1;
	if (i > 0) {
		if (child1 != null) count += child1.countGrandChildren(i-1);
		if (child2 != null) count += child2.countGrandChildren(i-1);
	}
	return count;
}
public int countMaxGenerations()
{
	//YOUR CODE HERE
	int p = 1;
	if (child1 != null) p = Math.max(child1.countMaxGenerations() + 1, p);
	if (child2 != null) p = Math.max(child2.countMaxGenerations() + 1, p);
	return p;
}

public int countGender(char gen)
{
	//YOUR CODE HERE
	int count = 0;
	if (gender == gen) count++;
	if (child1 != null) {
		count += child1.countGender(gen);
	} 
	if (child2 != null) {
		count += child2.countGender(gen);
	}
	return count;
}


public Person search(String name, int maxGeneration)
{
	Person a = null;
	Person b = null;
	if(this.name.equals(name))
			return this;
	if(maxGeneration==0 || (this.child1==null&&this.child2==null))
		return null;
	if(this.child1!=null)
		a= this.child1.search(name, maxGeneration-1);
	if(this.child2!=null)
		b= this.child2.search(name, maxGeneration-1);
	if(a!=null)
		return a;
	if(b!=null)
		return b;
	else return null;	
}

} // end of class
