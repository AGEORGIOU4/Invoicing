/**Andreas Georgiou**/

package com.company;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Vector;

public class Tests {
    /**======================================CUSTOMER======================================**/
    @Test
    public void testCustomerNameOnConstruction() {
        // Arrange
        String firstName = "firstName";
        Customer customer = new Customer(firstName, "midName",
                "lastName", "address 111", "+35799123456");
        Assertions.assertEquals(firstName, customer.getFirstName());
    }

    @Test
    public void testCustomerMidNameOnConstruction() {
        // Arrange
        String midName = "George";
        Customer customer = new Customer("firstName", midName,
                "lastName", "address 111", "+35799123456");

        //Assert
        Assertions.assertEquals(midName, customer.getMiddleName());
    }

    @Test
    public void testCustomerLastNameOnConstruction() {
        // Arrange
        String lastName = "lastName";
        Customer customer = new Customer("firstName", "midName",
                lastName, "address 111", "+35799123456");

        //Assert
        Assertions.assertEquals(lastName, customer.getLastName());
    }

    @Test
    public void testCustomerAddressOnConstruction() {
        // Arrange
        String address = "address 111";
        Customer customer = new Customer("firstName", "midName",
                "lastName", address, "+35799123456");

        //Assert
        Assertions.assertEquals(address, customer.getAddress());
    }

    @Test
    public void testCustomerPhoneOnConstruction() {
        // Arrange
        String phone = "+35799123456";
        Customer customer = new Customer("firstName", "midName",
                "lastName", "address 111", phone);

        //Assert
        Assertions.assertEquals(phone, customer.getPhone());
    }

    @Test
    public void testCustomerNameWhenSet() {
        // Arrange
        Customer customer = new Customer("firstName", "midName",
                "lastName", "address 111", "+35799123456");

        // Act
        customer.setFirstName("Andreas");
        //Assert
        Assertions.assertEquals("Andreas", customer.getFirstName());
    }

    @Test
    public void testCustomerMidNameWhenSet() {
        // Arrange
        Customer customer = new Customer("firstName", "midName",
                "lastName", "address 111", "+35799123456");

        // Act
        customer.setMiddleName("George");
        //Assert
        Assertions.assertEquals("George", customer.getMiddleName());
    }

    @Test
    public void testCustomerLastNameWhenSet() {
        // Arrange
        Customer customer = new Customer("firstName", "midName",
                "lastName", "address 111", "+35799123456");

        // Act
        customer.setLastName("Georgiou");
        //Assert
        Assertions.assertEquals("Georgiou", customer.getLastName());
    }

    @Test
    public void testCustomerAddressWhenSet() {
        // Arrange
        Customer customer = new Customer("firstName", "midName",
                "lastName", "address 111", "+35799123456");

        // Act
        customer.setAddress("Archiepiskopou Makariou C' 111");
        //Assert
        Assertions.assertEquals("Archiepiskopou Makariou C' 111", customer.getAddress());
    }

    @Test
    public void testCustomerPhoneWhenSet() {
        // Arrange
        Customer customer = new Customer("firstName", "midName",
                "lastName", "address 111", "+35799123456");

        // Act
        customer.setPhone("+35799131666");
        //Assert
        Assertions.assertEquals("+35799131666", customer.getPhone());
    }

    /**======================================SERVICE======================================**/
    @Test
    public void testServiceNameOnConstruction() {
        // Arrange
        String name = "name";
        Service service = new Service(name, "description", 1.0f);

        //Assert
        Assertions.assertEquals(name, service.getName());
    }

    @Test
    public void testServiceDescriptionOnConstruction() {
        // Arrange
        String description = "description";
        Service service = new Service("name", description, 1.0f);

        //Assert
        Assertions.assertEquals(description, service.getDescription());
    }

    @Test
    public void testServicePriceOnConstruction() {
        // Arrange
        float price = 53.89f;
        Service service = new Service("name", "description", price);

        //Assert
        Assertions.assertEquals(price, service.getPrice());
    }

    @Test
    public void testServiceNameWhenSet() {
        // Arrange
        Service service = new Service("name", "description", 1.0f);

        // Act
        service.setName("testName");

        //Assert
        Assertions.assertEquals("testName", service.getName());
    }

