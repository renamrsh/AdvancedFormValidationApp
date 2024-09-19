package com.example.advancedformvalidationapp;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextImie;
    private EditText editTextNazwisko;
    private EditText editTextEmail;
    private EditText editTextNnumerTelefonu;
    private EditText editTextHaslo;
    private EditText editTextPodtwHasla;
    private Button buttonWyslij;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextImie = findViewById(R.id.Imie);
        editTextNazwisko = findViewById(R.id.Nazwisko);
        editTextEmail = findViewById(R.id.Email);
        editTextNnumerTelefonu = findViewById(R.id.NumerTelefonu);
        editTextHaslo = findViewById(R.id.Haslo);
        editTextPodtwHasla = findViewById(R.id.PodtwHasla);
        buttonWyslij = findViewById(R.id.Przycisk);

        buttonWyslij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String imie = editTextImie.getText().toString().trim();
                String nazwisko = editTextNazwisko.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String numberTelefonu = editTextNnumerTelefonu.getText().toString().trim();
                String haslo = editTextHaslo.getText().toString().trim();
                String podtwHasla = editTextPodtwHasla.getText().toString().trim();

                if(imie.isEmpty()||nazwisko.isEmpty()){
                    Toast.makeText(MainActivity.this, "Prosze wprowadzić Imie i Nazwisko", Toast.LENGTH_SHORT).show();
                }else if(email.isEmpty()){
                    Toast.makeText(MainActivity.this, "Prosze wprowadzić adres e-mail", Toast.LENGTH_SHORT).show();
                }else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(MainActivity.this, "Niepoprawny adres e-mail", Toast.LENGTH_SHORT).show();
                }else if(numberTelefonu.length()<9){
                    Toast.makeText(MainActivity.this, "Numer telefonu powinien zawierac conajmniej 9 znakow", Toast.LENGTH_SHORT).show();
                }else if(haslo.length()<6){
                    Toast.makeText(MainActivity.this, "Haslo powinno zawierac conajmniej 6 znakow", Toast.LENGTH_SHORT).show();
                }else if(!haslo.equals(podtwHasla)){
                    Toast.makeText(MainActivity.this, "Hasla nie zgadzają się", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(MainActivity.this, "Formularz przeslany poprawnie", Toast.LENGTH_SHORT).show();
                    editTextImie.setText("");
                    editTextNazwisko.setText("");
                    editTextEmail.setText("");
                    editTextNnumerTelefonu.setText("");
                    editTextHaslo.setText("");
                    editTextPodtwHasla.setText("");
                }
            }
        });
    }
}