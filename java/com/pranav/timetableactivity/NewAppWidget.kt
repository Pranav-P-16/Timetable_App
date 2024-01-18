package com.pranav.timetableactivity

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import java.text.SimpleDateFormat
import java.util.*

/**
 * Implementation of App Widget functionality.
 */

// Sem 2 Data already feeded, just change all the switch variable names

class NewAppWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val widgetText = context.getString(R.string.appwidget_text)
    // Construct the RemoteViews object
    val calendar: Calendar = Calendar.getInstance()
    val date: Date = calendar.getTime()

// 3 letter name form of the day
// 3 letter name form of the day
    val day=(SimpleDateFormat("EE", Locale.ENGLISH).format(date.getTime()))
    //var views = RemoteViews(context.packageName, R.layout.activity_friday)
    if (day=="Sun") {
        val views = RemoteViews(context.packageName, R.layout.activity_sunday)
        appWidgetManager.updateAppWidget(appWidgetId, views)
    } else if (day=="Mon") {
        val views = RemoteViews(context.packageName, R.layout.monday_new)
        appWidgetManager.updateAppWidget(appWidgetId, views)
    } else if (day=="Tue") {
        val views = RemoteViews(context.packageName, R.layout.tuesday_new)
        appWidgetManager.updateAppWidget(appWidgetId, views)
    } else if (day=="Wed") {
        val views = RemoteViews(context.packageName, R.layout.wednesday_new)
        appWidgetManager.updateAppWidget(appWidgetId, views)
    } else if (day=="Thu") {
        val views = RemoteViews(context.packageName, R.layout.thursday_new)
        appWidgetManager.updateAppWidget(appWidgetId, views)
    } else if (day=="Fri") {
        val views = RemoteViews(context.packageName, R.layout.friday_new)
        appWidgetManager.updateAppWidget(appWidgetId, views)
    } else {
        val views = RemoteViews(context.packageName, R.layout.activity_saturday)
        appWidgetManager.updateAppWidget(appWidgetId, views)
    }
    //views.setTextViewText(R.id.appwidget_text3, widgetText)

    // Instruct the widget manager to update the widget

}