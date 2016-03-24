import java.util.Comparator;

/**
 * Project #2 CS 2334, Section 010 Feb 25, 2016
 * <P>
 * This class is a comparator for Episode to compare by the release year of the
 * episode.
 * </P>
 * 
 * @author Adrian Phillips, Michael Nguyen, and Jacob Huckabaa
 * @version 1.0
 */

public class SortEpisodeByYear implements Comparator<Episode> {

	/**
	 * A compare method that compares an episode with another given episode.
	 * 
	 * @param episode1 The episode being compared.
	 * @param episode2 The episode to be compared to.
	 * @return the value once compared.
	 */
	@Override
	public int compare(Episode episode1, Episode episode2) {
		int yearDifference = episode1.getReleaseYear().compareTo(episode2.getReleaseYear());
		if (yearDifference != 0) {
			return yearDifference;
		}
		return 0;
	}

}
