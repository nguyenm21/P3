/**
 * Project #2 CS 2334, Section 010 Feb 25, 2016
 * <P>
 * The Movie class stores the details of a specific movie inside of a Movie
 * object.
 * </P>
 * 
 * @author Adrian Phillips, Michael Nguyen, and Jacob Huckabaa
 * @version 1.0
 */
public class Movie implements Comparable<Movie> {

	/** Stores the name of the movie as a String. */
	private String name;

	/**
	 * Stores the year of the movie as a String. This is the marked version if
	 * applicable.
	 */
	private String year;

	/**
	 * Stores the second instance of the year of the movie as a String. This is
	 * redundant if year is the same as releaseYear.
	 */
	private String releaseYear;

	/** Stores the version of the movie as a String. */
	private String version;
	
	/** Stores the relation information of an actor, director, or producer as a String. */
	private String relation;
	
	/**
	 * Default constructor for the Movie class
	 */
	public Movie() {
		this.version = "";
		this.year = "";
		this.name = "";
		this.releaseYear = "";
		this.relation = "";
	}

	/**
	 *Method gets the name/title of the movie
	 * 
	 * @return name of the movie.
	 */
	public String getName() {
		return name;

	}

	/**
	 * Method gets the year of the movie
	 * 
	 * @return year (and duplicate number if applicable) of the movie.
	 */
	public String getYear() {
		return year;

	}

	/**
	 * Method returns the release year of a movie
	 * 
	 * @return year of the movie.
	 */
	public String getReleaseYear() {
		return releaseYear;

	}

	/**
	 * Method gets the release form/version of the movie
	 * 
	 * @return version of the movie.
	 */
	public String getVersion() {
		return version;

	}

	/**
	 * 
	 * @param   name    Name of the movie.
	 */
	public void setName(String name) {
		this.name = name;

	}

	/**
	 * 
	 * @param   year   Year of the movie (with duplicate number if applicable).
	 */
	public void setYear(String year) {
		this.year = year;

	}

	/**
	 * Method that sets the release year.
	 * 
	 * @param  releaseYear Year of the movie.
	 */
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;

	}

	/**
	 * Method that sets the version of the movie
	 * 
	 * @param   version   Version of the movie.
	 */
	public void setVersion(String version) {
		this.version = version;

	}

	/**
	 * Method that prints the details of the movie.
	 * 
	 * Prints the details of the movie.
	 */
	public void printMovieDetails() {
		System.out.println("Name: " + name);
		System.out.println("Year: " + releaseYear);
		System.out.println("Marked Year: " + year);
		if (version.equals("")) {
			System.out.println();
		} else {
			System.out.println("Version: " + version + "\n");
		}
	}

	/**
	 * Method that converts everything to String
	 * 
	 * @return the movie name and the year
	 */
	public String toString() {
		String string =  name + " " + "(" + releaseYear + ")";
		
		return string.replace("????", "UNSPECIFIED");
	}

	/**
	 * 
	 * Sorts the movie by name.
	 * 
	 * @param   movie     Movie object to be compared.
	 * 
	 * @return the difference between movies.
	 */
	@Override
	public int compareTo(Movie movie) {
		int nameDifference = this.name.compareTo(movie.getName());
		if (nameDifference != 0) {
			return nameDifference;
		}
		return 0;
	}
}
