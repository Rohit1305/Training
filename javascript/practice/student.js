class Student {
    constructor(rollno, firstname, lastname, marks,fullname,average,grades,final) {
        this.rollno = rollno
        this.firstname = firstname
        this.lastname = lastname
        this.marks = marks
        this.fullname =fullname
        this.average= average
        this.grades = grades
        this.final = final
        // this.fullname = lastname + " " + firstname
        // this.average = Student.averageMarks(marks)
        // this.grades = Student.gradeMarks(marks)
        // this.final = Student.gradeMarks([Student.average])[0]
    }

    static newStudent(rollno, firstname, lastname, marks){
        if(typeof(lastname)!="string"){
            return "lastname";
        } if (typeof(firstname)!="string"){
            return "firstname";
        } if (typeof(rollno)!="number"){
            return "rollno";
        } if (typeof(marks)!="object"){
            return "marks";
        }
        
        let fullname = lastname + " " + firstname
        let average = Student.averageMarks(marks)
        let grades = Student.gradeMarks(marks)
        let final = Student.gradeMarks([average])[0]
        return new Student(rollno, firstname, lastname, marks,fullname,average,grades,final)
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

}
let s1 = Student.newStudent(1, 'rohit', 'sabat', [10, 20, 30, 40])
console.log(s1.constructor.name)
console.log(s1)

// console.log(s1.fullname)
// let s2=new Student(1,'martin','guptil',80)
// console.log(s2)
// s1=s2
// console.log(s2)
