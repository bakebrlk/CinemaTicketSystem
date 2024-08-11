import java.util.ArrayList;
import java.util.HashMap;

public class CinemaTicketSystem {


    public HashMap<Integer, String> movies = new HashMap<>();
    public HashMap<Integer, String> users = new HashMap<>();
    public ArrayList<CinemaTicket> tickets = new ArrayList<>();

    CinemaTicketSystem(){}

    public int addMovie(String movieName) {
        movies.put(movies.size(), movieName);
        return movies.size();
    }

    public void showAllMovies() {
        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i+1) + ". " + movies.get(i));
        }
    }

    public int addUser(String userName) {
        users.put(users.size() + 1, userName);
        return users.size();
    }

    public int buyTicket(int userId, int movieId){
        tickets.add(new CinemaTicket(userId, movieId));
        return tickets.size();
    }

    public boolean cancelTicket(int ticketId){
        try{
            tickets.remove(ticketId-1);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

}
