package com.example.json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity; import android.os.Bundle;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException; import org.json.JSONObject;


    public class MainActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
            TextView JsonSrcTextView = (TextView) findViewById(R.id.tv1); TextView JsonObjectTextView = (TextView) findViewById(R.id.tv2);
            TextView JsonResultTextView = (TextView) findViewById(R.id.tv3); TextView JsonMySiteTextView = (TextView) findViewById(R.id.tv4);
            TextView JsonUrlTextView = (TextView) findViewById(R.id.tv5); String json_source = getString(R.string.simple_json);
            TextView JsonArrayTextView = (TextView) findViewById(R.id.tv6);
            json_source = getString(R.string.simple_json);
            // выводим сырые данные без обработки
            JsonSrcTextView.setText(json_source);
        
            try {
                JSONObject jsonObject = new JSONObject(json_source); JSONObject results = jsonObject.getJSONObject("results");
                String mySiteName = results.getString("sitename"); String myUrl = results.getString("url");
                JsonObjectTextView.setText("jsonObject:\n" + jsonObject.toString()); JsonResultTextView.setText("results:\n" + results.toString()); JsonMySiteTextView.setText("Имя сайта:\n" + mySiteName); JsonUrlTextView.setText("Адрес сайта:\n" + myUrl);
// Получаем данные из массива в JSON
                String stringArrayElement = "\n";
                JSONArray jsonArray = results.getJSONArray("array"); for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject arrayElement = jsonArray.getJSONObject(i);
                    stringArrayElement += arrayElement.getString("element") + "\n";
                }
// выводим данные, полученные из массива
                JsonArrayTextView.setText(stringArrayElement);
            }
            catch (JSONException e) {
                e.printStackTrace(); }
        }


    }