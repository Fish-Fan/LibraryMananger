package Dao;

import entity.Reader;
import util.BeanRowMapper;
import util.BeanSingRowMapper;
import util.DBHelp;

import java.util.List;

/**
 * Created by yanfeng-mac on 2016/12/29.
 */
public class ReaderDao <T>{
    public void addReader(Reader reader){
        String sql = "INSERT INTO reader VALUES(?,?,?,?,?)";
        DBHelp.DBHelpExecuteUpdate(sql,reader.getRno(),reader.getRname(),reader.getRgender(),reader.getRage(),reader.getRspecialty());
    }

    public void updateReader(Reader reader){
        String sql = "UPDATE reader set rname = ?,rgender = ?,rage = ?,rspecialty = ? WHERE rno = ?";
        DBHelp.DBHelpExecuteUpdate(sql,reader.getRname(),reader.getRgender(),reader.getRage(),reader.getRspecialty(),reader.getRno());
    }

    public void deleteReader(Reader reader){
        String sql = "DELETE FROM reader WHERE rno = ?";
        DBHelp.DBHelpExecuteUpdate(sql,reader.getRno());
    }

    public Reader findReader(String rno){
        String sql = "SELECT * FROM reader WHERE rno = ?";
        return (Reader) DBHelp.DBHelpExecuteSelect(sql,new BeanRowMapper(Reader.class),rno);
    }

    public List<Reader> findAllReader(){
        String sql = "SELECT * FROM reader";
        return DBHelp.DBHelpExecuteSelectAll(sql, new BeanRowMapper(Reader.class));
    }

    public T selectCount(){
        String sql = "SELECT COUNT(*) FROM reader";
        return (T) DBHelp.DBHelpExecuteSelect(sql,new BeanSingRowMapper());
    }


}
