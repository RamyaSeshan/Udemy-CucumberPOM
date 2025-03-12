package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.KiaPage;
import pages.NewCarPage;
import pages.ToyotoPage;
import utils.SeleniumDriver;

public class CarWaleSteps {

	HomePage home = new HomePage();
	NewCarPage carpage = new NewCarPage();
	ToyotoPage toyotaPage = new ToyotoPage();
	KiaPage kiapage = new KiaPage();

	@Given("user navigates to care wale")
	public void user_navigates_to_care_wale() {
		SeleniumDriver.navigateToBrowser(SeleniumDriver.config.getProperty("URL"));
	}

	@When("user mouseover to new cars")
	public void user_mouseover_to_new_cars() {
		home.mouseOverNewCar();

	}

	@Then("usee clicks on FindNewCar")
	public void usee_clicks_on_find_new_car() {
		home.findNewCar();
	}

	@And("user clicks on {string}")
	public void user_clicks_on_toyota(String CarBrand) {

		if (CarBrand.equalsIgnoreCase("toyota"))
			carpage.gotoToyota();
		
		else if (CarBrand.equalsIgnoreCase("kia"))
			carpage.gotoKia();
		
	}

	@And("user validates car {string}")
	public void user_validates_car_title( String title) {
		
		String carTitle ="";
		if(title.equalsIgnoreCase("totyotaTitle"))
       {
	      carTitle = toyotaPage.getCarTitle() ;
	       System.out.println( "carTitle is ---- > " + carTitle);
       }else if ( title.equalsIgnoreCase("kiaTitle") ) 
      {
    	   carTitle = kiapage.getCarTitle() ;
    		System.out.println( "carTitle is ---- > " + carTitle);
      }
		

	}

}
