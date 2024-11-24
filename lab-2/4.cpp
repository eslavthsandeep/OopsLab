#include <iostream>
#include <string>

using namespace std;

class Patient {
private:
    string name;
    char sex;
    int age;
    int wardNumber;
    int bedNumber;
    string illness;
    string admissionDate;

public:
    Patient(string n, char s, int a, int w, int b, string ill, string date) {
        name = n;
        sex = s;
        age = a;
        wardNumber = w;
        bedNumber = b;
        illness = ill;
        admissionDate = date;
    }

    // Default 
    Patient() {
        name = "";
        sex = 'M';
        age = 0;
        wardNumber = 0;
        bedNumber = 0;
        illness = "";
        admissionDate = "";
    }

    Patient(Patient& p) {  //copy
        name = p.name;
        sex = p.sex;
        age = p.age;
        wardNumber = p.wardNumber;
        bedNumber = p.bedNumber;
        illness = p.illness;
        admissionDate = p.admissionDate;
    }

    // Destructor
    ~Patient() {
        cout<<"Destructor called"<<endl;
    }

    void display() {
        cout << "Name: " << name << endl;
        cout << "Sex: " << sex << endl;
        cout << "Age: " << age << endl;
        cout << "Ward Number: " << wardNumber << endl;
        cout << "Bed Number: " << bedNumber << endl;
        cout << "Nature of Illness: " << illness << endl;
        cout << "Date of Admission: " << admissionDate << endl;
    }
};

int main() {
    Patient p1("Lokesh", 'M', 19, 12, 5, "Flu", "2024-08-14");
    p1.display();

    return 0;
}
