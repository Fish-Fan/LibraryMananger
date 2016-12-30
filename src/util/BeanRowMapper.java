package util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Created by yanfeng-mac on 2016/12/29.
 */
public class BeanRowMapper <T> implements MapRow<T>{
    Class<T> clazz;
    public BeanRowMapper(Class<T> clazz){
        this.clazz = clazz;
    }
    @Override
    public T MapRow(ResultSet resultSet) {
        try {
            T object = clazz.newInstance();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int colCount = resultSetMetaData.getColumnCount();
            for(int i = 1;i <= colCount;i++)
            {
                String colName = resultSetMetaData.getColumnLabel(i);
                String methodName = "set" + colName.substring(0,1).toUpperCase() + colName.substring(1);
                Object colValue = resultSet.getObject(i);
                Method[] methods = clazz.getMethods();
                for(Method method : methods)
                {
                    if(methodName.equals(method.getName())){
                        method.invoke(object,colValue);
                    }
                }
            }

            return object;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
