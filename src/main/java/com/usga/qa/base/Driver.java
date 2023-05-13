package com.usga.qa.base;

import io.appium.java_client.AppiumDriver;

public class Driver extends BaseClass
{
protected AppiumDriver driver;
public Driver()
{
	this.driver=super.getdriver();
	
}
	
}
