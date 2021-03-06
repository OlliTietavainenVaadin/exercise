package com.vaadin.training.charts.exercises;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.training.charts.exercises.ex1.ShoeSizeChart;
import com.vaadin.training.charts.exercises.ex2.WeatherChart;
import com.vaadin.training.charts.exercises.ex3.RangeDataChart;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class MainView extends VerticalLayout implements View {

	private static final long serialVersionUID = 1L;

	private Navigator navigator;

	public MainView(Navigator navigator) {
		this.navigator = navigator;
		setSpacing(true);

		int i = 1;
		createExerciseLink(i++, "Shoe Size Chart", ShoeSizeChart.class);
		createExerciseLink(i++, "Weather Chart", WeatherChart.class);
		createExerciseLink(i++, "Range Data Chart", RangeDataChart.class);

	}

	private void createExerciseLink(int exNum, String caption, Class<? extends View> viewClass) {
		navigator.addView(caption.replace(" ", ""), viewClass);
		Button button = new Button("Ex " + exNum + ": " + caption,
				event -> navigator.navigateTo(event.getButton().getData().toString().replace(" ", "")));
		button.setData(caption);
		button.setStyleName(ValoTheme.BUTTON_LINK);

		addComponent(button);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// Navigator method, no need to do anything here.
	}
}