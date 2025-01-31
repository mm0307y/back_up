package quiz_10_17.setp1_10_17;

public class Q28_1_10_24 {
    int i = 1;
    Q28_1_10_24 q = null;
    void m(int i, Q28_1_10_24 q){
        System.out.println(q);
        q = new Q28_1_10_24();
        System.out.println(q);
        System.out.println(this.q); //null
        System.out.println(this);
    }

    public static void main(String[] args) {
        Q28_1_10_24 q = new Q28_1_10_24();
        q.m(1,q);
    }
}
