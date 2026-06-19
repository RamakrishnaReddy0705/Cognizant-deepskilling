public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public String findCustomerById(int id) {
        return "Customer Found : ID = " + id + ", Name = Ramakrishna";
    }
}