package com.maartenmusic;

public class Utilities {

    public char[] everyNthChar(char[] sourceArray, int n){

        if (sourceArray == null || sourceArray.length < n) {
            return sourceArray;
        }

        int returnedLength = sourceArray.length/n;
        char[] result = new char[returnedLength];
        int index = 0;

        for (int i = n-1; i < sourceArray.length; i+=n) {
            result[index++] = sourceArray[i];
        }

        return result;
    }

    public String removePairs (String sourceString) {
        if (sourceString == null || sourceString.length() < 2) {
            return sourceString;
        }

        StringBuilder sb = new StringBuilder();
        char[] string = sourceString.toCharArray();

        for (int i = 0; i < string.length-1 ; i++) {
            if (string[i] != string[i+1]) {
                sb.append(string[i]);
            }
        }
            sb.append(string[string.length-1]);

        return sb.toString();
    }

    public int converter(int a, int b) {
        return (a/b) + (a * 30) -2;
    }

    public String nullIfOddLength(String source) {
        if (source.length() % 2 != 0) {
            return null;
        }
        return source;
    }
}
