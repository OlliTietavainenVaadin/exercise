package com.vaadin.training.charts.exercises.ex3;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.AxisType;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.Crosshair;
import com.vaadin.addon.charts.model.RangeSeries;
import com.vaadin.addon.charts.model.Tooltip;
import com.vaadin.addon.charts.model.YAxis;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.training.charts.exercises.ChartsData;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class RangeDataChart extends VerticalLayout implements View {

    private static final long serialVersionUID = 1L;

    public RangeDataChart() {
        ChartsData chartsData = new ChartsData();
        Chart chart = getAreaRangeChart(chartsData);
        addComponents(chart);
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // Navigator method, ignore for now
    }

    private Chart getAreaRangeChart(ChartsData data) {
        Chart chart = new Chart(ChartType.AREARANGE);

        Configuration conf = chart.getConfiguration();

        conf.setTitle("Temperature variation by day");
        conf.addyAxis(new YAxis());
        // TODO: Set the X axis type to AxisType.DATETIME and set a new Crosshair() to the axis
        // TODO: create a Tooltip, set the value suffix to "°C", set the Tooltip to be Shared and add it to the Configuration 
        // TODO: implement the getMinMaxTemperaturesByDay method in ChartsData
        RangeSeries series = new RangeSeries("Temperatures", data.getMinMaxTemperaturesByDay());

        conf.setSeries(series);

        return chart;
    }

}
