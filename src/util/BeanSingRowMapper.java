package util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Created by yanfeng-mac on 2016/12/29.
 */
public class BeanSingRowMapper <T> implements MapRow <T> {
//    Class<T> clazz;
//    public BeanSingRowMapper(Class<T> clazz){
//        this.clazz = clazz;
//    }

    @Override
    public T MapRow(ResultSet resultSet) {
        try {
            return (T)resultSet.getObject(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
