class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] adjMat = new int[numCourses][numCourses];
        int[] inDegree = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int ready = prerequisites[i][0];
            int preq = prerequisites[i][1];
            if(adjMat[preq][ready]==0)
                inDegree[ready]++;
            adjMat[preq][ready] = 1;
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0) queue.offer(i);
        }
        while(!queue.isEmpty()){
            int course = queue.poll();
            count++;
            for(int i=0;i<numCourses;i++){
                if(adjMat[course][i]==1){
                    if(--inDegree[i]==0){
                        queue.add(i);
                    }
                }
            }
        }
        return count==numCourses;
    }
}