    @Test
    public void testServiceDescriptionWhenSet() {
        // Arrange
        Service service = new Service("name", "description", 1.0f);

        // Act
        service.setDescription("testDescription");

        //Assert
        Assertions.assertEquals("testDescription", service.getDescription());
    }

    @Test
    public void testServicePriceWhenSet() {
        // Arrange
        Service service = new Service("name", "description", 1.0f);

        // Act
        service.setPrice(53.89f);

        //Assert
        Assertions.assertEquals(53.89f, service.getPrice());
    }

    /**======================================ITEM======================================**/
    @Test
    public void testItemServiceName() {
        // Arrange
        Service service = new Service("name", "description", 1.0f);
        Item item = new Item(service, 1);

        //Act
        item.getService().setName("test");
        //Assert
        Assertions.assertEquals("test", item.getService().getName());
    }

    @Test
    public void testItemServiceDescription() {
        // Arrange
        Service service = new Service("name", "description", 1.0f);
        Item item = new Item(service, 1);

        //Act
        item.getService().setDescription("description");
        //Assert
        Assertions.assertEquals("description", item.getService().getDescription());
    }

    @Test
    public void testItemServicePrice() {
        // Arrange
        Service service = new Service("name", "description", 1.0f);
        Item item = new Item(service, 1);

        //Act
        item.getService().setPrice(55.12f);
        //Assert
        Assertions.assertEquals(55.12f, item.getService().getPrice());
    }

    @Test
    public void testItemQuantityOnConstruction() {
        // Arrange
        int quantity = 5;
        Service service = new Service("name", "description", 1.0f);
        Item item = new Item(service, quantity);

        //Assert
        Assertions.assertEquals(5, item.getQuantity());
    }

    @Test
    public void testItemQuantityWhenSet() {
        // Arrange
        Service service = new Service("name", "description", 1.0f);
        Item item = new Item(service, 1);

        // Act
        item.setQuantity(10);
        //Assert
        Assertions.assertEquals(10, item.getQuantity());
    }

    @Test
    public void testItemAmountWhenSet() {
        // Arrange
        Service service = new Service("name", "description", 1.0f);
        Item item = new Item(service, 1);

        // Act
        item.setAmount(100);
        //Assert
        Assertions.assertEquals(100, item.getAmount());
    }

    @Test
    public void testItemCalculateAmount() {
        // Arrange
        float servicePrice = 1.50f;
        int quantity = 3;
        Service service = new Service("name", "description", servicePrice);
        Item item = new Item(service, quantity);

        // Act
        item.calculateAmount(service);

        //Assert
        Assertions.assertEquals(4.50f, item.getAmount());
    }

    /**======================================INVOICE======================================**/
    @Test
    public void testInvoiceNumberOnConstruction() {
        // Arrange
        Service service = new Service("name", "description", 1.0f);
        //--------------------------------------//
        Item item1 = new Item(service, 1);
        Item item2 = new Item(service, 2);
        //--------------------------------------//
        Vector<Item> listOfItems = new Vector<>();
        listOfItems.add(item1);
        listOfItems.add(item2);
        //--------------------------------------//
        Invoice invoice = new Invoice(1, System.currentTimeMillis(), listOfItems);
        //--------------------------------------//

        //Assert
        Assertions.assertEquals(1, invoice.getNumber());
    }

    @Test
    public void testInvoiceListOfItemsOnConstruction() {
        // Arrange
        Service service = new Service("name", "description", 1.0f);
        //--------------------------------------//
        Item item1 = new Item(service, 1);
        Item item2 = new Item(service, 2);
        //--------------------------------------//
        Vector<Item> listOfItems = new Vector<>();
        listOfItems.add(item1);
        listOfItems.add(item2);
        //--------------------------------------//
        Invoice invoice = new Invoice(1, System.currentTimeMillis(), listOfItems);
        //--------------------------------------//


        //Assert
        Assertions.assertEquals(listOfItems, invoice.getItems());
    }

