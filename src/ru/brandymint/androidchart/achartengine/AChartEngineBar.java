package ru.brandymint.androidchart.achartengine;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.BasicStroke;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer.Orientation;
import org.achartengine.renderer.XYSeriesRenderer;

import ru.brandymint.androidchart.ChartsData;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Фрагмент с круговой диаграммой на основе Android AChartEngine
 * @author alexey
 *
 */
public class AChartEngineBar extends Fragment {

	public AChartEngineBar() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		GraphicalView chartView;
		XYMultipleSeriesDataset dataset;


		XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
		renderer.setAxisTitleTextSize(16);
		renderer.setChartTitleTextSize(20);
		renderer.setLabelsTextSize(15);
		renderer.setLegendTextSize(15);
		renderer.setOrientation(Orientation.VERTICAL);
		renderer.setBackgroundColor(Color.WHITE);
		// renderer.setXLabels(1);
	    // renderer.setYLabels(20);

		dataset = createDataset(renderer);

		chartView = ChartFactory.getBarChartView(getActivity(), dataset, renderer,
				BarChart.Type.DEFAULT);

		return chartView;
	}

	private static XYMultipleSeriesDataset createDataset(XYMultipleSeriesRenderer xyRenderer) {
		final ChartsData.Chart chart = ChartsData.CHART_PAID_SERVICES_2012;

		xyRenderer.setChartTitle(chart.title);
		xyRenderer.setYTitle(chart.unit);
		xyRenderer.setXTitle("Услуги");
		xyRenderer.setBackgroundColor(Color.WHITE);
		xyRenderer.setApplyBackgroundColor(false);
		xyRenderer.setBarSpacing(-0.5);

		XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();

		for (int i=0; i < chart.items.length; ++i) {
			ChartsData.ChartItem chartItem = chart.items[i];
			XYSeriesRenderer renderer;

			// Значение
			CategorySeries series = new CategorySeries(chartItem.title);
			series.add(0);
			series.add(chartItem.value);
			dataset.addSeries(i, series.toXYSeries());

			// Цвет
			renderer = new XYSeriesRenderer();
			renderer.setColor(AChartEngineActivity.ITEM_COLOR[i % AChartEngineActivity.ITEM_COLOR.length]);
			renderer.setDisplayChartValues(true);
			renderer.setLineWidth(3f);
			renderer.setFillPoints(true);
			renderer.setStroke(BasicStroke.SOLID);

			xyRenderer.addSeriesRenderer(i, renderer);
			xyRenderer.addXTextLabel(i, chartItem.title);
		}

		return dataset;
	}
}
