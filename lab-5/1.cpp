#include <iostream>
using namespace std;

class Publication
{
private:
    string title;
    double price;
    string authorName;

public:
    void getData()
    {
        cout << "Enter title: ";
        cin >> this->title;
        cout << "Enter price: ";
        cin >> price;
        cout << "Enter author's name: ";
        cin >> this->authorName;
    }

    void displayData()
    {
        cout << "Title: " << title << endl;
        cout << "Price: " << price << endl;
        cout << "Author: " << authorName << endl;
    }
};

class Book : public Publication
{
private:
    int pcount;

public:
    void getData()
    {
        Publication::getData();
        cout << "Enter page count: ";
        cin >> pcount;
    }

    void displayData()
    {
        Publication::displayData();
        cout << "Page Count: " << pcount << endl;
    }
};

class Ebook : public Publication
{
private:
    double ptime;

public:
    void getData()
    {
        Publication::getData();
        cout << "Enter playing time: ";
        cin >> ptime;
    }

    void displayData()
    {
        Publication::displayData();
        cout << "Playing Time: " << ptime << " hours" << endl;
    }
};

int main()
{
    Book b;
    Ebook e;
    cout << "Enter Book details:" << endl;
    b.getData();
    cout << "\nEnter Ebook details:" << endl;
    e.getData();

    cout << "\nBook details:" << endl;
    b.displayData();

    cout << "\nEbook details:" << endl;
    e.displayData();

    return 0;
}
