import java.util.Comparator;

/**
 * Project #2 CS 2334, Section 010 Feb 25, 2016
 * <P>
 * This class is a comparator for Movie to compare by the release year of the
 * movie.
 * </P>
 * 
 * @author Adrian Phillips, Michael Nguyen, and Jacob Huckabaa
 * @version 1.0
 */

public class SortMovieByYear implements Comparator<Movie> {
	
	/**
	 * A compare method that compares an movie with another given movie.
	 * 
	 * @param movie1 The movie being compared.
	 * @param movie2 The movie to be compared to.
	 * @return the value once compared.
	 */
	@Override
	public int compare(Movie movie1, Movie movie2) {
		int yearDifference = movie1.getReleaseYear().compareTo(movie2.getReleaseYear());
		if (yearDifference != 0) {
			return yearDifference;
		}
		return 0;
	}

}
