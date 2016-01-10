package map;



public class MyValue implements Value {
	String val = "";
	
	public MyValue() {
		
	}

	public String getVal() {
		return this.val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	@Override
	public int compareTo(Value v) {
		return this.val.compareTo(v.getVal());
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof MyValue)
			return ((MyValue) other).val.equals(val);
		return false;
	}

}
