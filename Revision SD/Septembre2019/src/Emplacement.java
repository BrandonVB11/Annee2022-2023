
public class Emplacement {
	
	private int num;
	private char type; // A ou B
	private String exposant;
	
	public Emplacement(int num, char type) {
		super();
		this.num = num;
		this.type = type;
	}

	public int getNum() {
		return num;
	}

	public char getType() {
		return type;
	}

	public String getExposant() {
		return exposant;
	}

	public void setExposant(String exposant) {
		this.exposant = exposant;
	}

	@Override
	public String toString() {
		return num +" : "+ exposant;
	}
	
	
	
	
	
}
