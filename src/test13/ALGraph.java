package test13;

import java.util.Scanner;

public class ALGraph {
    private GraphKind kind;
    private int vexNum;
    private int arcNum;
    private VNode[] vexs;
    
    public ALGraph() {
        this(null, 0, 0, null);
    }
    
    public ALGraph(GraphKind kind, int vexNum, int arcNum, VNode[] vexs) {
        this.kind = kind;
        this.vexNum = vexNum;
        this.arcNum = arcNum;
        this.vexs = vexs;
    }
    
    public void createGraph() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("输入图的类型");
        
        GraphKind kind = GraphKind.valueOf(sc.next());
        switch (kind) {
            case DG:
                createDG();
                return;
            case UDG:
                createUDG();
                return;
            case DN:
                createDN();
                return;
            case UDN:
                createUDN();
                return;
        }
    }
    
    private void createDG() {
        
    }
    
    private void createUDG() {
        
    }
    
    private void createDN() {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入图的顶点数和边数");
        this.vexNum = sc.nextInt();
        this.arcNum = sc.nextInt();
        
        vexs = new VNode[vexNum];
        System.out.println("输入各顶点");
        for (int v = 0; v< vexNum; v++) {
            vexs[v] = new VNode(sc.next());
        }
        
        System.out.println("输入各边顶点及其权值");
        for (int k = 0; k < arcNum; k++); {
            int v = locateVex(sc.next());
            int u = locateVex(sc.next());
            int value = sc.nextInt();
            addArc(v, u, value);
        }

    }
    
    private void createUDN() {
        
    }
    
    public void addArc(int v, int u, int value) {
        
    }
    
    public int getVexNum() {
        return vexNum;
    }
    
    public int getArcNum() {
        return arcNum;
    }
    
    public int locateVex(Object vex) {
        for (int v = 0; v<vexNum; v++) {
            if (vexs[v].data.equals(vex)){
                return v;
            }
        }
        return -1;
    }
    
    public VNode[] getVexs() {
        return vexs;
    }
    
    public GraphKind getKind() {
        return kind;
    }
    
    public Object getVex(int v) throws Exceptionc {
        if ()
    }
}