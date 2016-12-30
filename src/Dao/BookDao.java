package Dao;

import entity.Book;
import util.BeanRowMapper;
import util.BeanSingRowMapper;
import util.ConnectionMananger;
import util.DBHelp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanfeng-mac on 2016/12/29.
 */
public class BookDao <T>{
    public void addBook(Book book) {
        String sql = "INSERT INTO book VALUES(?,?,?,?,?,?)";
        DBHelp.DBHelpExecuteUpdate(sql,book.getBisbn(),book.getBname(),book.getBauthor(),book.getBpublisher(),book.getBprice(),book.getBcategory());
    }

    public void updateBook(Book book){
        String sql = "UPDATE book set bname = ?,bauthor = ?,bpublisher = ?,bprice = ?,bcategory = ? WHERE bisbn = ?";
        DBHelp.DBHelpExecuteUpdate(sql,book.getBname(),book.getBauthor(),book.getBpublisher(),book.getBprice(),book.getBcategory(),book.getBisbn());
    }

    public void deleteBook(String isbn){
        String sql = "DELETE FROM book WHERE bisbn = ?";
        DBHelp.DBHelpExecuteUpdate(sql,isbn);
    }

    public Book findBookByIsbn(String isbn){
        String sql = "SELECT * FROM book WHERE bisbn = ?";
        return (Book) DBHelp.DBHelpExecuteSelect(sql,new BeanRowMapper(Book.class),isbn);
    }

    public List<Book> findAllBook(){
        String sql = "SELECT * FROM book";
        return DBHelp.DBHelpExecuteSelectAll(sql,new BeanRowMapper(Book.class));
    }

    public T selectCount(){
        String sql = "SELECT COUNT(*) FROM book";
        return (T)DBHelp.DBHelpExecuteSelect(sql,new BeanSingRowMapper());
    }

    public T selectValue(){
        String sql = "SELECT SUM(bprice) FROM book";
        return (T)DBHelp.DBHelpExecuteSelect(sql,new BeanSingRowMapper());
    }
}
