import java.util.*;

class Point {
    int x;
    int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Solution {
    static int robotCnt;
    static Map<Integer, Point> pointMap = new HashMap<>();
    static List<List<Point>> shortestPaths = new ArrayList<>();
    
    public int solution(int[][] points, int[][] routes) {
        robotCnt = routes.length;
        setPointMap(points);
        setShortestPath(routes);
        return countStrike();
    }
    
    private void setPointMap(int[][] points) {
        for(int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            pointMap.put(i + 1, new Point(x, y));
        }
    }
    
    private void setShortestPath(int[][] routes) {
        for (int i = 0; i <= robotCnt; i++) {
            shortestPaths.add(new ArrayList<>());
        }
        
        for (int i = 0; i < robotCnt; i++) {
            int[] route = routes[i];
            for (int j = 1; j < route.length; j++) {
                int cur = route[j - 1];
                int next = route[j];
                findShortestPath(i + 1, pointMap.get(cur), pointMap.get(next));
            }
        }
    }
    
    private void findShortestPath(int robotNum, Point cur, Point goal) {
        int x = cur.x, y = cur.y;
        int gx = goal.x, gy = goal.y;
        
        List<Point> path = shortestPaths.get(robotNum);
        
        if (path.isEmpty()) {
            path.add(cur);
        }
        
        while (x != gx) {
            x += (x > gx) ? -1 : 1;
            path.add(new Point(x, y));
        }
            
        while (y != gy) {
            y += (y > gy) ? -1 : 1;
            path.add(new Point(x, y));
        }
    }
    
    private int countStrike() {
        int total = 0;
        
        int t = 0;
        for (int i = 1; i <= robotCnt; i++) {
            t = Math.max(t, shortestPaths.get(i).size());
        }
        
        for (int i = 0; i <= t; i++) {
            Map<Point, Integer> countMap = new HashMap<>();
            
            for (List<Point> shortestPath : shortestPaths) {
                
                Point point = shortestPath.size() > i ? shortestPath.get(i) : null;
                
                if (point == null) {
                    continue;
                }
                
                countMap.put(point, countMap.getOrDefault(point, 0) + 1);
            }
            
            for (int count : countMap.values()) {
                if (count >= 2) total++;
            }
        }
        
        return total;
    }
}