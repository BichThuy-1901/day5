package jpa.main;

import jpa.config.SpringConfig;
import jpa.entity.BookDetailEntity;
import jpa.entity.BookEntity;
import jpa.entity.CategoryEntity;
import jpa.repository.BookRepository;
import jpa.repository.CategoryRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.List;

public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    static BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");
    static CategoryRepository categoryRepository = (CategoryRepository) context.getBean("categoryRepository");

    public static void main(String[] args) {
//        createNewBookEntityWithNewCategory();
//        createNewCategory();
//        createNewBookEntity();
//        findByAuthor ("Roger");
//
//        findByNameAndAuthor ("linux", "Roger");
//
//        findByNameOrAuthor ("linux", "Roger");
//
//        findByPriceLessThan (80);
//
//        bookRepository.findByBookDetailsIsbn("ISIBF1219321");
//
        bookRepository.findByNameContaining("Nu");
    }
//    public static void createNewBookEntity(){
//        CategoryEntity categoryEntity = new CategoryEntity();
//        categoryEntity.setId(1);
//
//        BookEntity bookEntity = createNewBook();
//        bookEntity.setCategory(categoryEntity);
//        bookRepository.save(bookEntity);
//}

//    public static void createNewBookEntityWithNewCategory(){
//        CategoryEntity categoryEntity = new CategoryEntity();
//        categoryRepository.save(categoryEntity);
//
//        BookEntity bookEntity = createNewBook();
//        bookEntity.setCategory(categoryEntity);
//        bookRepository.save(bookEntity);
//
//    }
//
//    private static CategoryRepository createNewCategory() {
//        CategoryEntity categoryEntity = new CategoryEntity();
//        categoryEntity.setName("IT");
//        categoryEntity.setDescription("IT book");
//        return (CategoryRepository) categoryEntity;
//        }
//
//    private static BookEntity createNewBook(){
//            BookDetailEntity bookDetailEntity = new BookDetailEntity();
//            bookDetailEntity.setIsbn("ISIBF1219321");
//            bookDetailEntity.setPrice(23);
//            bookDetailEntity.setNumberOfPage(65);
//            bookDetailEntity.setPublishDate(LocalDate.now());
//
//            BookEntity bookEntity = new BookEntity();
//            bookEntity.setName("Java A-Z");
//            bookEntity.setAuthor("Roger");
//            bookEntity.setBookDetails(bookDetailEntity);
//            bookDetailEntity.setBook(bookEntity);
//
//            return bookEntity;
//    }

//    private static void findByAuthor(String author) {
//        List<BookEntity> bookEntityList = bookRepository.findByAuthor(author);
//        if (bookEntityList != null) {
//            System.out.println("\nFind " + bookEntityList.size() + "books which author = " + author );
//            for (BookEntity bookEntity: bookEntityList){
//                System.out.println(bookEntity.toString());
//            }
//        }
//    }
//
//    private static void findByNameAndAuthor(String name, String author) {
//        List<BookEntity> bookEntityList = bookRepository.findByNameAndAuthor(name, author);
//        if (bookEntityList != null) {
//            System.out.println("\nFind " + bookEntityList.size() + "books which name = " + name + "and author = " + author );
//            for (BookEntity bookEntity: bookEntityList){
//                System.out.println(bookEntity.toString());
//            }
//        }
//    }
//
//    private static void findByNameOrAuthor(String name, String author) {
//        List<BookEntity> bookEntityList = bookRepository.findByNameOrAuthor(name, author);
//        if (bookEntityList != null) {
//            System.out.println("\nFind " + bookEntityList.size() + "books which name = " + name + "or author = " + author );
//            for (BookEntity bookEntity: bookEntityList){
//                System.out.println(bookEntity.toString());
//            }
//        }
//    }
//
//    private static void findByPriceLessThan(int price) {
//        List<BookEntity> bookEntityList = bookRepository.findByBookDetailsPriceLessThan(price);
//        if (bookEntityList != null) {
//            System.out.println("\nFind " + bookEntityList.size() + "books price less than" + price );
//            for (BookEntity bookEntity: bookEntityList){
//                System.out.println(bookEntity.toString());
//            }
//    }

    private static void findByNameContaining(String name) {
        List<BookEntity> bookEntityList = bookRepository.findByNameContaining(name);
        if (bookEntityList != null) {
            System.out.println("\nFind " + bookEntityList.size() + "books with containing name = " + name);
            for (BookEntity bookEntity : bookEntityList) {
                System.out.println(bookEntity.toString());
            }
        }

//          private static void findAllUsingQuery() {
//        List<BookEntity> books = (List<BookEntity>) bookRepository.getAll();
//        if (bookEntityList != null) {
////                System.out.println("\nFind " + bookEntityList.size() + books );
////                for (BookEntity bookEntity: bookEntityList){
////                    System.out.println(bookEntity.toString());
////                }
//    }
//        private static void findByBookDetailsIsbn(String isbn) {
//            List<BookEntity> bookEntityList = (List<BookEntity>) bookRepository.findByBookDetailsIsbn(isbn);
//            if (bookEntityList != null) {
//              System.out.println("\nFind book which isbn = " + isbn );
//                  System.out.println(bookEntityList.toString());
//        }
//  }


    }
}
