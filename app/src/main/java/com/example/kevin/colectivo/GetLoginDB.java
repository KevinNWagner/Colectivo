package com.example.kevin.colectivo;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.example.kevin.colectivo.MainActivity.resources;

/**
 * Created by kevin on 16/11/2016.
 */
public class GetLoginDB extends AsyncTask<String,Integer,Integer> {
    // private LatLng recorrido[];

    String ip = resources.getString(R.string.ipDB);
    String  port = resources.getString(R.string.portDB);
    String nameDB = resources.getString(R.string.nameDB);
    String pass = resources.getString(R.string.passDB);
    String user = resources.getString(R.string.userDB);

    String urlConection = "jdbc:mysql://"+ip+":"+port+"/"+nameDB+"?connectTimeout=3000";
    //String user = getResources();
    //String pass = R.string.passDB;

    @Override
    protected Integer doInBackground(String... params) {
        try {


            // tt.show();
            Class.forName("com.mysql.jdbc.Driver");
            // "jdbc:postgresql://IP:PUERTO/DB", "USER", "PASSWORD");
            // Si estás utilizando el emulador de android y tenes el PostgreSQL en tu misma PC no utilizar 127.0.0.1 o localhost como IP, utilizar 10.0.2.2

            DriverManager.setLoginTimeout(5);
            final Connection conn = DriverManager.getConnection(urlConection, user,pass);
            //En el stsql se puede agregar cualquier consulta SQL deseada.
            Log.d("Conectado ","latitud");
            String stsql = "SELECT TOP 1 * FROM users WHERE name='"+params[0]+" and password="+params[1];
            final Statement st = conn.createStatement();
            final ResultSet rs = st.executeQuery(stsql);
            Integer index = 0;
            rs.next();

            if(rs.wasNull()){
                conn.close();
                return -1;
            }else{
                conn.close();
                return rs.getInt(0);
            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            publishProgress((int) 3);
            isCancelled();


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            publishProgress((int) 3);
            isCancelled();
        }
        //colectivo= new LatLng(latitud,longitud);
        //return recorrido;
        return -1;

    }
}
