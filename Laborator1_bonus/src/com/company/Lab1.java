package com.company;

import java.util.*;

public class Lab1 {

    private LinkedList[] adjList;
    private boolean visited[];
    private List<Integer> sol = new ArrayList<>();
    private List<Integer> nrOfNeighbors = new ArrayList<>();

    public static void main(String[] args) {
        Lab1 lab1 = new Lab1();

        System.out.println("Compulsory:");
        lab1.compulsory();
        System.out.println();

        // 4. For larger n display the running time of the application in nanoseconds (DO NOT display the data structure!).
        long start = System.nanoTime();
        String[] input = {"7","3","q","w","e","r","t","y"};
        System.out.println("Homework:");
        lab1.homework(input);
        long end = System.nanoTime();
        long time = end - start;
        System.out.println("The running time of the application in nanoseconds is: " + time);
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

    void homework(String[] args) {
        // 1. Let n, p be two integers and C1,...,Cm a set of letters (the alphabet), all given as a command line arguments. Validate the arguments!
        boolean firstInt = Character.isDigit(args[0].charAt(0));
        boolean secondInt = Character.isDigit(args[1].charAt(0));

        if (args.length <= 2) {
            System.out.println("The input has not enough arguments!");
            return;
        }
        if (!firstInt) {
            System.out.println("The input for the variable n must be an integer!");
            return;
        }
        if (!secondInt) {
            System.out.println("The input for the variable p must be an integer!");
            return;
        }
        String[] alphabet = Arrays.copyOfRange(args, 2, args.length);
        for (String s : alphabet) {
            if (Character.isDigit(s.charAt(0))) {
                System.out.println("The input for the alphabet contains integers!");
                return;
            }
        }

        int n, p;
        ArrayList<String> letters = new ArrayList<>();
        n = Integer.parseInt(args[0]);
        p = Integer.parseInt(args[1]);
        System.out.println("Integers: " + n + " " + p);
        System.out.print("Letters: ");
        for (String s : alphabet) {
            letters.add(s);
            System.out.print(s + " ");
        }
        System.out.println();

        // 2. Create an array of n strings (called words), each word containing exactly p characters from the given alphabet. Display on the screen the generated array.

        ArrayList<StringBuilder> words = new ArrayList<>();
        System.out.print("Random words generated: ");
        for (int i = 0; i < n; i++) {
            Random random = new Random();
            StringBuilder randomWord = new StringBuilder();
            for (int j = 0; j < p; j++) {
                int randomLetter = random.nextInt(letters.size());
                randomWord.append(letters.get(randomLetter));
            }
            words.add(randomWord);
            System.out.print(words.get(i) + " ");
        }
        System.out.println();

    /* 3. Two words are neighbors if they have a common letter.
        - Create a boolean n x n matrix, representing the adjacency relation of the words.
        - Create a data structure (using arrays) that stores the neighbors of each word. Display this data structure on the screen. */

        boolean[][] adjacencyMatrix = new boolean[n][n];
        String[] neighbors = new String[n];
        for (int i = 0; i < n; i++) {
            neighbors[i] = "";
        }

        for (int i = 0; i < n; i++) {
            StringBuilder currentWord = words.get(i);
            for (int j = 0; j < n; j++) {
                StringBuilder anotherWord = words.get(j);
                boolean isNeighbor = false;
                for(int x = 0; x < currentWord.length(); x++) {
                    for(int y = 0; y < anotherWord.length(); y++) {
                        if (currentWord.charAt(x) == anotherWord.charAt(y)) {
                            isNeighbor = true;
                            break;
                        }
                    }
                    if(isNeighbor) {
                        break;
                    }
                }
                adjacencyMatrix[i][j] = isNeighbor;

                if(isNeighbor && i != j) {
                    neighbors[i] = neighbors[i].concat(String.valueOf(words.get(j)));
                    neighbors[i] = neighbors[i].concat(" ");
                }
                   System.out.print(adjacencyMatrix[i][j] + " "); // to print the boolean matrix on the screen
            }
              System.out.println();
        }

        for (int i = 0; i < n; i++) {
            System.out.print("Neighbors of " + words.get(i) + " are: ");
            System.out.print(neighbors[i] + " ");
            System.out.println();
        }



        // BONUS:
        adjList = new LinkedList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

        for(int i = 0; i < n; i++) {
            int nr = 0;
            for(int j = 0; j < n; j++) {
                if(adjacencyMatrix[i][j] && i != j)
                    nr++;
            }
            nrOfNeighbors.add(nr);
        }

        for(int i = 0; i < n; i++) {
            if(nrOfNeighbors.get(i) >= 2) {
                for (int j = 0; j < n; j++) {
                    if (adjacencyMatrix[i][j] && i != j) {
                        adjList[i].add(j);
                    }
                }
            }
        }

        boolean ok;
        boolean exists = false;
        for(int i = 0; i < n; i++){
            DFS(i); // parcurg cu dfs listele de adiacenta a fiecarui nod
            ok = true;
            for(int j = 0; j < sol.size()-1; j++){
                if(!adjacencyMatrix[sol.get(j)][sol.get(j+1)])
                    ok = false;
                if(j == sol.size()-2 && !adjacencyMatrix[sol.get(sol.size()-1)][sol.get(0)])
                    ok = false;
            }
            if (ok && sol.size() >= 3) {
                System.out.println("k-ul maxim este: " + sol.size());
                for (int j = 0; j < sol.size(); j++) {
                    System.out.println(words.get(sol.get(j)));
                }
                exists = true;
                break;
            }

            sol.removeAll(sol);
            for(int j=0;j<n;j++) {
                visited[j]=false;
            }
        }
        if(!exists) {
            System.out.println("Nu exista solutie!");
        }
    }

    void DFS(int vertex) {
        visited[vertex] = true;
        sol.add(vertex);

        for (Object o : adjList[vertex]) {
            int adj = (int) o;
            if (!visited[adj]) {
                DFS(adj);
            }
        }
    }
}