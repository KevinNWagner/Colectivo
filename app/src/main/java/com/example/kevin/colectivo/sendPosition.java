package com.example.kevin.colectivo;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by kevin on 15/12/2017.
 */

public class sendPosition extends AsyncTask<String, Integer, Integer> {
    // private LatLng recorrido[];



    @Override
    protected Integer doInBackground(String... params) {


        try {
            Log.d("Inicio de conexcion ", "latitud");

            // tt.show();
            Class.forName("com.mysql.jdbc.Driver");
            // "jdbc:postgresql://IP:PUERTO/DB", "USER", "PASSWORD");
            // Si estás utilizando el emulador de android y tenes el PostgreSQL en tu misma PC no utilizar 127.0.0.1 o localhost como IP, utilizar 10.0.2.2
            Log.d("check class ", "latitud");

            final Connection conn = DriverManager.getConnection("jdbc:mysql://10.0.2.2/db_administracion_colectivos", "root", "");
            //En el stsql se puede agregar cualquier consulta SQL deseada.
            try {

                if (conn != null) {
                    System.out.println("Connected");
                }

                String sql = "UPDATE colectivos SET posicionLatitud ='"+params[0]+"',posicionLongitud ='"+params[1]+"' WHERE idColectivos=1";

                PreparedStatement statement;
                statement = conn.prepareStatement(sql);


                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A Record inserted successfully!");
                }
            } catch (SQLException e) {
                System.out.println("Exception occured" + e);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

}
