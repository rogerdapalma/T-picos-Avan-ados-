package com.example.nutricomp.ui;

// import com.github.mikephil.charting.charts.BarChart;
// import com.github.mikephil.charting.data.BarData;
// import com.github.mikephil.charting.data.BarEntry;
// import com.github.mikephil.charting.data.BarDataSet;
// import com.github.mikephil.charting.components.XAxis;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nutricomp.R;


public class CompareActivity extends AppCompatActivity {

    // private BarChart barChart; // Comentado

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);

        // barChart = findViewById(R.id.barChart); // Comentado
        // initializeBarChart(); // Função comentada
    }

    /*
    private void initializeBarChart() {
        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 100f));
        entries.add(new BarEntry(1f, 200f));

        BarDataSet dataSet = new BarDataSet(entries, "Comparação de Alimentos");
        BarData barData = new BarData(dataSet);

        barChart.setData(barData);
        barChart.invalidate();

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
    }
    */
}
