package map;

public class MyKey implements Key {
	public String cheie = "";
	
	public MyKey() {
		
	}

	public int hashCode() {
		int hash = 0,s = 0;
		for (int i = 0; i < cheie.length(); i++)
			s += cheie.charAt(i);
		hash = s%cheie.length();
		return hash;
	}

	public String getKey() {
		return this.cheie;
	}

	public void setKey(String cheie) {
		this.cheie = cheie;
	}

	@Override
	public int compareTo(Key key) {
		return this.cheie.compareTo(key.getKey());
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof MyKey)
			return ((MyKey) other).cheie.equals(cheie);
		return false;
	}

}
