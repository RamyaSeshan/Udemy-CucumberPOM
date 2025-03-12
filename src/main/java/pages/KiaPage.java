package pages;

import base.basePage;

public class KiaPage extends basePage{
	
	public String getCarTitle()
	{
		return getText("kiaTitle_XPATH") ;
	}

}
