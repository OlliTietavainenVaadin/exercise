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

        conf.getxAxis().setType(AxisType.DATETIME);
        conf.getxAxis().setCrosshair(new Crosshair());
        conf.addyAxis(new YAxis());

        Tooltip tooltip = new Tooltip();
        tooltip.setShared(true);
        tooltip.setValueSuffix("°C");
        conf.setTooltip(tooltip);

        RangeSeries series = new RangeSeries("Temperatures", data.getMinMaxTemperaturesByDay());


        conf.setSeries(series);

        return chart;
    }



}

