package jp.co.sss.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	Employee findByEmpIdAndEmpPass(empId Integer,empPass String);
	
	List<Employee> findAllByOrderByEmpId();
	
	List<Employee> findByEmpNameContainingOrderByEmpId(empName String);

	List<Employee> findByDepartmentOrderByEmpId(department Department);
}
