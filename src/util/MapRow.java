package util;

import java.sql.ResultSet;

/**
 * Created by yanfeng-mac on 2016/12/29.
 */
public interface MapRow <T>{
    public <T> T MapRow (ResultSet resultSet);
}
