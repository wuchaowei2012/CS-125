//UIUC CS125 SPRING 2016 MP. File: ExampleBits.java, CS125 Project: Challenge4-Photoscoop, Version: 2016-02-22T08:07:56-0600.345149194

public class ExampleBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=0;i<16;i++) {
			TextIO.putln(i+ " "+Integer.toHexString(i)+ " : "+Integer.toBinaryString(i));
		}
	}
}
