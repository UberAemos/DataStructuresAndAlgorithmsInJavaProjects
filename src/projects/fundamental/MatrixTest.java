package projects.fundamental;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatrixTest {

    private Matrix firstMatrix;
    private Matrix secondMatrix;

    @BeforeEach
    void initEach() {
        firstMatrix = new Matrix(4, 4);
        secondMatrix = new Matrix(4, 4);

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                firstMatrix.data[i][j] = 4 * i + j + 1;
                secondMatrix.data[i][j] = firstMatrix.data[i][j] + 16;
            }
    }

    @org.junit.jupiter.api.Test
    void addMatrix() {
        firstMatrix.addMatrix(secondMatrix);
        assertEquals(18, firstMatrix.data[0][0]);
        assertEquals(26, firstMatrix.data[1][0]);
    }

    @org.junit.jupiter.api.Test
    void multiplyMatrix() {
        firstMatrix.multiplyMatrix(secondMatrix);
        assertEquals(17, firstMatrix.data[0][0]);
        assertEquals(105, firstMatrix.data[1][0]);
    }
}