    @Test
    public void testInvoiceNumberWhenSet() {
        // Arrange
        Service service = new Service("name", "description", 1.0f);
        //--------------------------------------//
        Item item1 = new Item(service, 1);
        Item item2 = new Item(service, 2);
        //--------------------------------------//
        Vector<Item> listOfItems = new Vector<>();
        listOfItems.add(item1);
        listOfItems.add(item2);
        //--------------------------------------//
        Invoice invoice = new Invoice(1, System.currentTimeMillis(), listOfItems);
        //--------------------------------------//

        // Act
        invoice.setNumber(5);

        //Assert
        Assertions.assertEquals(5, invoice.getNumber());
    }

    @Test
    public void testInvoiceListOfItemsWhenSet() {
        // Arrange
        Service service = new Service("name", "description", 1.0f);
        //--------------------------------------//
        Item item1 = new Item(service, 1);
        Item item2 = new Item(service, 2);
        //--------------------------------------//
        Vector<Item> listOfItems = new Vector<>();
        listOfItems.add(item1);
        listOfItems.add(item2);
        //--------------------------------------//
        Invoice invoice = new Invoice(1, System.currentTimeMillis(), listOfItems);
        //--------------------------------------//

        // Act
        Item item3 = new Item(service, 3);
        listOfItems.add(item3);
        invoice.setItems(listOfItems);

        //Assert
        Assertions.assertEquals(listOfItems, invoice.getItems());
    }

    @Test
    public void testInvoiceListOfItemsWhenClear() {
        // Arrange
        Service service = new Service("name", "description", 1.0f);
        //--------------------------------------//
        Item item1 = new Item(service, 1);
        Item item2 = new Item(service, 2);
        //--------------------------------------//
        Vector<Item> listOfItems = new Vector<>();
        listOfItems.add(item1);
        listOfItems.add(item2);
        //--------------------------------------//
        Invoice invoice = new Invoice(1, System.currentTimeMillis(), listOfItems);
        //--------------------------------------//

        // Act
        invoice.clearInvoice();

        //Assert
        Assertions.assertEquals(0, invoice.getItems().size());
    }

    @Test
    public void testInvoiceTotalAmount() {
        // Arrange
        Service service = new Service("name", "description", 1.0f);
        //--------------------------------------//
        Item item1 = new Item(service, 1);
        Item item2 = new Item(service, 2);
        //--------------------------------------//
        Vector<Item> listOfItems = new Vector<>();
        listOfItems.add(item1);
        listOfItems.add(item2);
        //--------------------------------------//
        Invoice invoice = new Invoice(1, System.currentTimeMillis(), listOfItems);
        //--------------------------------------//

        // Act
        // Total amount is auto-calculated - Amount (Service price * quantity) * Sum of Item amounts
        float totalAmount = (1 * 1) + (1 * 2);
        invoice.calculateTotalAmount(listOfItems);

        //Assert
        Assertions.assertEquals(totalAmount, invoice.getTotalAmount());
    }

    /**======================================ACCOUNT======================================**/
    @Test
    public void testAccountNumberOnFirstConstructor() {
        // Arrange
        //--------------------------------------//
        Customer customer = new Customer("firstName", "midName",
                "lastName", "address 111", "+35799123456");
        //--------------------------------------//
        Account account = new Account(1, customer);
        //--------------------------------------//

        //Assert
        Assertions.assertEquals(1, account.getNumber());
    }

    @Test
    public void testAccountNumberOnSecondConstructor() {
        // Arrange
        Service service = new Service("name", "description", 1.0f);
        Vector<Service> listOfServices = new Vector<>();
        listOfServices.add(service);
        //--------------------------------------//
        Item item1 = new Item(service, 1);
        Item item2 = new Item(service, 2);
        //--------------------------------------//
        Vector<Item> listOfItems = new Vector<>();
        listOfItems.add(item1);
        listOfItems.add(item2);
        //--------------------------------------//
        Invoice invoice = new Invoice(1, System.currentTimeMillis(), listOfItems);
        Vector<Invoice> listOfInvoices = new Vector<>();
        listOfInvoices.add(invoice);
        //--------------------------------------//
        Customer customer = new Customer("firstName", "midName",
                "lastName", "address 111", "+35799123456");
        //--------------------------------------//
        Account account = new Account(1, customer, listOfServices, listOfInvoices);
        //--------------------------------------//

        //Assert
        Assertions.assertEquals(1, account.getNumber());
    }

