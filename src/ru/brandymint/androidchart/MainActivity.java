package ru.brandymint.androidchart;

import ru.brandymint.androidchart.achartengine.AChartEngineActivity;
import ru.brandymint.androidchart.webview.WebView1Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class MainActivity extends ListActivity {

	/**
     * A simple POJO that holds the details about the demo that are used by the List Adapter.
     */
    private static class DemoDetails {
        /**
         * The resource id of the title of the demo.
         */
        private final int titleId;

        /**
         * The resources id of the description of the demo.
         */
        private final int descriptionId;

        /**
         * The demo activity's class.
         */
        private final Class<? extends android.support.v4.app.FragmentActivity> activityClass;

        public DemoDetails(int titleId, int descriptionId,
                Class<? extends android.support.v4.app.FragmentActivity> activityClass) {
            super();
            this.titleId = titleId;
            this.descriptionId = descriptionId;
            this.activityClass = activityClass;
        }
    }

    /**
     * A custom array adapter that shows a {@link FeatureView} containing details about the demo.
     */
    private static class CustomArrayAdapter extends ArrayAdapter<DemoDetails> {

        /**
         * @param demos An array containing the details of the demos to be displayed.
         */
        public CustomArrayAdapter(Context context, DemoDetails[] demos) {
            super(context, R.layout.feature, R.id.title, demos);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            FeatureView featureView;
            if (convertView instanceof FeatureView) {
                featureView = (FeatureView) convertView;
            } else {
                featureView = new FeatureView(getContext());
            }

            DemoDetails demo = getItem(position);

            featureView.setTitleId(demo.titleId);
            featureView.setDescriptionId(demo.descriptionId);

            return featureView;
        }
    }



    private static final DemoDetails[] demos = {
    	new DemoDetails(
                R.string.webview1_title, R.string.webview1_description, WebView1Activity.class),
        new DemoDetails(
        		R.string.achartengine_title, R.string.achartengine_description, AChartEngineActivity.class)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListAdapter adapter = new CustomArrayAdapter(this, demos);

        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	DemoDetails demo = (DemoDetails) getListAdapter().getItem(position);
    	startActivity(new Intent(this, demo.activityClass));
    }
}
