package com.vaadin.training.charts.exercises.ex1;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.training.charts.exercises.ChartsData;
import com.vaadin.training.charts.exercises.ChartsData.ShoeSizeInfo;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

public class ShoeSizeChart extends VerticalLayout implements View {
	private static final long serialVersionUID = 1L;

	public ShoeSizeChart() {
		Component chart = getShoeSizeChart(new ChartsData());
		addComponent(chart);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// Navigator method, ignore for now
	}

	private Component getShoeSizeChart(ChartsData data) {
		Chart chart = new Chart();
		Configuration conf = chart.getConfiguration();
		conf.getChart().setType(ChartType.LINE);
		conf.setTitle("Shoe size per age for boys and girls");
		conf.getyAxis().setTitle("Shoe size (EU)");
		conf.getxAxis().setTitle("Age (Years)");

		DataSeries girls = new DataSeries("Girls");
		for (ShoeSizeInfo shoeSizeInfo : data.getGirlsData()) {
			// Age on the X-axis, Shoe size on the Y-axis
			girls.add(new DataSeriesItem(shoeSizeInfo.getAgeMonths() / 12.0f, shoeSizeInfo.getSize()));
		}
		conf.addSeries(girls);


		DataSeries boys = new DataSeries("Boys");
		for (ShoeSizeInfo shoeSizeInfo : data.getBoysData()) {
			// Age on the X-axis, Shoe size on the Y-axis
			boys.add(new DataSeriesItem(shoeSizeInfo.getAgeMonths() / 12.0f, shoeSizeInfo.getSize()));
		}
		conf.addSeries(boys);

		return chart;
	}
}