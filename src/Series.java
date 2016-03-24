import java.util.ArrayList;

/**
 * Project #2 CS 2334, Section 010 Feb 25, 2016
 * <P>
 * The Series class stores a list of a episodes with the same series name inside
 * of a Series object.
 * </P>
 * 
 * @author Adrian Phillips, Michael Nguyen, and Jacob Huckabaa
 * @version 1.0
 */
public class Series implements Comparable<Series> {

	/** Stores a list of episodes of the same series in an ArrayList */
	private ArrayList<Episode> episodeList;

	/** Stores the name of the series as a String. */
	private String seriesName;

	/** Stores the year of the series as a String. */
	private String seriesYear;

	/** Stores the full year of the series as a String. */
	private String fullYear;

	/** Stores the relation information of an actor, director, or producer as a String. */
	private String relation;
	
	/**
	 * Constructor for the series class
	 * 
	 * @param seriesName The String name of the series.
	 * @param episodeList The ArrayList of the episodes within the series.
	 * @param seriesYear The initial release of the series in String format.
	 * @param fullYear The complete span of the series in String format.
	 * 
	 */
	public Series(String seriesName, ArrayList<Episode> episodeList, String seriesYear, String fullYear) {
		this.seriesName = seriesName;
		this.episodeList = episodeList;
		this.seriesYear = seriesYear;
		this.fullYear = fullYear;
		this.relation = "";
	}

	/**
	 * Method that gets the episode list.
	 * 
	 * @return list of episodes.
	 */
	public ArrayList<Episode> getEpisodeList() {

		return this.episodeList;
	}

	/**
	 * Method that gets the name of the series.
	 * 
	 * @return name of the series.
	 */
	public String getSeriesName() {

		return this.seriesName;
	}

	/**
	 * Method that gets the year the series was made.
	 * 
	 * @return year of the series.
	 */
	public String getSeriesYear() {

		return this.seriesYear;
	}

	/**
	 * Converts the description into a readable string.
	 * 
	 * @return the series name and the start year and end year of the series.
	 */
	public String toString() {

		return this.seriesName + " (" + this.fullYear + ")";
	}

	@Override
	/**
	 * A compareTo method that compares the series object to a given series.
	 * 
	 * @param series The series abject to be compared.
	 * 
	 * @return the difference between the first series name and the second
	 *         series name
	 */
	public int compareTo(Series series) {
		int nameDifference = this.seriesName.compareTo(series.getSeriesName());
		if (nameDifference != 0) {
			return nameDifference;
		}
		return 0;
	}

}
