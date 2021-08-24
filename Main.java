package sample;

        import javafx.application.Application;
        import javafx.scene.Group;
        import javafx.scene.Scene;
        import javafx.scene.canvas.Canvas;
        import javafx.scene.canvas.GraphicsContext;
        import javafx.stage.Stage;

        import java.io.StringReader;
        import java.sql.*;
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.Map;

public class Main extends Application {
    static int total = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Creating the canvas
        Group root = new Group();
        Scene shape = new Scene(root);
        primaryStage.setTitle("MyPie");
        int w = 500, h = 400;
        Canvas canvas = new Canvas(w, h);
        GraphicsContext Graphics = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        primaryStage.setScene(shape);
        MyPoint p = new MyPoint(w / 4, h / 7);

        Connection conn = null;
        try {
// Loads the class object for the mysql driver into the DriverManager.
            Class.forName("com.mysql.cj.jdbc.Driver");
            //  Attempt to establish a connection to the specified database via the
            //  DriverManager
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java", "root", "password");
            // Check the connection
            if (conn != null) {
                System.out.println("We have connected to our database!");

                //Drop table
               //dropTables(conn);

                //Create the table and show the table structure
                PreparedStatement table_1 = conn.prepareStatement("CREATE TABLE IF NOT EXISTS Students" +
                        "(empl_ID INT NOT NULL, " +
                        " PRIMARY KEY (empl_ID)," +
                        "firstName VARCHAR(255)," +
                        "lastName VARCHAR(255)," +
                        "Email VARCHAR(255)," +
                        "sex CHAR(1)," +
                        "CHECK (sex ='F'OR sex='M'OR sex='U'))");
                table_1.execute();

                PreparedStatement table_2 = conn.prepareStatement("CREATE TABLE IF NOT EXISTS Courses" +
                        "(Course_ID INT NOT NULL," +
                        "PRIMARY KEY (Course_ID)," +
                        "CourseTitle VARCHAR(255)," +
                        "Department VARCHAR(255))");
                table_2.execute();
                PreparedStatement table_3 = conn.prepareStatement("CREATE TABLE IF NOT EXISTS Classes" +
                        " (Course_ID INT NOT NULL, " +
                        " student_ID INT UNSIGNED NOT NULL, " +
                        " section_No VARCHAR(255), " +
                        " year INT UNSIGNED, " +
                        " semester VARCHAR(255), " +
                        " grade VARCHAR(255), " +
                        " PRIMARY KEY (course_ID, student_ID, section_No)," +
                        " CHECK (grade= 'A' OR grade = 'B' OR grade = 'C' OR grade = 'D' OR grade = 'F' OR grade = 'W'))");
                table_3.execute();
                //create a array list to populate the database with students information
//                ArrayList<Student> Student = new ArrayList<>();
//                ArrayList<Classes> Classes = new ArrayList<>();
//                Student.add(new Student("Tanvir", "Youhana", "tyouhan000@citymail.cuny.edu", "M"));
//                Student.add(new Student("Bob", "Ross", "Bobrossn045@citymail.cuny.edu", "M"));
//                Student.add(new Student("Nicolas", "Cage", "Ncage054@citymail.cuny.edu", "U"));
//                Student.add(new Student("Donald", "Trump", "Dtrump056@citymail.cuny.edu", "U"));
//                Student.add(new Student("Robert", "Harris", "Rharrisn002@citymail.cuny.edu", "M"));
//                Student.add(new Student("Barrack", "Obama", "Bobama023@citymail.cuny.edu", "M"));
//                Student.add(new Student("Daniel", "Yoon", "Dyoon045@citymail.cuny.edu", "U"));
//                Student.add(new Student("Gabyr", "Wurt", "Gwurt078@citymail.cuny.edu", "F"));
//                Student.add(new Student("Cindy", "Ortiz", "Cortiz0076@citymail.cuny.edu", "F"));
//                Student.add(new Student("Bernard", "Ko", "Bko001@citymail.cuny.edu", "M"));
//                Student.add(new Student("Angelica", "Ortiz", "Aortiz094@citymail.cuny.edu", "F"));
//                Student.add(new Student("Ronald", "Smith", "Rsmith345@citymail.cuny.edu", "M"));
//                Student.add(new Student("Jason", "Williams", "Jwilliams343@citymail.cuny.edu", "M"));
//                Student.add(new Student("Brandon", "King", "Bking346@citymail.cuny.edu", "U"));
//                Student.add(new Student("Lisa", "Green", "Lgreen294@citymail.cuny.edu", "F"));
//                Student.add(new Student("Richard", "Reed", "Rreed786@citymail.cuny.edu", "M"));
//                Student.add(new Student("Brooke", "Long", "Blong123@citymail.cuny.edu", "F"));
//                Student.add(new Student("John", "Fisher", "Jfisher412@citymail.cuny.edu", "M"));
//                Student.add(new Student("Angel", "Ortiz", "Aortiz094@citymail.cuny.edu", "U"));
//                Student.add(new Student("Mary", "Ann", "Mann534@citymail.cuny.edu", "F"));
//                Student.add(new Student("Melanie", "Beni", "Mbeni345@citymail.cuny.edu", "F"));
//                Student.add(new Student("Justin", "Rice", "Jrice121@citymail.cuny.edu", "M"));
//
//
//                // adds Algo 220 into course table
//                Courses Algo = new Courses(22000, "Algorithms", "Computer Science");
//                createNewCourse(conn, Algo);
//
//
//                Classes.add(new Classes(Algo.course_ID, Student.get(0).studentID, "T", 2020, "Fall", "A"));
//                Classes.add(new Classes(Algo.course_ID, Student.get(1).studentID, "T", 2020, "Fall", "B"));
//                Classes.add(new Classes(Algo.course_ID, Student.get(2).studentID, "T", 2020, "Fall", "C"));
//                Classes.add(new Classes(Algo.course_ID, Student.get(3).studentID, "T", 2020, "Fall", "F"));
//                Classes.add(new Classes(Algo.course_ID, Student.get(4).studentID, "T", 2020, "Fall", "F"));
//                Classes.add(new Classes(Algo.course_ID, Student.get(5).studentID, "T", 2020, "Fall", "W"));
//                Classes.add(new Classes(Algo.course_ID, Student.get(6).studentID, "T", 2020, "Fall", "A"));
//                Classes.add(new Classes(Algo.course_ID, Student.get(7).studentID, "T", 2020, "Fall", "C"));
//                Classes.add(new Classes(Algo.course_ID, Student.get(8).studentID, "T", 2020, "Fall", "A"));
//                Classes.add(new Classes(Algo.course_ID, Student.get(9).studentID, "T", 2020, "Fall", "D"));
//                Classes.add(new Classes(Algo.course_ID, Student.get(10).studentID, "T", 2020, "Fall", "D"));
//                Classes.add(new Classes(Algo.course_ID, Student.get(11).studentID, "T", 2020, "Fall", "B"));
//                Classes.add(new Classes(Algo.course_ID, Student.get(12).studentID, "T", 2020, "Fall", "C"));
//                Classes.add(new Classes(Algo.course_ID, Student.get(13).studentID, "T", 2020, "Fall", "A"));
//                Classes.add(new Classes(Algo.course_ID, Student.get(14).studentID, "T", 2020, "Fall", "C"));
//                Classes.add(new Classes(Algo.course_ID, Student.get(15).studentID, "T", 2020, "Fall", "F"));
//                Classes.add(new Classes(Algo.course_ID, Student.get(16).studentID, "T", 2020, "Fall", "W"));
//                Classes.add(new Classes(Algo.course_ID, Student.get(17).studentID, "T", 2020, "Fall", "D"));
//                Classes.add(new Classes(Algo.course_ID, Student.get(18).studentID, "T", 2020, "Fall", "B"));
//                Classes.add(new Classes(Algo.course_ID, Student.get(19).studentID, "T", 2020, "Fall", "D"));
//                Classes.add(new Classes(Algo.course_ID, Student.get(20).studentID, "T", 2020, "Fall", "C"));
//                Classes.add(new Classes(Algo.course_ID, Student.get(21).studentID, "T", 2020, "Fall", "A"));
//
//
//                //take all students from arraylist and add it to the database
//                for (int i = 0; i < Student.size(); i++) {
//                    createNewStudent(conn, Student.get(i));
//                    insertIntoClasses(conn, Student.get(i), Classes.get(i));
//
//                }


                displaySemestergrade(conn, "Fall");

                // Create pie chart
                MyPieChart myPieChart = new MyPieChart(displaySemestergrade(conn, "Fall"), total);
                //draws pie chart
                myPieChart.drawPieChart(w / 1.5, h / 1.5, Graphics);
                primaryStage.show();

                //Hashmap that keeps track of the grades and frequency
                HashMap<String, Integer> hashMap = displaySemestergrade(conn, "Fall");
                // prints out how many of each character was counted
                for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                    System.out.printf("%5s %10s", "Grade", "Frequency");
                    System.out.println();
                    System.out.format("%5s %10s", entry.getKey(), entry.getValue());
                    System.out.println();
                }
                System.out.println("Total:" + total);

                //Test to update courses
                //updateCourse(conn, 22000, "Linear Systems II",  "Electrical Engineering");
                // updateStudent(conn,1044, "Manny", "Garth");
                updateClasses(conn,22000,1007,"T", 2020, "FALL","B");
                //updateClasses(conn,22000,1036,"T", 2020, "FALL","C");

                //Print out the table
                System.out.println("Students Table");
                readStudentsList(conn);
                System.out.println();
                System.out.println("Course Table");
                readCoursesList(conn);
                System.out.println();
                System.out.println("Classes Table");
                readClassesList(conn);

                //close the connection to the database
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            ex.printStackTrace();
        }

    }


    public static void main(String[] args) {
        launch(args);
    }


    // Returns a HashMap with frequency for each grade
    public static HashMap<String, Integer> displaySemestergrade(Connection connection, String semester) {
        String sql = "SELECT student_ID, grade FROM classes WHERE semester = \"" + semester + "\"";
        HashMap<String, Integer> hashMap = new HashMap<>();
        int mtotal = 0;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                // How many times it occurs and corresponding letter
                String grade = rs.getString("grade");
                String studentID = rs.getString("student_ID");

                if (hashMap.containsKey(grade)) {
                    hashMap.put(grade, hashMap.get(grade) + 1); // Increment
                } else {
                    hashMap.put(grade, 1); // Unique
                }
                mtotal++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        total = mtotal;
        return hashMap;
    }


    // Pass in student and class objects to add student to a class
    public static void insertIntoClasses(Connection connection, Student student, Classes classes) {
        ResultSet rs = null;
        String sql = "INSERT INTO classes(Course_ID, student_ID, section_No, year, semester,grade) " + "VALUES(?,?,?,?,?,?)";

        try {
            // Creates the student in the database
            createNewStudent(connection, student);
            // Enters the student into the class
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, classes.course_ID);
            pstmt.setInt(2, classes.student_ID);
            pstmt.setString(3, classes.section);
            pstmt.setInt(4, classes.year);
            pstmt.setString(5, classes.semester);
            pstmt.setString(6, classes.grade);

            int rowAffected = pstmt.executeUpdate();
            if (rowAffected == 1) {
                rs = pstmt.getGeneratedKeys();
                if (rs.next())
                    System.out.println("Successfully added " + rs.getInt(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public static void createNewStudent(Connection connection, Student student) {
        ResultSet rs = null;
        String sql = "INSERT INTO students(empl_ID,firstName,lastName,Email,sex) " + "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, student.studentID);
            pstmt.setString(2, student.firstName);
            pstmt.setString(3, student.lastName);
            pstmt.setString(4, student.email);
            pstmt.setString(5, student.sex);


            int rowAffected = pstmt.executeUpdate();
            if (rowAffected == 1) {
                rs = pstmt.getGeneratedKeys();
                if (rs.next())
                    System.out.println("Successfully added student " + rs.getInt(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public static void createNewCourse(Connection connection, Courses course) {
        ResultSet rs = null;
        String sql = "INSERT INTO courses(Course_ID,CourseTitle,Department) " + "VALUES(?,?,?)";

        // Using prepared statements before inserting
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, course.course_ID);
            pstmt.setString(2, course.courseTitle);
            pstmt.setString(3, course.department);

            int rowAffected = pstmt.executeUpdate();
            if (rowAffected == 1) {
                rs = pstmt.getGeneratedKeys();
                if (rs.next())
                    System.out.println("Successfully added course " + rs.getInt(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //NOT Neccesary
    // Print all the students
    public static String getStudentName(Connection connection, int studentID) {
        String sql = "SELECT * FROM students WHERE student_ID = " + studentID;
        String name = "";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                name = rs.getString("lastName");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return name;
    }


    // Print all the students
    public static void readStudentsList(Connection connection) {
        String sql = "SELECT * FROM students";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("--------------------------------|");
                System.out.println(rs.getString("empl_ID") + "\t" + rs.getString("lastName") +
                        "\t" + rs.getString("firstName") + "\t" + rs.getString("sex"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    // Print all the classes
    public static void readClassesList(Connection connection) {
        String sql = "SELECT * FROM classes";
        ;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getInt("Course_ID") + "\t" + rs.getInt("student_ID")
                        + "\t" + rs.getString("section_No") + "\t" + rs.getInt("year") + "\t" + rs.getString("semester") + "\t" + rs.getString("grade"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    // Print all the courses
    public static void readCoursesList(Connection connection) {
        String sql = "SELECT * FROM courses";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString("course_ID") + "\t" + rs.getString("courseTitle")
                        + "\t" + rs.getString("department"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    // Allows to update students name and sex. Student id should stay the same
    public static void updateStudent(Connection connection, int studentID, String firstName, String lastName) {
        String sqlUpdate = "UPDATE students " + "SET firstName = ?, lastName = ? " + "WHERE empl_ID = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sqlUpdate);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setInt(3, studentID);

            int rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //update the courses
    public static void updateCourse(Connection connection, int course_ID, String courseTitle, String department) {
        String sqlUpdate = "UPDATE courses " + "SET courseTitle = ?, department = ? " + "WHERE course_ID = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sqlUpdate);
            pstmt.setString(1, courseTitle);
            pstmt.setString(2, department);
            pstmt.setInt(3, course_ID);

            int rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void updateClasses(Connection connection, int course_ID, int student_ID, String section_No,int year, String semester, String grade) {
        String sqlUpdate = "UPDATE classes " + "SET section_No = ?, year = ?, semester=?, grade= ?" + "WHERE student_ID=?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sqlUpdate);
            pstmt.setString(1, section_No);
            pstmt.setInt(2, year);
            pstmt.setString(3, semester);
            pstmt.setString(4,grade);
            pstmt.setInt(5, student_ID);

            int rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static void dropTables(Connection conn) {
        try {
            PreparedStatement drop1 = conn.prepareStatement("DROP TABLE Students");
            drop1.execute();

            PreparedStatement drop2 = conn.prepareStatement("DROP TABLE Courses");
            drop2.execute();

            PreparedStatement drop3 = conn.prepareStatement("DROP TABLE Classes");
            drop3.execute();

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}



