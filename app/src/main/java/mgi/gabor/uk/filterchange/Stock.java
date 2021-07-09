package mgi.gabor.uk.filterchange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Stock extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    private TextView tvBioBoostCount, tvBioBoostEnough;
    private int bioBoostCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);

        sharedPreferences = getSharedPreferences("sp", MODE_PRIVATE);

        tvBioBoostCount = findViewById(R.id.bioBoostCount);
        tvBioBoostEnough = findViewById(R.id.bioBoostEnough);
        ImageView ivBioBoostPlus = findViewById(R.id.bioBoostPlus);
        ImageView ivBioBoostMinus = findViewById(R.id.bioBoostMinus);

        updateFromShared();

        ivBioBoostPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bioBoostCount++;
                saveShared();
                updateBioBoost();
            }
        });
        ivBioBoostMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bioBoostCount > 0) {
                    bioBoostCount--;
                    saveShared();
                    updateBioBoost();
                }
            }
        });

    }

    private void updateFromShared() {
        bioBoostCount = sharedPreferences.getInt("bioBoostCount", 0);
        updateBioBoost();
    }


    private void saveShared() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("bioBoostCount", bioBoostCount);

        editor.apply();

    }

    private void updateBioBoost() {
        if (bioBoostCount <2 ) {
            tvBioBoostEnough.setBackgroundResource(R.drawable.red_alert);
        } else {

            tvBioBoostEnough.setBackgroundResource(R.color.m);
        }
        tvBioBoostCount.setText(String.valueOf(bioBoostCount));
        tvBioBoostEnough.setText(String.valueOf(bioBoostCount));
    }
}