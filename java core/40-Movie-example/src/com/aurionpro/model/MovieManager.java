package com.aurionpro.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MovieManager {
	 private List<Movie> movies;
	    private static final String filepath = "D:\\java22\\40-Movie-example\\src\\com\\aurionpro\\model\\moviesdata.txt";
	    
	    public MovieManager() {
	        this.movies = new ArrayList<>();
	        loadMoviesFromFile(); 
	    }

	    public List<Movie> getMovies() {
	        return movies;
	    }

	    public void addMovie(Movie movie) {
	        movies.add(movie);
	    }	
	    
	    public void clearMovies() {
	        movies.clear();
	        System.out.println("All movies cleared.");
	    }

//	    public int getMovieId(Movie movie) {
//	        int index = movies.indexOf(movie);
//	        if (index != -1) {
//	            return movies.get(index).getId();
//	        } else {
//	            return -1; 
//	        }
//	    }
	    
	    public Movie getMovieById(int id) { 
	        for (Movie movie : movies) { 
	            if (movie.getId() == id) { 
	                return movie; 
	            } 
	        } 
	        return null; 
	    }

	    public void saveMoviesToFile() {
	        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filepath))) {
	            outputStream.writeObject(movies);
	            System.out.println("Movies saved to file.");
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.out.println("Error saving movies to file: " + e.getMessage());
	        }
	    }

	    public void loadMoviesFromFile() {
	        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filepath))) {
	            movies = (List<Movie>) inputStream.readObject();
	            System.out.println("Movies loaded from file.");
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	            System.out.println("Error loading movies from file: " + e.getMessage());
	        }
	    }

}
