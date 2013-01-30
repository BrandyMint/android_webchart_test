package ru.brandymint.androidchart.teechart;

import ru.brandymint.androidchart.LooksLikeMarketActivity;
import android.support.v4.app.Fragment;


/**
 * Пример на основе KeepAdge chartsу
 *
 */
public class TeeChartActivity extends LooksLikeMarketActivity {

	@Override
	protected Fragment createPieDiagramFragment() {
		return new TeeChartPie();
	}

	@Override
	protected Fragment createBarDiagramFragment() {
		// TODO Auto-generated method stub
		return new TeeChartBar();
	}

	@Override
	protected Fragment createTableDiagramFragment() {
		// TODO Auto-generated method stub
		return super.createTableDiagramFragment();
	}

}
