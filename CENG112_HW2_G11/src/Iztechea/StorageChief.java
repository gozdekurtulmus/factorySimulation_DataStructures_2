package Iztechea;

public class StorageChief<T extends Product> {
	private Storage houses;

	
	public StorageChief(Storage storage) {
		houses = storage;		//gets the storage
	}

	//This method is called when the storing operation will be made.
	public void storeProduct(QueueInterface<T> queue) { //It takes the Factory Line as an argument.
		T product = queue.dequeue(); //Takes the product from the factory line.

		if (product != null && product.isManufactured()) { //If line is not empty (product is not null & is manufactured)
			houses.storingOperation(product.getName(), product); //Pushes the product to its own warehouse.
			product.setStored(true);
		}
		printStoring(product);
	}

	//This method prints to console if the operation is a SUCCESS or a FAIL.
	public void printStoring(T product){
        if(product != null && product.isStored()) {
        System.out.println("Storage Chief storing "+ product.getName()+ ", SUCCESS, " 
        					+ product.getName() + " stored in "+ product.getName() + " warehouse.");
        }
        else {
            System.out.println("Storage Chief storing, FAIL, Factory line is empty.");
        	
        }
    }

    //This method is called at the end of the simulation to see how many products are in warehouses.
	public void printHouseReport() {
		int[] amountsList = houses.getAmounts(); //Gets the count numbers of each house
		Product accessProduct = new Product();
    	String[] productList = accessProduct.getProducts(); //Gets the list of products
    	System.out.println("\n");
    	for (int i=0; i<productList.length; i++) { //Prints the report
            System.out.println("Amount of "+ productList[i]+ " in "+ productList[i] +" Warehouse: " +amountsList[i]);
    	}	
	}

	public Storage getHouses() {
		return houses;
	}

	public void setHouses(Storage houses) {
		this.houses = houses;
	}
}

	


