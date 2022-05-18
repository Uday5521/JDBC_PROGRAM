package JavaToSqlUsingJdbcApi;

public class Test {
	public static void main(String[] args) {
		
		EmployeeDao dao = new EmployeeDao();
		
		Employee employee = new Employee();
		
//		employee.setId(22);
//		employee.setName("uday");
//		employee.setPh("string");
////		
//		dao.saveEmployee(employee);
		dao.getEmployee(1);

		
	}
	

}
