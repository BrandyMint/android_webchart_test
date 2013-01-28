package ru.brandymint.androidchart.keepedge;

import ru.brandymint.androidchart.LooksLikeMarketActivity;
import android.support.v4.app.Fragment;


/**
 * Пример на основе KeepAdge charts
 *
 */
public class KeepEdgeActivity extends LooksLikeMarketActivity {

	@Override
	protected Fragment createPieDiagramFragment() {
		return new KeepEdgePie();
	}

	@Override
	protected Fragment createBarDiagramFragment() {
		// TODO Auto-generated method stub
		return new KeepEdgeBar();
	}

	@Override
	protected Fragment createTableDiagramFragment() {
		// TODO Auto-generated method stub
		return super.createTableDiagramFragment();
	}

}
