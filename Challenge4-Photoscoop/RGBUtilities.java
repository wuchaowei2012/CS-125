//UIUC CS125 SPRING 2016 MP. File: RGBUtilities.java, CS125 Project: Challenge4-Photoscoop, Version: 2016-02-22T08:07:56-0600.345149194
/* Manipulates RGB values
 * 
 * Todo: Put your netid (i.e. username) in the line below
 * 
 * @author fred wu
 */

public class RGBUtilities {

	/**
	 * Extracts the red component (0..255) Hint: see ch13.1.2 Working With
	 * Pixels http://math.hws.edu/javanotes/c13/s1.html#GUI2.1.2
	 * 
	 * ... also see the notes in READ-ME-FIRST
	 * 
	 * This is where base-16 'hexadecimal' 0,1,2,..9,A,B,C,D,E,F) becomes useful
	 * to describe different colors because each hex digit describes 4 bits of
	 * information. So two digits are required to get values from 0..255: . 00 ,
	 * 01, 02, 0F,10 ...F0, F1... FF (=255 in decimal). This means we can read
	 * the red,green,blue color components directly from it's hexadecimal
	 * format. For example, C044FF means red=C0 (192 out of 255), green=44 (68
	 * out of 255) and blue=FF (255 out of 255). So this color would be mostly
	 * blue, with some red and a small amount of green.
	 * 
	 * In Java, to tell the compiler that we want speak in hexadecimal we
	 * preface the number with 0x e.g. 0x10 is 16 in decimal. 0x1000 is 256 * 16
	 * in decimal 0x100000 is 256 * 256 * 16 in decimal
	 * 
	 * Here's some examples to show how writing a number in hexadecimal makes it
	 * easy to read- the red, green and blue component values: e.g. 0x--ffffff
	 * implies red,green and blue are all at the maximum of 255 out of 255;
	 * completely white e.g. 0x--ffff00 implies red,green are strongly on but
	 * without any blue; bright yellow e.g. 0x--808080 implies red,green and
	 * blue components are all half on; gray. e.g. 0x--000000 implies red,green
	 * and blue are all off; black!
	 * 
	 * @param rgb
	 *            the encoded color int
	 * @return the red component (0..255)
	 */

	/*
	 * 
	 * The fix is to use bit operators: If we only want the lowest eight bits
	 * (-blue) use "& 255' to 'MASK' out the other unwanted bits. If we want the
	 * green component, we need to shift the next eight bits to the right and
	 * then apply the same Mask trick. (look up <<)
	 * 
	 */
	public static int toRed(int rgb) {

		return (rgb >> 16) & 0xff; // FIX ME
	}

	public static int toGreen(int rgb) {
		return (rgb >> 8) & 0xff; // FIX THIS
	}

	public static int toBlue(int rgb) {
		return rgb & 0xff;
	}

	public static int toAlpha(int rgb) {
		return (rgb >> 24) & 0xff;
	}

	/**
	 * 
	 * @param r
	 *            the red component (0..255)
	 * @param g
	 *            the green component (0..255)
	 * @param b
	 *            the blue component (0..255)
	 * @return a single integer representation the rgb color (8 bits per
	 *         component) rrggbb
	 */
	static int toRGB(int r, int g, int b) {

		return r << 16 | g << 8 | b; // FIX THIS
	}

	static int toRGB(int alpha, int r, int g, int b) {

		return alpha << 24 | r << 16 | g << 8 | b; // FIX THIS
	}

}
