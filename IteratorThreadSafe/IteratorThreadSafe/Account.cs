using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IteratorThreadSafe {
    class Account {
        public string name;

        public double balance;

        public Account(string name, double balance) {
            this.name = name;
            this.balance = balance;
        }
    }
}
