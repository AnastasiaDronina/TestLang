package org.anastdronina.testlanguages;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Spinner mSpinner;
    private Locale mLocale;
    private TextView mString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpinner = findViewById(R.id.spinner);
        mString = findViewById(R.id.stringHi);

        List<String> languages = new ArrayList<>();

        languages.add("Choose language");
        languages.add("English");
        languages.add("Русский");
        languages.add("Español");
        languages.add("Français");
        languages.add("ไทย");
        languages.add("Chinese");

        ArrayAdapter<String> adapter
                = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        setLocale("en");
                        break;
                    case 2:
                        setLocale("ru");
                        break;
                    case 3:
                        setLocale("es");
                        break;
                    case 4:
                        setLocale("fr");
                        break;
                    case 5:
                        setLocale("th");
                        break;
                    case 6:
                        setLocale("zh");
                    default:
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void setLocale(String locale) {
        mLocale = new Locale(locale);

        Locale.setDefault(mLocale);
        Configuration config = new Configuration();
        config.locale = mLocale;

        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());

        if(getString(R.string.hi).length() < 1){
            Toast.makeText(getApplicationContext(), "There's no string resourse for that language", Toast.LENGTH_SHORT).show();
        } else {
            mString.setText(R.string.hi);
        }
    }
}
