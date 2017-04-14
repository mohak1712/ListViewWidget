package mohak.com.listviewwidget;

import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

public class WidgetAdapter implements RemoteViewsService.RemoteViewsFactory {
    Context context;
    String[] listArray = {"1", "2", "3", "4", "5"};

    public WidgetAdapter(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return listArray.length;
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.list_item);
        remoteViews.setTextViewText(R.id.textView, listArray[position]);

        Intent intent = new Intent();
        intent.setAction(WidgetProvider.TOAST_ACTION);
        intent.putExtra(WidgetProvider.KEY_ITEM, listArray[position]);
        remoteViews.setOnClickFillInIntent(R.id.list_item, intent);

        return remoteViews;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
