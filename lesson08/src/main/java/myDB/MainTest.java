package myDB;

public class MainTest {

	public static void main(String[] args) {
	ProductsDBService dbService = new ProductsDBService(DBConnector.getInstance());
	System.out.println(dbService.getProducts());
	

	}

}

