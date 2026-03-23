public class ContainerMostWater {

    public int maxArea(int[] heights) {
        int maxArea = 0;
        int i = 0;
        int j = heights.length - 1;
        while (i < j) {
            int minHeight = Math.min(heights[i], heights[j]);
            int localArea = (j - i) * minHeight;
            if (maxArea < localArea) {
                maxArea = localArea;
            }

            if (heights[i] > heights[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerMostWater c = new ContainerMostWater();
        int i = c.maxArea(new int[]{1, 7, 2, 5, 4, 7, 3, 6});
        System.out.printf("Max area: %d%n", i);

        int j = c.maxArea(new int[]{2, 2, 2});
        System.out.printf("Max area: %d%n", j);
    }
}
