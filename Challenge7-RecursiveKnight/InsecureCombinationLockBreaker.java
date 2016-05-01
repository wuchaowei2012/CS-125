//UIUC CS125 SPRING 2016 MP. File: InsecureCombinationLockBreaker.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2016-04-18T08:00:20-0500.644631539
public class InsecureCombinationLockBreaker {

	public static int breakLock(InsecureCombinationLock lock) {
		int key =0;
		int temp = 1;
		String s = "Success!";
		while (temp <= 10000000) {
			int[] value = new int[10];        
			int k = key;
			int countOdd = 0;    // count the number of odd result
			int countEven = 0;    // count the number of even result
			int index = 0;     // store the correct integer
			for (int i = 0; i < 10; i++) {
				String result = lock.open(k);
				if (result.equals(s))  
					break;                  

				if (result.charAt(0) == '*') {           // result = even
					countEven++;               
					value[i] = 2;           
				} else {
					countOdd++;
					value[i] = 1;            
				}
				k = k + temp;                
			}
			if (countEven == 1 && countOdd == 9) {        
				for (int i = 0; i < 10; i++) {
					if (value[i] == 2) {             
						index = i;
					}
				}
			}
			if (countOdd == 1 && countEven == 9) {         
				for (int i = 0; i < 10; i++) {    
					if (value[i] == 1) {              
						index = i;
					}
				}
			}
			if (!lock.open(key).equals(s)) {     
				key = key + index * temp;                 
				temp = temp * 10;                         
			}
		}
		if (!lock.open(key).equals(s)) {       
			key = key + 100000000;                      // change key to 9 digits

		}
		lock.open(key).equals(s);              // call to change isUnlocked
		return key;
	}

	public static void main(String[] args) {
			InsecureCombinationLock lock = new InsecureCombinationLock();
			int code = breakLock(lock);
			
			System.out.println("Unlock code:"+code);
			System.out.println(lock.isUnlocked() ? "Unlocked :-)" : "Still Locked :-(");
	}
}
