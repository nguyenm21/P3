import java.util.ArrayList;

/**
 * Project #3 CS 2334, Section 010 Mar 5, 2016
 * <P>
 * The MediaMaker class stores the details of a specific media maker inside of an MediaMaker
 * object.
 * </P>
 * 
 * @author Adrian Phillips
 * @version 1.0
 */
public class MediaMaker implements Comparable<MediaMaker> {

	/** Stores the name of the MediaMaker as a String. */
	private String name;
	
	/* Tells us whether or not the media maker is an actor */
	private boolean isActor = false;
	
	/* Tells us whether or not the media maker is a director */
	private boolean isDirector = false;
	
	/* Tells us whether or not the media maker is a producer */
	private boolean isProducer = false;
	
	/** Stores movie credit information in an ArrayList */
	private ArrayList<Movie> movieList = new ArrayList<Movie>();
	
	/** Stores series credit information in an ArrayList */
	private ArrayList<Series> seriesList = new ArrayList<Series>();


	
	/**
	 * Default constructor for the MediaMaker class
	 * 
	 * @param makerType Tells us what kind of media maker
	 */
	public MediaMaker(String makerType) {
		this.name = "";
		if (makerType.equals("isActor")){
			this.isActor = true;
		}
		if (makerType.equals("isDirector")){
			this.isDirector = true;
		}
		if (makerType.equals("isProducer")){
			this.isProducer = true;
		}
	}

	/**
	 *Method gets the name of the mediaMaker
	 * 
	 * @return name of the media maker.
	 */
	public String getName() {
		return name;

	}
	
	public ArrayList<Movie> getMovieList(){
		return movieList;
	}
	
	public ArrayList<Series> getSeriesList(){
		return seriesList;
	}


	/**
	 * 
	 * @param   name    Name of the media maker.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method that prints the details of the media maker.
	 * 
	 * Prints the details of the media maker.
	 */
	public void printMediaMakerDetails() {
		System.out.println("Name: " + name);
	}

	/**
	 * Method that converts everything to String
	 * 
	 * @return the media maker name
	 */
	public String toString() {
		
		return name;
	}

	/**
	 * 
	 * Sorts the mediaMaker by name.
	 * 
	 * @param   mediaMaker     MediaMaker object to be compared.
	 * 
	 * @return the difference between media makers.
	 */
	@Override
	public int compareTo(MediaMaker mediaMaker) {
		int nameDifference = this.name.compareTo(mediaMaker.getName());
		if (nameDifference != 0) {
			return nameDifference;
		}
		return 0;
	}
}
