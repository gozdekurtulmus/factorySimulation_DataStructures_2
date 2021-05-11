package Iztechea;

public class Product implements IProduct {
	private String name; //keeps product name as a String
	private final String[] products;
	private boolean manufactured = false;
	private boolean stored = false;
	private boolean sold = false;

	public Product(){
		//manufactured products
		this.products = new String[]{"Sofa", "Bed","Chair", "Dresser", "Table", "Bookcase"};
	}
	
	@Override
	//returns whether the product is manufactured or not
	public boolean isManufactured() {
		return manufactured;
	}

	@Override
	//returns whether the product is stored or not
	public boolean isStored() {
		return stored;
	}

	@Override
	////returns whether the product is sold or not
	public boolean isSold() {
		return sold;
	}
	//returns array of products
	public String[] getProducts() {
		return products;
	}

	//returns the product in the specified index
	public String getProduct(int index){
		return this.products[index];
	}

	public void setManufactured(boolean manufactured) {
		this.manufactured = manufactured;
	}

	public void setStored(boolean stored) {
		this.stored = stored;
	}

	public void setSold(boolean sold) {
		this.sold = sold;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

    
