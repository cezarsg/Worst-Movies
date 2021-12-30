package br.com.golden.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import br.com.golden.model.Movie;

public class CSVParserUtil {
	

	public static List<Record> toRecords(InputStream inputStream) {
		CsvParserSettings settings = new CsvParserSettings();
		settings.setHeaderExtractionEnabled(true);
		settings.setDelimiterDetectionEnabled(true, ';');
		CsvParser parser = new CsvParser(settings);
		
		List<Record> records = parser.parseAllRecords(inputStream);
		
		return records;
	}
	

	private static Movie toMovie(Record record) {
		Integer year = record.getInt("year");
		String title = record.getString("title");
		String studios = record.getString("studios");
		String producers = record.getString("producers");
		String winner = record.getString("winner");
		boolean winnerBoolean = winner != null && winner.contentEquals("yes");
		
		Movie movie = new Movie(year, title, studios, producers, winnerBoolean);
		
		return movie;
	}
	
	public static List<Movie> toMovies(List<Record> records) {
		List<Movie> movies = new ArrayList<Movie>();
		
		records.forEach(record -> {
        	Movie movie = toMovie(record);
			movies.add(movie);
		});
		
		return movies;
	}

}
