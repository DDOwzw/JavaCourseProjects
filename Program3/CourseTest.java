
public class CourseTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Course cr = new Course("cs77", "akua", 2);
		Student st = new Student("Wa","25",100);
		Student st2 = new Student("ba","15",100);
		Student st3 = new Student("ma","5",100);
		
		
		cr.addStudent(st, 1);
		cr.addStudent(st2, 1);
		cr.addStudent(st3, 101);
		System.out.println(cr.registrationQueue);
		
		
		
		cr.processRegistrationList();
		
		
		
		
		System.out.println(cr.getCourseRegister());
		
	}

}
