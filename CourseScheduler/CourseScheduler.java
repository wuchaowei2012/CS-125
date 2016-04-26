/** * @author ywang443
 *
 */
public class CourseScheduler {
	// Get and Set methods are NOT necessary!
	private String depart;
	private int courseNum;
	private String desp;
	private int hour;
	private boolean requiredForMajor;
	private int credit;
	private char[] meets;
	CourseScheduler next;

	/** Constructs this link.
	 * @param word ; a single word (never null).
	 * @param next ; the next item in the chain (null, if there are no more items).
	 */
	public CourseScheduler(String depart, int courseNum, String desp, int hour, boolean requiredForMajor, int credit, char[] meets, CourseScheduler next) {
		this.depart = depart;
		this.courseNum = courseNum;
		this.desp = desp;
		this.hour = hour;
		this.requiredForMajor = requiredForMajor;
		this.credit = credit;
		this.meets = new char [5];
		for(int i = 0; i < meets.length; i++){
			if(meets[i] != 0)
				this.meets[i] = meets[i];
		}
		this.next = next;
	}

	public CourseScheduler(){
		this.next = null;
	}
	
	//check conflict
	public boolean confilcts(String depart, int courseNum, int hour, char[] meets){
		if (this != null) {
			//check if they register the same course
			if(this.depart.equals(depart) && this.courseNum == courseNum){
				TextIO.putln("You already registed the same course");
				return true;
			}
			if(this.hour == hour){
				for(int i = 0; i < meets.length; i++){
					if(this.meets[i] == meets[i]){
						TextIO.putln("Conflict with" + this.depart + this.courseNum);
						return true;
					}
				}
			}
			if (this.next != null) {
				return this.next.confilcts(depart, courseNum, hour, meets);
			}
		}
		return false;
	}

	// add course
	public CourseScheduler add(String depart, int courseNum, String desp, int hour, boolean requiredForMajor, int credit, char[] meets) {
			if (depart.charAt(0) <= this.depart.charAt(0)){
				return new CourseScheduler(depart, courseNum, desp, hour, requiredForMajor, credit, meets, this);
			}
			if (next == null) {
				this.next = new CourseScheduler(depart, courseNum, desp, hour, requiredForMajor, credit, meets, null);
				return this;
			}
			this.next = next.add(depart, courseNum, desp, hour, requiredForMajor, credit, meets);
			return this;
	}

	public void displayAlpha(){
		TextIO.putln(this.depart + " " + this.courseNum);
		if(this.next == null)
			return;
		this.next.displayAlpha();
	}

}