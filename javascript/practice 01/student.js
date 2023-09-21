class Student {
    constructor(rollno, firstname, lastname, marks,fullname,average,grades,final,DOB,age) {
        this.rollno = rollno
        this.firstname = firstname
        this.lastname = lastname
        this.marks = marks
        this.fullname =fullname
        this.average= average
        this.grades = grades
        this.final = final
        this.DOB=DOB;  
        this.age=age;
        // this.fullname = lastname + " " + firstname
        // this.average = Student.averageMarks(marks)
        // this.grades = Student.gradeMarks(marks)
        // this.final = Student.gradeMarks([Student.average])[0]
    }

    static newStudent(rollno, firstname, lastname, marks,DOB){
        if(typeof(lastname)!="string"){
            return "lastname";
        } if (typeof(firstname)!="string"){
            return "firstname";
        } if (typeof(rollno)!="number"){
            return "rollno";
        } if (typeof(marks)!="object"){
            return "marks";
        }
        let dob=new Date(DOB);
        if(typeof dob=='Invalid Date'){
            return "Invalid Date";
        }
        
        let fullname = lastname + " " + firstname
        let average = Student.averageMarks(marks)
        let grades = Student.gradeMarks(marks)
        let final = Student.gradeMarks([average])[0]
        let age= Student.calcAge(DOB);
        return new Student(rollno, firstname, lastname, marks,fullname,average,grades,final,DOB,age)
    }


    static averageMarks(marks) {
        let sum = 0;
        for (let i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        let ave = sum / marks.length;
        return ave;
    }
    static gradeMarks(marks) {
        let grade = Array(marks.length);
        for (let i = 0; i < marks.length; i++) {
            if (marks[i] > 10 && marks[i] < 80) {
                grade[i] = "A";
            }
            else if(marks[i] <= 10){
                grade[i] = "C";
            }
        }
        return grade;
    }
    static calcAge(DOB)  
    {  
        let d= new Date(DOB)
        return new Date().getFullYear() - d.getFullYear();
    }  

}
let s1 = Student.newStudent(1, 'rohit', 'sabat', [10, 20, 30, 40],"2001-02-05")
console.log(s1.constructor.name)
console.log(s1)

// console.log(s1.fullname)
// let s2=new Student(1,'martin','guptil',80)
// console.log(s2)
// s1=s2
// console.log(s2)
