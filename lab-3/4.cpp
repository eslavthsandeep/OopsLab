#include <iostream>
#include <string>

using namespace std;

class Person
{
private:
    string name;
    string dateOfBirth;
    string bloodGroup;
    float height;
    float weight;
    string insurancePolicyNumber;
    string contactAddress;
    string telephoneNumber;
    string drivingLicenseNumber;

public:
    Person(string n, string dob, string bg, float h, float w, string insPolicy, string address, string phone, string license)
    {
        name = n;
        dateOfBirth = dob;
        bloodGroup = bg;
        height = h;
        weight = w;
        insurancePolicyNumber = insPolicy;
        contactAddress = address;
        telephoneNumber = phone;
        drivingLicenseNumber = license;
    }
    // Default
    Person()
    {
        cout << "Default Constructor called" << endl;
    }

    // Copy
    Person(Person &p)
    {
        name = p.name;
        dateOfBirth = p.dateOfBirth;
        bloodGroup = p.bloodGroup;
        height = p.height;
        weight = p.weight;
        insurancePolicyNumber = p.insurancePolicyNumber;
        contactAddress = p.contactAddress;
        telephoneNumber = p.telephoneNumber;
        drivingLicenseNumber = p.drivingLicenseNumber;
    }

    // Destructor
    ~Person()
    {
        cout << "Destructor called" << endl;
    }

    friend class DisplayPerson; // Friend class

    inline void displayContactInfo()
    {
        cout << "Contact Address: " << contactAddress << endl;
        cout << "Telephone Number: " << telephoneNumber << endl;
    }
};

// Friend class definition
class DisplayPerson
{
public:
    void showPersonDetails(Person &p)
    {
        cout << "Name: " << p.name << endl;
        cout << "Date of Birth: " << p.dateOfBirth << endl;
        cout << "Blood Group: " << p.bloodGroup << endl;
        cout << "Height: " << p.height << " meters" << endl;
        cout << "Weight: " << p.weight << " kg" << endl;
        cout << "Insurance Policy Number: " << p.insurancePolicyNumber << endl;
        p.displayContactInfo();
        cout << "Driving License Number: " << p.drivingLicenseNumber << endl;
    }
};

int main()
{
    Person *person = new Person("Lokesh", "2005-07-01", "A+", 1.65, 58.0, "INS123456", "123 Miyapur, Hyderabad, INDIA", "77-1234", "TS7E4066");
    DisplayPerson display;
    display.showPersonDetails(*person);
    delete person;

    return 0;
}
