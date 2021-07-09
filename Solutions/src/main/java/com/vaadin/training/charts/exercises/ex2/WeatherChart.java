package com.vaadin.training.charts.exercises.ex2;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.training.charts.exercises.ChartsData;
import com.vaadin.training.charts.exercises.ChartsData.WeatherInfo;
import com.vaadin.ui.VerticalLayout;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class WeatherChart extends VerticalLayout implements View {

	private static final long serialVersionUID = 1L;

	public WeatherChart() {
		ChartsData chartsData = new ChartsData();
		Chart chart = getWeatherChart(chartsData);
		addComponents(chart);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// Navigator method, ignore for now
	}

	private Chart getWeatherChart(ChartsData data) {
		Chart chart = new Chart();

		Configuration conf = chart.getConfiguration();

		conf.setTitle("Turku, Finland 2013");

		conf.getxAxis().setTitle("Date");
		conf.getxAxis().setType(AxisType.DATETIME);

		YAxis tempYAxis = new YAxis();
		tempYAxis.setTitle("Temperature (°C)");
		conf.addyAxis(tempYAxis);

		YAxis humidityYAxis = new YAxis();
		humidityYAxis.setTitle("Humidity (%)");
		conf.addyAxis(humidityYAxis);


		ListDataProvider<WeatherInfo> weatherDataProvider = DataProvider.ofCollection(data.getWeatherData());

		weatherDataProvider.addFilter(point -> {
			LocalDateTime date = LocalDateTime.ofInstant(point.getInstant(), ZoneId.of("Europe/Helsinki"));
			return date.getDayOfWeek() == DayOfWeek.SUNDAY;
		});

		DataProviderSeries<WeatherInfo> temp = new DataProviderSeries<>(weatherDataProvider);
		temp.setName("Temperature");
		temp.setX(WeatherInfo::getInstant);
		temp.setY(WeatherInfo::getMaxTemp);
		temp.setPlotOptions(new PlotOptionsLine());


		DataProviderSeries<WeatherInfo> humidity = new DataProviderSeries<>(weatherDataProvider);
		humidity.setName("Humidity");
		humidity.setX(WeatherInfo::getInstant);
		humidity.setY(WeatherInfo::getMeanHumidity);
		humidity.setPlotOptions(new PlotOptionsColumn());


		conf.addSeries(humidity);
		conf.addSeries(temp);

		temp.setyAxis(tempYAxis);
		humidity.setyAxis(humidityYAxis);

		chart.setTimeline(true);
		conf.getNavigator().setEnabled(false);

		return chart;
	}
}