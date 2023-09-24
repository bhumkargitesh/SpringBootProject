package com.example.employeepayrollapp.repo;
import com.example.employeepayrollapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PayrollAppRepo extends JpaRepository<Employee, Integer> {
//    @Query(value ="select c from employee c  where c.name= :Name ",nativeQuery = true )
//    List<EmployeeDto> findByName(@Param("name")String Name);
}


