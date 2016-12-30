package app;

import entity.Book;

import java.util.Scanner;

/**
 * Created by yanfeng-mac on 2016/12/29.
 */
public class LibrarySystem {
    public void start(){
        System.out.println("---欢迎来到图书馆管理系统---");
        System.out.println("1. 进入书籍管理菜单");
        System.out.println("2. 进入人员管理菜单");
        System.out.println("3. 进入借阅管理菜单");

        Scanner scanner = new Scanner(System.in);
        int index = 0;
        index = scanner.nextInt();

        if(index == 1){
            BookSystem bookSystem = new BookSystem();
            bookSystem.start();
        }
        if(index == 2){
            ReaderSystem readerSystem = new ReaderSystem();
            readerSystem.start();
        }
        if(index == 3){
            BorrowSystem borrowSystem = new BorrowSystem();
            borrowSystem.start();
        }
    }
}
