package app;

import Dao.BorrowDao;
import entity.Borrow;

import java.util.List;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.logging.FileHandler;

/**
 * Created by yanfeng-mac on 2016/12/29.
 */
public class BorrowSystem {
    final String unEndDate = "";
    final float unFine = 0;
    BorrowDao borrowDao = new BorrowDao();

    public void start(){
        System.out.println("---所处位置：借阅管理菜单---");
        System.out.println("1. 添加借阅信息");
        System.out.println("2. 修改借阅信息");
        System.out.println("3. 删除借阅信息");
        System.out.println("4. 按借阅者编号和所借ISBN号查找借阅信息");
        System.out.println("5. 查找所有借阅信息");
        System.out.println("6. 查找用户欠费总额");
        System.out.println("0. 返回上一级");

        Scanner scanner = new Scanner(System.in);
        int index = 0;
        index = scanner.nextInt();

        if(index == 0){
            LibrarySystem librarySystem = new LibrarySystem();
            librarySystem.start();
        }
        if(index == 1){
            Borrow borrow = new Borrow();

            System.out.println("请输入借阅者编号");
            String rno = scanner.next();
            borrow.setRno(rno);
            System.out.println("请输入所借图书的ISBN号");
            String bisbn = scanner.next();
            borrow.setBisbn(bisbn);
            System.out.println("请输入所借图书的起始日期");
            String startDate = scanner.next();
            borrow.setStartdate(startDate);
            borrow.setEnddate(unEndDate);
            borrow.setFine(unFine);

            borrowDao.addBorrow(borrow);
            start();
        }
        if(index == 2){
            System.out.println("请输入要修改的借阅者编号");
            String rno = scanner.next();
            System.out.println("请输入要修改借阅者所借图书的ISBN号");
            String bisbn = scanner.next();
            Borrow borrow = borrowDao.findBorrow(rno,bisbn);
            if(borrow == null){
                System.out.println("未找到该借阅记录！");
            }
            else {
                String answer = "";
                System.out.println("是否要修改该条记录的结束日期？(Y|N)");
                answer = scanner.next();
                if("y".equalsIgnoreCase(answer)){
                    System.out.println("请输入结束日期");
                    String enddate = scanner.next();
                    borrow.setEnddate(enddate);
                }
                System.out.println("是否要修改该条记录的租金？(Y|N)");
                answer = scanner.next();
                if("y".equalsIgnoreCase(answer)){
                    System.out.println("请输入租金");
                    float fine = scanner.nextFloat();
                    borrow.setFine(fine);
                }
            }
            borrowDao.updateBorrow(borrow);
            start();
        }
        if(index == 3){
            System.out.println("请输入要删除记录的借阅者编号");
            String rno = scanner.next();
            System.out.println("请输入要删除记录的借阅者所借图书的ISBN号");
            String bisbn = scanner.next();

            Borrow borrow = borrowDao.findBorrow(rno,bisbn);
            if(borrow == null){
                System.out.println("未找到该图书！");
            }
            else {
                borrowDao.deleteBorrow(borrow);
                start();
            }
        }
        if(index == 4){
            System.out.println("请输入要查找的借阅者编号");
            String rno = scanner.next();
            System.out.println("请输入要查找的借阅者所借图书的ISBN号");
            String bisbn = scanner.next();

            Borrow borrow = borrowDao.findBorrow(rno,bisbn);
            if(borrow == null){
                System.out.println("未找到该图书！");
            }
            else {
                System.out.println(borrow);
                start();
            }
        }
        if(index == 5){
            List<Borrow> list = borrowDao.findAllBorrow();
            for(Borrow borrow : list)
            {
                System.out.println(borrow);
            }
            start();
        }

        if(index == 6){
            Long count = (Long) borrowDao.findCount();
            System.out.println("借阅表中共有 " + count + " 条记录！");
        }
    }
}
