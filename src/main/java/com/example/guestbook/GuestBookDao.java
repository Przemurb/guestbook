package com.example.guestbook;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GuestBookDao {
    private final DataSource dataSource;

    public GuestBookDao() {
        try {
            this.dataSource = DataProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    List<GuestBookEntry> allEntries() {
        final String sql = "SELECT nick, content FROM entry ORDER BY id DESC";
        List<GuestBookEntry> entriesList = new ArrayList<>();
        try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String nick = resultSet.getString("nick");
                String content = resultSet.getString("content");
                entriesList.add(new GuestBookEntry(nick, content));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entriesList;
    }

    void saveNewEntry(GuestBookEntry entry) {
        final String sql = String.format("INSERT INTO entry (nick, content) VALUES ('%s', '%s')",
                entry.getNick(), entry.getContent());
        try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate(sql);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
