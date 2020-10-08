package com.maartenmusic;

import java.sql.*;

public class Main {

    public static final String DB_NAME = "javatest.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + DB_NAME;

    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";


    public static void insertIntoContacts(Statement statement, String name, int phone, String email)
            throws SQLException {
            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                    "(" + COLUMN_NAME + ", " + COLUMN_PHONE + ", " + COLUMN_EMAIL + ")" +
                    "VALUES('" + name + "', '" + phone + "', '" + email + "')");
    }


    public static void main(String[] args) {

       try(Connection connection = DriverManager.getConnection(CONNECTION_STRING);
           Statement statement = connection.createStatement()
       ) {
           statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
           statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                   "(" + COLUMN_NAME +" TEXT, " +
                        COLUMN_PHONE + " INTEGER, " +
                        COLUMN_EMAIL + " TEXT" +
                    ")");
//           statement.execute("INSERT INTO contacts" +
//                            "(name, phone, email)" +
//                            "VALUES('Maarten', 0612345, 'email@maarten.com')");
//           statement.execute("INSERT INTO contacts" +
//                   "(name, phone, email)" +
//                   "VALUES('Anna', 543321, 'email@anna.com')");
//           statement.execute("INSERT INTO contacts" +
//                   "(name, phone, email)" +
//                   "VALUES('Ella', 11111, 'email@ella.com')");
//           statement.execute("INSERT INTO contacts" +
//                   "(name, phone, email)" +
//                   "VALUES('Kasper & Berend', 00000, 'email@kb.com')");

           insertIntoContacts(statement, "Maarten2", 1313131, "maarten2@maarten2.com");
           insertIntoContacts(statement, "Maarten", 347663, "maarten@maarten2.com");
           insertIntoContacts(statement, "Anna", 889, "anna@maarten2.com");
           insertIntoContacts(statement, "Ella", 568755885, "ella@maarten2.com");

//           statement.execute("DELETE FROM contacts WHERE name='Maarten'");
//           statement.execute("UPDATE contacts SET phone=101010 WHERE name='Kasper & Berend'");
//           System.out.println(statement.execute("SELECT * FROM contacts"));

           try (ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS)) {
               while (resultSet.next()) {
                   System.out.println("name: " + resultSet.getString(COLUMN_NAME));
                   System.out.println("phone: " + resultSet.getInt(COLUMN_PHONE));
                   System.out.println("email: " + resultSet.getString(COLUMN_EMAIL));
                   System.out.println("+++++++++");
               }
           }


       } catch (SQLException e) {
           e.printStackTrace();
       }
    }
}
