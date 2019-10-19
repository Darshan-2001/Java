
public class Fruit {
	String name;
	double weight;
	
	public Fruit() {
		this.name = "";
		this.weight = 0.0;
	}
	
	public Fruit(String aName, double aWeight) {
		this.name = aName;
		this.weight = aWeight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public int compareTo(Fruit aFruit) {
		if(this.weight < aFruit.getWeight())
			return -1;
		else if(this.weight > aFruit.getWeight())
			return 1;
		else
			return 0;
	}
	public boolean equalsTo(Fruit aFruit) {
		return aFruit != null && this.name.equalsIgnoreCase(aFruit.getName()) && this.weight == aFruit.getWeight();
	}
	public String toString() {
		return this.name + " " + this.weight;
	}

}
