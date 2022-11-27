package test11;

public class HuffmanTree {
    public int[][] huffmanCoding(int[] W) {
        int n = W.length;
        int m = n * 2 - 1;
        HuffmanNode[] huffmanNodes = new HuffmanNode[m];
        int i;
        for (i = 0; i < n; i++) {
            huffmanNodes[i] = new HuffmanNode(W[i]);
        }
        for (i = n; i < m; i++) {
            HuffmanNode minNode1 = selectMin(huffmanNodes, i - 1);
            minNode1.flag = 1;
            HuffmanNode minNode2 = selectMin(huffmanNodes, i - 1);
            minNode2.flag = 1;

            huffmanNodes[i] = new HuffmanNode();
            minNode1.parent = huffmanNodes[i];
            minNode2.parent = huffmanNodes[i];

            huffmanNodes[i].lchild = minNode1;
            huffmanNodes[i].rchild = minNode2;

            huffmanNodes[i].weight = minNode1.weight + minNode2.weight;
        }

        int[][] HuffCode = new int[n][n];
        for (int j = 0; j < n; j++) {
            int start = n - 1;
            for (HuffmanNode c = huffmanNodes[j], p = c.parent; p != null; c = p, p = p.parent) {
                if (p.lchild.equals(c)) {
                    HuffCode[j][start--] = 0;
                } else {
                    HuffCode[j][start--] = 1;
                }
                HuffCode[j][start] = -1;
            }
        }
        return HuffCode;
    }

    private HuffmanNode selectMin(HuffmanNode[] huffmanNodes, int end) {
        HuffmanNode minNode = huffmanNodes[end];

        for (int i = 0; i <= end; i++) {
            HuffmanNode h = huffmanNodes[i];
            if (h.flag == 0 && h.weight < minNode.weight) {
                minNode = h;
            }
        }

        return minNode;
    }

    public static void main(String[] args) {
        int[] W = { 23, 11, 5, 3, 29, 14, 7, 8 };
        HuffmanTree T = new HuffmanTree();
        int[][] huffmanNodes = T.huffmanCoding(W);
        for (int i = 0; i < huffmanNodes.length; i++) {
            System.out.println(W[i] + " ");
            for (int j = 0; j < huffmanNodes[i].length; j++) {
                if (huffmanNodes[i][j] == -1) {
                    for (int k = j + 1; k < huffmanNodes[i].length; k++) {
                        System.out.print(huffmanNodes[i][k]);
                    }
                    break;
                }
            }
        }
        System.out.println();
    }
}