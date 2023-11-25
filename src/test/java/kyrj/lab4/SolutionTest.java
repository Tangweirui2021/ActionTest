package kyrj.lab4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("@BeforeEach，测试开始");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("@AfterEach，测试结束");
    }

    @Test
    public void findMinHeightTrees() {
        Solution s = new Solution();

        // 等价类1: 生成最小高度树只有一个可能的节点
        // 输入：n = 4, edges = [[1,0],[1,2],[1,3]]
        // 输出：[1]
        int[][] edges1 = {{1, 0}, {1, 2}, {1, 3}};
        assertEquals(new ArrayList<>(List.of(1)) , s.findMinHeightTrees(4, edges1));

        // 等价类2: 生成最小高度树有多个可能的节点
        // 输入：n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
        // 输出：[3,4]
        int[][] edges2 = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        assertEquals(new ArrayList<>(List.of(3, 4, 5)) , s.findMinHeightTrees(6, edges2));

        // 等价类3: 输入的边为空
        // 输入：n = 0, edges = []
        // 输出：ArrayIndexOutOfBoundsException异常
        int[][] edges3 = {};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> s.findMinHeightTrees(0, edges3));

        // 等价类4: 输入的边不为空，但是节点数为0
        // 输入：n = 0, edges = [[1,0],[1,2],[1,3]]
        // 输出：ArrayIndexOutOfBoundsException异常
        int[][] edges4 = {{1, 0}, {1, 2}, {1, 3}};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> s.findMinHeightTrees(0, edges4));
    }
}