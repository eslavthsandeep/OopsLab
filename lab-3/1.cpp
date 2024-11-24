#include <iostream>
#include <string>
using namespace std;
class PayRoll
{
private:
    string Employee_name;
    int code;
    string Designation;
    int acc_no;
    string dateOfJoining;
    float basicpay;
    float da, hra, cca;
    float ppf, gpf, cpf, lic, nss, nsc;

public:
    PayRoll(string em_name, int code, string dis, int a_no, string doj, float bp, float a, float b, float c, float d, float e, float f, float g, float h, float i)
    {
        Employee_name = em_name;
        this->code = code;
        Designation = dis;
        acc_no = a_no;
        dateOfJoining = doj;
        basicpay = bp;
        da = a;
        hra = b;
        cca = c;
        ppf = d;
        gpf = e;
        cpf = f;
        lic = g;
        nss = h;
        nsc = i;
    }
    PayRoll() // default
    {
        cout << "Default Constructor called" << endl;
    }
    PayRoll(PayRoll &p)
    { // Copy
        Employee_name = p.Employee_name;
        this->code = p.code;
        Designation = p.Designation;
        acc_no = p.acc_no;
        dateOfJoining = p.dateOfJoining;
        basicpay = p.basicpay;
        da = p.da;
        hra = p.hra;
        cca = p.cca;
        ppf = p.ppf;
        gpf = p.gpf;
        cpf = p.cpf;
        lic = p.lic;
        nss = p.nss;
        nsc = p.nsc;
    }

    ~PayRoll()
    {
        cout << "Distructor called";
    }

    friend class DisplayDetails; // friend class

    inline float calculateNetPay() // Inline function
    {
        float grossPay = basicpay + da + hra + cca;
        float deductions = ppf + gpf + cpf + lic + nss + nsc;
        return grossPay - deductions;
    }
};

// friend class defination
class DisplayDetails
{
public:
    void showDetails(PayRoll &p)
    {
        cout << "Employee Name: " << p.Employee_name << endl;
        cout << "Employee Code: " << p.code << endl;
        cout << "Designation: " << p.Designation << endl;
        cout << "Account Number: " << p.acc_no << endl;
        cout << "Date of Joining: " << p.dateOfJoining << endl;
        cout << "Basic Pay: " << p.basicpay << endl;
        cout << "DA: " << p.da << endl;
        cout << "HRA: " << p.hra << endl;
        cout << "CCA: " << p.cca << endl;
        cout << "PPF: " << p.ppf << endl;
        cout << "GPF: " << p.gpf << endl;
        cout << "CPF: " << p.cpf << endl;
        cout << "LIC: " << p.lic << endl;
        cout << "NSS: " << p.nss << endl;
        cout << "NSC: " << p.nsc << endl;
        cout << "Net Pay: " << p.calculateNetPay() << endl;
    }
};
int main()
{
    PayRoll *employee = new PayRoll("Lokesh", 1001, "Manager", 123456789, "2020-01-15", 50000.0, 10000.0, 8000.0, 2000.0, 3000.0, 2000.0, 1500.0, 1000.0, 500.0, 400.0);
    DisplayDetails details;
    details.showDetails(*employee);
    delete employee;

    return 0;
}