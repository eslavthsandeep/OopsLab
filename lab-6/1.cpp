#include <iostream>
using namespace std;
class Employee
{
public:
    int emp_id;
    string emp_name;
    int emp_age;
    void getInput()
    {
        cout << "Enter the employee id : ";
        cin >> this->emp_id;
        cout << "Enter the employee name : ";
        cin >> this->emp_name;
        cout << "Enter the employee age : ";
        cin >> this->emp_age;
    }
    void search(Employee emp[], int n, int id)
    {
        for (int i = 0; i < n; i++)
        {
            if (id == emp[i].emp_id)
            {
                cout << "Id found!!" << endl;
                cout << "Employee name : " << emp[i].emp_name << endl;
                cout << "Employee Id : " << emp[i].emp_id << endl;
                cout << "Employee age : " << emp[i].emp_age << endl;
                return;
            }
        }
        cout << "Id not found!!" << endl;
    }
};

int main()
{
    Employee emp[10];
    for (int i = 0; i < 10; i++)
    {
        cout << "Enter the details of Employee " << i + 1 << " : " << endl;
        emp[i].getInput();
    }
    cout << "Enter employee ID to search: ";
    int n;
    cin >> n;
    emp->search(emp, 10, n);
}