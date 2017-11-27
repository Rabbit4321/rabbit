package model;

public class Property extends Square{
	private String propertyName;
	private double propertyCost;
	private double lastPropertyCost; // מחיר קניה אחרון
	private PropertyTypes type;
	// יבשות או  איזורים בארץ???
	
	private Player propertyOwner;
	
	public Property(String propertyName, double propertyCost, PropertyTypes type) {
		super();
		this.propertyName = propertyName;
		this.propertyCost = propertyCost;
		this.lastPropertyCost=propertyCost; 
		this.type = type;
		this.propertyOwner = null;
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
	public PropertyTypes getPropertyType() {
		return type;
	}
	public void setType(PropertyTypes type) {
		this.type = type;
	}
	

}
