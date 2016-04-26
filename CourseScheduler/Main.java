public class Main{
	static CourseScheduler head = null;
	public static void main(String[] args) {
		int opt = 0;
		TextIO.putln("Welcome to the Course Scheduler! Select an option below:\n");
		do{
			printOpt();
			opt = TextIO.getlnInt();
			switch(opt){
				case 1:
					boolean success = addACourse();
					while(success == false){
						TextIO.putln("Add course failed, please try again.");
						success = addACourse();
					}
					TextIO.putln("Course added.");
					break;
				case 2:
					removeACourse();
					break;
				case 3:
					if (head == null)
						TextIO.putln("No course to display.");
					else
						head.displayAlpha();
					break;
				case 4:
					displayMajor();
					break;
				case 5:
					displayForDay();
					break;
				case 6:
					displayCreditHours();
					break;
				case 7:
					TextIO.putln("Thanks for using Course Scheduler!");
					System.exit(0);
					break;
				default:
					TextIO.putln("Invalid input, please try again.");
					break;
			}
		}while(opt != 7);
	}

	public static boolean addACourse(){
		TextIO.putln("Department? (e.g.: MATH, CS, ECE, etc)");
		String depart = TextIO.getln();
		TextIO.putln("Course number? (e.g.: 125, 173, 225, etc)");
		int courseNum = TextIO.getlnInt();
		TextIO.putln("Course description? (e.g.: Introduction to Computer Science, Linear Transformations and Matrices, etc)");
		String desp = TextIO.getln();
		TextIO.putln("Starting hour? (integer use 24-hour clock: 0-23)(e.g.: 9, 10, 13, etc)");
		int hour = TextIO.getlnInt();
		TextIO.putln("Is this course required for major? (e.g.:true, false, t, f, yes, no, y, n, 1, or 0.)");
		boolean requiredForMajor = TextIO.getlnBoolean();
		TextIO.putln("How many credit hours for this course? (e.g.: 1, 2, 3, etc)");
		int credit = TextIO.getlnInt();
		TextIO.putln("Days the course meets? (e.g.: M W F etc, please seperate characters by space)");
		String str = TextIO.getln();
		char [] meets = new char[str.length()];
		for (int i = 0; i < str.length(); i++){
			meets[i] = str.charAt(i);
		}
		boolean valid = checkInputs(depart, courseNum, desp, hour, requiredForMajor, credit, meets);
		if (valid == false) {
			return false;
		}
		if(head == null){
			head = new CourseScheduler(depart, courseNum, desp, hour, requiredForMajor, credit, meets, null);
			//TextIO.putln(head.next); = null
			return true;
		}
		else{
			boolean confilct = head.confilcts(depart, courseNum, hour, meets);
			if (confilct) {
				return false;
			}
			head = head.add(depart, courseNum, desp, hour, requiredForMajor, credit, meets);
		}
		return true;
	}

	public static void removeACourse(){
		if(head.next == null)
			TextIO.putln("There's no course to remove.");
		TextIO.putln("removeACourse");
	}

	public static void displayMajor(){
		TextIO.putln("displayMajor");
	}

	public static void displayForDay(){
		TextIO.putln("displayForDay");
	}

	public static void displayCreditHours(){
		TextIO.putln("displayCreditHours");
	}

	public static void printOpt(){
		TextIO.putln("1). add a course\n");
		TextIO.putln("2). remove a course\n");
		TextIO.putln("3). display courses alphabetically\n");
		TextIO.putln("4). display courses in major\n");
		TextIO.putln("5). display schedule for day\n");
		TextIO.putln("6). display total number of credit hours\n");
		TextIO.putln("7). quit");
	}
	
	public static boolean checkInputs(String depart, int courseNum, String desp, int hour, boolean requiredForMajor, int credit, char[] meets){
		if (depart.length() > 6){
			TextIO.putln("Invalid department.");
			return false;
		}
		if (String.valueOf(courseNum).length() > 3 || String.valueOf(courseNum).length() < 0) {
			TextIO.putln("Invalid course number.");
			return false;
		}
		if (hour < 0 || hour > 23) {
			TextIO.putln("Invalid starting hour.");
			return false;
		}
		if (credit < 0 || credit > 5){
			TextIO.putln("Invalid credit hours.");
			return false;
		}
		if (meets.length > 5) {
			TextIO.putln("Invalid meet dates");
			return false;
		}
		return true;
	}
}