    @Test
    public void testAccountCustomerFirstNameOnConstruction() {
        // Arrange
        Service service = new Service("name", "description", 1.0f);
        Vector<Service> listOfServices = new Vector<>();
        listOfServices.add(service);
        //--------------------------------------//
        Item item1 = new Item(service, 1);
        Item item2 = new Item(service, 2);
        //--------------------------------------//
        Vector<Item> listOfItems = new Vector<>();
        listOfItems.add(item1);
        listOfItems.add(item2);
        //--------------------------------------//
        Invoice invoice = new Invoice(1, System.currentTimeMillis(), listOfItems);
        Vector<Invoice> listOfInvoices = new Vector<>();
        listOfInvoices.add(invoice);
        //--------------------------------------//
        Customer customer = new Customer("firstName", "midName",
                "lastName", "address 111", "+35799123456");
        //--------------------------------------//
        Account account = new Account(1, customer, listOfServices, listOfInvoices);
        //--------------------------------------//

        //Assert
        Assertions.assertEquals("firstName", account.getCustomer().getFirstName());
    }

    @Test
    public void testAccountCustomerMiddleNameOnConstruction() {
        // Arrange
        Service service = new Service("name", "description", 1.0f);
        Vector<Service> listOfServices = new Vector<>();
        listOfServices.add(service);
        //--------------------------------------//
        Item item1 = new Item(service, 1);
        Item item2 = new Item(service, 2);
        //--------------------------------------//
        Vector<Item> listOfItems = new Vector<>();
        listOfItems.add(item1);
        listOfItems.add(item2);
        //--------------------------------------//
        Invoice invoice = new Invoice(1, System.currentTimeMillis(), listOfItems);
        Vector<Invoice> listOfInvoices = new Vector<>();
        listOfInvoices.add(invoice);
        //--------------------------------------//
        Customer customer = new Customer("firstName", "midName",
                "lastName", "address 111", "+35799123456");
        //--------------------------------------//
        Account account = new Account(1, customer, listOfServices, listOfInvoices);
        //--------------------------------------//

        //Assert
        Assertions.assertEquals("midName", account.getCustomer().getMiddleName());
    }

    @Test
    public void testAccountCustomerLastNameOnConstruction() {
        // Arrange
        Service service = new Service("name", "description", 1.0f);
        Vector<Service> listOfServices = new Vector<>();
        listOfServices.add(service);
        //--------------------------------------//
        Item item1 = new Item(service, 1);
        Item item2 = new Item(service, 2);
        //--------------------------------------//
        Vector<Item> listOfItems = new Vector<>();
        listOfItems.add(item1);
        listOfItems.add(item2);
        //--------------------------------------//
        Invoice invoice = new Invoice(1, System.currentTimeMillis(), listOfItems);
        Vector<Invoice> listOfInvoices = new Vector<>();
        listOfInvoices.add(invoice);
        //--------------------------------------//
        Customer customer = new Customer("firstName", "midName",
                "lastName", "address 111", "+35799123456");
        //--------------------------------------//
        Account account = new Account(1, customer, listOfServices, listOfInvoices);
        //--------------------------------------//

        //Assert
        Assertions.assertEquals("lastName", account.getCustomer().getLastName());
    }

    @Test
    public void testAccountCustomerAddressOnConstruction() {
        // Arrange
        Service service = new Service("name", "description", 1.0f);
        Vector<Service> listOfServices = new Vector<>();
        listOfServices.add(service);
        //--------------------------------------//
        Item item1 = new Item(service, 1);
        Item item2 = new Item(service, 2);
        //--------------------------------------//
        Vector<Item> listOfItems = new Vector<>();
        listOfItems.add(item1);
        listOfItems.add(item2);
        //--------------------------------------//
        Invoice invoice = new Invoice(1, System.currentTimeMillis(), listOfItems);
        Vector<Invoice> listOfInvoices = new Vector<>();
        listOfInvoices.add(invoice);
        //--------------------------------------//
        Customer customer = new Customer("firstName", "midName",
                "lastName", "address 111", "+35799123456");
        //--------------------------------------//
        Account account = new Account(1, customer, listOfServices, listOfInvoices);
        //--------------------------------------//

        //Assert
        Assertions.assertEquals("address 111", account.getCustomer().getAddress());
    }

