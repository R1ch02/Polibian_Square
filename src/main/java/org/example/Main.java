package org.example;
public class Main {
    private static String text = "pedestrian";
    private static String cypher = "ukikxywofs";

    private static final char[][] SQUARE = {
            {'a', 'b', 'c', 'd', 'e'},
            {'f', 'g', 'h', 'i', 'k'},
            {'l', 'm', 'n', 'o', 'p'},
            {'q', 'r', 's', 't', 'u'},
            {'v', 'w', 'x', 'y', 'z'}
    };

    private static String encrypt(String text){
        char[] textArray = new char[text.length()];
        StringBuilder cypher = new StringBuilder();
        text.getChars(0, text.length(), textArray, 0);
        for(char c : textArray){
            int[] coords;
            if(c == 'j') coords = getCoords('i');
            else {
                coords = getCoords(c);
            }
            if(coords[0] == 4){
                cypher.append(SQUARE[0][coords[1]]);
            } else {
                cypher.append(SQUARE[coords[0] + 1][coords[1]]);
            }
        }
    return cypher.toString();
    }

    private static String decrypt(String cypher){
        char[] cypherArray = new char[cypher.length()];
        StringBuilder text = new StringBuilder();
        cypher.getChars(0,cypher.length(),cypherArray,0);
        for(char c: cypherArray){
            int[] coords;
            if(c == 'j') coords = getCoords('i');
            else {
                coords = getCoords(c);
            }
            if (coords[0] == 0){
                text.append(SQUARE[4][coords[1]]);
            } else {
                text.append(SQUARE[coords[0] - 1][coords[1]]);
            }
        }
            return text.toString();
    }

    private static int[] getCoords(char c){
        int[] array = new int[2];
        for (int i = 0; i < SQUARE.length; i++) {
            for (int j = 0; j < SQUARE.length; j++) {
                if(SQUARE[i][j] == c){
                    array[0] = i;
                    array[1] = j;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(encrypt(text));
        System.out.println(decrypt(cypher));
    }

}