class Question1 {
    enum Color {
        RED, BLUE, GREEN;
    }

    public static void main(String[] args) {
        for(Color c : Color.values()){
            System.out.println(c);
        }
    }
}