package test13;

import java.util.ArrayList;
import java.util.List;

import test12.*;

public class Prim {
    public List<VNode> verList = new ArrayList<VNode>();
    public List<ArcNode> arcList = new ArrayList<ArcNode>();
    public List<VNode> newVerList = new ArrayList<VNode>();
    public void primeTree(ALGraph G) {
        Object start = G.getVex(0);
        newVerList.add(new VNode(start));

        for (int i = 0; i<G.getVexNum-1;i++) {
            VNode temp = new VNode(start.getData);
        }
    }
}