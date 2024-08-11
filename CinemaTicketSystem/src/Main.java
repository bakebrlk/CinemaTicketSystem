import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CinemaTicketSystem system = new CinemaTicketSystem();

        System.out.println("\nЗдравствуйте, у вас есть следующие доступные функции:\n");

        while (true) {
            System.out.println("1. Добавить новый фильм;\n" +
                    "2. Показать все доступные фильмы;\n" +
                    "3. Добавить нового пользователя;\n" +
                    "4. Купить билет;\n" +
                    "5. Отменить покупку билета;\n");

            System.out.print("Ваш выбор: ");
            int in = sc.nextInt();

            System.out.println();

            if(in == 1) {
                System.out.print("Напишите названия для фильма: ");
                String movieName = sc.next();
                movieName += sc.nextLine();

                system.addMovie(movieName);

            }else if(in == 2) {
                system.showAllMovies();

            }else if(in == 3) {
                System.out.print("Напишите имя пользователя: ");
                String userName = sc.next();
                userName += sc.nextLine();

                int userID = system.addUser(userName);
                System.out.println(userName + " ваш ID: " + userID);

            }else if(in == 4) {
                System.out.print("Напишите ID пользователя: ");
                int userID = sc.nextInt();
                System.out.print("Напишите ID фильма: ");
                int movieID = sc.nextInt();

                if(movieID <= system.movies.size() && userID <= system.users.size()) {
                    int ticketID = system.buyTicket(userID, movieID);
                    System.out.println("Ваш ID билета: " + ticketID);
                    System.out.println(system.users.get(userID) + " покупает билет на " + system.movies.get(movieID - 1));
                }else {
                    System.out.println("ID пользователя или ID фильма неправельно.");
                }

            }else if(in == 5) {
                System.out.print("Напишите ID билета: ");
                int ticketID = sc.nextInt();

                System.out.println(system.cancelTicket(ticketID));
            }

            System.out.println();
        }
    }
}