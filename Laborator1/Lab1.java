public class Lab1 {
    public static void main(String[] args) {
        Lab1 lab1 = new Lab1();
        lab1.compulsory();
        lab1.homework();
        lab1.bonus();
    }

    static int sumOfDigits(int number) {
        int sum = 0;
        while(number != 0) {
            sum = sum + number % 10;
            number = number / 10;
        }
        return sum;
    }

    void compulsory() {
        System.out.println("Hello World!");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n = n * 3;
        n = n + Integer.parseInt("10101", 2);
        n = n + Integer.parseInt("FF", 16);
        n = n * 6;
        int result = n;
        while(result >= 10) {
            result = sumOfDigits(result);
        }
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }

    void homework() {
        // TO DO
    }

    void bonus() {
        // TO DO
    }
}

