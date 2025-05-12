package assignments;





class User {
	public Integer id;
	public String name;
	
	
	public User(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}

class Employee extends User{

	public double salary;

	public Employee(Integer id, String name, Double salary) {
		super(id, name);
		this.salary = salary;
	}
	
	public double calculateSalary() {
		return salary * 12;
	}
	
}




public class CalculateAnualSalary {

	public static void main(String[] args) {
		
		Employee emp = new Employee(101, "Amarjeet", 10000.00);
		
		double anualSalary = emp.calculateSalary();
		System.out.println("Id: " + emp.id);
		System.out.println("Name: " + emp.name);
		System.out.println("Anual Salary: " + anualSalary);


	}

}
