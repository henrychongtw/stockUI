package henrychong.stock.stockui.graphpackage;

import android.content.Context;
import android.view.View;

import com.github.mikephil.charting.data.ChartData;

/**
 * Created by henrychong on 2016/5/24.
 */
public abstract class ChartItem {

    protected static final int TYPE_BARCHART = 0;
    protected static final int TYPE_LINECHART = 1;
    protected static final int TYPE_PIECHART = 2;

    protected ChartData<?> mChartData;

    public ChartItem(ChartData<?> cd) {
        this.mChartData = cd;
    }

    public abstract int getItemType();

    public abstract View getView(int position, View convertView, Context c);
}

