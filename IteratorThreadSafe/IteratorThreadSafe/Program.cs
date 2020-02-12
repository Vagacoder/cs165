using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;


namespace IteratorThreadSafe
{
    class Program
    {

        private static object syncer = new object();

        static void Main(string[] args)
        {
            Console.WriteLine();

            List<Account> accounts = new List<Account>();

            accounts.Add(new Account("Bella", 100.0));
            accounts.Add(new Account("Chico", 100.0));
            accounts.Add(new Account("Daria", 100.0));
            accounts.Add(new Account("Eddie", 100.0));

            Console.WriteLine("BALANCE REPORT\n==============");
            for (int i = 0; i < accounts.Count; i++)
                Console.WriteLine(accounts[i].name + String.Format(" = ${0:f2}", accounts[i].balance));
            Console.WriteLine();

            // Schedule Alva's account to be added during fee assessment
            Task.Delay(1000).ContinueWith(t => AddAlva(accounts));

            lock (syncer)
            {
                Console.WriteLine("OUTRAGEOUS FEE ASSESSMENT\n=========================");
                for (int i = 0; i < accounts.Count; i++)
                {
                    Console.WriteLine("Charging " + accounts[i].name + " a fee of " +
                                      String.Format(" = ${0:f2}", accounts[i].balance * 0.01));
                    accounts[i].balance -= accounts[i].balance * 0.01;
                    Thread.Sleep(500);
                }

            }
            Console.WriteLine();

            Console.WriteLine("BALANCE REPORT\n==============");
            Thread.Sleep(500);
            for (int i = 0; i < accounts.Count; i++)
                Console.WriteLine(accounts[i].name + String.Format(" = ${0:f2}", accounts[i].balance));
            Console.WriteLine();

            Console.Read();
        }












        private static void AddAlva(List<Account> accounts)
        {
            lock (syncer)
            {
                Console.WriteLine("Adding Alva");
                accounts.Insert(0, new Account("Alva", 100.0));
            }
        }
    }
}
