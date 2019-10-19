/*
 * Written By Prashant Thirumal
 */
public class Prize {
	
	private String name;
	private double prizeCost;

	//Default Constructor
	public Prize() {
		this.name = "No Name Yet";
		this.prizeCost = 0.0;
	}
	
	//Parametrised Constructor
	public Prize(String aName, double aPrizeCost) {
		this.name = aName;
		this.prizeCost = aPrizeCost;
	}

	//Setters and Getters
	public String getName() {
		return this.name;
	}

	public void setName(String aName) {
		this.name = aName;
	}

	public double getPrizeCost() {
		return prizeCost;
	}

	public void setPrizeCost(double aPrizeCost) {
		if(aPrizeCost >= 0.0) { //Ensure Prize has a valid value
		this.prizeCost = aPrizeCost;
		}
		else {
			System.out.println("Invalid value for price");
		}
	}
	
	public boolean equals(Prize aPrize) {
		return aPrize != null && this.name.equals(aPrize.getName()) && this.prizeCost == aPrize.getPrizeCost();
	}
	

}
