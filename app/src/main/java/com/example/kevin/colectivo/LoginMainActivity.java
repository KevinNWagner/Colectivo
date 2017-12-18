package com.example.kevin.colectivo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by kevin on 17/12/2017.
 */

public class LoginMainActivity extends AppCompatActivity {
    EditText usuario ;
    EditText password;
    Integer idColectivo = 0;
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        usuario = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pass);

        Button ingersar = (Button) findViewById(R.id.button2);
        ingersar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idColectivo = checkLogin(usuario.getText().toString(),
                                            password.getText().toString());
            }
        });

    }

    private  Integer checkLogin(String user , String pass){
        AesCbcWithIntegrity.CipherTextIvMac cipherTextIvMac = AesCbcWithIntegrity.encrypt("some test", keys);
        //store or send to server
        String ciphertextString = cipherTextIvMac.toString();

        Log.d("encriptacion" , decrypted);
        /*
        if (BCrypt.checkpw(pass, hashed))
            Log.d("encriptacion" , "It matches");
        else
          */  Log.d("encriptacion" , "It does not match");



        return  0;
    }
}
