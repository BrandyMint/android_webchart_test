package ru.brandymint.androidchart.achartengine;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DialRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import ru.brandymint.androidchart.ChartsData;
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
public class AChartEnginePie extends Fragment {

	public AChartEnginePie() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		GraphicalView chartView;

		DialRenderer renderer = new DialRenderer();
		renderer.setChartTitleTextSize(20);
		renderer.setLabelsTextSize(15);
		renderer.setLegendTextSize(15);
		renderer.setMargins(new int[] {20, 30, 15, 0});

		chartView = ChartFactory.getPieChartView(getActivity(), createDataset(renderer), renderer);

		return chartView;
	}

	private static CategorySeries createDataset(DialRenderer dialRenderer) {
		final ChartsData.Chart chart = ChartsData.CHART_PAID_SERVICES_2012;
		SimpleSeriesRenderer renderer;

		CategorySeries dataset = new CategorySeries(chart.title);

		int i=0;
		for (ChartsData.ChartItem chartItem: chart.items) {
			// Значение
			dataset.add(chartItem.title, chartItem.value);

			// Цвет
			renderer = new SimpleSeriesRenderer();
			renderer.setColor(AChartEngineActivity.ITEM_COLOR[i]);
			i = (i + 1) % AChartEngineActivity.ITEM_COLOR.length;

			dialRenderer.addSeriesRenderer(renderer);
		}

		return dataset;
	}

}
