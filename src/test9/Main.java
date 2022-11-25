package test9;

public class Main {
    public static void main(String[] args) {
        int m[][] = {
                { 0, 0, 8, 0, 0, 0 }, 
                { 0, 0, 0, 0, 0, }, 
                { 5, 0, 0, 0, 16, 0 }, 
                { 0, 0, 18, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 0 }
        };
        
        SpareMatrix spareMatrix = new SpareMatrix(m);
        SpareMatrix result = spareMatrix.transpose();
        spareMatrix.printMatrix();
        result.printMatrix();
    }
}
