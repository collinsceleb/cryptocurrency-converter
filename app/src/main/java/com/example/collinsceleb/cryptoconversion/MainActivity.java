package com.example.collinsceleb.cryptoconversion;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    CustomAdapter customAdapter;
    ProgressDialog loading;
    ProgressBar load;
    List<CryptoCurrency> cryptoCurrency;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!isDeviceConnected(MainActivity.this)) buildDialog(MainActivity.this).show();

        recyclerView = (RecyclerView) findViewById(R.id.currency_each);
        recyclerView.setHasFixedSize(true);
        load = (ProgressBar) findViewById(R.id.loading);
        loading = new ProgressDialog(MainActivity.this);

        cryptoCurrency = new ArrayList<>();

        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.refresh);
        setSwipeRefreshLayout();
        addOnScrollListener();
        new myTask().execute();
    }
    // Setting the connectivity of the device
    public boolean isDeviceConnected(Context context){
        ConnectivityManager connect = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo dNetInfo = connect.getActiveNetworkInfo();
        return dNetInfo != null && dNetInfo.isConnected();
    }

    // Building the alert dialog for the connectivity
    public AlertDialog.Builder buildDialog(Context c){
        AlertDialog.Builder builder = new AlertDialog.Builder(c);

        // Title of the connectivity
        builder.setTitle("Internet Connection Error");

        // Message of the connectivity
        builder.setMessage("Check your internet connection, \"OK\" to EXIT");

        // Image to determine its connectivity
        builder.setIcon(R.drawable.no_connection);


        // Set a button to exit the UI after a connection fails
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(0);
            }
        });
        return builder;
    }

    private class myTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            super.onPreExecute();
            loading.setMessage("Loading...");
            loading.setCancelable(false);
            loading.show();
        }

        @Override

        // Requesting the URL to populate the data form the API
        protected String doInBackground(String... urls) {
            OkHttpClient client = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            builder.url("https://min-api.cryptocompare.com/data/pricemulti?fsyms=ETH,BTC&tsyms=USD,CAD,EUR,GBP,NGN,CNY,GHS,INR,JPY,NZD,NOK,QAR,SAR,ZAR,KRW,RUB,SEK,CHF,AED,CLP=");
            Request request = builder.build();

            try {


                Response response = client.newCall(request).execute();
                String responseData = response.body().string();

                JSONObject output = new JSONObject(responseData);
                JSONObject ETH = output.getJSONObject("ETH");



                    // JSON response for the country currency codes
                    String USDCode = ETH.getString("USD");

                    String CADCode = ETH.getString("CAD");

                    String EURCode = ETH.getString("EUR");

                    String GBPCode = ETH.getString("GBP");

                    String NGNCode = ETH.getString("NGN");

                    String CNYCode = ETH.getString("CNY");

                    String GHSCode = ETH.getString("GHS");

                    String INRCode = ETH.getString("INR");

                    String JPYCode = ETH.getString("JPY");

                    String NZDCode = ETH.getString("NZD");

                    String NOKCode = ETH.getString("NOK");

                    String QARCode = ETH.getString("QAR");

                    String SARCode = ETH.getString("SAR");

                    String ZARCode = ETH.getString("ZAR");

                    String KRWCode = ETH.getString("KRW");

                    String RUBCode = ETH.getString("RUB");

                    String SEKCode = ETH.getString("SEK");

                    String CHFCode = ETH.getString("CHF");

                    String AEDCode = ETH.getString("AED");

                    String CLPCode = ETH.getString("CLP");

                // JSON response for BTC currency
                JSONObject BTC = output.getJSONObject("BTC");

                String USD = BTC.getString("USD");

                String CAD = BTC.getString("CAD");

                String EUR = BTC.getString("EUR");

                String GBP = BTC.getString("GBP");

                String NGN = BTC.getString("NGN");

                String CNY = BTC.getString("CNY");

                String GHS = BTC.getString("GHS");

                String INR = BTC.getString("INR");

                String JPY = BTC.getString("JPY");

                String NZD = BTC.getString("NZD");

                String NOK = BTC.getString("NOK");

                String QAR = BTC.getString("QAR");

                String SAR = BTC.getString("SAR");

                String ZAR = BTC.getString("ZAR");

                String KRW = BTC.getString("KRW");

                String RUB = BTC.getString("RUB");

                String SEK = BTC.getString("SEK");

                String CHF = BTC.getString("CHF");

                String AED = BTC.getString("AED");

                String CLP = BTC.getString("CLP");



                CryptoCurrency CryptoCurrency = new CryptoCurrency(USDCode, CADCode, EURCode, GBPCode, NGNCode, CNYCode, GHSCode, INRCode, JPYCode, NZDCode, NOKCode, QARCode, SARCode, ZARCode, KRWCode, RUBCode, SEKCode, CHFCode, AEDCode, CLPCode, USD, CAD, EUR, GBP, NGN, CNY, GHS, INR, JPY, NZD, NOK, QAR, SAR, ZAR, KRW, RUB, SEK, CHF, AED, CLP);
                    cryptoCurrency.add(CryptoCurrency);
                }catch (IOException e) {
                e.printStackTrace();
                return e.toString();
            }catch (JSONException e){
                e.getMessage();
                return e.toString();
            }
            return null;


        }
        @Override
        protected void onPostExecute(String s) {
            loading.dismiss();
            recyclerView = (RecyclerView) findViewById(R.id.currency_each);
            //set Adapter
            customAdapter = new CustomAdapter(MainActivity.this, cryptoCurrency);
            recyclerView.setAdapter(customAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

            customAdapter.notifyDataSetChanged();
        }

    }



    public void setSwipeRefreshLayout() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new myTask().execute();
            }
        });
    }
    public void addOnScrollListener(){
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(!recyclerView.canScrollVertically(1)) {
                    loading.dismiss();
                    new myTask().execute();
                }
            }
        });
    }
}
