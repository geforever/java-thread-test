class Print implements PrintInterface {

    @Override
    public String print(String str) {
        System.out.println("输出值：" + str);
        return str;
    }

    public String print(int strInt) {
        System.out.println("输出值int:" + strInt);
        return "1";
    }
}
