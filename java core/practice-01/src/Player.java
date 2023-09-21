
public class Player {
	private String name;
	@Override
	public String toString() {
		return "Player [name=" + name + ", age=" + age + ", country=" + country + ", runscored=" + runscored
				+ ", fifties=" + fifties + ", hundreds=" + hundreds + "]";
	}
	private int age;
	private CountryType country;
	private int runscored;
	private int fifties;
	private int hundreds;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public CountryType getCountry() {
		return country;
	}
	public void setCountry(CountryType country) {
		this.country = country;
	}
	public int getRunscored() {
		return runscored;
	}
	public void setRunscored(int runscored) {
		this.runscored = runscored;
	}
	public int getFifties() {
		return fifties;
	}
	public void setFifties(int fifties) {
		this.fifties = fifties;
	}
	public int getHundreds() {
		return hundreds;
	}
	public void setHundreds(int hundreds) {
		this.hundreds = hundreds;
	}
	public Player(String name, int age, CountryType country, int runscored, int fifties, int hundreds) {
		super();
		this.name = name;
		this.age = age;
		this.country = country;
		this.runscored = runscored;
		this.fifties = fifties;
		this.hundreds = hundreds;
	}
	
}
