class This{
    int aaa;
    String bbb;
    This(int aaa, String bbb) {
        this.aaa = aaa;
        this.bbb = bbb;
        System.out.println("this in Constructor : " + this);
    }
    void checkThisMethod(int anything){
        aaa = anything;
        System.out.println("this in method : " + this);
    }
}