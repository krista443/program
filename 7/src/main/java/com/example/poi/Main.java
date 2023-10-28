import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод данных о книге с консоли
        System.out.print("Введите название книги: ");
        String title = scanner.nextLine();

        System.out.print("Введите автора книги: ");
        String author = scanner.nextLine();

        System.out.print("Введите жанр книги: ");
        String genre = scanner.nextLine();

        System.out.print("Введите количество страниц: ");
        int pageCount = scanner.nextInt();

        // Создание объекта Book с использованием введенных данных
        Book.BookBuilder builder = new Book.BookBuilder()
                .setTitle(title)
                .setAuthor(author)
                .setGenre(genre)
                .setPageCount(pageCount);

        Book book = builder.build();

        // Вывод информации о книге
        System.out.println("Название: " + book.getTitle());
        System.out.println("Автор: " + book.getAuthor());
        System.out.println("Жанр: " + book.getGenre());
        System.out.println("Количество страниц: " + book.getPageCount());

        // Закрытие Scanner
        scanner.close();
    }
}
