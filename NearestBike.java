public class NearestBike {

	/*  You are given a campus map with the Google buildings, roads and Google 
		bikes. You have to help the employee find the nearest Google bike. 
		
		Campus map:
		
		
		. - Free path/road
		# - Building
		B - Google bike
		
		Employee location - (x, y) - (1, 2)
		
		. . . . . #
		. . E . . #
		# # # # . #
		. B . . . .
		. . . . . B
	 */

	public static void main(String[] args) {
		
		int[][] matrix = {{0,0,0,0,0,1},{0,0,0,0,0,1},{1,1,1,1,0,1},{0,2,0,0,0,0},{0,0,0,0,0,2}};
		Point employee = new Point(1,2);
		bfsBikeSearch(matrix, employee);
		
		
		
	}
	
	
	public static List<Point> getAdjacentPaths(int[][] matrix, Point start){
		
		List<Point> adjacnetPaths = new ArrayList<NearestBike.Point>();
		
		if(start.x-1>=0 && matrix[start.x-1][start.y] !=1) adjacnetPaths.add(new Point(start.x-1,start.y));
		if(start.x+1 < matrix.length && matrix[start.x+1][start.y] !=1) adjacnetPaths.add(new Point(start.x+1,start.y));
		if(start.y-1 >=0 && matrix[start.x][start.y-1] !=1 ) adjacnetPaths.add(new Point(start.x,start.y-1));
		if(start.y+1 < matrix[0].length && matrix[start.x][start.y+1] !=1) adjacnetPaths.add(new Point(start.x,start.y+1));

		return adjacnetPaths;
		
	}
	
	
	public static void bfsBikeSearch(int[][] matrix, Point employee){
		 
		if(matrix[employee.x][employee.y] == 2) {
			
			System.out.println("Fount bike at employee location (" + employee.x + ","  + employee.y + ")"); return;
			
		}
		
		Queue<Point> queue = new LinkedList<Point>();
		
		Set<Point> visited = new HashSet<NearestBike.Point>();
		
		visited.add(employee);
		
		queue.add(employee);
		
		
		
		while(!queue.isEmpty()){
			
		Point loc = queue.remove();
		
	    List<Point> neighbors = getAdjacentPaths(matrix, loc);
	    
	    for(Point neighbor : neighbors){
	    	
	    	if(!visited.contains(neighbor)){
	    		
	    		if(matrix[neighbor.x][neighbor.y] == 2){
	    			System.out.println("Fount bike at employee location (" + neighbor.x + ","  + neighbor.y + ")"); return;

	    		}else{
	    			visited.add(neighbor);
	    			queue.add(neighbor);
	    		}
            }
	    	
	    }
		}
	}