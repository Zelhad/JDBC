package utils;

import dao.ProductDao;
import serviceImpl.ProductServiceImpl;

public class TestWithSystemOutPrintln {
	public static void main(String[] args) throws java.sql.SQLException {

		ProductDao dao = new ProductDao();
		ProductServiceImpl productServiceImpl = new ProductServiceImpl(dao);

		/*
		 * List<BillingAccountRef> billingAccountRefs =
		 * productServiceImpl.findBillingAccountRef();
		 * billingAccountRefs.forEach(System.out::println);
		 */
		// List<RelatedPlaceRefOrValue> placeRefOrValues =
		// productServiceImpl.findRelatedPlaceRefOrValues();
		// System.out.println(placeRefOrValues);

		// Task 1 print only the names;
		/*
		 * for(RelatedPlaceRefOrValue place : placeRefOrValues) {
		 * System.out.println(place.getName()); }
		 * 
		 */

		// Tak2 Find the object whose role equals "main"
		/*
		 * for(RelatedPlaceRefOrValue place : placeRefOrValues) { if( "main"
		 * .equals(place.getRole())) { System.out.println(place.getName() +
		 * "Has a Rool " + place.getRole()); } }
		 */

		// Debug addProduct via java scanner

		/*
		 * id href description is_bundle is_customer_visible name order_date
		 * product_serial_number start_date termination_date
		 */
		java.util.Scanner scanner = new java.util.Scanner(System.in);

		System.out.println("Enter id  :");
		String id = scanner.nextLine();

		System.out.println("Enter hrefs  :");
		String href = scanner.nextLine();

		System.out.println("Enter description  :");
		String description = scanner.nextLine();

		System.out.println("Is the product is bundle ? Type 1 for Yes, 2 for No:");
		Integer userChoise = scanner.nextInt();

		boolean isBundle = false;
		switch (userChoise) {
		case 1:
			isBundle = true;
			break;
		case 2:
			isBundle = false;
			break;
		default:
			System.out.println("invalid answer");
			isBundle = false;
		}
		System.out.println("Is the product a customer visiible ? Type 1 for Yes, 2 for No:");
		boolean isCostomerVisible = false;
		int costumerVisible = scanner.nextInt();
		scanner.nextLine();
		switch (costumerVisible) {
		case 1:
			isCostomerVisible = true;
			break;
		case 2:
			isCostomerVisible = false;
			break;
		default:
			System.out.println("invalid option");
			isCostomerVisible = false;
		}
		System.out.println("Provide name of  the product ");
		String productName = scanner.nextLine();

		//scanner.nextLine();
		System.out.println("Provide Order product date");
		String order_date = scanner.nextLine();
		//System.out.println(order_date);

		// java.sql.Timestamp.from(Instant.)

		// OffsetDateTime offsetDateTime = OffsetDateTime.parse()

		// System.out.println(offsetDateTime);

		System.out.println("Your id is -----> " + id + "\nhref --->" + href + "\ndescription --->" + description
				+ "\nis bundle ---->" + isBundle + "\ncostumer  visible --->" + isCostomerVisible + "\n name -->"
				+ productName + " Order date -->" + order_date);

		scanner.close();
	}
}