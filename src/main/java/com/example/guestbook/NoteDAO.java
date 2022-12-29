package com.example.guestbook;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoteDAO {
    private final DataSource dataSource;

    public NoteDAO() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    List<Note> findAll() {
        final String sql = "SELECT * FROM questList";
        List<Note> resultList = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String context = resultSet.getString("context");
                java.sql.Timestamp timestamp = resultSet.getTimestamp("currentTime");
                resultList.add(new Note(name, context, timestamp));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }
}
