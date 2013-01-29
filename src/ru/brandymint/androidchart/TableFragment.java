package ru.brandymint.androidchart;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils.TruncateAt;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class TableFragment extends Fragment {

	public TableFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.frame_table, container, false);

		final TableLayout tv = (TableLayout)v.findViewById(R.id.table1);
		loadDataset(tv);

		return v;
	}

	private void loadDataset(TableLayout table) {
		final ChartsData.Chart chartData = ChartsData.CHART_PAID_SERVICES_2012;
		final Context ctx = table.getContext();

		TableRow.LayoutParams params = new TableRow.LayoutParams();

		for (ChartsData.ChartItem chartItem: chartData.items) {
			final TableRow row = new TableRow(ctx);
			final TextView title = new TextView(ctx);
			title.setLayoutParams(params);
			title.setText(chartItem.title);
			title.setEllipsize(TruncateAt.MIDDLE);
			row.addView(title);

			final TextView value = new TextView(ctx);
			value.setLayoutParams(params);
			value.setText(String.format("%8.2f", chartItem.value));
			value.setGravity(Gravity.RIGHT);
			row.addView(value);

			table.addView(row);
    	}

	}


}
