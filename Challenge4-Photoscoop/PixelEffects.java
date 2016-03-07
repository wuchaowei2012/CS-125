//UIUC CS125 SPRING 2016 MP. File: PixelEffects.java, CS125 Project: Challenge4-Photoscoop, Version: 2016-02-22T08:07:56-0600.345149194

/* A class to implement the various pixel effects.
 *
 * Todo: Put your netid (i.e. username) in the line below
 * 
 * @author ywang443
 */
public class PixelEffects {

	/** Copies the source image to a new 2D integer image */
	public static int[][] copy(int[][] source) {
		// Create a NEW 2D integer array and copy the colors across
		// See redeye code below
		int [][] ret = new int [source.length][source[0].length];
		for (int i = 0; i < source.length; i++){
			//ret = new int [source.length][source[i].length];
			for (int j = 0; j < source[i].length; j++){
				ret[i][j] = source[i][j];
			}
		}
		return ret; // Fix Me
	}
	/**
	 * Resize the array image to the new width and height
	 * You are going to need to figure out how to map between a pixel
	 * in the destination image to a pixel in the source image
	 * @param source
	 * @param newWidth
	 * @param newHeight
	 * @return
	 */
	public static int[][] resize(int[][] source, int newWidth, int newHeight) {
		int[][] ret = new int[newWidth][newHeight];		
		for(int i = 0; i < newWidth; i++) {
			for(int j = 0; j < newHeight; j++) {
				ret[i][j] = source[(int)(((double)i/(double)newWidth)*source.length)][(int)(((double)j/(double)newHeight)*source[0].length)];
			}
		}
		return ret;
		// Hints: Use two nested for loops between 0... newWidth-1 and 0.. newHeight-1 inclusive.
		// Hint: You can just use relative proportion to calculate the x (or y coordinate)  in the original image.
		// For example if you're setting a pixel halfway across the image, you should be reading half way across the original image too.
	}

	/**
	 * Half the size of the image. This method should be just one line! Just
	 * delegate the work to resize()!
	 */
	public static int[][] half(int[][] source) {
		return resize(source, source.length/2, source[0].length/2); // Fix Me
	}
	
	/**
	 * Create a new image array that is the same dimesions of the reference
	 * array. The array may be larger or smaller than the source. Hint -
	 * this methods should be just one line - delegate the work to resize()!
	 * 
	 * @param source
	 *            the source image
	 * @param reference
	 * @return the resized image
	 */
	public static int[][] resize(int[][] source, int[][] reference) {
		return resize(source, reference.length, reference[0].length); // Fix Me
	}

	/** Flip the image vertically */
	public static int[][] flip(int[][] source) {
		int ret [][] = new int[source.length][source[0].length];
		for (int i = 0; i < source.length; i++){
			for(int j = 0; j < source[0].length; j++){
				ret[i][j] = source[i][source[0].length - 1 - j];
			}	
		}
		return ret;// Fix Me
	}

	/** Reverse the image horizontally */
	public static int[][] mirror(int[][] source) {
		int ret [][] = new int[source.length][source[0].length];
		for (int i = 0; i < source.length; i++){
			for(int j = 0; j < source[0].length; j++){
				ret[i][j] = source[source.length - 1 - i][j];
			}	
		}
		return ret;// Fix Me
	}

	/** Rotate the image */
	public static int[][] rotateLeft(int[][] source) {
		int ret [][] = new int[source[0].length][source.length];
		for(int i = 0; i < source.length; i++){
			for (int j = 0; j < source[0].length; j++){
				ret[j][i] = source[i][j];
			}
		}
		ret = flip(ret);
		return ret;
	}

	/** Merge the red,blue,green components from two images */
	public static int[][] merge(int[][] sourceA, int[][] sourceB) {
		// The output should be the same size as the input. Scale (x,y) values
		// when reading the background
		// (e.g. so the far right pixel of the source is merged with the
		// far-right pixel of the background).
		int [][] bg = resize(sourceB, sourceA);
		int [][] ret = new int[sourceA.length][sourceA[0].length];
		for (int i = 0; i < sourceA.length; i++){
			for (int j = 0; j < sourceA[0].length; j++){
				int red = (RGBUtilities.toRed(sourceA[i][j]) + RGBUtilities.toRed(bg[i][j])) / 2;
				int green = (RGBUtilities.toGreen(sourceA[i][j]) + RGBUtilities.toGreen(bg[i][j])) / 2;
				int blue = (RGBUtilities.toBlue(sourceA[i][j]) + RGBUtilities.toBlue(bg[i][j])) / 2;
				ret[i][j] = RGBUtilities.toRGB(red, green, blue);
			}
		}
		return ret;
	}

	/**
	 * Replace the green areas of the foreground image with parts of the back
	 * image
	 */
	public static int[][] chromaKey(int[][] foreImage, int[][] backImage) {
		// If the image has a different size than the background use the
		// resize() method
		// create an image the same as the background size.
		int[][] ret = new int[backImage.length][backImage[0].length];
		int[][] bg = resize(foreImage,backImage);
		for(int i = 0; i < backImage.length; i++) {
			for(int j = 0; j < backImage[0].length; j++) {
				if (RGBUtilities.toGreen(foreImage[i][j]) > 50) 
					ret[i][j] = backImage[i][j];
				else 
					ret[i][j] = bg[i][j];
			}
		}
		return ret;
	}

	/** Removes "redeye" caused by a camera flash. sourceB is not used */
	public static int[][] redeye(int[][] source) {

		int width = source.length, height = source[0].length;
		int[][] result = new int[width][height];
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++) {
				int rgb = source[i][j];
				int red = RGBUtilities.toRed(rgb);
				int green = RGBUtilities.toGreen(rgb);
				int blue = RGBUtilities.toBlue(rgb);
				if (red > 4 * Math.max(green, blue) && red > 64)
					red = green = blue = 0;
				result[i][j] = RGBUtilities.toRGB(red, green, blue);
			}

		return result;
	}

	/* Upto you! do something fun to the image */
	public static int[][] funky(int[][] source, int[][] sourceB) {
		// You need to invent your own image effect
		// Minimum boring requirements to pass autograder:
		
		// Does not ask for any user input and returns a new 2D array
		// Todo: remove this return null
		int[][] ret = new int[source.length][source[0].length];
		for (int i = 0; i < source.length; i++){
			for (int j = 0; j < source[0].length; j++) {
				int red = 256 - RGBUtilities.toRed(source[i][j]);
				int green = 256 - RGBUtilities.toGreen(source[i][j]);
				int blue = 256 - RGBUtilities.toBlue(source[i][j]);
				ret[i][j] = RGBUtilities.toRGB(red, green, blue);
			}
		}
		return ret;
	}
}
