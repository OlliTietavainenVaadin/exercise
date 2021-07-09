package com.vaadin.training.charts.exercises.ex2;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.training.charts.exercises.ChartsData;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class WeatherChart extends VerticalLayout implements View {

	private static final long serialVersionUID = 1L;

	public WeatherChart() {
		ChartsData chartsData = new ChartsData();
		Component chart = getWeatherChart(chartsData);
		addComponents(chart);

	}

	@Override
	public void enter(ViewChangeEvent event) {
		// Navigator method, ignore for now
	}
	
	private Component getWeatherChart(ChartsData data) {
		Label label = new Label("Implement a weather chart here");
        return label;
    }
}