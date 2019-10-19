/*
 * Written By Prashant Thirumal
 */

public class Jeep implements Comparable<Jeep>{
	private String name;
	private double weight;
	private int horsepower;
	
	public Jeep() {
		this.name = "";
		this.weight = 0.0;
		this.horsepower = 0;
	}
	
	public Jeep(String name, double weight, int horsepower) {
		this.name = name;
		this.weight = weight;
		this.horsepower = horsepower;
	}
	
	public int compareTo(Jeep aJeep) {
		if(this.horsepower < aJeep.getHorsepower())
			return -1;
		else if(this.horsepower > aJeep.getHorsepower())
			return 1;
		else
			return 0;
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
	
	public int getHorsepower() {
		return horsepower;
	}
	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}
	
	public String toString() {
		return "Name: " + name + " \tWeight: " + weight + " \tHorsepower: " + horsepower;
	}
	

}
