#include <iostream>
#include <string>
using namespace std;
class MarkSheet
{
private:
    string studentName;
    int rollNumber;
    string subjectCode;
    string subjectName;
    int internalMarks;
    int externalMarks;

public:
    MarkSheet(string name, int roll, string subCode, string subName, int internal, int external)
    {
        studentName = name;
        rollNumber = roll;
        subjectCode = subCode;
        subjectName = subName;
        internalMarks = internal;
        externalMarks = external;
    }

    // Default constructor
    MarkSheet()
    {
        cout << "Default Constructor called" << endl;
    }

    MarkSheet(MarkSheet &m) // Copy constructor
    {
        studentName = m.studentName;
        rollNumber = m.rollNumber;
        subjectCode = m.subjectCode;
        subjectName = m.subjectName;
        internalMarks = m.internalMarks;
        externalMarks = m.externalMarks;
    }

    ~MarkSheet() // Destructor
    {
        cout << "Destructor called" << endl;
    }

    friend class DisplayMarkSheet; // Friend

    inline int calculateTotalMarks() // Inline function
    {
        return internalMarks + externalMarks;
    }
};

// friend class defination
class DisplayMarkSheet
{
public:
    void showMarkSheet(MarkSheet &m)
    {
        cout << "Student Name: " << m.studentName << endl;
        cout << "Roll Number: " << m.rollNumber << endl;
        cout << "Subject Code: " << m.subjectCode << endl;
        cout << "Subject Name: " << m.subjectName << endl;
        cout << "Internal Marks: " << m.internalMarks << endl;
        cout << "External Marks: " << m.externalMarks << endl;
        cout << "Total Marks: " << m.calculateTotalMarks() << endl;
    }
};
int main()
{
    MarkSheet *student = new MarkSheet("Lokesh", 1093, "AI101", "OOPS", 40, 60);
    DisplayMarkSheet display;
    display.showMarkSheet(*student);
    delete student;

    return 0;
}