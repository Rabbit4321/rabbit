package model;

public class Property extends Square{
	private String propertyName;
	private double propertyCost;
	private double lastPropertyCost; // מחיר קניה אחרון
	private Player propertyOwner;
	private PropertyTypes ProType;
	
	
	
	
	public Property(String propertyName, double propertyCost) {
		super();
		this.propertyName = propertyName;
		this.propertyCost = propertyCost;
		this.lastPropertyCost=propertyCost; 
		this.propertyOwner = null;
		setType();
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
	public Player getPropertyOwner() {
		return propertyOwner;
	}
	public void setPropertyOwner(Player propertyOwner) {
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
