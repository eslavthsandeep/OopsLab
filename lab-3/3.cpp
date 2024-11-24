#include <iostream>
#include <string>

using namespace std;

class Book
{
private:
    int accessionNumber;
    string authorName;
    string bookTitle;
    int publicationYear;
    string publisherName;
    float bookCost;

public:
    Book(int accNo, string author, string title, int year, string publisher, float cost)
    {
        accessionNumber = accNo;
        authorName = author;
        bookTitle = title;
        publicationYear = year;
        publisherName = publisher;
        bookCost = cost;
    }

    // Default
    Book()
    {
        cout << "Default Constructor called" << endl;
    }

    // Copy
    Book(Book &b)
    {
        accessionNumber = b.accessionNumber;
        authorName = b.authorName;
        bookTitle = b.bookTitle;
        publicationYear = b.publicationYear;
        publisherName = b.publisherName;
        bookCost = b.bookCost;
    }

    // Destructor
    ~Book()
    {
        cout << "Destructor called" << endl;
    }

    friend class DisplayBook; // Friend class

    inline float getCost() // Inline function
    {
        return bookCost;
    }
};

// Friend class definition
class DisplayBook
{
public:
    void showBookDetails(Book &b)
    {
        cout << "Accession Number: " << b.accessionNumber << endl;
        cout << "Author Name: " << b.authorName << endl;
        cout << "Title of the Book: " << b.bookTitle << endl;
        cout << "Year of Publication: " << b.publicationYear << endl;
        cout << "Publisher's Name: " << b.publisherName << endl;
        cout << "Cost of the Book: $" << b.getCost() << endl;
    }
};

int main()
{
    Book *book1 = new Book(1001, "Deepak", "Harry Potter", 1997, "Sandeep", 39.99);
    DisplayBook display;
    display.showBookDetails(*book1);
    delete book1;

    return 0;
}
