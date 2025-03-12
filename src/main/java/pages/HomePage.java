package pages;

import base.basePage;

public class HomePage extends basePage {

	public void mouseOverNewCar() {
		mouseOver("newCar_XPATH");
	}

	public void findNewCar() {
		Click("findNewCar_XPATH");
	}

}
