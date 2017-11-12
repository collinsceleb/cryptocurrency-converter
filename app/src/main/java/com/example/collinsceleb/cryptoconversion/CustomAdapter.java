package com.example.collinsceleb.cryptoconversion;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Collinsceleb on 10/24/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private Context context;
    private List<CryptoCurrency> cryptoCurrencyList;

    public CustomAdapter(Context context, List<CryptoCurrency> cryptoCurrencyList) {
        this.context = context;
        this.cryptoCurrencyList = cryptoCurrencyList;
    }

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }
    @Override
    public int getItemCount() {
        return cryptoCurrencyList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView country_codes;


        public ViewHolder (View v){
            super(v);
            country_codes = (TextView) itemView.findViewById(R.id.country_codes);

        }
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final CryptoCurrency eachCryptoCurrency = cryptoCurrencyList.get(position);

        holder.country_codes.setText(eachCryptoCurrency.USD);

        holder.country_codes.setText(eachCryptoCurrency.CAD);

        holder.country_codes.setText(eachCryptoCurrency.EUR);

        holder.country_codes.setText(eachCryptoCurrency.GBP);

        holder.country_codes.setText(eachCryptoCurrency.NGN);

        holder.country_codes.setText(eachCryptoCurrency.GHS);

        holder.country_codes.setText(eachCryptoCurrency.CNY);

        holder.country_codes.setText(eachCryptoCurrency.INR);

        holder.country_codes.setText(eachCryptoCurrency.JPY);

        holder.country_codes.setText(eachCryptoCurrency.NZD);

        holder.country_codes.setText(eachCryptoCurrency.NOK);

        holder.country_codes.setText(eachCryptoCurrency.QAR);

        holder.country_codes.setText(eachCryptoCurrency.RUB);
        holder.country_codes.setText(eachCryptoCurrency.SAR);
        holder.country_codes.setText(eachCryptoCurrency.SEK);
        holder.country_codes.setText(eachCryptoCurrency.AED);
        holder.country_codes.setText(eachCryptoCurrency.KRW);
        holder.country_codes.setText(eachCryptoCurrency.ZAR);
        holder.country_codes.setText(eachCryptoCurrency.CHF);
        holder.country_codes.setText(eachCryptoCurrency.CLP);


    }
}
