package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    private TextView tvDot, tvZero, tvBack, tvEgale, tvUn, tvDeux, tvTrois,
            tvPlus, tvQuatre, tvCinq, tvSix, tvSet, tvMoin, tvHuit, tvNeuf,
            tvFois, tvCE, tvAwes, tvAsa, tvSur;
    private TextView tvResult, tvExpression;
    private String ch = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvExpression = findViewById(R.id.tvExpression);
        tvResult = findViewById(R.id.tvResult);

        tvZero = findViewById(R.id.tvZero);
        tvUn = findViewById(R.id.tvUn);
        tvDeux = findViewById(R.id.tvDeux);
        tvTrois = findViewById(R.id.tvTrois);
        tvQuatre = findViewById(R.id.tvQuatre);
        tvCinq = findViewById(R.id.tvCinq);
        tvSix = findViewById(R.id.tvSix);
        tvSet = findViewById(R.id.tvSet);
        tvHuit = findViewById(R.id.tvHuit);
        tvNeuf = findViewById(R.id.tvNeuf);

        tvEgale = findViewById(R.id.tvEgale);
        tvPlus = findViewById(R.id.tvPlus);
        tvMoin = findViewById(R.id.tvMoin);
        tvFois = findViewById(R.id.tvFois);
        tvSur = findViewById(R.id.tvSur);

        tvCE = findViewById(R.id.tvCE);
        tvAwes = findViewById(R.id.tvAwes);
        tvAsa = findViewById(R.id.tvAsa);
        tvDot = findViewById(R.id.tvDot);
        tvBack = findViewById(R.id.tvBack);

        //******************
        tvZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch = ch + 0;
                tvExpression.setText(ch.toString());
            }
        });
        tvUn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch = ch + 1;
                tvExpression.setText(ch.toString());
            }
        });
        tvDeux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch = ch + 2;
                tvExpression.setText(ch.toString());
            }
        });
        tvTrois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch = ch + 3;
                tvExpression.setText(ch.toString());
            }
        });
        tvQuatre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch = ch + 4;
                tvExpression.setText(ch.toString());
            }
        });
        tvCinq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch = ch + 5;
                tvExpression.setText(ch.toString());
            }
        });
        tvSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch = ch + 6;
                tvExpression.setText(ch.toString());
            }
        });
        tvSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch = ch + 7;
                tvExpression.setText(ch.toString());
            }
        });
        tvHuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch = ch + 8;
                tvExpression.setText(ch.toString());
            }
        });
        tvNeuf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch = ch + 9;
                tvExpression.setText(ch.toString());
            }
        });

        //*
        tvEgale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch = ch.replaceAll("x", "*");
                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalResult = "";
                try {
                    Scriptable scriptable = rhino.initSafeStandardObjects();
                    finalResult = rhino.evaluateString(scriptable, ch, "javascript", 1, null).toString();
                } catch (Exception e) {
                    finalResult = "ERREUR";
                }
                tvResult.setText(finalResult);


            }
        });
        tvPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch = ch + "+";
                tvExpression.setText(ch.toString());
            }
        });
        tvMoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch = ch + "-";
                tvExpression.setText(ch.toString());
            }
        });
        tvFois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch = ch + "x";
                tvExpression.setText(ch.toString());
            }
        });
        tvSur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch = ch + "/";
                tvExpression.setText(ch.toString());
            }
        });

        //*

        tvCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch = deleteAll(ch);
                tvExpression.setText(ch.toString());
                tvResult.setText(ch.toString());
            }
        });
        tvAwes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch = ch + "(";
                tvExpression.setText(ch.toString());
            }
        });
        tvAsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch = ch + ")";
                tvExpression.setText(ch.toString());
            }
        });

        tvDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch = ch + ".";
                tvExpression.setText(ch.toString());
            }
        });
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch = deleteLastCaractere(ch);
                tvExpression.setText(ch.toString());
            }
        });


    }

    public static String deleteAll(String ch) {
        ch = "";
        return ch;
    }

    public static String deleteLastCaractere(String ch) {
        String result = null;
        if ((ch.length() > 0) && (ch != null)) {
            result = ch.substring(0, ch.length() - 1);
        }
        return result;
    }
}