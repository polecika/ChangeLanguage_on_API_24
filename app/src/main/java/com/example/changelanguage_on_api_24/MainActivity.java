package com.example.changelanguage_on_api_24;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerChangeLanguage;
    private Button okBtn;
    private static boolean changeLanguaceBoolean = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      /*  ArrayAdapter<?> adapter =
                ArrayAdapter.createFromResource(this, R.array.change_language_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerChangeLanguage.setAdapter(adapter);
        spinnerChangeLanguage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


            }

        });*/
        okBtn = findViewById(R.id.okBtn);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinnerChangeLanguage = findViewById(R.id.spinner);
                int selected = spinnerChangeLanguage.getSelectedItemPosition();
                if (selected == 0) {
                    Locale locale = new Locale("ru");
                    Configuration config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                    Toast.makeText(MainActivity.this, R.string.tostLanguage, Toast.LENGTH_SHORT).show();
                } else if (selected == 1) {
                    Locale locale = new Locale("en");
                    Configuration config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    Toast.makeText(MainActivity.this, R.string.tostLanguage, Toast.LENGTH_SHORT).show();
                    recreate();
                }
            }
        });
    }
}