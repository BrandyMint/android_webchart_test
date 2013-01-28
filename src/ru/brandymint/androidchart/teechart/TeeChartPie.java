package ru.brandymint.androidchart.teechart;

import java.lang.reflect.InvocationTargetException;

import ru.brandymint.androidchart.ChartsData;
import ru.brandymint.androidchart.R;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.steema.teechart.Chart;
import com.steema.teechart.TChart;
import com.steema.teechart.drawing.Color;
import com.steema.teechart.legend.LegendAlignment;
import com.steema.teechart.styles.Pie;
import com.steema.teechart.styles.Series;
import com.steema.teechart.themes.ColorPalettes;
import com.steema.teechart.themes.Theme;

/**
 * Фрагмент с круговой диаграммой на основе TeeChart
 * @author alexey
 *
 */
public class TeeChartPie extends Fragment {

	public TeeChartPie() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		final View v;
		final LinearLayout group;
		TChart chart = null;

		v = inflater.inflate(R.layout.fragment_teechartview, container, false);
		try {
			chart = createChart(inflater.getContext());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (java.lang.InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		group = (LinearLayout) v.findViewById(R.id.linearLayoutTchart);
		group.addView(chart);

		return v;
	}

	private TChart createChart(final Context ctx) throws IllegalArgumentException, java.lang.InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		final TChart chart;


		chart = new TChart(ctx);

		chart.getPanel().setBorderRound(7);
		chart.getAspect().setView3D(false);

		chart.removeAllSeries();


		@SuppressWarnings("unused")
		Color[] oldPalette = chart.getChart().getGraphics3D().getColorPalette();
		ColorPalettes.applyPalette(chart.getChart(), Theme.WarmPalette);


		chart.addSeries(createSeries(chart.getChart()));
		chart.getLegend().setAlignment(LegendAlignment.BOTTOM);
		chart.getLegend().setVisible(true);
		chart.getHeader().setText("Pie Series");
		chart.getHeader().getFont().setSize(14);
		chart.getWalls().getBack().setVisible(false);

		((com.steema.teechart.styles.Pie)chart.getSeries(0)).setCircled(true);
		((com.steema.teechart.styles.Pie)chart.getSeries(0)).getMarks().setVisible(false);
		((com.steema.teechart.styles.Pie)chart.getSeries(0)).setExplodeBiggest(10);
		((com.steema.teechart.styles.Pie)chart.getSeries(0)).getPen().setVisible(false);

		return chart;
	}

	private static Series createSeries(Chart chart) {
		Series series = null;
		final ChartsData.Chart chartData = ChartsData.CHART_PAID_SERVICES_2012;

		try {
			series = Series.createNewSeries(chart, Pie.class, null);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (java.lang.InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		series.setTitle(chartData.title);

    	for (ChartsData.ChartItem chartItem: chartData.items) {
    		series.add(chartItem.value, chartItem.title);
    	}

		return series;
	}

}
