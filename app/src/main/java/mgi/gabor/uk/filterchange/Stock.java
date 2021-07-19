package mgi.gabor.uk.filterchange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Stock extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    private TextView tvBioPadCount, tvBioPadEnough;
    private int bioPadCount;
    private TextView tvBioCarbCount, tvBioCarbEnough;
    private int bioCarbCount;
    private TextView tvBioNitraxCount, tvBioNitraxEnough;
    private int bioNitraxCount;
    private TextView tvBioCoarseCount, tvBioCoarseEnough;
    private int bioCoarseCount;
    private TextView tvBioFineCount, tvBioFineEnough;
    private int bioFineCount;
    private TextView tvBioBoostCount, tvBioBoostEnough;
    private int bioBoostCount;
    private TextView tvCarbaxCount, tvCarbaxEnough;
    private int carbaxCount;
    private TextView tvCiraxCount, tvCiraxEnough;
    private int ciraxCount;
    private TextView tvPhoraxCount, tvPhoraxEnough;
    private int phoraxCount;
    private TextView tvAmoraxCount, tvAmoraxEnough;
    private int amoraxCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);

        sharedPreferences = getSharedPreferences("sp", MODE_PRIVATE);

        tvBioPadCount = findViewById(R.id.bioPadCount);
        tvBioPadEnough = findViewById(R.id.bioPadEnough);
        ImageView ivBioPadPlus = findViewById(R.id.bioPadPlus);
        ImageView ivBioPadMinus = findViewById(R.id.bioPadMinus);

        tvBioCarbCount = findViewById(R.id.bioCarbCount);
        tvBioCarbEnough = findViewById(R.id.bioCarbEnough);
        ImageView ivBioCarbPlus = findViewById(R.id.bioCarbPlus);
        ImageView ivBioCarbMinus = findViewById(R.id.bioCarbMinus);

        tvBioNitraxCount = findViewById(R.id.bioNitraxCount);
        tvBioNitraxEnough = findViewById(R.id.bioNitraxEnough);
        ImageView ivBioNitraxPlus = findViewById(R.id.bioNitraxPlus);
        ImageView ivBioNitraxMinus = findViewById(R.id.bioNitraxMinus);

        tvBioCoarseCount = findViewById(R.id.bioCoarseCount);
        tvBioCoarseEnough = findViewById(R.id.bioCoarseEnough);
        ImageView ivBioCoarsePlus = findViewById(R.id.bioCoarsePlus);
        ImageView ivBioCoarseMinus = findViewById(R.id.bioCoarseMinus);

        tvBioFineCount = findViewById(R.id.bioFineCount);
        tvBioFineEnough = findViewById(R.id.bioFineEnough);
        ImageView ivBioFinePlus = findViewById(R.id.bioFinePlus);
        ImageView ivBioFineMinus = findViewById(R.id.bioFineMinus);

        tvBioBoostCount = findViewById(R.id.bioBoostCount);
        tvBioBoostEnough = findViewById(R.id.bioBoostEnough);
        ImageView ivBioBoostPlus = findViewById(R.id.bioBoostPlus);
        ImageView ivBioBoostMinus = findViewById(R.id.bioBoostMinus);

        tvCarbaxCount = findViewById(R.id.CarbaxCount);
        tvCarbaxEnough = findViewById(R.id.CarbaxEnough);
        ImageView ivCarbaxPlus = findViewById(R.id.CarbaxPlus);
        ImageView ivCarbaxMinus = findViewById(R.id.CarbaxMinus);

        tvCiraxCount = findViewById(R.id.CiraxCount);
        tvCiraxEnough = findViewById(R.id.CiraxEnough);
        ImageView ivCiraxPlus = findViewById(R.id.CiraxPlus);
        ImageView ivCiraxMinus = findViewById(R.id.CiraxMinus);

        tvPhoraxCount = findViewById(R.id.PhoraxCount);
        tvPhoraxEnough = findViewById(R.id.PhoraxEnough);
        ImageView ivPhoraxPlus = findViewById(R.id.PhoraxPlus);
        ImageView ivPhoraxMinus = findViewById(R.id.PhoraxMinus);

        tvAmoraxCount = findViewById(R.id.AmoraxCount);
        tvAmoraxEnough = findViewById(R.id.AmoraxEnough);
        ImageView ivAmoraxPlus = findViewById(R.id.AmoraxPlus);
        ImageView ivAmoraxMinus = findViewById(R.id.AmoraxMinus);


        updateFromShared();

        ivBioPadPlus.setOnClickListener(v -> {
            bioPadCount++;
            saveShared("bioPadCount", bioPadCount);
            updateUI(bioPadCount, bioPadCount / 4, tvBioPadCount, tvBioPadEnough);
        });
        ivBioPadMinus.setOnClickListener(v -> {
            if (bioPadCount > 0) {
                bioPadCount--;
                saveShared("bioPadCount", bioPadCount);
                updateUI(bioPadCount, bioPadCount / 4, tvBioPadCount, tvBioPadEnough);
            }
        });

        ivBioCarbPlus.setOnClickListener(v -> {
            bioCarbCount++;
            saveShared("bioCarbCount", bioCarbCount);
            updateUI(bioCarbCount, bioCarbCount, tvBioCarbCount, tvBioCarbEnough);
        });
        ivBioCarbMinus.setOnClickListener(v -> {
            if (bioCarbCount > 0) {
                bioCarbCount--;
                saveShared("bioCarbCount", bioCarbCount);
                updateUI(bioCarbCount, bioCarbCount, tvBioCarbCount, tvBioCarbEnough);
            }
        });

        ivBioNitraxPlus.setOnClickListener(v -> {
            bioNitraxCount++;
            saveShared("bioNitraxCount", bioNitraxCount);
            updateUI(bioNitraxCount, bioNitraxCount * 2, tvBioNitraxCount, tvBioNitraxEnough);
        });
        ivBioNitraxMinus.setOnClickListener(v -> {
            if (bioNitraxCount > 0) {
                bioNitraxCount--;
                saveShared("bioNitraxCount", bioNitraxCount);
                updateUI(bioNitraxCount, bioNitraxCount * 2, tvBioNitraxCount, tvBioNitraxEnough);
            }
        });

        ivBioCoarsePlus.setOnClickListener(v -> {
            bioCoarseCount++;
            saveShared("bioCoarseCount", bioCoarseCount);
            updateUI(bioCoarseCount, bioCoarseCount * 3, tvBioCoarseCount, tvBioCoarseEnough);
        });
        ivBioCoarseMinus.setOnClickListener(v -> {
            if (bioCoarseCount > 0) {
                bioCoarseCount--;
                saveShared("bioCoarseCount", bioCoarseCount);
                updateUI(bioCoarseCount, bioCoarseCount * 3, tvBioCoarseCount, tvBioCoarseEnough);
            }
        });

        ivBioFinePlus.setOnClickListener(v -> {
            bioFineCount++;
            saveShared("bioFineCount", bioFineCount);
            updateUI(bioFineCount, bioFineCount * 9, tvBioFineCount, tvBioFineEnough);
        });
        ivBioFineMinus.setOnClickListener(v -> {
            if (bioFineCount > 0) {
                bioFineCount--;
                saveShared("bioFineCount", bioFineCount);
                updateUI(bioFineCount, bioFineCount * 9, tvBioFineCount, tvBioFineEnough);
            }
        });

        ivBioBoostPlus.setOnClickListener(v -> {
            bioBoostCount++;
            saveShared("bioBoostCount", bioBoostCount);
            updateUI(bioBoostCount, bioBoostCount, tvBioBoostCount, tvBioBoostEnough);
        });
        ivBioBoostMinus.setOnClickListener(v -> {
            if (bioBoostCount > 0) {
                bioBoostCount--;
                saveShared("bioBoostCount", bioBoostCount);
                updateUI(bioBoostCount, bioBoostCount, tvBioBoostCount, tvBioBoostEnough);
            }
        });

        ivCarbaxPlus.setOnClickListener(v -> {
            carbaxCount++;
            saveShared("carbaxCount", carbaxCount);
            updateUI(carbaxCount, carbaxCount * 2, tvCarbaxCount, tvCarbaxEnough);
        });
        ivCarbaxMinus.setOnClickListener(v -> {
            if (carbaxCount > 0) {
                carbaxCount--;
                saveShared("carbaxCount", carbaxCount);
                updateUI(carbaxCount, carbaxCount * 2, tvCarbaxCount, tvCarbaxEnough);
            }
        });

        ivCiraxPlus.setOnClickListener(v -> {
            ciraxCount++;
            saveShared("ciraxCount", ciraxCount);
            updateUI(ciraxCount, ciraxCount * 12, tvCiraxCount, tvCiraxEnough);
        });
        ivCiraxMinus.setOnClickListener(v -> {
            if (ciraxCount > 0) {
                ciraxCount--;
                saveShared("ciraxCount", ciraxCount);
                updateUI(ciraxCount, ciraxCount * 12, tvCiraxCount, tvCiraxEnough);
            }
        });

        ivPhoraxPlus.setOnClickListener(v -> {
            phoraxCount++;
            saveShared("phoraxCount", phoraxCount);
            updateUI(phoraxCount, phoraxCount / 2, tvPhoraxCount, tvPhoraxEnough);
        });
        ivPhoraxMinus.setOnClickListener(v -> {
            if (phoraxCount > 0) {
                phoraxCount--;
                saveShared("phoraxCount", phoraxCount);
                updateUI(phoraxCount, phoraxCount / 2, tvPhoraxCount, tvPhoraxEnough);
            }
        });

        ivAmoraxPlus.setOnClickListener(v -> {
            amoraxCount++;
            saveShared("amoraxCount", amoraxCount);
            updateUI(amoraxCount, amoraxCount * 3, tvAmoraxCount, tvAmoraxEnough);
        });
        ivAmoraxMinus.setOnClickListener(v -> {
            if (amoraxCount > 0) {
                amoraxCount--;
                saveShared("amoraxCount", amoraxCount);
                updateUI(amoraxCount, amoraxCount * 3, tvAmoraxCount, tvAmoraxEnough);
            }
        });


    }

    private void updateFromShared() {
        bioPadCount = sharedPreferences.getInt("bioPadCount", 0);
        updateUI(bioPadCount, bioPadCount / 4, tvBioPadCount, tvBioPadEnough);
        bioCarbCount = sharedPreferences.getInt("bioCarbCount", 0);
        updateUI(bioCarbCount, bioCarbCount, tvBioCarbCount, tvBioCarbEnough);
        bioNitraxCount = sharedPreferences.getInt("bioNitraxCount", 0);
        updateUI(bioNitraxCount, bioNitraxCount * 2, tvBioNitraxCount, tvBioNitraxEnough);
        bioCoarseCount = sharedPreferences.getInt("bioCoarseCount", 0);
        updateUI(bioCoarseCount, bioCoarseCount * 3, tvBioCoarseCount, tvBioCoarseEnough);
        bioFineCount = sharedPreferences.getInt("bioFineCount", 0);
        updateUI(bioFineCount, bioFineCount * 9, tvBioFineCount, tvBioFineEnough);
        bioBoostCount = sharedPreferences.getInt("bioBoostCount", 0);
        updateUI(bioBoostCount, bioBoostCount, tvBioBoostCount, tvBioBoostEnough);
        carbaxCount = sharedPreferences.getInt("carbaxCount", 0);
        updateUI(carbaxCount, carbaxCount * 2, tvCarbaxCount, tvCarbaxEnough);
        ciraxCount = sharedPreferences.getInt("ciraxCount", 0);
        updateUI(ciraxCount, ciraxCount * 12, tvCiraxCount, tvCiraxEnough);
        phoraxCount = sharedPreferences.getInt("phoraxCount", 0);
        updateUI(phoraxCount, phoraxCount / 2, tvPhoraxCount, tvPhoraxEnough);
        amoraxCount = sharedPreferences.getInt("amoraxCount", 0);
        updateUI(amoraxCount, amoraxCount * 3, tvAmoraxCount, tvAmoraxEnough);
    }


    private void saveShared(String name, int count) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(name, count);
        editor.apply();

    }

    private void updateUI(int count, int months, TextView countTextView, TextView enoughTextView) {
        if (months < 2) {
            enoughTextView.setBackgroundResource(R.drawable.red_alert);
        } else {
            enoughTextView.setBackgroundResource(R.color.black);
        }
        countTextView.setText(String.valueOf(count));
        enoughTextView.setText(String.valueOf(months));
    }
}