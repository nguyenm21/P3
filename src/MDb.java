import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class MDb {
	
	/** Stores a list of the movies in an ArrayList. */
	private static ArrayList<Movie> MOVIE_DATABASE = new ArrayList<Movie>();

	/** Stores a list of episodes in an ArrayList. */
	private static ArrayList<Episode> EPISODE_DATABASE = new ArrayList<Episode>();

	/** Stores a list of the series in an ArrayList. */
	private static ArrayList<Series> SERIES_DATABASE = new ArrayList<Series>();
	
	private static LinkedHashMap<String, MediaMaker> MEDIAMAKER_DATABASE = new LinkedHashMap<String, MediaMaker>();
	
	
	public static void main(String[] args) throws IOException{
		
		String actorFileName = "SomeActors.txt";
		String[] actorList = readInFile(actorFileName, findSizeOfList(actorFileName));
		addKeys(actorList);
		
		/* for (String line : actorList){
			System.out.println(line);
		} */
		
		
		String directorFileName = "SomeDirectors.txt";
		String[] directorList = readInFile(directorFileName, findSizeOfList(actorFileName));
		//addKeys(directorList);
		
		String producerFileName = "SomeDirectors.txt";
		String[] producerList = readInFile(producerFileName, findSizeOfList(actorFileName));
		//addKeys(producerList);
		
	}
	/**
	 * Gets a single line from the list of movies and creates a Movie object
	 * from the information
	 * 
	 * @param movieLine Line from the list of movies.
	 * @return The Movie object created from the information.
	 * 
	 */
	public static Movie movieFromLine(String movieLine) {

		String[] separatedDetails = movieLine.split(" ");
		Movie movie = new Movie();

		for (int i = 0; i <= separatedDetails.length - 1; ++i) {

			String namePart = movie.getName();

			// These next lines of code put together the title of the movie
			// using the variable above. (The conditions omit anything that is
			// associated with the other details of a movie)
			if (!(separatedDetails[i].startsWith("(1") || separatedDetails[i].startsWith("(2")
					|| separatedDetails[i].startsWith("(3") || separatedDetails[i].startsWith("(?")
					|| separatedDetails[i].startsWith("(TV)") || separatedDetails[i].startsWith("(V)"))
					&& !(i == separatedDetails.length - 1)) {
				if (namePart.equals("")) {
					movie.setName(separatedDetails[i]);
				} else {
					namePart = namePart.replaceAll("\\s+", " ") + " " + separatedDetails[i];
					movie.setName(namePart.trim());
				}
			}

			// These next lines of code organize and assign the version, year,
			// and the yearOfMovie variables.
			if (separatedDetails[i].startsWith("(V)")) {
				movie.setVersion("V");
			} else if (separatedDetails[i].startsWith("(TV)")) {
				movie.setVersion("TV");
			} else if (separatedDetails[i].startsWith("(1") || separatedDetails[i].startsWith("(2")
					|| separatedDetails[i].startsWith("(3") || separatedDetails[i].startsWith("(?")) {
				movie.setYear(separatedDetails[i].substring(separatedDetails[i].indexOf("(") + 1,
						separatedDetails[i].indexOf(")")));
			}
			if (i == separatedDetails.length - 1) {
				movie.setReleaseYear(separatedDetails[i]);
			}
		}

		return movie;
	}

	/**
	 * Gets a single line from the list of episodes and creates an Episode
	 * object from the information
	 * 
	 * @param episodeLine Line from the list of movies.
	 * @return The Episode object created from the information.
	 * 
	 */
	public static Episode episodeFromLine(String episodeLine) {

		Episode episode = new Episode();
		String fullYear = "";

		String[] separatedDetails = episodeLine.split("\\s+");
		for (int i = 0; i <= separatedDetails.length - 1; ++i) {
			if (!episodeLine.contains("{")) {
				fullYear = separatedDetails[separatedDetails.length - 1];
				Episode dudEpisode = new Episode();
				dudEpisode.setFullYear(fullYear);
				return dudEpisode;
			}

			// This code sets the seriesName of the episode
			if (separatedDetails[i].startsWith("\"")) {

				for (int j = i; i <= separatedDetails.length - 1; ++j) {
					String seriesNamePart = episode.getSeriesName();
					if (separatedDetails[j].charAt(separatedDetails[j].length() - 1) == '"') {
						seriesNamePart = seriesNamePart.replaceAll("\\s+", " ") + " "
								+ separatedDetails[j].substring(0, separatedDetails[j].indexOf("\""));
						episode.setSeriesName(seriesNamePart.trim());
						break;
					} else {
						if (seriesNamePart.equals("")) {
							episode.setSeriesName(separatedDetails[j].substring(1, separatedDetails[j].length()));
						} else {
							seriesNamePart = seriesNamePart.replaceAll("\\s+", " ") + " "
									+ separatedDetails[j].substring(0, separatedDetails[j].length());
							episode.setSeriesName(seriesNamePart.trim());
						}
					}
				}
			}

			if (separatedDetails[i].startsWith("{") && !(separatedDetails[i].startsWith("{(#"))
					&& !(separatedDetails[i].startsWith("{{"))) {

				for (int j = i; i <= separatedDetails.length - 1; ++j) {
					String episodeNamePart = episode.getEpisodeName();
					if (separatedDetails[j].startsWith("(#")) {
						break;
					}
					if (separatedDetails[j].charAt(separatedDetails[j].length() - 1) == '}') {
						episodeNamePart = episodeNamePart.replaceAll("\\s+", " ") + " "
								+ separatedDetails[j].substring(0, separatedDetails[j].indexOf("}"));
						episode.setEpisodeName(episodeNamePart.trim());
						break;
					} else {
						if (episodeNamePart.equals("")) {
							episode.setEpisodeName(separatedDetails[j].substring(1, separatedDetails[j].length()));
						} else {
							episodeNamePart = episodeNamePart.replaceAll("\\s+", " ") + " "
									+ separatedDetails[j].substring(0, separatedDetails[j].length());
							episode.setEpisodeName(episodeNamePart.trim());
						}
					}
				}
			}

			if (separatedDetails[i].startsWith("{{")) {
				episode.setSuspended(true);
			}

			if (separatedDetails[i].startsWith("{(#")) {
				episode.setSeason(separatedDetails[i].substring(3, separatedDetails[i].indexOf(".")));
				episode.setEpisode(separatedDetails[i].substring(separatedDetails[i].indexOf(".") + 1,
						separatedDetails[i].indexOf(")")));
			}

			if (separatedDetails[i].startsWith("(#")) {
				episode.setSeason(separatedDetails[i].substring(2, separatedDetails[i].indexOf(".")));
				episode.setEpisode(separatedDetails[i].substring(separatedDetails[i].indexOf(".") + 1,
						separatedDetails[i].indexOf(")")));
			}

			if (separatedDetails[i].startsWith("(1") || separatedDetails[i].startsWith("(2")) {
				episode.setSeriesYear(separatedDetails[i].substring(separatedDetails[i].indexOf("(") + 1,
						separatedDetails[i].indexOf(")")));
			}

			if (i == separatedDetails.length - 1) {
				episode.setReleaseYear(separatedDetails[i]);
			}
		}

		return episode;

	}
	
	/**
	 * 
	 * @param list List of media maker details to parse.
	 * @return MediaMaker object from the parsed details.
	 */
	public static MediaMaker actorFromList(ArrayList<String> list) {
		for (String credit : list){
			if (credit.equals("")){
				continue;
			}
			if (!credit.startsWith("	")){
				
			}
			
		}
		return new MediaMaker("isActor");
	}
	
	public static MediaMaker producerFromList(ArrayList<String> list) {
		
		return new MediaMaker("isProducer");
	}

	public static MediaMaker directorFromList(ArrayList<String> list) {
		
		return new MediaMaker("isDirector");
	}
	
	public static void addKeys(String[] list){
		
		for (String line : list){
			if (!line.startsWith("	")){
				String key = line.substring(0, line.indexOf("	") + 1);
				System.out.println(key);
				key = key.trim();
				MEDIAMAKER_DATABASE.putIfAbsent(key, null);
			}
		}
	}
	/**
	 * 
	 * Reads in a file to a String Array.
	 * 
	 * @param fileName File name to be read.
	 * @param listSize Size of the file list.
	 * @return The String array of what was read from file.
	 * @throws IOException
	 *             Don't break if file is not found
	 */
	public static String[] readInFile(String fileName, int listSize) throws IOException {
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		String[] list = new String[listSize];
		int i = 0;
		while (br.ready()) {
			String line = br.readLine();
			list[i] = line;
			++i;
		}
		br.close();

		return list;

	}
	


	/**
	 * 
	 * Reads a file to get the size of a String Array.
	 * 
	 * @param fileName File name to be read.
	 * @return Size of the file list.
	 * @throws IOException
	 *             Don't break if file is not found
	 */
	public static int findSizeOfList(String fileName) throws IOException {
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		int i = 0;
		while (br.ready()) {
			br.readLine();
			++i;
		}
		br.close();

		return i;

	}

}

