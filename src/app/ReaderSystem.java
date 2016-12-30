package app;

import Dao.ReaderDao;
import com.apple.eawt.SystemSleepListener;
import entity.Reader;

import javax.swing.text.html.StyleSheet;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yanfeng-mac on 2016/12/29.
 */
public class ReaderSystem {
    ReaderDao readerDao = new ReaderDao();
    public void start(){
        System.out.println("---所处位置：人员管理菜单---");
        System.out.println("1. 添加用户");
        System.out.println("2. 修改用户");
        System.out.println("3. 删除用户");
        System.out.println("4. 查找用户");
        System.out.println("5. 查找所有用户");
        System.out.println("6. 查找所有用户数量");
        System.out.println("0. 返回上一级");

        Scanner scanner = new Scanner(System.in);
        int index = 0;
        index = scanner.nextInt();

        if(index == 0){
            LibrarySystem librarySystem = new LibrarySystem();
            librarySystem.start();
        }
        if(index == 1){
            Reader reader = new Reader();
            System.out.println("请输入用户编号！");
            String rno = scanner.next();
            reader.setRno(rno);
            System.out.println("请输入用户姓名！");
            String rname = scanner.next();
            reader.setRname(rname);
            System.out.println("请输入用户性别！");
            String rgender = scanner.next();
            reader.setRgender(rgender);
            System.out.println("请输入用户年龄！");
            int rage = scanner.nextInt();
            reader.setRage(rage);
            System.out.println("请输入用户专业！");
            String rspecialty = scanner.next();
            reader.setRspecialty(rspecialty);

            readerDao.addReader(reader);
            start();
        }
        if(index == 2){
            System.out.println("请输入要修改用户的编号！");
            String rno = scanner.next();
            Reader reader = readerDao.findReader(rno);

            if(reader == null){
                System.out.println("未找到该用户！");
            }
            else {
                String answer = "";
                System.out.println("是否需要修改用户的姓名？(Y|N)");
                answer = scanner.next();
                if("y".equalsIgnoreCase(answer)){
                    System.out.println("请输入用户的姓名！");
                    String name = scanner.next();
                    reader.setRname(name);
                }

                System.out.println("是否需要修改用户的性别？(Y|N)");
                answer = scanner.next();
                if("y".equalsIgnoreCase(answer)){
                    System.out.println("请输入用户的性别！");
                    String gender = scanner.next();
                    reader.setRgender(gender);
                }

                System.out.println("是否需要修改用户的年龄？(Y|N)");
                answer = scanner.next();
                if("y".equalsIgnoreCase(answer)){
                    System.out.println("请输入用户的年龄！");
                    int age = scanner.nextInt();
                    reader.setRage(age);
                }

                System.out.println("是否需要修改用户所在专业？(Y|N)");
                answer = scanner.next();
                if("y".equalsIgnoreCase(answer)){
                    System.out.println("请输入用户所在专业！");
                    String specialty = scanner.next();
                    reader.setRspecialty(specialty);
                }

                readerDao.updateReader(reader);
                start();
            }

        }

        if(index == 3){
            System.out.println("请输入要删除用户的编号");
            String rno = scanner.next();
            Reader reader = readerDao.findReader(rno);
            if(reader == null){
                System.out.println("未找到该用户！");
            }
            else {
                readerDao.deleteReader(reader);
            }

            start();
        }

        if(index == 4){
            System.out.println("请输入要查找用户的编号");
            String rno = scanner.next();
            Reader reader = readerDao.findReader(rno);
            if(reader == null){
                System.out.println("未找到该用户！");
            }
            else {
                System.out.println(reader);
            }

            start();
        }

        if(index == 5){
            List<Reader> list = readerDao.findAllReader();
            for(Reader reader : list)
            {
                System.out.println(reader);
            }

            start();
        }

        if(index == 6){
            Long count = (Long) readerDao.selectCount();
            System.out.println("用户的总数量为: " + count);

            start();
        }

    }
}
