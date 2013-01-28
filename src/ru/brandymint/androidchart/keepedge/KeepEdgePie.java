package ru.brandymint.androidchart.keepedge;

import ru.brandymint.androidchart.ChartsData;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.keepedge.android.chart.ChartPie;
import com.keepedge.android.chart.data.PieDataset;

/**
 * Фрагмент с круговой диаграммой на основе Android KeepEdge charts
 * @author alexey
 *
 */
public class KeepEdgePie extends Fragment {

	public KeepEdgePie() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return new ChartPieDemoView(inflater.getContext());
	}

	private class ChartPieDemoView extends View
	{

	    public ChartPieDemoView(Context context) {
	        super(context);
	    }

	    @Override
	    protected void onDraw(Canvas canvas)
	    {
	        super.onDraw(canvas);

	        drawPieChart(canvas);
	    }

	    private void drawPieChart(Canvas canvas)
	    {
	        RectF bounds = new RectF(canvas.getClipBounds());

	        ChartPie pieChart = new ChartPie("Android Pie Chart Demo");

	        pieChart.setDisplayItemLabels(true);
	        pieChart.setItemLabelsFormat("{0} = {2}");
	        pieChart.setLegendItemLabelsFormat("{0} = {1}");

	        pieChart.draw(canvas, createPieDataset(), bounds);
	    }

	    private PieDataset createPieDataset()
	    {
	    	final ChartsData.Chart chart = ChartsData.CHART_PAID_SERVICES_2012;

	    	PieDataset dataset = new PieDataset();

	    	for (ChartsData.ChartItem chartItem: chart.items) {
	    		dataset.setValue(chartItem.title, chartItem.value);
	    	}

	        return dataset;
	    }
	}


}
