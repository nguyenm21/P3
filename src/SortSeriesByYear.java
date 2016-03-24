import java.util.Comparator;

/**
 * Project #2 CS 2334, Section 010 Feb 25, 2016
 * <P>
 * This class is a comparator for Series to compare by the release year of the
 * series.
 * </P>
 * 
 * @author Adrian Phillips, Michael Nguyen, and Jacob Huckabaa
 * @version 1.0
 */

public class SortSeriesByYear implements Comparator<Series>{
	
	/**
	 * A compare method that compares a series with another given series.
	 * 
	 * @param  series1 The series being compared.
	 * @param  series2 The series to be compared to.
	 * @return  the value once compared.
	 */
	@Override
	public int compare(Series series1, Series series2) {
		int yearDifference = series1.getSeriesYear().compareTo(series2.getSeriesYear());
		if(yearDifference != 0){
			return yearDifference;
		}
		return 0;
	}

}