import static org.junit.Assert.*;

import org.junit.Test;

public class MDbTest {

	@Test
	public void test() {
		String testLine = "Waka waka Amzing stuf (156845623) (V) 156845623";
		Movie testMovie = new Movie();
		testMovie.setName("Waka waka Amzing stuf");
		testMovie.setVersion("V");
		testMovie.setYear("156845623");
		testMovie.setReleaseYear("156845623");
 
		String testEpLine = "\"Star Trek Cataja\" (2013) {Konfrontation (#1.4)}	2015";
		Episode testEpisode = new Episode();
		testEpisode.setEpisodeName("Konfrontation");
		testEpisode.setSeriesName("Star Trek Cataja");
		testEpisode.setReleaseYear("2015");
		testEpisode.setSeason("1");
		testEpisode.setEpisode("4");
		
		// Both of these tests will fail, but the objects have the same information
		assertEquals(testMovie, MDb.movieFromLine(testLine));
		assertEquals(testEpisode, MDb.episodeFromLine(testEpLine));
		
		String[] list= {""};
		// Should not produce an error????
		// assertEquals(MDb.mediaMakerFromList(list), new MediaMaker("isActor"));
	}

}
