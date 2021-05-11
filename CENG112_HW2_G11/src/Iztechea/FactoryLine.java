package Iztechea;

public class FactoryLine<T extends Product> {
    private QueueInterface<T> factoryLine; //factory line based on FIFO structure
    private T product;
    private int manufactureNumberBed = 0; //number of beds manufactured
    private int manufactureNumberChair = 0; //number of chair manufactured
    private int manufactureNumberDresser = 0; //number of dresser manufactured
    private int manufactureNumberTable = 0; //number of table manufactured
    private int manufactureNumberBookcase = 0; //number of bookcase manufactured
    private int manufactureNumberSofa = 0; //number of sofa manufactured

    @SuppressWarnings("unchecked")
    public FactoryLine() {
        this.factoryLine = new ArrayQueue<>();
        this.product = (T) new Product();
    }
    
    //randomly generates product and return this product
    public T manufacture(int choice) {
        String item = product.getProduct(choice); //name of the product to be manufactured
        product = manufactureProduct(item); //product is manufactured
        factoryLine.enqueue(product); //product is added factory line
        product.setManufactured(true); //product is manufactured so isManufactured must be true
        return product;
    }

    @SuppressWarnings("unchecked")
	//returns the product to be manufactured
    public T manufactureProduct(String productName) {
		return switch (productName) {
			case "Bed" -> (T) new Bed();
			case "Sofa" -> (T) new Sofa();
			case "Dresser" -> (T) new Chair();
			case "Table" -> (T) new Dresser();
			case "Chair" -> (T) new Table();
			case "Bookcase" -> (T) new Bookcase();
			default -> null;
		};
    }
    //returns a list of how much of which product at the end of the program
    public int[] numberManufactured() {
    	while (!factoryLine.isEmpty()) {
    		Product frontProduct = factoryLine.dequeue();
			switch (frontProduct.getName()) {
				case "Bed" -> manufactureNumberBed++;
				case "Sofa" -> manufactureNumberSofa++;
				case "Dresser" -> manufactureNumberDresser++;
				case "Table" -> manufactureNumberTable++;
				case "Chair" -> manufactureNumberChair++;
				case "Bookcase" -> manufactureNumberBookcase++;
			}
    	}
		return new int[]{manufactureNumberSofa, manufactureNumberBed, manufactureNumberChair, manufactureNumberDresser,
							manufactureNumberTable, manufactureNumberBookcase};
    	
    }  
    //Prints the amount of the product in the factory line at the end of the program
    public void totalNumberManufactured(){
    	int[] amountsList = numberManufactured();
    	String[] productList = product.getProducts();
    	System.out.println("\n");
    	for (int i=0; i<productList.length; i++) {
            System.out.println("Amount of "+ productList[i]+ " in Factory Line: "+ amountsList[i]);
    	}
  }
    
    public  QueueInterface<T> getFactoryLine(){
 	   return this.factoryLine;
    }
	// starts the getters and setters methods
	public void setFactoryLine(QueueInterface<T> factoryLine) {
		this.factoryLine = factoryLine;
	}

	public T getProduct() {
		return product;
	}

	public void setProduct(T product) {
		this.product = product;
	}

	public int getManufactureNumberBed() {
		return manufactureNumberBed;
	}

	public void setManufactureNumberBed(int manufactureNumberBed) {
		this.manufactureNumberBed = manufactureNumberBed;
	}

	public int getManufactureNumberChair() {
		return manufactureNumberChair;
	}

	public void setManufactureNumberChair(int manufactureNumberChair) {
		this.manufactureNumberChair = manufactureNumberChair;
	}

	public int getManufactureNumberDresser() {
		return manufactureNumberDresser;
	}

	public void setManufactureNumberDresser(int manufactureNumberDresser) {
		this.manufactureNumberDresser = manufactureNumberDresser;
	}

	public int getManufactureNumberTable() {
		return manufactureNumberTable;
	}

	public void setManufactureNumberTable(int manufactureNumberTable) {
		this.manufactureNumberTable = manufactureNumberTable;
	}

	public int getManufactureNumberBookcase() {
		return manufactureNumberBookcase;
	}

	public void setManufactureNumberBookcase(int manufactureNumberBookcase) {
		this.manufactureNumberBookcase = manufactureNumberBookcase;
	}

	public int getManufactureNumberSofa() {
		return manufactureNumberSofa;
	}

	public void setManufactureNumberSofa(int manufactureNumberSofa) {
		this.manufactureNumberSofa = manufactureNumberSofa;
	}//ends the getters and setters methods
}