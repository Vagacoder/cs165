package example1;

import example1.OuterClass.InnerClass;

class OuterClass{

    int x = 5;

    public void outShow(){
        System.out.println("out");
    }

    class InnerClass{

        int y = 6;

        public void outShow(){
            System.out.println("this out inside in");
        }

        public void InShow(){
            OuterClass.this.outShow();
            System.out.println(x);
            System.out.println("in");
            outShow();
            System.out.println(y);
        }
    }
}

public class InnerClassTester{

    public static void main(String[] args){
        OuterClass out = new OuterClass();
        InnerClass in = out.new InnerClass();
        in.InShow();
    }
}