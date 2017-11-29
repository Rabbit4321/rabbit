package model;

import java.util.ArrayList;

public class Property extends Square{
	private String propertyName;
	private double propertyCost;
	private double lastPropertyCost; // מחיר קניה אחרון
	private PlayerInGame propertyOwner;
	private PropertyTypes ProType;
	private Cities city;
	
	
	
	
	public Property(String propertyName, double propertyCost, Cities city) {
		super();
		this.propertyName = propertyName;
		this.propertyCost = propertyCost;
		this.lastPropertyCost=propertyCost; 
		this.propertyOwner = null;
		setType();
		this.city=city;
	}
	
	
	public Cities getCity() {
		return city;
	}


	public void setCity(Cities city) {
		this.city = city;
	}


	public void setType()
	{
		if(this.propertyCost >= 50000 && this.propertyCost<250000)
		{
			this.ProType = PropertyTypes.Low_cost;
		}
		if(this.propertyCost >= 250000 && this.propertyCost<2000000)
		{
			this.ProType = PropertyTypes.Average;
		}
		if(this.propertyCost >= 2000000)
		{
			this.ProType = PropertyTypes.Expensive;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public double getLastPropertyCost()
	{
		return lastPropertyCost;
	}


	public void setLastPropertyCost(double lastPropertyCost) {
		this.lastPropertyCost = lastPropertyCost;
	}
	public PlayerInGame getPropertyOwner() {
		return propertyOwner;
	}
	public void setPropertyOwner(PlayerInGame propertyOwner) {
		this.propertyOwner = propertyOwner;
	}

	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public double getPropertyCost() {
		return propertyCost;
	}
	public void setPropertyCost(double propertyCost) {
		this.propertyCost = propertyCost;
	}
	public PropertyTypes getProType() {
		return ProType;
	}
	public void setProType(PropertyTypes type) {
		this.ProType = type;
	}
	

}
