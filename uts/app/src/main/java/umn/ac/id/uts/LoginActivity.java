package umn.ac.id.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.BreakIterator;

public class LoginActivity extends AppCompatActivity {

    private EditText etIsian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etIsian = findViewById(R.id.inputa);

        Button input = findViewById(R.id.input);

        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenta = new Intent(LoginActivity.this, LibraryActivity.class );
                String isian = etIsian.getText().toString();
                if(etIsian.getText().length() == 0){
                    etIsian.setError("Harap Di-isi");
                }else{
                    intenta.putExtra("InputName", isian);
                    Toast.makeText(getBaseContext(), "Selamat datang, "+isian, Toast.LENGTH_SHORT).show();
                    startActivity(intenta);
                }

            }
        });
    }
}