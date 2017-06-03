package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.sql.*;




public class MainActivity extends AppCompatActivity {

    static final String DB_URL = "jdbc:mysql://localhost:8080/phpmyadmin";
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    String dbname, username, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            sql();
        } catch (IOException e) {
            TextView tv1 = (TextView)findViewById(R.id.textView);
            tv1.setText("Hello");
            setContentView(tv1);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public  void sql() throws IOException, SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement stmt = null;
        dbname = "ssp";
        username = "ssp";
        pass = "sspPassword";
        try{
            //Class.forName("com.mysql.jdbc.Driver");

            //System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, username ,pass);

            //STEP 4: Execute a query
            //System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, user, email, password FROM user";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String user = rs.getString("age");
                String email = rs.getString("first");
                String password = rs.getString("last");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", user: " + user);
                System.out.print(", password: " + password);
                System.out.println(", email: " + email);
                TextView tv1 = (TextView)findViewById(R.id.textView);
                tv1.setText("Hello");
                setContentView(tv1);
            }


        }catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }
    }
}