    @Test
    public void testAccountCustomerPhoneOnConstruction() {
        // Arrange
        Service service = new Service("name", "description", 1.0f);
        Vector<Service> listOfServices = new Vector<>();
        listOfServices.add(service);
        //--------------------------------------//
        Item item1 = new Item(service, 1);
        Item item2 = new Item(service, 2);
        //--------------------------------------//
        Vector<Item> listOfItems = new Vector<>();
        listOfItems.add(item1);
        listOfItems.add(item2);
        //--------------------------------------//
        Invoice invoice = new Invoice(1, System.currentTimeMillis(), listOfItems);
        Vector<Invoice> listOfInvoices = new Vector<>();
        listOfInvoices.add(invoice);
        //--------------------------------------//
        Customer customer = new Customer("firstName", "midName",
                "lastName", "address 111", "+35799123456");
        //--------------------------------------//
        Account account = new Account(1, customer, listOfServices, listOfInvoices);
        //--------------------------------------//

        //Assert
        Assertions.assertEquals("+35799123456", account.getCustomer().getPhone());
    }

    @Test
    public void testAccountBalanceOnConstruction() {
        // Arrange
        Service service = new Service("name", "description", 1.0f);
        Vector<Service> listOfServices = new Vector<>();
        listOfServices.add(service);
        //--------------------------------------//
        Item item1 = new Item(service, 1);
        Item item2 = new Item(service, 2);
        //--------------------------------------//
        Vector<Item> listOfItems = new Vector<>();
        listOfItems.add(item1);
        listOfItems.add(item2);
        //--------------------------------------//
        Invoice invoice = new Invoice(1, System.currentTimeMillis(), listOfItems);
        Vector<Invoice> listOfInvoices = new Vector<>();
        listOfInvoices.add(invoice);
        //--------------------------------------//
        Customer customer = new Customer("firstName", "midName",
                "lastName", "address 111", "+35799123456");
        //--------------------------------------//
        Account account = new Account(1, customer, listOfServices, listOfInvoices);
        //--------------------------------------//

        // Act
        // Balance is auto-calculated (sum of all the customer's invoice total amounts)
        float balance = ((1 * 1) + (1 * 2)) * 1;

        //Assert
        Assertions.assertEquals(balance, account.getBalance());
    }

    @Test
    public void testAccountBalanceWhenInvoiceAdded() {
        // Arrange
        Service service1 = new Service("name", "description", 1.0f);
        Vector<Service> listOfServices = new Vector<>();
        listOfServices.add(service1);
        //--------------------------------------//
        Item item1 = new Item(service1, 1);
        Item item2 = new Item(service1, 2);
        //--------------------------------------//
        Vector<Item> listOfItems1 = new Vector<>();
        listOfItems1.add(item1);
        listOfItems1.add(item2);
        //--------------------------------------//
        Invoice invoice1 = new Invoice(1, System.currentTimeMillis(), listOfItems1);
        Vector<Invoice> listOfInvoices = new Vector<>();
        listOfInvoices.add(invoice1);
        //--------------------------------------//
        Customer customer = new Customer("firstName", "midName",
                "lastName", "address 111", "+35799123456");
        //--------------------------------------//
        Account account = new Account(1, customer, listOfServices, listOfInvoices);
        //--------------------------------------//

        // Act
        // Create another invoice
        Service service2 = new Service("name2", "description2", 2.0f);
        listOfServices.add(service2);
        //--------------------------------------//
        Item item3 = new Item(service2, 5);
        //--------------------------------------//
        Vector<Item> listOfItems2 = new Vector<>();
        listOfItems2.add(item3);
        //--------------------------------------//
        Invoice invoice2 = new Invoice(1, System.currentTimeMillis(), listOfItems2);
        listOfInvoices.add(invoice2); // add new invoice on the account list
        account.calculateBalance(listOfInvoices); // calculate balance
        //--------------------------------------//
        // The balance must be equal to the sum of previous invoice plus the new one ((1 x 1) + (2 x 1) + (2 x 5)))
        float balance = ((1 * 1) + (1 * 2)) + (2 * 5);

        //Assert
        Assertions.assertEquals(balance, account.getBalance());
    }

