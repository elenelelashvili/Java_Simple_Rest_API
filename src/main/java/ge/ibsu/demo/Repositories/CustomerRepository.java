package ge.ibsu.demo.Repositories;

import ge.ibsu.demo.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
