// Encapsulation practice
class Student{
    private Integer studentId;
    private String studentName;
    private String collegeName;
    private String address;

    Student(){
        studentId = 1;
        studentName = "default";
        collegeName = "default";
        address = "default";
    }

    Student(Integer id, String name, String college, String ad){
        studentId = id;
        studentName = name;
        collegeName = college;
        address = ad;
    }

    //getter
    public Integer getId(){
        return studentId;
    }

    public String getStudentName(){
        return studentName;
    }

    public String getCollege(){
        return collegeName;
    }

    public String getAddress(){
        return address;
    }

    //setter
    public void setStudentId(Integer id){
        studentId = id;
    }
    public void setStudentName(String name){
        studentName = name;
    }
    public void setCollegeName(String name){
        collegeName = name;
    }
    public void setAddress(String ad){
        address = ad;
    }

}

public class TestStudent {
    public static void main(String[] args) {
        Student newStudent = new Student();
        System.out.println("id: " + newStudent.getId() +" name: " + newStudent.getStudentName() +" college: "+ newStudent.getCollege() +" address: "+newStudent.getAddress());
        newStudent.setStudentId(32);
        newStudent.setStudentName("Carl");
        newStudent.setCollegeName("WWU");
        newStudent.setAddress("1234 1st Ave");
        System.out.println("id: " + newStudent.getId() +" name: " + newStudent.getStudentName() +" college: "+ newStudent.getCollege() +" address: "+newStudent.getAddress());
        //System.out.println(newStudent.studentName); //error Line 64: error: studentName has private access in Student [in TestStudent.java]
        newStudent = new Student(10,"Janice","UW","4443 Forest Rd");
        System.out.println("id: " + newStudent.getId() +" name: " + newStudent.getStudentName() +" college: "+ newStudent.getCollege() +" address: "+newStudent.getAddress());
    }
}
