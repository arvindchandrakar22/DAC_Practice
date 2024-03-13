#include<iostream>
using namespace std;

class Bank
{
    private:
    string name;
    double *balance;

    public:
    Bank()
    {
        cout<<"Inside Default Constructor"<<endl;
    }

    Bank(string n, double bal)
    {
        cout<<"Inside Parameterised Constructor"<<endl;
        name = n;
        balance = new double;
        *balance = bal;
    }

    //Copy Constructor
    Bank(Bank &other)
    {
        //Deep Copy
        cout<<"Inside Copy Constructor"<<endl;

        name = other.name;
        balance = new double;
        *balance = *other.balance;
    }

    void accept()
    {
        cout<<"Enter Name ::  ";
        cin>>name;
        cout<<"Enter Balance ::  ";
        cin>>*balance;
    }

    void print()
    {
        cout<<"Name :: "<<name<<endl;
        cout<<"Balance :: "<<*balance<<endl;
    }
    ~Bank()
    {
        cout<<"Inside Destructor"<<endl;
        delete balance;
        balance = NULL;
    }
};

int main()
{
    Bank b1("SBI",1000);
    b1.print();

    Bank b2 = b1;
    b2.print();
    
    b2.accept();
    cout<<"Object b2"<<endl;
    b2.print();
    cout<<"Object b1"<<endl;
    b1.print();

    return 0;
}