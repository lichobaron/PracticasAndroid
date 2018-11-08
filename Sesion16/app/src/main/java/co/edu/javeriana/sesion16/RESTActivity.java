package co.edu.javeriana.sesion16;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RESTActivity extends AppCompatActivity {

    LinearLayout restList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest);

        restList = findViewById(R.id.llRestList);

        String x = getIntent().getStringExtra("type");
        consumeRESTVolley(x);

    }

    public void consumeRESTVolley(String type){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://restcountries.eu/rest/v2/";
        String path = "";
        String query = "";

        if(type.equals("type1")){
            path = "regionalbloc/eu";
            query = "?fields=name;capital";
            StringRequest req = new StringRequest(Request.Method.GET, url+path+query,
                    new Response.Listener() {
                        @Override
                        public void onResponse(Object response) {
                            String data = (String)response;
                            try {
                                JSONArray countries = new JSONArray(data);
                                for(int i=0; i<countries.length(); i++)
                                {
                                    JSONObject jo = (JSONObject) countries.get(i);
                                    Log.d("TAG", "Json Object "+jo.toString());
                                    String name = (String)jo.get("name");
                                    String capital = (String) jo.get("capital");
                                    TextView tv = new TextView(RESTActivity.this);
                                    tv.setText(name+" -- > "+capital);
                                    restList.addView(tv);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.i("TAG", "Error handling rest invocation"+error.getCause());
                        }
                    }
            );
            queue.add(req);
        }
        else if(type.equals("type2")){
            path = "currency/jpy";
            query = "?fields=name;capital;population";
            StringRequest req = new StringRequest(Request.Method.GET, url+path+query,
                    new Response.Listener() {
                        @Override
                        public void onResponse(Object response) {
                            String data = (String)response;
                            try {
                                JSONArray countries = new JSONArray(data);
                                for(int i=0; i<countries.length(); i++)
                                {
                                    JSONObject jo = (JSONObject) countries.get(i);
                                    Log.d("TAG", "Json Object "+jo.toString());
                                    String name = (String)jo.get("name");
                                    String capital = (String) jo.get("capital");
                                    Integer population = (Integer) jo.get("population");
                                    TextView tv = new TextView(RESTActivity.this);
                                    tv.setText(name+" -- > "+capital+" --> " + population);
                                    restList.addView(tv);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.i("TAG", "Error handling rest invocation"+error.getCause());
                        }
                    }
            );
            queue.add(req);
        }
        else if(type.equals("type3")){
            path = "lang/fr";
            query = "?fields=name";
            StringRequest req = new StringRequest(Request.Method.GET, url+path+query,
                    new Response.Listener() {
                        @Override
                        public void onResponse(Object response) {
                            String data = (String)response;
                            try {
                                JSONArray countries = new JSONArray(data);
                                for(int i=0; i<countries.length(); i++)
                                {
                                    JSONObject jo = (JSONObject) countries.get(i);
                                    Log.d("TAG", "Json Object "+jo.toString());
                                    String name = (String)jo.get("name");
                                    TextView tv = new TextView(RESTActivity.this);
                                    tv.setText(name);
                                    restList.addView(tv);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.i("TAG", "Error handling rest invocation"+error.getCause());
                        }
                    }
            );
            queue.add(req);
        }
    }
}
