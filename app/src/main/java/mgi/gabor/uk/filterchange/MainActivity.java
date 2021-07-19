package mgi.gabor.uk.filterchange;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView tvBioPadLast;
    TextView tvBioPadNext;
    ImageView ivBioPad;
    Calendar cBioPadL;
    Calendar cBioPadN;

    TextView tvBioCarbLast;
    TextView tvBioCarbNext;
    ImageView ivBioCarb;
    Calendar cBioCarbL;
    Calendar cBioCarbN;

    TextView tvNitraxLast;
    TextView tvNitraxNext;
    ImageView ivNitrax;
    Calendar cNitraxL;
    Calendar cNitraxN;

    TextView tvBioPlusCoarseLast;
    TextView tvBioPlusCoarseNext;
    ImageView ivBioPlusCoarse;
    Calendar cBioPlusCoarseL;
    Calendar cBioPlusCoarseN;

    TextView tvBioPlusFineLast;
    TextView tvBioPlusFineNext;
    ImageView ivBioPlusFine;
    Calendar cBioPlusFineL;
    Calendar cBioPlusFineN;

    TextView tvBioBoostLast;
    TextView tvBioBoostNext;
    ImageView ivBioBoost;
    Calendar cBioBoostL;
    Calendar cBioBoostN;

    TextView tvCarbaxLast;
    TextView tvCarbaxNext;
    ImageView ivCarbax;
    Calendar cCarbaxL;
    Calendar cCarbaxN;

    TextView tvCiraxLast;
    TextView tvCiraxNext;
    ImageView ivCirax;
    Calendar cCiraxL;
    Calendar cCiraxN;

    TextView tvPhoraxLast;
    TextView tvPhoraxNext;
    ImageView ivPhorax;
    Calendar cPhoraxL;
    Calendar cPhoraxN;

    TextView tvAmoraxLast;
    TextView tvAmoraxNext;
    ImageView ivAmorax;
    Calendar cAmoraxL;
    Calendar cAmoraxN;

    final String NONE = "none";
    Drawable drOnTime;
    Drawable drAlert;
    Drawable drLate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("sp", MODE_PRIVATE);

        drOnTime = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_ontime, null);
        drAlert = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_alert, null);
        drLate = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_late, null);

        tvBioPadLast = findViewById(R.id.tvBioPadLast);
        tvBioPadNext = findViewById(R.id.tvBioPadNext);
        ivBioPad = findViewById(R.id.ivBioPad);

        tvBioCarbLast = findViewById(R.id.tvBioCarbLast);
        tvBioCarbNext = findViewById(R.id.tvBioCarbNext);
        ivBioCarb = findViewById(R.id.ivBioCarb);

        tvNitraxLast = findViewById(R.id.tvNitraxLast);
        tvNitraxNext = findViewById(R.id.tvNitraxNext);
        ivNitrax = findViewById(R.id.ivNitrax);

        tvBioPlusCoarseLast = findViewById(R.id.tvBioPlusCoarseLast);
        tvBioPlusCoarseNext = findViewById(R.id.tvBioPlusCoarseNext);
        ivBioPlusCoarse = findViewById(R.id.ivBioPlusCoarse);

        tvBioPlusFineLast = findViewById(R.id.tvBioPlusFineLast);
        tvBioPlusFineNext = findViewById(R.id.tvBioPlusFineNext);
        ivBioPlusFine = findViewById(R.id.ivBioPlusFine);

        tvBioBoostLast = findViewById(R.id.tvBioBoostLast);
        tvBioBoostNext = findViewById(R.id.tvBioBoostNext);
        ivBioBoost = findViewById(R.id.ivBioBoost);

        tvCarbaxLast = findViewById(R.id.tvCarbaxLast);
        tvCarbaxNext = findViewById(R.id.tvCarbaxNext);
        ivCarbax = findViewById(R.id.ivCarbax);

        tvCiraxLast = findViewById(R.id.tvCiraxLast);
        tvCiraxNext = findViewById(R.id.tvCiraxNext);
        ivCirax = findViewById(R.id.ivCirax);

        tvPhoraxLast = findViewById(R.id.tvPhoraxLast);
        tvPhoraxNext = findViewById(R.id.tvPhoraxNext);
        ivPhorax = findViewById(R.id.ivPhorax);

        tvAmoraxLast = findViewById(R.id.tvAmoraxLast);
        tvAmoraxNext = findViewById(R.id.tvAmoraxNext);
        ivAmorax = findViewById(R.id.ivAmorax);

        initFromShared();

        Button btnOpenPicture = findViewById(R.id.btnOpenPicture);
        btnOpenPicture.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, FilterPicture.class)));

        Button btnOpenStock = findViewById(R.id.btnOpenStock);
        btnOpenStock.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Stock.class)));

        tvBioPadLast.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, (view, year110, month110, dayOfMonth) -> {
                cBioPadL.set(Calendar.YEAR, year110);
                cBioPadL.set(Calendar.MONTH, month110);
                cBioPadL.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                cBioPadN.set(Calendar.YEAR, year110);
                cBioPadN.set(Calendar.MONTH, month110);
                cBioPadN.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                cBioPadN.add(Calendar.DATE, 7);
                String currentDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(cBioPadL.getTime());
                String nextDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(cBioPadN.getTime());
                tvBioPadLast.setText(currentDateString);
                tvBioPadNext.setText(nextDateString);
                saveToShared();
                updateDrawable(ivBioPad, cBioPadN);
            }, year, month, day);
            datePickerDialog.show();
        });

        tvBioCarbLast.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, (view, year19, month19, dayOfMonth) -> {
                cBioCarbL.set(Calendar.YEAR, year19);
                cBioCarbL.set(Calendar.MONTH, month19);
                cBioCarbL.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                cBioCarbN.set(Calendar.YEAR, year19);
                cBioCarbN.set(Calendar.MONTH, month19);
                cBioCarbN.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                cBioCarbN.add(Calendar.DATE, 28);
                String currentDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(cBioCarbL.getTime());
                String nextDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(cBioCarbN.getTime());
                tvBioCarbLast.setText(currentDateString);
                tvBioCarbNext.setText(nextDateString);
                saveToShared();
                updateDrawable(ivBioCarb, cBioCarbN);
            }, year, month, day);
            datePickerDialog.show();
        });

        tvNitraxLast.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, (view, year18, month18, dayOfMonth) -> {
                cNitraxL.set(Calendar.YEAR, year18);
                cNitraxL.set(Calendar.MONTH, month18);
                cNitraxL.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                cNitraxN.set(Calendar.YEAR, year18);
                cNitraxN.set(Calendar.MONTH, month18);
                cNitraxN.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                cNitraxN.add(Calendar.DATE, 56);
                String currentDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(cNitraxL.getTime());
                String nextDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(cNitraxN.getTime());
                tvNitraxLast.setText(currentDateString);
                tvNitraxNext.setText(nextDateString);
                saveToShared();
                updateDrawable(ivNitrax, cNitraxN);
            }, year, month, day);
            datePickerDialog.show();
        });

        tvBioPlusCoarseLast.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, (view, year17, month17, dayOfMonth) -> {
                cBioPlusCoarseL.set(Calendar.YEAR, year17);
                cBioPlusCoarseL.set(Calendar.MONTH, month17);
                cBioPlusCoarseL.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                cBioPlusCoarseN.set(Calendar.YEAR, year17);
                cBioPlusCoarseN.set(Calendar.MONTH, month17);
                cBioPlusCoarseN.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                cBioPlusCoarseN.add(Calendar.DATE, 84);
                String currentDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(cBioPlusCoarseL.getTime());
                String nextDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(cBioPlusCoarseN.getTime());
                tvBioPlusCoarseLast.setText(currentDateString);
                tvBioPlusCoarseNext.setText(nextDateString);
                saveToShared();
                updateDrawable(ivBioPlusCoarse, cBioPlusCoarseN);
            }, year, month, day);
            datePickerDialog.show();
        });

        tvBioPlusFineLast.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, (view, year16, month16, dayOfMonth) -> {
                cBioPlusFineL.set(Calendar.YEAR, year16);
                cBioPlusFineL.set(Calendar.MONTH, month16);
                cBioPlusFineL.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                cBioPlusFineN.set(Calendar.YEAR, year16);
                cBioPlusFineN.set(Calendar.MONTH, month16);
                cBioPlusFineN.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                cBioPlusFineN.add(Calendar.DATE, 252);
                String currentDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(cBioPlusFineL.getTime());
                String nextDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(cBioPlusFineN.getTime());
                tvBioPlusFineLast.setText(currentDateString);
                tvBioPlusFineNext.setText(nextDateString);
                saveToShared();
                updateDrawable(ivBioPlusFine, cBioPlusFineN);
            }, year, month, day);
            datePickerDialog.show();
        });

        tvBioBoostLast.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, (view, year15, month15, dayOfMonth) -> {
                cBioBoostL.set(Calendar.YEAR, year15);
                cBioBoostL.set(Calendar.MONTH, month15);
                cBioBoostL.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                cBioBoostN.set(Calendar.YEAR, year15);
                cBioBoostN.set(Calendar.MONTH, month15);
                cBioBoostN.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                cBioBoostN.add(Calendar.DATE, 28);
                String currentDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(cBioBoostL.getTime());
                String nextDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(cBioBoostN.getTime());
                tvBioBoostLast.setText(currentDateString);
                tvBioBoostNext.setText(nextDateString);
                saveToShared();
                updateDrawable(ivBioBoost, cBioBoostN);
            }, year, month, day);
            datePickerDialog.show();
        });

        tvCarbaxLast.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, (view, year14, month14, dayOfMonth) -> {
                cCarbaxL.set(Calendar.YEAR, year14);
                cCarbaxL.set(Calendar.MONTH, month14);
                cCarbaxL.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                cCarbaxN.set(Calendar.YEAR, year14);
                cCarbaxN.set(Calendar.MONTH, month14);
                cCarbaxN.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                cCarbaxN.add(Calendar.DATE, 56);
                String currentDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(cCarbaxL.getTime());
                String nextDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(cCarbaxN.getTime());
                tvCarbaxLast.setText(currentDateString);
                tvCarbaxNext.setText(nextDateString);
                saveToShared();
                updateDrawable(ivCarbax, cCarbaxN);
            }, year, month, day);
            datePickerDialog.show();
        });

        tvCiraxLast.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, (view, year13, month13, dayOfMonth) -> {
                cCiraxL.set(Calendar.YEAR, year13);
                cCiraxL.set(Calendar.MONTH, month13);
                cCiraxL.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                cCiraxN.set(Calendar.YEAR, year13);
                cCiraxN.set(Calendar.MONTH, month13);
                cCiraxN.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                cCiraxN.add(Calendar.DATE, 365);
                String currentDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(cCiraxL.getTime());
                String nextDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(cCiraxN.getTime());
                tvCiraxLast.setText(currentDateString);
                tvCiraxNext.setText(nextDateString);
                saveToShared();
                updateDrawable(ivCirax, cCiraxN);
            }, year, month, day);
            datePickerDialog.show();
        });

        tvPhoraxLast.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, (view, year12, month12, dayOfMonth) -> {
                cPhoraxL.set(Calendar.YEAR, year12);
                cPhoraxL.set(Calendar.MONTH, month12);
                cPhoraxL.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                cPhoraxN.set(Calendar.YEAR, year12);
                cPhoraxN.set(Calendar.MONTH, month12);
                cPhoraxN.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                cPhoraxN.add(Calendar.DATE, 14);
                String currentDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(cPhoraxL.getTime());
                String nextDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(cPhoraxN.getTime());
                tvPhoraxLast.setText(currentDateString);
                tvPhoraxNext.setText(nextDateString);
                saveToShared();
                updateDrawable(ivPhorax, cPhoraxN);
            }, year, month, day);
            datePickerDialog.show();
        });

        tvAmoraxLast.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, (view, year1, month1, dayOfMonth) -> {
                cAmoraxL.set(Calendar.YEAR, year1);
                cAmoraxL.set(Calendar.MONTH, month1);
                cAmoraxL.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                cAmoraxN.set(Calendar.YEAR, year1);
                cAmoraxN.set(Calendar.MONTH, month1);
                cAmoraxN.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                cAmoraxN.add(Calendar.DATE, 84);
                String currentDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(cAmoraxL.getTime());
                String nextDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(cAmoraxN.getTime());
                tvAmoraxLast.setText(currentDateString);
                tvAmoraxNext.setText(nextDateString);
                saveToShared();
                updateDrawable(ivAmorax, cAmoraxN);
            }, year, month, day);
            datePickerDialog.show();
        });

        ivBioBoost.setOnClickListener(v -> deleteOptional(cBioBoostL, cBioBoostN));
        ivCarbax.setOnClickListener(v -> deleteOptional(cCarbaxL, cCarbaxN));
        ivCirax.setOnClickListener(v -> deleteOptional(cCiraxL, cCiraxN));
        ivPhorax.setOnClickListener(v -> deleteOptional(cPhoraxL, cPhoraxN));
        ivAmorax.setOnClickListener(v -> deleteOptional(cAmoraxL, cAmoraxN));


    }

    public void initFromShared() {
        cBioPadL = Calendar.getInstance();
        cBioPadN = Calendar.getInstance();
        cBioPadL.setTimeInMillis(sharedPreferences.getLong("cBioPadL", 0));
        cBioPadN.setTimeInMillis(sharedPreferences.getLong("cBioPadN", 0));

        cBioCarbL = Calendar.getInstance();
        cBioCarbN = Calendar.getInstance();
        cBioCarbL.setTimeInMillis(sharedPreferences.getLong("cBioCarbL", 0));
        cBioCarbN.setTimeInMillis(sharedPreferences.getLong("cBioCarbN", 0));

        cNitraxL = Calendar.getInstance();
        cNitraxN = Calendar.getInstance();
        cNitraxL.setTimeInMillis(sharedPreferences.getLong("cNitraxL", 0));
        cNitraxN.setTimeInMillis(sharedPreferences.getLong("cNitraxN", 0));

        cBioPlusCoarseL = Calendar.getInstance();
        cBioPlusCoarseN = Calendar.getInstance();
        cBioPlusCoarseL.setTimeInMillis(sharedPreferences.getLong("cBioPlusCoarseL", 0));
        cBioPlusCoarseN.setTimeInMillis(sharedPreferences.getLong("cBioPlusCoarseN", 0));

        cBioPlusFineL = Calendar.getInstance();
        cBioPlusFineN = Calendar.getInstance();
        cBioPlusFineL.setTimeInMillis(sharedPreferences.getLong("cBioPlusFineL", 0));
        cBioPlusFineN.setTimeInMillis(sharedPreferences.getLong("cBioPlusFineN", 0));

        cBioBoostL = Calendar.getInstance();
        cBioBoostN = Calendar.getInstance();
        cBioBoostL.setTimeInMillis(sharedPreferences.getLong("cBioBoostL", 0));
        cBioBoostN.setTimeInMillis(sharedPreferences.getLong("cBioBoostN", 0));

        cCarbaxL = Calendar.getInstance();
        cCarbaxN = Calendar.getInstance();
        cCarbaxL.setTimeInMillis(sharedPreferences.getLong("cCarbaxL", 0));
        cCarbaxN.setTimeInMillis(sharedPreferences.getLong("cCarbaxN", 0));

        cCiraxL = Calendar.getInstance();
        cCiraxN = Calendar.getInstance();
        cCiraxL.setTimeInMillis(sharedPreferences.getLong("cCiraxL", 0));
        cCiraxN.setTimeInMillis(sharedPreferences.getLong("cCiraxN", 0));

        cPhoraxL = Calendar.getInstance();
        cPhoraxN = Calendar.getInstance();
        cPhoraxL.setTimeInMillis(sharedPreferences.getLong("cPhoraxL", 0));
        cPhoraxN.setTimeInMillis(sharedPreferences.getLong("cPhoraxN", 0));

        cAmoraxL = Calendar.getInstance();
        cAmoraxN = Calendar.getInstance();
        cAmoraxL.setTimeInMillis(sharedPreferences.getLong("cAmoraxL", 0));
        cAmoraxN.setTimeInMillis(sharedPreferences.getLong("cAmoraxN", 0));

        if (cBioPadL.getTimeInMillis() == 0) {
            tvBioPadLast.setText(NONE);
            tvBioPadNext.setText(NONE);
            ivBioPad.setImageDrawable(null);
        } else {
            tvBioPadLast.setText(dateToText(cBioPadL));
            tvBioPadNext.setText(dateToText(cBioPadN));
            updateDrawable(ivBioPad, cBioPadN);
        }

        if (cBioCarbL.getTimeInMillis() == 0) {
            tvBioCarbLast.setText(NONE);
            tvBioCarbNext.setText(NONE);
            ivBioCarb.setImageDrawable(null);
        } else {
            tvBioCarbLast.setText(dateToText(cBioCarbL));
            tvBioCarbNext.setText(dateToText(cBioCarbN));
            updateDrawable(ivBioCarb, cBioCarbN);
        }

        if (cNitraxL.getTimeInMillis() == 0) {
            tvNitraxLast.setText(NONE);
            tvNitraxNext.setText(NONE);
            ivNitrax.setImageDrawable(null);
        } else {
            tvNitraxLast.setText(dateToText(cNitraxL));
            tvNitraxNext.setText(dateToText(cNitraxN));
            updateDrawable(ivNitrax, cNitraxN);
        }

        if (cBioPlusCoarseL.getTimeInMillis() == 0) {
            tvBioPlusCoarseLast.setText(NONE);
            tvBioPlusCoarseNext.setText(NONE);
            ivBioPlusCoarse.setImageDrawable(null);
        } else {
            tvBioPlusCoarseLast.setText(dateToText(cBioPlusCoarseL));
            tvBioPlusCoarseNext.setText(dateToText(cBioPlusCoarseN));
            updateDrawable(ivBioPlusCoarse, cBioPlusCoarseN);
        }

        if (cBioPlusFineL.getTimeInMillis() == 0) {
            tvBioPlusFineLast.setText(NONE);
            tvBioPlusFineNext.setText(NONE);
            ivBioPlusFine.setImageDrawable(null);
        } else {
            tvBioPlusFineLast.setText(dateToText(cBioPlusFineL));
            tvBioPlusFineNext.setText(dateToText(cBioPlusFineN));
            updateDrawable(ivBioPlusFine, cBioPlusFineN);
        }

        if (cBioBoostL.getTimeInMillis() == 0) {
            tvBioBoostLast.setText(NONE);
            tvBioBoostNext.setText(NONE);
            ivBioBoost.setImageDrawable(null);
        } else {
            tvBioBoostLast.setText(dateToText(cBioBoostL));
            tvBioBoostNext.setText(dateToText(cBioBoostN));
            updateDrawable(ivBioBoost, cBioBoostN);
        }

        if (cCarbaxL.getTimeInMillis() == 0) {
            tvCarbaxLast.setText(NONE);
            tvCarbaxNext.setText(NONE);
            ivCarbax.setImageDrawable(null);
        } else {
            tvCarbaxLast.setText(dateToText(cCarbaxL));
            tvCarbaxNext.setText(dateToText(cCarbaxN));
            updateDrawable(ivCarbax, cCarbaxN);
        }

        if (cCiraxL.getTimeInMillis() == 0) {
            tvCiraxLast.setText(NONE);
            tvCiraxNext.setText(NONE);
            ivCirax.setImageDrawable(null);
        } else {
            tvCiraxLast.setText(dateToText(cCiraxL));
            tvCiraxNext.setText(dateToText(cCiraxN));
            updateDrawable(ivCirax, cCiraxN);
        }

        if (cPhoraxL.getTimeInMillis() == 0) {
            tvPhoraxLast.setText(NONE);
            tvPhoraxNext.setText(NONE);
            ivPhorax.setImageDrawable(null);
        } else {
            tvPhoraxLast.setText(dateToText(cPhoraxL));
            tvPhoraxNext.setText(dateToText(cPhoraxN));
            updateDrawable(ivPhorax, cPhoraxN);
        }

        if (cAmoraxL.getTimeInMillis() == 0) {
            tvAmoraxLast.setText(NONE);
            tvAmoraxNext.setText(NONE);
            ivAmorax.setImageDrawable(null);
        } else {
            tvAmoraxLast.setText(dateToText(cAmoraxL));
            tvAmoraxNext.setText(dateToText(cAmoraxN));
            updateDrawable(ivAmorax, cAmoraxN);
        }

    }

    public void saveToShared() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong("cBioPadL", cBioPadL.getTimeInMillis());
        editor.putLong("cBioPadN", cBioPadN.getTimeInMillis());
        editor.putLong("cBioCarbL", cBioCarbL.getTimeInMillis());
        editor.putLong("cBioCarbN", cBioCarbN.getTimeInMillis());
        editor.putLong("cNitraxL", cNitraxL.getTimeInMillis());
        editor.putLong("cNitraxN", cNitraxN.getTimeInMillis());
        editor.putLong("cBioPlusCoarseL", cBioPlusCoarseL.getTimeInMillis());
        editor.putLong("cBioPlusCoarseN", cBioPlusCoarseN.getTimeInMillis());
        editor.putLong("cBioPlusFineL", cBioPlusFineL.getTimeInMillis());
        editor.putLong("cBioPlusFineN", cBioPlusFineN.getTimeInMillis());
        editor.putLong("cBioBoostL", cBioBoostL.getTimeInMillis());
        editor.putLong("cBioBoostN", cBioBoostN.getTimeInMillis());
        editor.putLong("cCarbaxL", cCarbaxL.getTimeInMillis());
        editor.putLong("cCarbaxN", cCarbaxN.getTimeInMillis());
        editor.putLong("cCiraxL", cCiraxL.getTimeInMillis());
        editor.putLong("cCiraxN", cCiraxN.getTimeInMillis());
        editor.putLong("cPhoraxL", cPhoraxL.getTimeInMillis());
        editor.putLong("cPhoraxN", cPhoraxN.getTimeInMillis());
        editor.putLong("cAmoraxL", cAmoraxL.getTimeInMillis());
        editor.putLong("cAmoraxN", cAmoraxN.getTimeInMillis());

        editor.apply();

    }

    private void updateDrawable(ImageView imageView, Calendar calendar) {
        long threeDays = 259200000;
        Calendar today = Calendar.getInstance();
        today.setTime(new Date());

        if (today.getTimeInMillis() + threeDays < calendar.getTimeInMillis()) {
            imageView.setImageDrawable(drOnTime);
        }
        if (today.getTimeInMillis() + threeDays >= calendar.getTimeInMillis()) {
            imageView.setImageDrawable(drAlert);
        }
        if (today.getTimeInMillis() > calendar.getTimeInMillis()) {
            imageView.setImageDrawable(drLate);
        }
    }

    public void deleteOptional(Calendar calendar1, Calendar calendar2) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setCancelable(false)
                .setTitle("Delete date")
                .setMessage("Are you sure?")
                .setNeutralButton("No, cancel", null)
                .setPositiveButton("Yes, please", (dialog, which) -> {
                    calendar1.setTimeInMillis(0);
                    calendar2.setTimeInMillis(0);
                    saveToShared();
                    initFromShared();
                })
                .create().show();
    }

    public String dateToText(Calendar calendar) {
        return DateFormat.getDateInstance(DateFormat.SHORT).format(calendar.getTime());
    }
}