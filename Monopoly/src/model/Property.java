package model;

public class Property {
	private String propertyName;
	private double propertyCost;
	private PropertyTypes type;
	// יבשות או  איזורים בארץ???
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
	public PropertyTypes getType() {
		return type;
	}
	public void setType(PropertyTypes type) {
		this.type = type;
	}
	

}
