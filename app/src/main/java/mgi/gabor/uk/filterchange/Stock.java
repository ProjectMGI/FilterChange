package mgi.gabor.uk.filterchange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Stock extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    private TextView tvBioPadCount, tvBioPadEnough;
    private int bioPadCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);

        sharedPreferences = getSharedPreferences("sp", MODE_PRIVATE);

        tvBioPadCount = findViewById(R.id.bioPadCount);
        tvBioPadEnough = findViewById(R.id.bioPadEnough);
        ImageView ivBioBoostPlus = findViewById(R.id.bioPadPlus);
        ImageView ivBioBoostMinus = findViewById(R.id.bioPadMinus);

        updateFromShared();

        ivBioBoostPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bioPadCount++;
                saveShared();
                updateUI(bioPadCount, tvBioPadCount, tvBioPadEnough);
            }
        });
        ivBioBoostMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bioPadCount > 0) {
                    bioPadCount--;
                    saveShared();
                    updateUI(bioPadCount, tvBioPadCount, tvBioPadEnough);
                }
            }
        });

    }

    private void updateFromShared() {
        bioPadCount = sharedPreferences.getInt("bioPadCount", 0);
        // TODO: 15/07/2021 fix it for all updateUI(); red for alert may already in update
    }


    private void saveShared() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("bioPadCount", bioPadCount);

        editor.apply();

    }

    private void updateUI(int count, TextView countTextView, TextView enoughTextView) {
        if (count < 2) {
            enoughTextView.setBackgroundResource(R.drawable.red_alert);
        } else {

            enoughTextView.setBackgroundResource(R.color.black);
        }
        countTextView.setText(String.valueOf(bioPadCount));
        enoughTextView.setText(String.valueOf(bioPadCount));
    }
}