    @Test
    public void testAccountServicesOnSet() {
        // Arrange
        Service service = new Service("name", "description", 1.0f);
        Vector<Service> listOfServices = new Vector<>();
        listOfServices.add(service);
        //--------------------------------------//
        Item item1 = new Item(service, 1);
        Item item2 = new Item(service, 2);
        //--------------------------------------//
        Vector<Item> listOfItems = new Vector<>();
        listOfItems.add(item1);
        listOfItems.add(item2);
        //--------------------------------------//
        Invoice invoice = new Invoice(1, System.currentTimeMillis(), listOfItems);
        Vector<Invoice> listOfInvoices = new Vector<>();
        listOfInvoices.add(invoice);
        //--------------------------------------//
        Customer customer = new Customer("firstName", "midName",
                "lastName", "address 111", "+35799123456");
        //--------------------------------------//
        Account account = new Account(1, customer, listOfServices, listOfInvoices);
        //--------------------------------------//

        // Act
        Service service2 = new Service("name2", "description", 1.0f);
        Vector<Service> listOfServices2 = new Vector<>();
        listOfServices2.add(service2);
        account.setServices(listOfServices2);

        //Assert
        Assertions.assertEquals("name2", account.getServices().get(0).getName());
    }

    @Test
    public void testAccountInvoicesOnSet() {
        // Arrange
        Service service = new Service("name", "description", 1.0f);
        Vector<Service> listOfServices = new Vector<>();
        listOfServices.add(service);
        //--------------------------------------//
        Item item1 = new Item(service, 1);
        Item item2 = new Item(service, 2);
        //--------------------------------------//
        Vector<Item> listOfItems = new Vector<>();
        listOfItems.add(item1);
        listOfItems.add(item2);
        //--------------------------------------//
        Invoice invoice = new Invoice(1, System.currentTimeMillis(), listOfItems);
        Vector<Invoice> listOfInvoices = new Vector<>();
        listOfInvoices.add(invoice);
        //--------------------------------------//
        Customer customer = new Customer("firstName", "midName",
                "lastName", "address 111", "+35799123456");
        //--------------------------------------//
        Account account = new Account(1, customer, listOfServices, listOfInvoices);
        //--------------------------------------//

        // Act
        Invoice invoice2 = new Invoice(2, System.currentTimeMillis(), listOfItems);
        Vector<Invoice> listOfInvoices2 = new Vector<>();
        listOfInvoices2.add(invoice2);
        account.setInvoices(listOfInvoices2);

        //Assert
        Assertions.assertEquals(2, account.getInvoices().get(0).getNumber());
    }

    @Test
    public void testAccountGenerateInvoice() {
        // Arrange
        Service service = new Service("name", "description", 1.0f);
        Service service2 = new Service("name", "description", 2.0f);
        Vector<Service> listOfServices = new Vector<>();
        listOfServices.add(service);
        listOfServices.add(service2);
        //--------------------------------------//
        Item item1 = new Item(service, 1);
        Item item2 = new Item(service, 2);
        Item item3 = new Item(service2, 3);
        //--------------------------------------//
        Vector<Item> listOfItems = new Vector<>();
        listOfItems.add(item1);
        listOfItems.add(item2);
        listOfItems.add(item3);
        //--------------------------------------//
        Invoice invoice = new Invoice(1, System.currentTimeMillis(), listOfItems);
        Vector<Invoice> listOfInvoices = new Vector<>();
        listOfInvoices.add(invoice);
        //--------------------------------------//
        Customer customer = new Customer("firstName", "midName",
                "lastName", "address 111", "+35799123456");
        //--------------------------------------//
        Account account = new Account(1, customer, listOfServices, listOfInvoices);
        //--------------------------------------//

        // Act
        boolean generateInvoice = account.generateCustomerInvoice();

        //Assert
        Assertions.assertTrue(generateInvoice);
    }
}