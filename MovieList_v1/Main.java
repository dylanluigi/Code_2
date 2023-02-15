import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        FileManager fm = new FileManager("movies.txt", true);
        Scanner s = new Scanner(System.in);

        System.out.print("Movie name: ");
        String movie = s.nextLine();
        System.out.println();
        System.out.print("Director: ");
        String director = s.nextLine();
        System.out.println();
        s = new Scanner(System.in);
        System.out.print("Year: ");
        int year = s.nextInt();

        s.close();

        fm.WriteMovie(movie,director,year);


        System.out.println();

        fm.getTitles();
        System.out.println();
        fm.getAuthors();
        System.out.println();
        fm.ReadAllMovies();

    }
}
