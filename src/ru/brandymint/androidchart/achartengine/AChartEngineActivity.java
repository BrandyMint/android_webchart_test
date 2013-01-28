package ru.brandymint.androidchart.achartengine;

import ru.brandymint.androidchart.LooksLikeMarketActivity;
import android.graphics.Color;
import android.support.v4.app.Fragment;


/**
 * Пример на основе AChartEngine
 *
 */
public class AChartEngineActivity extends LooksLikeMarketActivity {

	/**
	 * Цвета на диаграммах
	 */
	public static final int ITEM_COLOR[] = new int[] {
		Color.BLUE,
		Color.CYAN,
		Color.GRAY,
		Color.GREEN,
		Color.MAGENTA,
		Color.RED,
		Color.YELLOW,
		Color.BLACK
	};

	@Override
	protected Fragment createPieDiagramFragment() {
		return new AChartEnginePie();
	}

	@Override
	protected Fragment createBarDiagramFragment() {
		// TODO Auto-generated method stub
		return new AChartEngineBar();
	}

	@Override
	protected Fragment createTableDiagramFragment() {
		// TODO Auto-generated method stub
		return super.createTableDiagramFragment();
	}

}
