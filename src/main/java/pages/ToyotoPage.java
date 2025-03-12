package pages;

import base.basePage;

public class ToyotoPage extends basePage{
	
	public String getCarTitle()
	{
		return getText("title_XPATH") ;
	}

}
