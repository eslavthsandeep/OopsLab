#include <iostream>
#include <string>
using namespace std;

class emp
{
public:
    string *arr;
    int n;
    string name;
   emp()
    { // default constructor
        cout << "Welcome to SVNIT" << endl;
    }
    ~emp(){
        cout<<"Distructor called"<<endl;
    }
    emp(int n)
    {
        this->n = n;
        arr = new string[n];
    }
    emp(emp *st)
    {
        this->name = st->name;
    }
    void getInput()
    {
        cout<<"enter thr name:"<<endl;
        cin>>this->name;
        for (int i = 0; i < n; i++)
        {
            cout << "Enter the string:" << endl;
            cin >> arr[i];
        }
    }
    void check(string s1,string s2)
    {
        int count = 0;
        for (int i = 0; i < arr->size(); i++)
        {
            if (arr[i]==  s1)
            {
                arr[i]=s2;
                count++;
            }
        }
        if (count == 0)
        {
            cout << "the string  " << s1 << " is not present in the array" << endl;
        }
        else
        {
            cout << "The string is present in the the array  ->" << count << "times" << endl;
        }
    }
    void print(){
        for(int i=0;i<n;i++){
            cout<<arr[i]<<endl;
        }
    }
};

int main()
{
    emp a;
    cout << "Enter the length of the array:" << endl;
    int n;
    cin >> n;
    emp b(n);
    b.getInput();
    cout<<"the array before checking"<<endl;
    b.print();
    emp *c(&b); // copy constructor
    cout << "copy constructor  is called: " << c->name << endl;
    cout << "enter the string:" << endl;
    string str1,str2;
    cin >> str1>>str2;
    b.check(str1,str2);
    cout<<"the array after checking"<<endl;
    b.print();
    return 0;
}