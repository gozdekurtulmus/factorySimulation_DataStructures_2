package Iztechea;
import java.util.Scanner;
import java.util.Random;

/* This class is called from main and used to perform the simulation. */

public class StartSimulation {
	
	private MarketAnalyst marketAnalyst;
	private Storage storage;
	private StorageChief<Product> storageChief;
	private Customer customer;

	public StartSimulation() {
		this.storage = new Storage();	//Creates the storage(Warehouses)
		this.marketAnalyst = new MarketAnalyst();    //Creates the Market Analyst Role
	    this.storageChief = new StorageChief<>(storage);	//Creates the Storage Chief Role
		this.customer = new Customer(storage);		// Creates the Customer Role
	}
	
	
	public void start() {
		 
		    Scanner scanner = new Scanner(System.in); //Takes the input of user
		    System.out.print("Enter the number of random request cycles:");
		    int requestNumber;
		    while (true){  //Checks if the entry is integer. If not, asks to enter a new entry until it is an integer.
		    	if(scanner.hasNextInt()){
		    	requestNumber = scanner.nextInt();
		    	break;
		    	}
		    	else{
		    		System.out.println("Please enter a number!");
					System.out.print("Enter the number of random request cycles:");
		    		scanner.next();
					}
			}
			scanner.close();
			callRoles(requestNumber); //Starts the simulation and choosing roles.
	        marketAnalyst.printNumberManufactured(); //Prints the number of products existing in the factory line.
	        storageChief.printHouseReport();	//Prints the number of products existing in the warehouses.
	        customer.printCustomerReport();		//Prints the number of products customer bought.
	}
		
	//Starts the simulation and choosing roles.
	private void callRoles(int requestNumber) {

		for(int i=1; i <= requestNumber; i++) { //Executes a simulation for number of requested times.
	    	int randomRole = randomNumber(3); //Chooses a random role.
	    	System.out.print(i+": ");
			switch (randomRole) {

				case 0 -> marketAnalyst.printManufactured(randomNumber(6)); //Calls Market Analyst with another random number to choose and manufacture a new product.
				case 1 -> storageChief.storeProduct(marketAnalyst.getFactoryLine()); //Calls Storage Chief to store a product from the factory line queue.
				case 2 -> customer.printBuyProduct(randomNumber(6)); //Calls Customer with another random number to buy a product.
			}
	    }		
		
	}
	
	private int randomNumber(int number) { //Generates a random number.
		Random rand = new Random();
		return rand.nextInt(number);		
	}


	public MarketAnalyst getMarketAnalyst() {
		return marketAnalyst;
	}

	public void setMarketAnalyst(MarketAnalyst marketAnalyst) {
		this.marketAnalyst = marketAnalyst;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public StorageChief<Product> getStorageChief() {
		return storageChief;
	}

	public void setStorageChief(StorageChief<Product> storageChief) {
		this.storageChief = storageChief;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
