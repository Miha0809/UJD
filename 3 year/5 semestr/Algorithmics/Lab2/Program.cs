// Task1
var bfs = new Grapth();

var el0 = new Node(0);
var el1 = new Node(1);
var el2 = new Node(2);
var el3 = new Node(3);
var el4 = new Node(4);
var el5 = new Node(5);
var el6 = new Node(6);
var el7 = new Node(7);
var el8 = new Node(8);
var el9 = new Node(9);

el0.AddNeighborhood(el1);
el0.AddNeighborhood(el3);
el1.AddNeighborhood(el8);
el3.AddNeighborhood(el2);
el3.AddNeighborhood(el9);
el3.AddNeighborhood(el7);
el8.AddNeighborhood(el5);
el2.AddNeighborhood(el6);
el2.AddNeighborhood(el4);

bfs.BFS(el0);
Console.WriteLine(bfs);

// Task2
var dfs = new Grapth();
el0 = new Node(0);
el1 = new Node(1);
el2 = new Node(2);
el3 = new Node(3);
el4 = new Node(4);
el5 = new Node(5);
el6 = new Node(6);
el7 = new Node(7);
el8 = new Node(8);
el9 = new Node(9);

el0.AddNeighborhood(el1);
el0.AddNeighborhood(el3);
el1.AddNeighborhood(el8);
el3.AddNeighborhood(el2);
el3.AddNeighborhood(el9);
el3.AddNeighborhood(el7);
el8.AddNeighborhood(el5);
el2.AddNeighborhood(el6);
el2.AddNeighborhood(el4);

dfs.DFS(el0);
Console.WriteLine(dfs);

// Task3
var problem733 = new Problem733();

foreach (
    var item in problem733.FloodFill(
        [
            [1, 1, 1],
            [1, 1, 1],
            [1, 0, 1],
        ],
        sr: 1,
        sc: 1,
        newColor: 2
    )
)
{
    foreach (var item2 in item)
    {
        Console.Write(item2);
    }

    Console.WriteLine();
}
