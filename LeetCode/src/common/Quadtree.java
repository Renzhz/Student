package common;

/**
 * 四叉树
 * <p>
 * 2024/8/5
 */
public class Quadtree {
    public boolean val;
    public boolean isLeaf;
    public Quadtree topLeft;
    public Quadtree topRight;
    public Quadtree bottomLeft;
    public Quadtree bottomRight;


    public Quadtree() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Quadtree(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Quadtree(boolean val, boolean isLeaf, Quadtree topLeft, Quadtree topRight, Quadtree bottomLeft, Quadtree bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
