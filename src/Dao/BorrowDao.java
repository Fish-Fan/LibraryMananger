package Dao;

import entity.Borrow;
import util.BeanRowMapper;
import util.BeanSingRowMapper;
import util.DBHelp;

import java.util.List;

/**
 * Created by yanfeng-mac on 2016/12/29.
 */
public class BorrowDao {
    public void addBorrow(Borrow borrow){
        String sql = "INSERT INTO borrow VALUES(?,?,?,?,?);";
        DBHelp.DBHelpExecuteUpdate(sql,borrow.getRno(),borrow.getBisbn(),borrow.getStartdate(),borrow.getEnddate(),borrow.getFine());
    }

    public void updateBorrow(Borrow borrow){
        String sql = "UPDATE borrow set startdate = ?,enddate = ?,fine = ?";
        DBHelp.DBHelpExecuteUpdate(sql,borrow.getStartdate(),borrow.getEnddate(),borrow.getFine());
    }

    public void deleteBorrow(Borrow borrow){
        String sql = "DELETE FROM borrow WHERE rno = ? and bisbn = ?";
        DBHelp.DBHelpExecuteUpdate(sql,borrow.getRno(),borrow.getBisbn());
    }

    public Borrow findBorrow(String rno,String bisbn){
        String sql = "SELECT * FROM borrow WHERE rno = ? and bisbn = ?";
        return (Borrow) DBHelp.DBHelpExecuteSelect(sql,new BeanRowMapper(Borrow.class),rno,bisbn);
    }

    public List<Borrow> findAllBorrow(){
        String sql = "SELECT * FROM borrow";
        return DBHelp.DBHelpExecuteSelectAll(sql,new BeanRowMapper(Borrow.class));
    }

    public Object findCount(){
        String sql = "SELECT COUNT(*) FROM borrow";
        return DBHelp.DBHelpExecuteSelect(sql,new BeanSingRowMapper());
    }
}
