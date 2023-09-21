package com.aurionpro.model;

import java.util.List;
import java.util.Scanner;

public class MovieController {
    private MovieManager manager;
    private Scanner sc;

    public MovieController() {
        manager = new MovieManager();
        sc = new Scanner(System.in);
    }

    public void start() {
        displayMenu();
    }

 
    public void displayMenu() {
        int choice;
        do {
            System.out.println("===== Movie Store Menu =====");
            System.out.println("1. Add Movie");
            System.out.println("2. List Movies");
            System.out.println("3. Save Movies");
            System.out.println("4. Load Movies");
            System.out.println("5. Clear Movies");
            System.out.println("6. Get Movie by ID");
            System.out.println("7. Exit");
            System.out.println("===========================");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addMovie();
                    break;
                case 2:
                    listMovies();
                    break;
                case 3:
                    saveMovies();
                    break;
                case 4:
                    loadMovies();
                    break;
                case 5:
                    clearMovies();
                    break;
                case 6:
                    getMovieById();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
    }

    public void addMovie() {
        System.out.println("Enter Movie Details:");
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Year: ");
        int year = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Genre: ");
        String genre = sc.nextLine();
        Movie movie = new Movie(id, name, year, genre);
        
        manager.addMovie(movie);
        System.out.println("Movie added successfully!");
    }

    public void listMovies() {
        List <Movie> movies = manager.getMovies();
        System.out.println("===== Movie List =====");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
        System.out.println("=====================");
    }
    
//    public Movie getMovieById(int id) {
//        for (Movie movie : movies) {
//            if (movie.getId() == id) {
//                return movie;
//            }
//        }
//        return null; 
//    }
    
    public void getMovieById() { 
        System.out.print("Enter Movie ID to get details: "); 
        int id = sc.nextInt(); 
        sc.nextLine();  
 
        Movie movie = manager.getMovieById(id); 
        if (movie != null) { 
            System.out.println("Movie Details:"); 
            System.out.println(movie); 
        } else { 
            System.out.println("Movie with ID " + id + " not found."); 
        } 
    }

    public void saveMovies() {
        manager.saveMoviesToFile();
    }

    public void loadMovies() {
        manager.loadMoviesFromFile();
    }

    public void clearMovies() {
        manager.clearMovies();
    }

    public static void main(String[] args) {
        MovieController controller = new MovieController();
        controller.start();
    }
}
