public class TwoB {

	/**
	 * Compute the average of two integers. Rounds toward zero if the average is
	 * not a whole number.
	 * Proconditions: left and right are ints of size up to MAX_VALUE / 10
	 */
	public static int average(int left, int right) {
		int newright = (right * 10) / 2;
		int newleft = (left * 10) / 2;
		int av_num = newleft + newright;
		return av_num / 10;
	} // average(int,int)

} // class TwoB