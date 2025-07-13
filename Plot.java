public class Plot {
    private int x, y, width, depth;

    public Plot() {
        this(0, 0, 1, 1);
    }

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public Plot(Plot otherPlot) {
        this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth);
    }

    public boolean overlaps(Plot otherPlot) {
        if (x >= otherPlot.x + otherPlot.width || x + width <= otherPlot.x ||
            y >= otherPlot.y + otherPlot.depth || y + depth <= otherPlot.y) {
            return false;
        }
        return true;
    }

    public boolean encompasses(Plot otherPlot) {
        return (x <= otherPlot.x &&
                y <= otherPlot.y &&
                x + width >= otherPlot.x + otherPlot.width &&
                y + depth >= otherPlot.y + otherPlot.depth);
    }

    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }

    // Getters and setters
    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getDepth() { return depth; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setWidth(int width) { this.width = width; }
    public void setDepth(int depth) { this.depth = depth; }
}