package com.vaadin.training.charts.exercises.ex1;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.training.charts.exercises.ChartsData;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
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
        Label label = new Label("Implement a shoe size chart here");
        // TODO: Create a new Chart. Chart type should be ChartType.LINE
        
        // TODO: Get the Configuration from the Chart and update the following:
        // TODO: * Chart title "Shoe size per age for boys and girls"
        // TODO: * Y axis title should be "Shoe size (EU)"
        // TODO: * X axis title should be "Age (Years)"
        
        // TODO: Create a new DataSeries for girls. Get the ShoeSizeInfos from `data.getGirlsData()`
        
        // TODO: For each ShoeSizeInfo, adda new DataSeriesItem to the girls' DataSeries.
        // TODO: * For the new DataSeriesItem, X value is age in years and Y value is shoe size.
        // TODO: * Add the new DataSeriesItem to the girls' DataSeries
        
        // TODO: Create a new DataSeries for boys similarly with `data.getBoysData()`
        
        // TODO: Add both DataSeries to the Configuration
        // TODO: Return the Chart instead of a Label
        return label;
    }
}