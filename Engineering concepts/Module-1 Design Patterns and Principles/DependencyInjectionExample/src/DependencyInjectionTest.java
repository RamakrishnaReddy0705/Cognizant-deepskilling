

public class DependencyInjectionTest {

    public static void main(String[] args) {

        // Inject dependency
        CustomerRepository repository =
                new CustomerRepositoryImpl();

        CustomerService service =
                new CustomerService(repository);

        service.getCustomerDetails(101);
    }
}
