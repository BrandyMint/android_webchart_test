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

import com.keepedge.android.chart.AndroidColor;
import com.keepedge.android.chart.ChartClusteredBar;
import com.keepedge.android.chart.data.CategoryDataset;

/**
 * Фрагмент с стобчатой диаграммой на основе Android KeepEdge charts
 * @author alexey
 *
 */
public class KeepEdgeBar extends Fragment {

	public KeepEdgeBar() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return new ChartBarDemoView(inflater.getContext());
	}

	private class ChartBarDemoView extends View
	{

	    public ChartBarDemoView(Context context) {
	        super(context);
	    }

	    @Override
	    protected void onDraw(Canvas canvas)
	    {
	        super.onDraw(canvas);

	        drawBarChart(canvas);
	    }

	    private void drawBarChart(Canvas canvas)
	    {
	        RectF bounds = new RectF(canvas.getClipBounds());
	        ChartClusteredBar chart = new ChartClusteredBar(ChartsData.CHART_PAID_SERVICES_2012.title);

	        chart.getCategoryAxis().setLabelPositionUpRotation(Math.PI / 6);

	        chart.setBeginMargin(0.05);
	        chart.setEndMargin(0.05);
	        chart.setCategoryMargin(0.10);
	        chart.setItemMargin(0);

	        chart.setDisplayItemLabels(true);
	        chart.setItemLabelsColor(AndroidColor.blue);

	        chart.draw(canvas, createDataset(), bounds);
	    }

	    private CategoryDataset createDataset()
	    {
	    	final ChartsData.Chart chart = ChartsData.CHART_PAID_SERVICES_2012;

	    	String series1 = "2012";

	    	CategoryDataset dataset = new CategoryDataset();

	    	for (ChartsData.ChartItem chartItem: chart.items) {
	    		dataset.addValue(chartItem.value, series1, chartItem.title);
	    	}

	        return dataset;
	    }
	}


}
