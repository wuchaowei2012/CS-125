import java.util.Collections;

//UIUC CS125 SPRING 2016 MP. File: PixelEffects.java, CS125 Project: Challenge4-Photoscoop, Version: 2016-02-22T08:07:56-0600.345149194

/* A class to implement the various pixel effects.
 *
 * Todo: Put your netid (i.e. username) in the line below
 * 
 * @author fred wu
 */
public class PixelEffects {

	/** Copies the source image to a new 2D integer image */
	public static int[][] copy(int[][] source) {
		// Create a NEW 2D integer array and copy the colors across
		// See redeye code below
		int width = source.length;
		int height = source[0].length;
		int[][] copy = new int[width][height];

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				copy[i][j] = source[i][j];
			}
		}
		return copy; // Fix Me
	}

	/**
	 * Resize the array image to the new width and height You are going to need
	 * to figure out how to map between a pixel in the destination image to a
	 * pixel in the source image
	 * 
	 * @param source
	 * @param newWidth
	 * @param newHeight
	 * @return
	 */
	public static int[][] resize(int[][] source, int newWidth, int newHeight) {
		// Hints: Use two nested for loops between 0... newWidth-1 and 0..
		// newHeight-1 inclusive.
		// Hint: You can just use relative proportion to calculate the x (or y
		// coordinate) in the original image.
		// For example if you're setting a pixel halfway across the image, you
		// should be reading half way across the original image too.
		int[][] copy = new int[newWidth][newHeight];
		int width = source.length;
		int height = source[0].length;

		for (int i = 0; i < newWidth; i++) {
			for (int j = 0; j < newHeight; j++) {
				// System.out.println((int)(i * 1.0 / newWidth * width));
				copy[i][j] = source[(int) (i * 1.0 / newWidth * width)][(int) (1.0 * j / newHeight * height)];
			}
		}
		return copy; // Fix Me
	}

	/**
	 * Half the size of the image. This method should be just one line! Just
	 * delegate the work to resize()!
	 */
	public static int[][] half(int[][] source) {
		return resize(source, source.length / 2, source[0].length / 2); // Fix
																		// Me
	}

	/**
	 * Create a new image array that is the same dimensions of the reference
	 * array. The array may be larger or smaller than the source. Hint - this
	 * methods should be just one line - delegate the work to resize()!
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
		// return null;// Fix Me
		int[][] sourceC = copy(source);
		int width = sourceC.length;
		int height = sourceC[0].length;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height / 2; j++) {
				int tmpRow = sourceC[i][j];
				sourceC[i][j] = sourceC[i][height - 1 - j];
				sourceC[i][height - 1 - j] = tmpRow;
			}
		}

		return sourceC; // Fix Me
	}

	/** Reverse the image horizontally */
	public static int[][] mirror(int[][] source) {
		int width = source.length;
		int height = source[0].length;
		int[][] sourceC = copy(source);

		for (int i = 0; i < width / 2; i++) {
			for (int j = 0; j < height; j++) {
				int tmpRow = sourceC[i][j];
				sourceC[i][j] = sourceC[width - 1 - i][j];
				sourceC[width - 1 - i][j] = tmpRow;
			}
		}

		return sourceC; // Fix Me
	}

	/** Rotate the image */
	public static int[][] rotateLeft(int[][] source) {
		int width = source.length; // 3,
		int height = source[0].length; // 4

		// { { 20, 10, 0 }, { 21, 11, 1 }, { 22, 12, 2 },{ 23, 13, 3 } }; //
		// expected
		// { { 0, 1, 2, 3 }, { 10, 11, 12, 13 }, { 20, 21, 22, 23 } }; source

		int[][] sourceC = new int[height][width];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				sourceC[i][j] = source[width - 1 - j][i]; // height -1 = 3
			}
		}

		return sourceC;
	}

	/** Merge the red,blue,green components from two images */
	public static int[][] merge(int[][] sourceA, int[][] sourceB) {
		// The output should be the same size as the input. Scale (x,y) values
		// when reading the background
		// (e.g. so the far right pixel of the source is merged with the
		// far-right pixel of the background).
		int width = sourceA.length;
		int height = sourceA[0].length;

		int[][] sourceAC = copy(sourceA);

		int[][] sourceC = resize(sourceB, width, height);

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int rgb = sourceA[i][j];
				int red = RGBUtilities.toRed(rgb);
				int green = RGBUtilities.toGreen(rgb);
				int blue = RGBUtilities.toBlue(rgb);
				int alpha = RGBUtilities.toAlpha(rgb);

				int rgbC = sourceC[i][j];
				int redC = RGBUtilities.toRed(rgbC);
				int greenC = RGBUtilities.toGreen(rgbC);
				int blueC = RGBUtilities.toBlue(rgbC);
				int alphaC = RGBUtilities.toAlpha(rgbC);

				sourceAC[i][j] = RGBUtilities.toRGB((alpha + alphaC) / 2, (red + redC) / 2, (green + greenC) / 2,
						(blue + blueC) / 2);

			}
		}

		return sourceAC;
	}

	/**
	 * Replace the green areas of the foreground image with parts of the back
	 * image
	 */
	public static int[][] chromaKey(int[][] foreImage, int[][] backImage) {
		// If the image has a different size than the background use the
		// resize() method
		// create an image the same as the background size.
		
		/*
		 * Re. Chroma Key - 
			To pass the unit tests you just need to choose the background pixel whenever the source pixel is green.
			However I suggest you experiment with the test images to find a good way to differentiate between green background and non-green in all of the test images.
			Here's some ideas you might want to try - but feel free to improve on them /invent your own.
			
			green > 100 and blue <100
			green > max(blue,red)
			green > (blue+red)
			green > blue 
		 */
		int width = backImage.length, height = backImage[0].length;
		int[][]foreImageC = copy(foreImage);
		foreImageC = resize(foreImageC, width, height);
		
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++) {
				int rgb = foreImageC[i][j];
				int red = RGBUtilities.toRed(rgb);
				int green = RGBUtilities.toGreen(rgb);
				int blue = RGBUtilities.toBlue(rgb);
				if (green > 0)
					foreImageC[i][j] = backImage[i][j];
			}
		
		
		return foreImageC;
	}

	/** Removes "redeye" caused by a camera flash. sourceB is not used */
	public static int[][] redeye(int[][] source, int[][] sourceB) {

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
		
		return chromaKey(redeye(source, sourceB), sourceB);
	}
}
