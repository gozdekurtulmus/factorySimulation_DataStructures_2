package Iztechea;

/* This class contains all the Warehouses and executes storing/buying operations. */

public class Storage extends Product{
	private StackInterface<Bed> bedHouse;
	private StackInterface<Sofa> sofaHouse;
	private StackInterface<Chair> chairHouse;
	private StackInterface<Table> tableHouse;
	private StackInterface<Dresser> dresserHouse;
	private StackInterface<Bookcase> bookcaseHouse;
	
	public Storage() { //Creates all the Warehouses (Stack Arrays) for the products to store in.
		this.bedHouse = new ArrayStack<>();
		this.sofaHouse = new ArrayStack<>();
		this.chairHouse = new ArrayStack<>();
		this.dresserHouse = new ArrayStack<>();
		this.tableHouse = new ArrayStack<>();
		this.bookcaseHouse = new ArrayStack<>();
	}

	//This method is called to place a product to its own warehouse.
	public void storingOperation(String productName, Product product) {
		switch (productName) {
			case "Bed" -> bedHouse.push((Bed) product); //push the product to its own warehouse
			case "Sofa" -> sofaHouse.push((Sofa) product);
			case "Dresser" -> dresserHouse.push((Dresser) product);
			case "Table" -> tableHouse.push((Table) product);
			case "Chair" -> chairHouse.push((Chair) product);
			case "Bookcase" -> bookcaseHouse.push((Bookcase) product);
		}
	}

	//This method is called when the customer wants to buy a product
	public Product buyingOperation(String productName) {
		return switch (productName) {
			case "Bed" -> bedHouse.pop(); //get the product from its own stack and return
			case "Sofa" -> sofaHouse.pop();
			case "Dresser" -> dresserHouse.pop();
			case "Table" -> tableHouse.pop();
			case "Chair" -> chairHouse.pop();
			case "Bookcase" -> bookcaseHouse.pop();
			default -> null;
		};
}
	
	public int[] getAmounts() { //returns the number of products in the warehouses as a list to make printing to console easier.
		return new int[]{sofaHouse.findLength(),bedHouse.findLength(),chairHouse.findLength(),dresserHouse.findLength(),
							tableHouse.findLength(),bookcaseHouse.findLength()};
	}


	public StackInterface<Bed> getBedHouse() {
		return bedHouse;
	}

	public void setBedHouse(StackInterface<Bed> bedHouse) {
		this.bedHouse = bedHouse;
	}

	public StackInterface<Sofa> getSofaHouse() {
		return sofaHouse;
	}

	public void setSofaHouse(StackInterface<Sofa> sofaHouse) {
		this.sofaHouse = sofaHouse;
	}

	public StackInterface<Chair> getChairHouse() {
		return chairHouse;
	}

	public void setChairHouse(StackInterface<Chair> chairHouse) {
		this.chairHouse = chairHouse;
	}

	public StackInterface<Table> getTableHouse() {
		return tableHouse;
	}

	public void setTableHouse(StackInterface<Table> tableHouse) {
		this.tableHouse = tableHouse;
	}

	public StackInterface<Dresser> getDresserHouse() {
		return dresserHouse;
	}

	public void setDresserHouse(StackInterface<Dresser> dresserHouse) {
		this.dresserHouse = dresserHouse;
	}

	public StackInterface<Bookcase> getBookcaseHouse() {
		return bookcaseHouse;
	}

	public void setBookcaseHouse(StackInterface<Bookcase> bookcaseHouse) {
		this.bookcaseHouse = bookcaseHouse;
	}
}
