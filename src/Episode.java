
/**
 * Project #2 CS 2334, Section 010 Feb 25, 2016
 * <P>
 * The Episode class stores the details of a specific episode inside of an
 * episode object.
 * </P>
 * 
 * @author Adrian Phillips, Michael Nguyen, and Jacob Huckabaa
 * @version 1.0
 */
public class Episode implements Comparable<Episode> {

	/** Stores the name of the series as a String. */
	private String seriesName;

	/** Stores the name of the episode as a String */
	private String episodeName;

	/** Stores the name of the year as a String. */
	private String seriesYear;

	/**
	 * Stores the year of the episode as a String. This is redundant if
	 * seriesYear is the same as releaseYear.
	 */
	private String releaseYear;

	/** Stores the number of the season as a String. */
	private String season;

	/** Stores the number of the episode as a String. */
	private String episode;

	/** Tells us whether or not the episode was complete. */
	private boolean suspended;

	/** Stores the full year of the series */
	private String fullYear;

	/** Default constructor for the episode class **/
	public Episode() {
		this.seriesName = "";
		this.episodeName = "";
		this.seriesYear = "";
		this.releaseYear = "";
		this.season = "";
		this.episode = "";
		this.suspended = false;
		this.fullYear = "";
	}

	/**
	 * 
	 * @return name of the series.
	 */
	public String getSeriesName() {

		return seriesName;
	}

	/**
	 * 
	 * @return name of the episode.
	 */
	public String getEpisodeName() {

		return episodeName;
	}

	/**
	 * 
	 * @return year of the series.
	 */
	public String getSeriesYear() {

		return seriesYear;
	}

	/**
	 * 
	 * @return year of the episode.
	 */
	public String getReleaseYear() {

		return releaseYear;
	}

	/**
	 * 
	 * @return season number of the episode.
	 */
	public String getSeason() {

		return season;
	}

	/**
	 * 
	 * @return episode number of the episode.
	 */
	public String getEpisode() {

		return episode;
	}

	/**
	 * 
	 * @return the beginning and end year of the episode EX: 1990-2001
	 */
	public String getFullYear() {

		return fullYear;
	}

	/**
	 * 
	 * @param seriesName Name of the series.
	 */
	public void setSeriesName(String seriesName) {

		this.seriesName = seriesName;
	}

	/**
	 * 
	 * @param episodeName Name of the episode.
	 */
	public void setEpisodeName(String episodeName) {

		this.episodeName = episodeName;
	}

	/**
	 * 
	 * @param seriesYear Year of the series.
	 */
	public void setSeriesYear(String seriesYear) {

		this.seriesYear = seriesYear;
	}

	/**
	 * 
	 * @param releaseYear Year of the episode.
	 */
	public void setReleaseYear(String releaseYear) {

		this.releaseYear = releaseYear;
	}

	/**
	 * 
	 * @param season Number of the season.
	 */
	public void setSeason(String season) {

		this.season = season;
	}

	/**
	 * 
	 * @param episode Number of the episode.
	 */
	public void setEpisode(String episode) {

		this.episode = episode;
	}

	/**
	 * 
	 * @param suspended If the episode was suspended.
	 */
	public void setSuspended(boolean suspended) {

		this.suspended = suspended;
	}

	/**
	 * 
	 * @param fullYear beginning and ending years of the series of the episode.
	 */
	public void setFullYear(String fullYear) {

		this.fullYear = fullYear;
	}

	public String toString() {

		/**
		 * If statement that returns a string if the series/episode is suspended
		 **/
		if (suspended) {
			if (this.episodeName == "" && this.season == "" && this.episode == "") {
				return this.seriesName + " (" + this.releaseYear + ")" + " SUSPENDED";
			}
			if (this.season == "" && this.episode == "" && !(this.episodeName == "")) {
				return this.seriesName + ": " + this.episodeName + " (" + this.releaseYear + ")" + " SUSPENDED";
			}
			if (this.episodeName == "" && !(this.season == "") && !(this.episode == "")) {
				return this.seriesName + ": " + this.episodeName + " (" + this.releaseYear + ")" + " SUSPENDED";
			}
			return this.seriesName + ": " + this.episodeName + " (" + this.releaseYear + ")" + " SUSPENDED";
		}
		/** else condition to the above if statement **/
		else {
			if (this.episodeName == "" && this.season == "" && this.episode == "") {
				return this.seriesName + " (" + this.releaseYear + ")";
			}
			if (this.season == "" && this.episode == "" && !(this.episodeName == "")) {
				return this.seriesName + ": " + this.episodeName + " (" + this.releaseYear + ")";
			}
			if (this.episodeName == "" && !(this.season == "") && !(this.episode == "")) {
				return this.seriesName + ": " + this.episodeName + " (" + this.releaseYear + ")";
			}
			return this.seriesName + ": " + this.episodeName + " (" + this.releaseYear + ")";
		}
	}

	/**
	 * 
	 * Prints the details of the episode.
	 */
	public void printEpisodeDetails() {
		System.out.println("Name: " + seriesName);
		System.out.println("Release Year: " + releaseYear);
		System.out.println("Season: " + season);
		System.out.println("Episode: " + episode);
	}

	/**
	 * 
	 * Sorts the episode by series title, by episode title, by season number,
	 * and by episode number in that order.
	 * 
	 * @param episode Episode object to be compared.
	 * @return the difference between episodes.
	 */
	@Override
	public int compareTo(Episode episode) {
		int titleDifference = this.seriesName.compareTo(episode.getSeriesName());
		if (titleDifference == 0) {
			int episodeTitleDifference = this.episodeName.compareTo(episode.getEpisodeName());
			if (episodeTitleDifference == 0) {
				int seasonDifference = this.season.compareTo(episode.getSeason());
				if (seasonDifference == 0) {
					int episodeDifference = this.episode.compareTo(episode.getEpisode());
					if (episodeDifference == 0) {
						return 0;
					} else {
						return episodeDifference;
					}
				} else {
					return seasonDifference;
				}
			} else {
				return episodeTitleDifference;
			}
		} else {
			return titleDifference;
		}
	}
}
