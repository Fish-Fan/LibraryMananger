package app;

import Dao.BookDao;
import entity.Book;

import java.util.List;
import java.util.Scanner;

/**
 * Created by yanfeng-mac on 2016/12/29.
 */
public class BookSystem {
    BookDao bookDao = new BookDao();
    public void start(){
        System.out.println("---所处位置：图书管理菜单---");
        System.out.println("1. 添加书籍");
        System.out.println("2. 修改书籍");
        System.out.println("3. 删除书籍");
        System.out.println("4. 查找书籍");
        System.out.println("5. 查找所有书籍");
        System.out.println("6. 查找书籍总数");
        System.out.println("7. 查找书籍总价值");
        System.out.println("0. 返回上一级");

        Scanner scanner = new Scanner(System.in);
        int index = 0;
        index = scanner.nextInt();

        if(index == 0){
            LibrarySystem librarySystem = new LibrarySystem();
            librarySystem.start();
        }
        if(index == 1){
            Book book = new Book();
            System.out.println("请输入添加书籍的ISBN号！");
            String isbn = scanner.next();
            book.setBisbn(isbn);
            System.out.println("请输入添加书籍的名称！");
            String name = scanner.next();
            book.setBname(name);
            System.out.println("请输入添加书籍的作者！");
            String author = scanner.next();
            book.setBauthor(author);
            System.out.println("请输入添加书籍的出版社名称！");
            String publisher = scanner.next();
            book.setBpublisher(publisher);
            System.out.println("请输入添加书籍的价格！");
            float price = scanner.nextFloat();
            book.setBprice(price);
            System.out.println("请输入添加书籍的类别！");
            String category = scanner.next();
            book.setBcategory(category);

            bookDao.addBook(book);
            start();
        }
        if(index == 2){
            System.out.println("请输入要修改书籍的ISBN号！");
            String isbn = scanner.next();
            Book book = bookDao.findBookByIsbn(isbn);

            if(book == null){
                System.out.println("未找到该书籍！");
            }
            else {
                String answer = "";
                System.out.println("是否要修改名称？(Y|N)");
                answer = scanner.next();
                if("y".equalsIgnoreCase(answer)){
                    System.out.println("请输入修改后的名称！");
                    String name = scanner.next();
                    book.setBname(name);
                }

                System.out.println("是否要修改作者？(Y|N)");
                answer = scanner.next();
                if("y".equalsIgnoreCase(answer)){
                    System.out.println("请输入修改后的作者！");
                    String author = scanner.next();
                    book.setBauthor(author);
                }

                System.out.println("是否要修改出版社名称？(Y|N)");
                answer = scanner.next();
                if("y".equalsIgnoreCase(answer)){
                    System.out.println("请输入修改后的出版社名称！");
                    String publisher = scanner.next();
                    book.setBpublisher(publisher);
                }

                System.out.println("是否要修改价格？(Y|N)");
                answer = scanner.next();
                if("y".equalsIgnoreCase(answer)){
                    System.out.println("请输入修改后的价格！");
                    float price = scanner.nextFloat();
                    book.setBprice(price);
                }

                System.out.println("是否要修改图书类别？(Y|N)");
                answer = scanner.next();
                if("y".equalsIgnoreCase(answer)){
                    System.out.println("请输入修改后的图书类别！");
                    String category = scanner.next();
                    book.setBcategory(category);
                }

                bookDao.updateBook(book);
                start();
            }

        }
        if(index == 3){
            System.out.println("请输入您要删除书籍的ISBN号！");
            String isbn = scanner.next();

            Book book = bookDao.findBookByIsbn(isbn);
            if(book == null){
                System.out.println("未找到该书籍!");
            }
            else {
                bookDao.deleteBook(isbn);
            }
            start();

        }
        if(index == 4){
            System.out.println("请输入您要查找图书的ISBN号！");
            String isbn = scanner.next();
            Book book = bookDao.findBookByIsbn(isbn);
            System.out.println(book);
        }
        if(index == 5){
            List<Book> list = bookDao.findAllBook();
            for(Book book : list)
            {
                System.out.println(book);
            }

            start();
        }
        if(index == 6){
            Long count = (Long) bookDao.selectCount();
            System.out.println("图书总数量为: " + count);
            start();
        }
        if(index == 7){
            Double value = (Double) bookDao.selectValue();
            System.out.println("图书总价值为: " + value);
            start();
        }

    }
}
