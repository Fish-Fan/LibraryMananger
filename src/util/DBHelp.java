package util;

import entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanfeng-mac on 2016/12/29.
 */
public class DBHelp {
    public static void DBHelpExecuteUpdate(String sql,Object...pram){
        Connection connection = ConnectionMananger.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            for(int i = 0;i < pram.length;i++)
            {
                statement.setObject(i+1,pram[i]);
            }
            statement.executeUpdate();

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static <T> T DBHelpExecuteSelect(String sql,MapRow<T> mapRow,Object...pram){
        Connection connection = ConnectionMananger.getConnection();
        T result = null;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            for(int i = 0;i < pram.length;i++)
            {
                statement.setObject(i+1,pram[i]);
            }

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                result = mapRow.MapRow(resultSet);
            }

            statement.close();
            connection.close();
            return result;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

//    public static <T> T DBHelpExecuteSelectSingle(String sql,MapRow<T> mapRow){
//        Connection connection = ConnectionMananger.getConnection();
//        T result = null;
//
//        try {
//            PreparedStatement statement = connection.prepareStatement(sql);
//            ResultSet resultSet = statement.executeQuery();
//            result = mapRow.MapRow(resultSet);
//
//            statement.close();
//            connection.close();
//            return result;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public static <T> List<T> DBHelpExecuteSelectAll(String sql,MapRow<T> mapRow){
        Connection connection = ConnectionMananger.getConnection();
        List<T> list = new ArrayList<T>();
        T object = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                object = mapRow.MapRow(resultSet);
                list.add(object);
            }

            statement.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
