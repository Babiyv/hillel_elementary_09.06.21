package lesson12;

import lesson12.dao.CustomerDao;
import lesson12.entity.Customer;

public class Main {
    public static void main(String[] args) {
        CustomerDao customerDao = new CustomerDao();
//        вывод размера SQL таблицы кастомеров:
        System.out.println(customerDao.findAllCustomers().size());

//        вывод конкретных записей с таблицы SQL
        System.out.println(customerDao.findAllCustomers());

//        вывод конкретных записей с таблицы SQL через цикл foreach:
        for (Customer customer : customerDao.findAllCustomers()) {
            System.out.println(customer);
        }

        Customer customer = new Customer();
        customer.setName("NAME");
        customer.setSurname("SURNAME");
        customer.setEmail("qrq@mail.com");
        customer.setPassword("geg");
        customer.setAge(4);

        customerDao.save(customer);

        customerDao.delete(5);
        System.out.println("deleted");
/*        for (Customer customer : customerDao.findAllCustomers()) {
            System.out.println(customer);
        }*/
    }
}
