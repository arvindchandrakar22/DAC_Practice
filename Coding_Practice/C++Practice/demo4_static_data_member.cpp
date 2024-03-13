#include<iostream>
using namespace std;

class Bank
{
    private:
    string name;
    double balance;
    static int count;

    public:
    Bank()
    {
        cout<<"Inside Default Constructor"<<endl;
    }

    Bank(string n, double bal)
    {
        cout<<"Inside Parameterised Constructor"<<endl;
        name = n;
        balance = bal;
        count++;
    }

    void accept()
    {
        cout<<"Enter Name ::  ";
        cin>>name;
        cout<<"Enter Balance ::  ";
        cin>>balance;
    }

    void print()
    {
        cout<<"Name :: "<<name<<endl;
        cout<<"Balance :: "<<balance<<endl;
        cout<<"Count :: "<<&count<<" - "<<count<<endl;
    }
};

int Bank :: count = 0;
int main()
{
    Bank b1("SBI",10000);
    b1.print();

    Bank b2("CBI",20000);
    b2.print();

    Bank b3("ICICI",30000);
    b3.print();

    return 0;
}