package Iztechea;

public class Customer {
    private Product product;
    private Product getAccess; //to reach the product list
    private Storage storage;
    private int buyNumberBed; //number of beds sold
    private int buyNumberChair; //number of chair sold
    private int buyNumberBookcase; //number of bookcase sold
    private int buyNumberDresser; //number of dresser sold
    private int buyNumberTable;  //number of table sold
    private int buyNumberSofa; //number of sofa sold
    private int[] amounts ; //Keeps the number of products sold according to their type
    
    public Customer(Storage storage){
        this.product = new Product();
        this.storage = storage;
        this.getAccess = new Product();
        
    }

    public void buyProduct(String name){
    		this.product = storage.buyingOperation(name); //product equals to sold product or null
            if (product != null){
                product.setSold(true); //product sold so isSold must be true
                addBuyNumber(name); // increases the amount of product sold
                }
            printBuying(product,name); //prints whether product sold or nota
        }
    //Increases the amount of product sold by one, depending on its type
    public void addBuyNumber(String name){
        switch (name) {
            case "Bed" -> buyNumberBed++;
            case "Dresser" -> buyNumberDresser++;
            case "Chair" -> buyNumberChair++;
            case "Table" -> buyNumberTable++;
            case "Sofa" -> buyNumberSofa++;
            case "Bookcase" -> buyNumberBookcase++;
        }
    }
    public void printBuyProduct(int choice){
    	String productName = getAccess.getProduct(choice); //randomly select one product type
        buyProduct(productName);
    }
    public void printBuying(Product product, String name){
        if(product !=null && product.isSold()){ //product is not null and sold
            System.out.println("Customer buying " + product.getName() + ", SUCCESS, Customer bought " + product.getName());
        }
        else{
            System.out.println("Customer buying " + name + ", FAIL, "+ name + " warehouse empty");
        }
    }
    //Prints the amount of products sold at the end of the program according to their type.
    public void printCustomerReport(){
        String[] products = getAccess.getProducts();
        System.out.println("\n");
        soldCounts();
        for (int i = 0; i < amounts.length; i++){
            System.out.println("Amount of " + products[i] + " Sold: "+ amounts[i]);
        }

    }
    
    public void soldCounts() {
       this.amounts = new int[]{buyNumberSofa,buyNumberBed,buyNumberChair,buyNumberDresser,buyNumberTable,buyNumberBookcase}; 	
    }

    //starts the getters and setters methods
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getGetAccess() {
        return getAccess;
    }

    public void setGetAccess(Product getAccess) {
        this.getAccess = getAccess;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public int getBuyNumberBed() {
        return buyNumberBed;
    }

    public void setBuyNumberBed(int buyNumberBed) {
        this.buyNumberBed = buyNumberBed;
    }

    public int getBuyNumberChair() {
        return buyNumberChair;
    }

    public void setBuyNumberChair(int buyNumberChair) {
        this.buyNumberChair = buyNumberChair;
    }

    public int getBuyNumberBookcase() {
        return buyNumberBookcase;
    }

    public void setBuyNumberBookcase(int buyNumberBookcase) {
        this.buyNumberBookcase = buyNumberBookcase;
    }

    public int getBuyNumberDresser() {
        return buyNumberDresser;
    }

    public void setBuyNumberDresser(int buyNumberDresser) {
        this.buyNumberDresser = buyNumberDresser;
    }

    public int getBuyNumberTable() {
        return buyNumberTable;
    }

    public void setBuyNumberTable(int buyNumberTable) {
        this.buyNumberTable = buyNumberTable;
    }

    public int getBuyNumberSofa() {
        return buyNumberSofa;
    }

    public void setBuyNumberSofa(int buyNumberSofa) {
        this.buyNumberSofa = buyNumberSofa;
    }

    public int[] getAmounts() {
        return amounts;
    }

    public void setAmounts(int[] amounts) {
        this.amounts = amounts;
    }//ends the getters and setters methods
}
